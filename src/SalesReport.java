import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesReport extends Report{
    static void salesreport() throws SQLException {
        String sql11="SELECT * FROM pos_system.invoice where DATE_FORMAT(date, '%Y-%m-%d')=DATE_FORMAT(sysdate(), '%Y-%m-%d')";
        ResultSet rsc = null; try {
            rsc = Main.sqll.executeQuery(sql11);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {
            while (rsc.next()) {
                System.out.println("\t"+rsc.getString("Itemname")+"\t\t"+rsc.getDouble("unitprice")+
                        "\t\t"+rsc.getInt("Qty")+"\t\t"+ rsc.getDouble("unitprice")*rsc.getInt("Qty"));
            }
        }

    }
}
