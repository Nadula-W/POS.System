import java.util.Scanner;

public class Inventory {
    public static void selectinventory(){
        int option=-1;
        while (option!=0) {
            System.out.println("Add inventory--6");
            System.out.println("Modify inventory--7");
            System.out.println("Exit 0");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option == 6) {
                AddInventory.addinventory();
            }
            if (option == 7) {
                ModifyInventory.modifyinventory();
            }
        }
    }
}
