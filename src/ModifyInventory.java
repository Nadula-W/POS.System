import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifyInventory {
    static void modifyinventory(){
        System.out.println("enter item id ");
        Scanner scanner = new Scanner(System.in);
        String eid = scanner.nextLine();
        String sql3 = "select * from pos_system.inventory where itemid ='" + eid + "'";


        try {
            ResultSet result1 = Main.sqll.executeQuery(sql3);
            if (result1.next()) {
                System.out.println(result1.getString("item_name"));
                System.out.println(result1.getDouble("mrp"));
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("enter the new value to be changed");
                double newmrp = scanner.nextDouble();
                System.out.println("Enter Quantity");
                int Qty=scanner.nextInt();
                String sql4 = "update pos_system.inventory set mrp=" + newmrp + " ,Qty=" +Qty + " where itemid='" + eid + "'";

                Main.sqll.executeUpdate(sql4);

            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


