import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Snow {

    private static final String SNOW_DB_URL = "jdbc:mysql://localhost:3306/snow?useUnicode=true&characterEncoding=UTF8";

    public static void transfer() {

        try (Connection connection = DriverManager.getConnection(Util.OLTP_DB_URL, Util.USER, Util.PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from oltp")) {

            importData(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void importData(ResultSet resultSet) {
        try (Connection connection = DriverManager.getConnection(SNOW_DB_URL, Util.USER, Util.PASS);
             PreparedStatement stmt1 = connection.prepareStatement("insert into book (`book_name`,`book_author`,`book_id`,`book_category`) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt2 = connection.prepareStatement("insert into borrow_time (`year`, `month`, `day`, `hour`, `minute`) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt3 = connection.prepareStatement("insert into return_time (`year`, `month`, `day`, `hour`, `minute`) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt4 = connection.prepareStatement("insert into user (`user_id`, `user_name`, `user_department`, `user_category`) values (?,?,?,?)")
        ) {

            while (resultSet.next()) {
                String borrowT = resultSet.getString("borrow_time");
                String returnT = resultSet.getString("return_time");

                String bookN = resultSet.getString("book_name");
                String bookA = resultSet.getString("book_author");
                String bookI = resultSet.getString("book_id");
                String bookC = resultSet.getString("book_category");

                String userN = resultSet.getString("user_name");
                String userD = resultSet.getString("user_department");
                String userI = resultSet.getString("user_id");
                String userC = resultSet.getString("user_category");

                stmt1.setString(1, bookN);
                stmt1.setString(2, bookA);
                stmt1.setString(3, bookI);
                stmt1.setString(4, bookC);

                String[] dateStrings = borrowT.split("-");
                stmt2.setString(1, dateStrings[0]);
                stmt2.setString(2, dateStrings[1]);
                stmt2.setString(3, dateStrings[2]);
                stmt2.setString(4, dateStrings[3]);
                stmt2.setString(5, dateStrings[4]);

                String[] dateStrings2 = returnT.split("-");
                stmt3.setString(1, dateStrings2[0]);
                stmt3.setString(2, dateStrings2[1]);
                stmt3.setString(3, dateStrings2[2]);
                stmt3.setString(4, dateStrings2[3]);
                stmt3.setString(5, dateStrings2[4]);

                stmt4.setString(1, userI);
                stmt4.setString(2, userN);
                stmt4.setString(3, userD);
                stmt4.setString(4, userC);

                stmt1.execute();
                stmt2.execute();
                stmt3.execute();
                stmt4.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
