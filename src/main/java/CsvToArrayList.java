/**
 * Created by alex on 07-Dec-16.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 28-Nov-16.
 */
public class CsvToArrayList {
    //    static Calendar now = Calendar.getInstance();
    static String sDate = LocalDate.now().toString().replace("-",""); //сьогоднішній день
    final static String sTime = LocalTime.now().toString().substring(0,6);  //поточний час - цієї хвилини
    final private static Path path = Paths.get("\\\\F7\\Logs\\" + sDate + ".log");

    public static void main(String[] args) {

        BufferedReader Buffer = null;

        try {
            String Line;
            Buffer = new BufferedReader(new FileReader(String.valueOf(path)));
            int countLine = 0;
            ArrayList<String> lastLine = new ArrayList<>();
            // How to read file in java line by line?
            while ((Line = Buffer.readLine()) != null) {
                countLine++;

// Тут робиться підстановка поточного часу - цієї хвилини,
// формат такий "14:23:" -substring(0,6)
                if (Line.contains(sTime)) {

                    DaTemp daTemp = parseCSVLine(Line);

//                    System.out.println(daTemp.toString());
             }
            }  //+++++++++++++++++++++++++++++
            System.out.println("File count " + countLine + " lines");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Buffer != null) Buffer.close();
            } catch (IOException Exception) {
                Exception.printStackTrace();
            }
        }
    }
    private static DaTemp parseCSVLine(String line) {   // метод,
        // отримує line, повертає DaTemp
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*,\\s*");
        String date = scanner.next();
        String time = scanner.next();
        Double temp0 = scanner.nextDouble();
        Double temp1 = scanner.nextDouble();
        Double temp2 = scanner.nextDouble();
        Double temp3 = scanner.nextDouble();
        Double temp4 = scanner.nextDouble();
        Double temp5 = scanner.nextDouble();
        Double temp6 = scanner.nextDouble();
        CsvToArrayList csVtoArrayList = new CsvToArrayList();

        return csVtoArrayList.new DaTemp(date, time, temp0, temp1, temp2, temp3, temp4, temp5, temp6);
    }

    public class DaTemp { //class csVtoArrayList.DaTemp
        private String date;
        private String time;
        private Double temp0;
        private Double temp1;
        private Double temp2;
        private Double temp3;
        private Double temp4;
        private Double temp5;
        private Double temp6 ;
//constructor DaTemp для class-у csVtoArrayList.DaTemp
        public DaTemp(String date, String time, Double temp0, Double temp1,
                      Double temp2, Double temp3, Double temp4, Double temp5,
                      Double temp6) { //конструктор класу DaTemp, присвоює значення даними

            this.date = date;
            this.time = time;
            this.temp0 = temp0;
            this.temp1 = temp1;
            this.temp2 = temp2;
            this.temp3 = temp3;
            this.temp4 = temp4;
            this.temp5 = temp5;
            this.temp6 = temp6;

        }

        @Override
        public String toString() {
            return  "Дата "+ this.date +
                    " time " + this.time +
                    " дім подача " + this.temp0 +
                    " триходовий " + this.temp1 +
                    " погріб " + this.temp2 +
                    " котел подача " + this.temp3 +
                    " котел зворотня " + this.temp4 +
                    " дім зворотня " + this.temp5 +
                    " вулиця " + this.temp6;
        }
    }


    // Utility which converts CSV to ArrayList using Split Operation
    public static ArrayList<String> CSVtoArrayList(String CSV) {
        ArrayList<String> Result = new ArrayList<String>();

        if (CSV != null) {
            String[] splitData = CSV.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    Result.add(splitData[i].trim());
                }
            }
        }

        return Result;
    }

}

