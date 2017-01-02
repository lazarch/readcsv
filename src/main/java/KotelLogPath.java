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


/*
    public KotelLogPath(String date, String time, String temp0, String temp1,String temp2, String temp3, String temp4, String temp5, String temp6) {
        //конструктор класу DaTemp, присвоює значення даними

        this.date = date;
        this.time = time;
        this.temp0 = Float.parseFloat(temp0);
        this.temp1 = Float.parseFloat(temp1);
        this.temp2 = Float.parseFloat(temp2);
        this.temp3 = Float.parseFloat(temp3);
        this.temp4 = Float.parseFloat(temp4);
        this.temp5 = Float.parseFloat(temp5);
        this.temp6 = Float.parseFloat(temp6);
    }
*/

    KotelLogPath(String line) {
        //конструктор класу DaTemp, присвоює значення даними
        String[] array = line.split(",");
        this.date = array[0];
        this.time =  array[1];
        this.temp0 = Float.parseFloat(array[2]);
        this.temp1 = Float.parseFloat(array[3]);
        this.temp2 = Float.parseFloat(array[4]);
        this.temp3 = Float.parseFloat(array[5]);
        this.temp4 = Float.parseFloat(array[6]);
        this.temp5 = Float.parseFloat(array[7]);
        this.temp6 = Float.parseFloat(array[8]);
    }

    public String toString() {
        return "Дата "+ this.date +
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