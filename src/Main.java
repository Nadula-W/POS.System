import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static Statement sqll;
    public static String uname;
    public static String pw;


    public static void main(String[] args) throws SQLException {
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos_system"
                    ,"root","root");
            sqll= connection.createStatement();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
        try {
            FileReader reader = new FileReader("art.txt");
            int data =  reader.read();
            while (data != -1){
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("WELCOME TO THE POS SYSTEM");
        System.out.println("-------------------------");

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter username: ");
        uname=scanner.nextLine();

        System.out.println("Enter password: ");
        pw=scanner.nextLine();


        callLogin.callLogin(uname,pw,sqll);

    }

    }
