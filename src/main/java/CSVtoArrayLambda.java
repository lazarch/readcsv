import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/** Created by alex on 09-Dec-16. */
public class CSVtoArrayLambda {
//        static Calendar now = Calendar.getInstance();
    static String sDate = LocalDate.now().toString().replace("-",""); //сьогоднішній день
//    final static String sTime = LocalTime.now().minus(60, ChronoUnit.SECONDS).toString().substring(0,6);  //поточний час
    // - попередньої хвилини, інколи немає ще даних на поточну хвилину
    final private static Path path = Paths.get("\\\\F7\\Logs\\" + sDate + ".log");

    public static void main(String[] args) {

        try {

            Stream<String> lines2 = Files.lines(path);
            List<String> resultList = lines2
                    .filter(listString ->
                            (listString.substring(15,16).contains("5")) //лише 5 хвилина
                             && listString.substring(17,18).matches("[012]") ) //лише секунди, які починаються з 0,1,2
                    .collect(Collectors.toList());

/*
можна ось так робити, тут у ліст передається значення запиту, який формується на основі
виборки з обєкта User
List<User> users = jdbcTemplate.query(
  "SELECT USER_ID, USERNAME FROM USER",

   (rs, rowNum) -> {        // ось тут формується виборка
    User user = new User();
    user.setUserId(rs.getLong("USER_ID"));
    user.setUsername(rs.getString("USERNAME"));
    return user;
});
*/

//тут відрізаю дату - substring(11), беруться тільки час і дані
// вона не потрібна у масиві, але тут лише друкую!!!
            Function<String, String> sData = (sValue) -> sValue.substring(11);
            resultList.forEach(value -> System.out.println(sData.apply(value)));
//            resultList.forEach(value -> System.out.println(sData.apply(value).split("\\s*,\\s*")));
            System.out.println(resultList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


