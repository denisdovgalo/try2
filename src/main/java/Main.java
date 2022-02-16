import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
    private static String URL = "jdbc:sqlserver://192.168.191.47/GSCRSDB";
    private static String LOGIN = "iflex";
    private static String PASSWORD = "iflex";
    private static Statement stmt;
    private static ResultSet rs;
    private static String query = "select * from GSCRSDB.dbo.CRS_ENUM_PAYCARDS ep  where ep.SPID=242 " +
            "and ep.SBID=70 and STATUS='C' and ep.SERIAL_NUM like '0000%' order by SERIAL_NUM  desc";


    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load class.");
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD)){
            stmt = conn.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);
            int serialNumber = rs.getInt(1);
            System.out.println(serialNumber);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

