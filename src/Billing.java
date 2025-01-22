import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Billing {
    public static String bid;
    public static int quantity;
    public static String itemName;
    public static double total;
    public static double mrp;

    public  StringBuilder sb = new StringBuilder();

    private double calculateFinal(double mrp, int quantity) {
        return mrp * quantity;
    }
    public static void createBill() throws SQLException {
        Billing bill1 = new Billing();


            System.out.println("WELCOME TO THE BILLING SYSTEM");
            Scanner scanner = new Scanner(System.in);


            String sql6 ="DROP TABLE IF EXISTS " + Main.uname +"";
            Main.sqll.executeUpdate(sql6);


            String sql5="Create table " + Main.uname + "  select * from invoice where 1=0";
            Main.sqll.executeUpdate(sql5);


            while (true) {
                System.out.println("Enter item ID and quantity (or type 'c' to cancel):");
                 bid = scanner.nextLine();

                if (bid.equalsIgnoreCase("c")) {
                    break;
                }

                System.out.println("Enter quantity:");
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity. Please enter a valid number.");
                    continue;
                }

                // Query to check the item in the inventory
                String sqlQuery = "SELECT * FROM pos_system.inventory WHERE itemid = '" + bid + "' and Qty>0";
                ResultSet result = Main.sqll.executeQuery(sqlQuery);

                if (result.next()) {
                     itemName = result.getString("item_name");
                     mrp = result.getDouble("mrp");

                     total = bill1.calculateFinal(mrp, quantity);

                     String sql7="insert into "+ Main.uname+" (InvoiceNo, Itemname, Qty, unitprice, Itemid,user,Date) values (0,'"+itemName+"',"+quantity+","+mrp+",'"+bid+"','"+ Main.uname+"',sysdate())" ;
                    Main.sqll.executeUpdate(sql7);

                    // Append item details to the bill
                    bill1.sb.append("Item ID: ").append(bid)
                            .append(", Name: ").append(itemName)
                            .append(", Quantity: ").append(quantity)
                            .append(", Total: ").append(total)
                            .append("\n");
                    System.out.println("Added: " + itemName + " (ID: " + bid + ") - Quantity: " + quantity + ", Total: " + total);
                } else { 
                    System.out.println("Item not found in the inventory.");
                }
            }

            System.out.println("Billing completed. Final data:");
            System.out.println(bill1.sb.toString());

            while (true) {
                System.out.println("Press 'p' to print the bill");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("p")) {
                    printBill bill2=new printBill(itemName,bid,quantity,total);
                    bill2.printHeader();
                    bill2.printItem();
                    bill2.saveInvoice();
                    break;
                }
            }

            scanner.close();
        }
    }

