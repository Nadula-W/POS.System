import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class callLogin {
    private static int level;
    public static String uname;
    private static String password;


    public static void callLogin(String uname, String pw, Statement sqll) throws SQLException {
        setUname(getUsername());
        setPassword(getPassword());
        String sql = "SELECT * FROM pos_system.password WHERE TRIM(username)='" +
                uname + "' AND TRIM(password)='" + pw + "' AND active=1";

        ResultSet result= sqll.executeQuery(sql);
        if(result.next()){
            System.out.println("Successfully logged in");
             level=result.getInt("level");
            if(level==2){
                mainMenu menu1=new mainMenu();
                menu1.displayAdmin();
            } else if (level==1) {
                mainMenu menu2=new mainMenu();
                menu2.displayuser();
            }
        }
    }

    private static String setUname(String uname) {
        return uname;
    }
    private static String setPassword(String password){
        return password;
    }
    private static String getUsername() {
        return uname;
    }

    private static String getPassword() {
        return password;
    }

}
