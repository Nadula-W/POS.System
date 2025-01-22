import java.util.Scanner;

public class adminMenu extends mainMenu {

    int option = -1;


        Scanner scanner = new Scanner(System.in);
        public void displayoption() {
        while (option != 0) {
            System.out.println("---- Admin Menu ----");
            System.out.println("1) Inventory");
            System.out.println("2) Billing");
            System.out.println("3) Reports");
            System.out.println("0) Quit");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        Inventory.selectinventory();
                        break;
                    case 2:
                        Billing.createBill();
                        option = 0;
                        break;
                    case 3:
                        Report.reportMenu();
                        break;
                    case 0:
                        System.out.println("Exiting Admin Menu. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
