import java.sql.SQLException;
import java.util.Scanner;

public  class userMenu  extends mainMenu{
    int option=-1;
    @Override
    public void displayoption() {
        while (option!=0) {
            System.out.println("Welcome to the user menu");
            System.out.println("Select any key to access billing (select 0 to exit)");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            if ((!key.isBlank())) {
                try {
                    Billing.createBill();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
