import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    static int option = 0;









    public static void main(String[] args) {
        do{
            dispalyMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
//                    createAccount();
                    break;
                case 2:
//                    depositMoney();
                    break;
                case 3:
//                    withdrawMoney();
                    break;
                case 4:
//                    transferMoney();
                    break;
                case 5:
//                    displayAccountInfo();
                    break;
                case 6:
//                    deleteAccount();
                    break;
                case 7:
                    System.out.println(Colors.BLUE + "Exiting the system... Goodbye!" + Colors.RESET);
                    System.exit(0);
                default:
                    System.out.println(Colors.RED + "Invalid option. Please try again." + Colors.RESET);
            }
        }while (option >1 && option <8);
    }
//  _______________________________________________________________________________________________________
    class Colors{
        public static final String RESET = "\u001B[0m";
        public static final String GREEN = "\u001B[32m";
        public static final String RED = "\u001B[31m";
        public static final String BLUE = "\u001B[34m";
        public static final String YELLOW = "\u001B[33m";
    }
//  ________________________________________________________________________________________________
    public static void dispalyMenu(){
        System.out.println(Colors.BLUE + "\n===== Online Banking System =====" + Colors.RESET);
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Display Account Information");
        System.out.println("6. Delete Account");
        System.out.println("7. Exit");
        System.out.print(Colors.YELLOW + "Choose an option (1-7): " + Colors.RESET);
    }
}