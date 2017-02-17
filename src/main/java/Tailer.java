/**
 * Created by alexlaz on 08-Feb-17 & 22:17.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author http://.com
 */

public class Tailer implements Runnable {

    public static String newLine;
    private boolean debug = false;

    private int RunEveryNSeconds = 10000;
    private long lastKnownPosition = 0;
    private boolean shouldIRun = true;
    private File File = null;
    private static int Counter = 0;

    public Tailer(String myFile, int myInterval) {
        File = new File(myFile);
        this.RunEveryNSeconds = myInterval;
    }

    private void printLine(String message) {
        System.out.println(message);
    }

    public void stopRunning() {
        shouldIRun = false;
    }

    public void run() {
        try {
            while (shouldIRun) {
                Thread.sleep(RunEveryNSeconds);
                long fileLength = File.length();
                if (fileLength > lastKnownPosition) {

                    // Reading and writing file
                    RandomAccessFile readWriteFileAccess = new RandomAccessFile(File, "rw");
                    readWriteFileAccess.seek(lastKnownPosition);
                    String Line = null;
                    while ((Line = readWriteFileAccess.readLine()) != null) {
                        this.newLine = Line;
                        this.printLine(Line);
                        Counter++;
                    }
                    lastKnownPosition = readWriteFileAccess.getFilePointer();
                    readWriteFileAccess.close();
                } else {
                    if (debug)
                        this.printLine("Hmm.. Couldn't found new line after line # " + Counter);
                }
            }
        } catch (Exception e) {
            stopRunning();
        }
        if (debug)
            this.printLine("Exit the program...");
    }

    public static void main(String argv[]) {

        ExecutorService Executor = Executors.newFixedThreadPool(4);

        // Replace username with your real value
        // For windows provide different path like: c:\\temp\\.log
        String filePathLog = "d:\\Libraries\\Plot\\today.log";
        String filePath = String.valueOf(KotelLogPath.path);
        Tailer _tailF = new Tailer(filePath, 10000);

        // Start running log file tailer on .log file
        Executor.execute(_tailF);

        // Start pumping data to file .log file
        appendData(filePathLog, true, 15000);

    }

    /**
     * Use appendData method to add new line to file, so above tailer method can print the same in Eclipse Console
     *
     * @param filePathLog
     * @param shouldIRun
     * @param RunEveryNSeconds
     */
    private static void appendData(String filePathLog, boolean shouldIRun, int RunEveryNSeconds) {
        FileWriter fileWritter;

        try {
            while (shouldIRun) {
                Thread.sleep(RunEveryNSeconds);
                fileWritter = new FileWriter(filePathLog, true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

                String data = newLine + "\n";
                bufferWritter.write(data);
                bufferWritter.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}