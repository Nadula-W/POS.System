import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryReport extends Report{
    static void inventoryReport() throws SQLException {
        String sql11="SELECT * FROM pos_system.inventory ";
        ResultSet rsc = null; try {
            rsc = Main.sqll.executeQuery(sql11);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {
            //no, itemid, item_name, mrp, Qty
            while (rsc.next()) {
                System.out.println("\t"+rsc.getInt("no")+"\t\t"+rsc.getInt("itemid")+
                        "\t\t"+rsc.getString("item_name")+"\t\t"+ rsc.getDouble("mrp")+"\t\t"+rsc.getInt("Qty"));
            }
        }

    }


}
