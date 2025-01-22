import java.sql.SQLException;
import java.util.Scanner;

public class Report {
        static int option=-1;
        static Scanner scanner =new Scanner(System.in);

    public static void reportMenu() throws SQLException {
        while (option != 0) {
            System.out.println("welcome to the report menu");
            System.out.println("Select from the list");
            System.out.println("1) Sales report");
            System.out.println("2) Inventory report");
            System.out.println("0) Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    SalesReport.salesreport();
                    break;
                case 2:
                    InventoryReport.inventoryReport();
                    break;
                case 3:
                    System.out.println("Exiting Report menu");

            }

        }

    }

}
