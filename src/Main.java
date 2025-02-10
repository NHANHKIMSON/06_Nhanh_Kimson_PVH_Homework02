import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                     withdrawMoney();
                    break;
                case "4":
                     transferMoney();
                    break;
                case "5":
                    System.out.println(Main.Colors.YELLOW + "========================================" + Main.Colors.RESET);
                     displayAccountInfo();
                    break;
                case "6":
                     deleteAccount();
                    break;
                case "7":
                    System.out.println(Colors.BLUE + "Exiting the system... Goodbye!" + Colors.RESET);
                    System.exit(0);
                default:
//                    System.out.println(Colors.RED + "Invalid option. Please try again." + Colors.RESET);
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

            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
            Table t = new Table(1, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
            t.setColumnWidth(0,50,70);
            t.addCell(Colors.RED + "Neither Checking nor Saving account is created!" + Colors.RESET , cellStyle);
            System.out.println(t.render());
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
        String con =  scanner.nextLine();
        if(Objects.equals(con, "\n")){
            return;
        }
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
        String userName, dob, gender, phone;
        if(accountType == 1){
            if(checkingAccount == null){
                while (true){
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    if(userName.matches("^[a-zA-Z][a-zA-Z ]*$")){
                        break;
                    }
                }
                while (true) {
                    System.out.print("Enter date of birth (dd-mm-yyyy): ");
                    dob = scanner.nextLine();
                    if (dob.matches("^([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$")) {
                        break;
                    } else {
                        System.out.println("Invalid date format. Please use dd-mm-yyyy.");
                    }
                }
                while (true) {
                    System.out.print("Enter gender (Male/Female/Other): ");
                    gender = scanner.nextLine();
                    if (gender.matches("(?i)^(male|female|other)$")) {
                        break;
                    } else {
                        System.out.println("Invalid gender. Please enter Male, Female, or Other.");
                    }
                }

                while (true) {
                    System.out.print("Enter phone number (9-12 digits): ");
                    phone = scanner.nextLine();
                    if (phone.matches("^.{9,12}$")) {
                        break;
                    } else {
                        System.out.println("Invalid phone number. Please enter exactly 9 digits.");
                    }
                }

                accountNumber=String.valueOf((int)(Math.random()*1000000));
                checkingAccount = new CheckingAccount(accountNumber,dob,gender, phone, userName);
                System.out.println(Colors.GREEN + "Checking account has created successfully!" + Colors.RESET);

            }else {
                System.out.println(Colors.RED + "You are already have checking account!" + Colors.RESET );
            }
        }else {
            if(savingAccount == null){
                while (true){
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    if(userName.matches("^[a-zA-Z][a-zA-Z ]*$")){
                        System.out.println(Colors.RED + "Wrong format" + Colors.RESET);
                        break;
                    }
                }
                while (true) {
                    System.out.print("Enter date of birth (dd-mm-yyyy): ");
                    dob = scanner.nextLine();
                    if (dob.matches("^([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$")) {
                        System.out.println(Colors.RED + "Wrong format" + Colors.RESET);

                        break;
                    } else {
                        System.out.println("Invalid date format. Please use dd-mm-yyyy.");
                    }
                }
                while (true) {
                    System.out.print("Enter gender (Male/Female/Other): ");
                    gender = scanner.nextLine();
                    if (gender.matches("(?i)^(male|female|other)$")) {
                        System.out.println(Colors.RED + "Wrong format" + Colors.RESET);
                        break;
                    } else {
                        System.out.println("Invalid gender. Please enter Male, Female, or Other.");
                    }
                }

                while (true) {
                    System.out.print("Enter phone number (9-12 digits): ");
                    phone = scanner.nextLine();
                    if (phone.matches("^.{9,12}$")) {
                        System.out.println(Colors.RED + "Wrong format" + Colors.RESET);
                        break;
                    } else {
                        System.out.println("Invalid phone number. Please enter exactly 9 digits.");
                    }
                }
                accountNumber = String.valueOf((int)(Math.random()*1000000));
                savingAccount =  new SavingAccount(accountNumber,dob,gender, phone, userName);
                System.out.println(Colors.GREEN + "Saving account has created successfully!" + Colors.RESET);
            }else {

                CellStyle centerStyle = new CellStyle(CellStyle.HorizontalAlign.center);
                Table t = new Table(1, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
                // Set column widths
                t.setColumnWidth(0, 50, 70);

                t.addCell(Colors.RED + "You are already have Saving account!" + Colors.RESET , centerStyle);
                System.out.println(t.render());
            }
        }
    }
    public static void depositMoney(){
        String accountType;
        while (true) {
            System.out.println("1, Checking Account ");
            System.out.println("2, Saving Account ");
            System.out.println("3, Back -> ");
            System.out.print("Choose Account: ");
            accountType = scanner.nextLine();

            if (accountType.matches("^[1-3]$")) {  // Ensures input is 1, 2, or 3
                break;
            } else {
                System.out.println("Invalid input. Please choose a number between 1 and 3.");
            }
        }

        if(accountType.equals("1")){
            if(checkingAccount == null){
                System.out.println("Don't have checking account!");
            }else {
                System.out.print("Enter money to deposit: ");
                String amount = scanner.nextLine();
                checkingAccount.deposit(Double.parseDouble(amount));
            }
        }else {
            if(savingAccount == null){
                System.out.println("Don't have saving account!");
            }else {
                System.out.print("Enter money to deposit: ");
                String amount = scanner.nextLine();
                savingAccount.deposit(Double.parseDouble(amount));
            }
        }
    }

    public static void withdrawMoney(){
        String accountType;
        while (true) {
            System.out.println("1, Checking Account ");
            System.out.println("2, Saving Account ");
            System.out.println("3, Back -> ");
            System.out.print("Choose Account: ");
            accountType = scanner.nextLine();

            if (accountType.matches("^[1-3]$")) {  // Ensures input is 1, 2, or 3
                break;
            } else {
                System.out.println("Invalid input. Please choose a number between 1 and 3.");
            }
        }

        if(accountType.equals("3")){
            return;
        }
        if(accountType.equals("1")){
            System.out.print("Enter amount to withdrew: ");
            String amount = scanner.nextLine();
            checkingAccount.withdraw(Double.parseDouble(amount));
        }else {
            System.out.print("Enter amount to withdrew: ");
            String amount = scanner.nextLine();
            savingAccount.withdraw(Double.parseDouble(amount));
        }
    }
    public static void transferMoney(){
        String accountType;
        while (true) {
            System.out.println("1, Checking Account ");
            System.out.println("2, Saving Account ");
            System.out.println("3, Back -> ");
            System.out.print("Choose Account: ");
            accountType = scanner.nextLine();

            if (accountType.matches("^[1-3]$")) {  // Ensures input is 1, 2, or 3
                break;
            } else {
                System.out.println("Invalid input. Please choose a number between 1 and 3.");
            }
        }
        if(accountType.equals("3")){
            return;
        }
        if(accountType.equals("1") && checkingAccount !=null && savingAccount !=null){
            System.out.print("Enter amount to transfer: ");
            String amount = scanner.nextLine();
            checkingAccount.transfer(Double.parseDouble(amount), savingAccount);
        }else if(checkingAccount !=null && savingAccount !=null){
            System.out.print("Enter amount to transfer: ");
            String amount = scanner.nextLine();
            savingAccount.transfer(Double.parseDouble(amount), checkingAccount);
        }else {
            System.out.println(Colors.RED + "You must to create account to transfer!" + Colors.RESET);
        }
    }
    public static void deleteAccount(){
        String accountType;
        while (true) {
            System.out.println("1, Checking Account ");
            System.out.println("2, Saving Account ");
            System.out.println("3, Back -> ");
            System.out.print("Choose Account: ");
            accountType = scanner.nextLine();

            if (accountType.matches("^[1-3]$")) {  // Ensures input is 1, 2, or 3
                break;
            } else {
                System.out.println("Invalid input. Please choose a number between 1 and 3.");
            }
        }
        if(accountType.equals("1") && checkingAccount !=null && savingAccount !=null){


            String amount = String.valueOf(checkingAccount.getBalance());
            checkingAccount.transfer(Double.parseDouble(amount), savingAccount);
            checkingAccount = null;
            System.out.println(Colors.GREEN + "Checking account has deleted successfully!" + Colors.RESET);
        }else if(checkingAccount !=null && savingAccount !=null){
            String amount = String.valueOf(savingAccount.getBalance());
            savingAccount.transfer(Double.parseDouble(amount), checkingAccount);
            savingAccount = null;
            System.out.println(Colors.GREEN + "Saving account has deleted successfully!" + Colors.RESET);
        }else {
            System.out.println(Colors.RED + "You must to create account to transfer!" + Colors.RESET);
        }
    }
}