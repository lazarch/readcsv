import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class KotelLogPath {
    private static String sDate = LocalDate.now().toString().replace("-", ""); //сьогоднішній день
    final static Path path = Paths.get("\\\\F7\\Logs\\" + sDate + ".log");
    final static String pathS = "\\\\F7\\Logs\\" + sDate + ".log";

    private String date;
    private String time;
    private float temp0;
    private float temp1;
    private float temp2;
    private float temp3;
    private float temp4;
    private float temp5;
    private float temp6;
    public KotelLogPath fieldKotelLog = null;

    KotelLogPath(String line) {
        //конструктор класу DaTemp, присвоює значення даними
        String[] array = line.split(",");
        date = array[0];
        time =  array[1];
        temp0 = Float.parseFloat(array[2]);
        temp1 = Float.parseFloat(array[3]);
        temp2 = Float.parseFloat(array[4]);
        temp3 = Float.parseFloat(array[5]);
        temp4 = Float.parseFloat(array[6]);
        temp5 = Float.parseFloat(array[7]);
        temp6 = Float.parseFloat(array[8]);
    }

    public String toString() {
        return  "Дата "             + date +
                " time "            + time +
                " дім подача "      + temp0 +
                " триходовий "      + temp1 +
                " погріб "          + temp2 +
                " котел подача "    + temp3 +
                " котел зворотня "  + temp4 +
                " дім зворотня "    + temp5 +
                " вулиця "          + temp6;
    }
}