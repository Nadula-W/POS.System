import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryReport extends Report {
    static void inventoryReport() throws SQLException {
        System.out.println("\t\t\t\t\t\t\tInventory Report");
        System.out.println("\t---------------------------------------------------------------");
        System.out.printf("\t%-5s %-15s %-25s %-10s %-10s\n", "No", "Item ID", "Item Name", "MRP", "Quantity");
        System.out.println("\t---------------------------------------------------------------");

        String sql11 = "SELECT * FROM pos_system.inventory";
        ResultSet rsc = null;

        try {
            rsc = Main.sqll.executeQuery(sql11);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (rsc.next()) {
            System.out.printf("\t%-5d %-15s %-25s %-10.2f %-10d\n",
                    rsc.getInt("no"),
                    rsc.getString("itemid"),
                    rsc.getString("item_name"),
                    rsc.getDouble("mrp"),
                    rsc.getInt("Qty"));
        }


        System.out.println();
        System.out.println();
        System.out.println();
    }
}
