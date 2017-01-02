import java.util.stream.Stream;

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
    public DaTemp fieldK = null;
    //constructor DaTemp для class-у csVtoArrayList.DaTemp
    public DaTemp(String date, String time, Double temp0, Double temp1,
                  Double temp2, Double temp3, Double temp4, Double temp5,
                  Double temp6) {
        //конструктор класу DaTemp, присвоює значення даними

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
    public DaTemp(String date, String time, String temp0, String temp1,
                  String temp2, String temp3, String temp4, String temp5,
                  String temp6) {
        //конструктор класу DaTemp, присвоює значення даними

        this.date = date;
        this.time = time;
        this.temp0 = Double.parseDouble(temp0);
        this.temp1 = Double.parseDouble(temp1);
        this.temp2 = Double.parseDouble(temp2);
        this.temp3 = Double.parseDouble(temp3);
        this.temp4 = Double.parseDouble(temp4);
        this.temp5 = Double.parseDouble(temp5);
        this.temp6 = Double.parseDouble(temp6);
    }

    DaTemp(Stream<String> lines) {

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
/*        @Override
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
        }*/
}

