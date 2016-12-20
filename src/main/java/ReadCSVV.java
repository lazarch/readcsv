/**
 * Created by alex on 07-Dec-16.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class ReadCSVV {
    static String sDate = LocalDate.now().toString().replace("-",""); //сьогоднішній день
    final static String sTime = LocalTime.now().toString().substring(0,6);  //поточний час - цієї хвилини
    final private static Path path = Paths.get("\\\\F7\\Logs\\" + sDate + ".log");
    public String fileName = String.valueOf(path);

    public static Scanner ScanData() throws IOException, ParseException {
       String fileName = String.valueOf(path);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate, endDate;
//        startDate = sdf.parse(args[0]);
//        endDate = sdf.parse(args[1]);
        File file = new File(fileName);
        final long length = file.length();
        Scanner inputfile = new Scanner(file);
        
        
        inputfile.next();
        inputfile.next();
        int count = (int) Files.lines(path).count();
//        count = sdf.NumRows(fileName);
        Date[] date_tr = new Date[count];
        Time[] open = new Time[count];
        Double[] high = new Double[count];
        Double[] low = new Double[count];
        Double[] close = new Double[count];
        Double[] close1 = new Double[count];
        Double[] close2 = new Double[count];
        Double[] close3 = new Double[count];
        Double[] close4 = new Double[count];
        int i = 0;

        while (inputfile.hasNext()) {
            String data_row = inputfile.next();
            String[] data = data_row.split(",");
            date_tr[i] = sdf.parse(data[0]);
            open[i] = Time.valueOf(data[1]);
            high[i] = Double.parseDouble(data[2]);
            low[i] = Double.parseDouble(data[3]);
            close[i] = Double.parseDouble(data[4]);
            close1[i] = Double.parseDouble(data[5]);
            close2[i] = Double.parseDouble(data[6]);
            close3[i] = Double.parseDouble(data[7]);
            close4[i] = Double.parseDouble(data[8]);
            SimpleDateFormat outFormat = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println(outFormat.format(date_tr[i]) + " " + open[i] + " " + high[i] + " " + low[i] + " " + close[i]
                    + " " + close1[i] + " " + close2[i] + " " + close3[i] + " " + close4[i]);
            i++;
        }
//        inputfile.close();
        return inputfile;
    }
}
