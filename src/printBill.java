import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class printBill extends Billing {
    String itemName;
    String bid;
    double Qty;
    double Total;
    static int invoiceno;
    static int totalbill = 0;

    printBill(String itemName, String bid, double Qty, double Total) {
        this.itemName = itemName;
        this.bid = bid;
        this.Qty = Qty;
        this.Total = Total;
    }

    public static void saveInvoice() {
        try {
            String sql9 = "insert into invoice (InvoiceNo, Itemname, Qty, unitprice, Itemid, user, Date) " +
                    "select " + invoiceno + ", Itemname, Qty, unitprice, Itemid, user, Date from " + Main.uname;
            Main.sqll.executeUpdate(sql9);

            String sql11 = "update inventory a, " + Main.uname + " b set a.qty = a.qty - b.qty where a.Itemid = b.Itemid";
            Main.sqll.executeUpdate(sql11);

            String sql10 = "delete from " + Main.uname;
            Main.sqll.executeUpdate(sql10);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printHeader() {
        try {
            FileReader reader = new FileReader("art.txt");
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("\t\t\t\t\t\tNo-50, Kandy Road, Kiribathgoda");
        System.out.println("\t\t\t\t\t\tTEL:-0112-918366/0125");
        System.out.println("\t\t\t\t\t\tCashier : " + Main.uname);
        invoiceno = (int) (Math.random() * 1000);
        System.out.printf("\t\t\t\t\t\tInvoice no: %d\n", invoiceno);
        System.out.println("\t---------------------------------------------------------------");
        System.out.printf("\t%-20s %-10s %-10s %-15s\n", "Name", "Price", "Qty", "Nett Price");
        System.out.println("\t---------------------------------------------------------------");
    }

    public static void printItem() throws SQLException {
        String sql8 = "SELECT * FROM " + Main.uname;
        ResultSet rsc = null;

        try {
            rsc = Main.sqll.executeQuery(sql8);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (rsc.next()) {
            System.out.printf("\t%-20s %-10.2f %-10d %-15.2f\n",
                    rsc.getString("Itemname"),
                    rsc.getDouble("unitprice"),
                    rsc.getInt("Qty"),
                    rsc.getDouble("unitprice") * rsc.getInt("Qty"));

            int net = (int) (rsc.getDouble("unitprice") * rsc.getInt("Qty"));
            totalbill += net;
        }
        System.out.println("\t---------------------------------------------------------------");
        System.out.printf("\t%-20s %-10s %-10s %-15d\n", "Total bill", "", "", totalbill);
        System.out.println("\t---------------------------------------------------------------");
    }
}
