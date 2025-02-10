import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CheckingAccount checkingAccount;
    private static SavingAccount savingAccount;
    private static String accountNumber;
    static String option;



    public static void main(String[] args) {
        while (true){
            displayMenu();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    createAccount();
                    break;
                case "2":
                     depositMoney();
                    break;
                case "3":
//                     withdrawMoney();
                    break;
                case "4":
//                     transferMoney();
                    break;
                case "5":
                    System.out.println(Main.Colors.YELLOW + "\n===== Account Information =====" + Main.Colors.RESET);
                     displayAccountInfo();
                    break;
                case "6":
//                     deleteAccount();
                    break;
                case "7":
                    System.out.println(Colors.BLUE + "Exiting the system... Goodbye!" + Colors.RESET);
                    System.exit(0);
                default:
                    System.out.println(Colors.RED + "Invalid option. Please try again." + Colors.RESET);
                    promptToContinue();
            }
        }
    }

    public static void displayAccountInfo(){
        if (checkingAccount != null && savingAccount != null) {
            System.out.println(Colors.GREEN + "Displaying both accounts:" + Colors.RESET);
            checkingAccount.display();
            savingAccount.display();
        } else if (checkingAccount != null) {
            System.out.println(Colors.GREEN + "Displaying Checking Account:" + Colors.RESET);
            checkingAccount.display();
        } else if (savingAccount != null) {
            System.out.println(Colors.GREEN + "Displaying Saving Account:" + Colors.RESET);
            savingAccount.display();
        } else {
            System.out.println(Colors.RED + "Neither Checking nor Saving account is created!" + Colors.RESET);
        }
    }



//  ---------------------------------------------------------------------------------------------
    private static void promptToContinue() {
        CellStyle centerStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(1, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        // Set column widths
        t.setColumnWidth(0, 50, 70);

        t.addCell(Colors.RED + "Press Enter to continue..." + Colors.RESET , centerStyle);
        System.out.println(t.render());
        scanner.nextLine();
    }
//  ------------------------------------------------------------------------------------------------

//  _______________________________________________________________________________________________________
    class Colors{
        public static final String RESET = "\u001B[0m";
        public static final String GREEN = "\u001B[32m";
        public static final String RED = "\u001B[31m";
        public static final String BLUE = "\u001B[34m";
        public static final String YELLOW = "\u001B[33m";
    }
//  ________________________________________________________________________________________________
    public static void displayMenu(){
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
//    -------------------------------------------------------------------------------------

    public static void createAccount(){
        System.out.println(Colors.GREEN + "Creating Account" + Colors.RESET);
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.print("Choose an option: ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        if(accountType == 1){
            System.out.print("Enter username: ");
            String userName = scanner.nextLine();
            System.out.print("Enter date of birth (dd-mm-yyyy): ");
            String dob = scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter phone number (9 digits): ");
            String phone = scanner.nextLine();

            accountNumber=String.valueOf((int)(Math.random()*1000000));
            checkingAccount = new CheckingAccount(userName, dob, gender, phone, accountNumber);
        }else {
            System.out.print("Enter username: ");
            String userName = scanner.nextLine();
            System.out.print("Enter date of birth (dd-mm-yyyy): ");
            String dob = scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter phone number (9 digits): ");
            String phone = scanner.nextLine();

            accountNumber = String.valueOf((int)(Math.random()*1000000));
            savingAccount =  new SavingAccount(userName, dob, gender, phone, accountNumber);
        }
    }
    public static void depositMoney(){
        System.out.println("1. checking account: ");
        System.out.println("2. saving account: ");
        String accountType = scanner.nextLine();
        if(accountType.equals("1")){
            if(checkingAccount == null){
                System.out.println("Don't have checking account!");
            }else {
                System.out.println("Enter money to deposit: ");
                checkingAccount.deposit(scanner.nextInt());
            }
        }else {
            if(savingAccount == null){
                System.out.println("Don't have saving account!");
            }else {
                System.out.println("Enter money to deposit: ");
                int amount = scanner.nextInt();
                savingAccount.deposit(amount);
            }
        }
    }





}