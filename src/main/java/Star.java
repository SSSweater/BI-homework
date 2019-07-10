import java.sql.*;

public class Star {

    private static final String STAR_DB_URL = "jdbc:mysql://localhost:3306/star?useUnicode=true&characterEncoding=UTF8";

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

        try (Connection con = DriverManager.getConnection(STAR_DB_URL, Util.USER, Util.PASS);
             PreparedStatement stmt1 = con.prepareStatement("insert into book (`book_name`,`book_author`,`book_id`,`book_category`) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt2 = con.prepareStatement("insert into time (`borrow_time`, `return_time`) values (?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt3 = con.prepareStatement("insert into user (`user_id`, `user_name`, `user_department`, `user_category`) values (?,?,?,?)")
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

                stmt2.setString(1, borrowT);
                stmt2.setString(2, returnT);


                stmt3.setString(1, userI);
                stmt3.setString(2, userN);
                stmt3.setString(3, userD);
                stmt3.setString(4, userC);


                stmt1.execute();
                stmt2.execute();
                stmt3.execute();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
