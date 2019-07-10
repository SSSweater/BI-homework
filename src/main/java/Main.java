import java.sql.*;

public class Main {

    public static void init() {
        try {
            Class.forName(Util.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
        Star.transfer();
        Snow.transfer();
    }

}
