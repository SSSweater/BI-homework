import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Util {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String OLTP_DB_URL = "jdbc:mysql://localhost:3306/lib?useUnicode=true&characterEncoding=UTF8";

    public static final String USER = "root";
    public static final String PASS = "root";

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
}
