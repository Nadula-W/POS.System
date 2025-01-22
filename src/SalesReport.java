import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesReport extends Report {
    static void salesreport() throws SQLException {
        System.out.println("\t\t\t\t\t\t\tSales Report");
        System.out.println("\t--------------------------------------------------------------------------");
        System.out.printf("\t%-15s %-20s %-15s %-10s %-15s\n", "Invoice No", "Item Name", "Unit Price", "Qty", "Net Balance");
        System.out.println("\t--------------------------------------------------------------------------");

        String sql11 = "SELECT * FROM pos_system.invoice WHERE DATE_FORMAT(date, '%Y-%m-%d') = DATE_FORMAT(sysdate(), '%Y-%m-%d')";
        ResultSet rsc = null;

        try {
            rsc = Main.sqll.executeQuery(sql11);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (rsc.next()) {
            System.out.printf("\t%-15d %-20s %-15.2f %-10d %-15.2f\n",
                    rsc.getInt("InvoiceNo"),
                    rsc.getString("Itemname"),
                    rsc.getDouble("unitprice"),
                    rsc.getInt("Qty"),
                    rsc.getDouble("unitprice") * rsc.getInt("Qty"));
        }

        System.out.println("\t--------------------------------------------------------------------------");
    }
}
