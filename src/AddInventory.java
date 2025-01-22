import java.sql.SQLException;
import java.util.Scanner;

public class AddInventory extends Inventory {
    public static void addinventory() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item code,item name,mrp");

        System.out.println("Enter item code:");
        String id = scanner.nextLine();

        System.out.println("Enter item name:");
        String itemname = scanner.nextLine();

        System.out.println("Enter MRP:");
        double mrp = scanner.nextDouble();

        System.out.println("Enter quantity");
        int Qty= scanner.nextInt();


        String sql2 = "insert into pos_system.inventory(itemid,item_name,mrp,Qty) values('" + id + "','" + itemname + "','" + mrp + "','"+Qty+"')";
        try {
            Main.sqll.execute(sql2);
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

    }
}