import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CsvToArrayList {
    //    static Calendar now = Calendar.getInstance();

    private static Array[][] array;

    public static void main(String[] args) {

        BufferedReader Buffer = null;

        try {
            String Line;
            Buffer = new BufferedReader(new FileReader(String.valueOf(KotelLogPath.path)));
            int countLine = 0;
            // How to read file in java line by line?
            while ((Line = Buffer.readLine()) != null) {
                countLine++;
// Тут робиться підстановка поточного часу - цієї хвилини,
// формат такий "14:23:" -substring(0,6)
                if ((Line.substring(15,16).contains("5")) //лише 5 хвилина
                        && Line.substring(17,18).matches("[012]")) {
                    KotelLogPath aaa = new KotelLogPath(Line);
                    System.out.println(aaa );
                    System.out.println(aaa + " KotelLogPath");

 // тут з DaTemp береться
                    System.out.println(parseCSVLine(Line) + "parseCSVLine(Line)");



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
    private static ArrayList<String> parseCSVLine(String line) {   // метод,
        // отримує line, повертає DaTemp
        return CSVtoArrayList(line);
    }
//ніби ніде не використовую, видалити
    // Utility which converts CSV to ArrayList using Split Operation
    private static ArrayList<String> CSVtoArrayList(String CSV) {
        ArrayList<String> Result = new ArrayList<>();

        if (CSV != null) {
            String[] splitData = CSV.split("\\s*,\\s*");
            for (String aSplitData : splitData) {
                if (!(aSplitData == null) || !(aSplitData.length() == 0)) {
                    Result.add(aSplitData.trim());
                }
            }
        }

        return Result;
    }

}

