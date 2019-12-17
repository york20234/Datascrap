import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dconnect {
    static final String JDBC_DRIVER="com.mysql.jabc.Driver";
    static final String DB_URL="jabc:mysql://210.70.80.21:3306/s107021246/";

    static final String UID="s107021246";
    static final String PWD="ahmoh7ku";

    public static void main(String[] args){
        Connection con=null;
        Statement stm=null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database");
            stm=con.createStatement();
            String sql;
            sql="SELECT*FROM user";
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("id");
                String userName=rs.getString("name");
                String password=rs.getString("password");
                String email=rs.getString("email");

                System.out.print("ID"+id);
                System.out.print(",name"+userName);
                System.out.print(",password"+password);
                System.out.print(",email"+email);
            }
            rs.close();
            stm.close();
            con.close();

        }catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (stm!=null)
                    stm.close();
            }catch (SQLException se2){
            }
            try {
                if (con!=null)
                    con.close();
                }catch (SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye");
    }
}
