import java.sql.SQLException;
import java.util.Scanner;

public class Report {

    public static void reportMenu() throws SQLException {
        Scanner scanner =new Scanner(System.in);
        System.out.println("welcome to the report menu");
        System.out.println("Select from the list");
        System.out.println("1) Sales report");
        System.out.println("2) Inventory report");
        int option=scanner.nextInt();
        switch (option){
            case 1:
                SalesReport.salesreport();
            case 2:
                InventoryReport.inventoryReport();

        }

    }



}
