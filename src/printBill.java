import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class printBill extends Billing{
    String itemName;
    String bid;
    double Qty;
    double Total;
    static int invoiceno;
    static int totalbill=0;
    printBill(String itemName, String bid, double Qty, double Total){
        this.itemName=itemName;
        this.bid=bid;
        this.Qty=Qty;
        this.Total=Total;
    }
    public static void saveInvoice(){
        try {
       String sql9="insert into invoice (InvoiceNo, Itemname, Qty, unitprice, Itemid, user, Date) " +
               "select "+invoiceno+", Itemname, Qty, unitprice, Itemid, user, Date from "+Main.uname+"";
        Main.sqll.executeUpdate(sql9);

        String sql11="update inventory a, "+Main.uname+" b set a.qty=a.qty-b.qty where a.Itemid=b.Itemid";
       Main.sqll.executeUpdate(sql11);


        String sql10="delete from "+Main.uname+"";
        Main.sqll.executeUpdate(sql10);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printHeader() {

        System.out.println("\t\t\t No-50,Kandy Road,Kiribathgoda \t\t\t");
        System.out.println("\tTEL:-0112-918366/0125");
        System.out.println("\tCashier : " + Main.uname);
        invoiceno = (int) (Math.random() * 1000);
        System.out.printf("\tInvoice no: %d", (int) invoiceno);
        System.out.println();
        System.out.println("\t-------------------------------------------------\t");
        System.out.println("\tName\t\tPrice\t\tQty\t\tNett Price");
        System.out.println("\t------------------------------------------\t");
    }

    public static void printItem() throws SQLException {
        String sql8="SELECT * FROM " + Main.uname + "";
        ResultSet rsc = null; try {
            rsc = Main.sqll.executeQuery(sql8);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {
                while (rsc.next()) {
                    System.out.println("\t"+rsc.getString("Itemname")+"\t\t"+rsc.getDouble("unitprice")+
                            "\t\t"+rsc.getInt("Qty")+"\t\t"+ rsc.getDouble("unitprice")*rsc.getInt("Qty"));

                    int net= (int) (rsc.getDouble("unitprice")*rsc.getInt("Qty"));
                     totalbill+=net;
                }
            System.out.println("\t------------------------------------------\t");
            System.out.printf("Total\t\t\t\t\t\t\t\t\t\t%d",totalbill);
            System.out.println("\t------------------------------------------\t");

        }

    }
}
