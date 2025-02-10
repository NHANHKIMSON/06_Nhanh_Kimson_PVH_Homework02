public class SavingAccount extends Account {

    private String accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance = 0;
//    ----------------------------------------------------------
    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println(Main.Colors.GREEN + "You have Deposit $" + amount  + " into your Saving account " + Main.Colors.RESET);
    }

    @Override
    void withdraw(double amount) {
        if(amount > balance*0.8){
            System.out.println(Main.Colors.RED + "You can't not withdrew money higher than 80% in your account!" + Main.Colors.RESET);
        }else if(balance >amount){
            balance -= amount;
            System.out.println(Main.Colors.YELLOW + "You are withdrew money: $" + amount + Main.Colors.RESET);
        }else {
            System.out.println("You don't have enough money to withdrew!:" + " $" + balance);
        }
    }

    @Override
    void transfer(double amount, Account account) {
        if(balance >amount){
            balance -= amount;
            System.out.println(Main.Colors.GREEN + "You have transfer $" + amount + " to Checking account" + Main.Colors.RESET);
        }else {
            System.out.println(Main.Colors.RED + "You don't have enough money to withdrew! you balance is:" + " $" + balance + Main.Colors.RESET);
        }
    }

    @Override
    void delete(double amount, Account account) {
        if(account == null){
            account.deposit(amount);
        }
    }

    @Override
    void display() {
        System.out.println(Main.Colors.YELLOW + "\n========================================");
        System.out.printf("%s%-20s%s%n", Main.Colors.BLUE, "===== Account Information =====", Main.Colors.RESET);
        System.out.println(Main.Colors.YELLOW + "========================================" + Main.Colors.RESET);

        // Table-style aligned formatting
        System.out.printf(Main.Colors.GREEN + "%-20s: %s%n" + Main.Colors.RESET, "Account Number", accountNumber);
        System.out.printf("%-20s: %s%n", "User Name", userName);
        System.out.printf("%-20s: %s%n", "Date of Birth", dateOfBirth);
        System.out.printf("%-20s: %s%n", "Gender", gender);
        System.out.printf("%-20s: %s%n", "Phone Number", phoneNumber);
        System.out.printf(Main.Colors.GREEN + "%-20s: $%.2f%n" + Main.Colors.RESET, "Balance", balance);

        System.out.println(Main.Colors.YELLOW + "========================================" + Main.Colors.RESET);
    }
//    void display() {
//        System.out.println("Account Number: " + accountNumber);
//        System.out.println("User Name: " + userName);
//        System.out.println("Date of Birth: " + dateOfBirth);
//        System.out.println("Gender: " + gender);
//        System.out.println("Phone Number: " + phoneNumber);
//        System.out.println("Balance: $" + balance);
//        System.out.println(Main.Colors.YELLOW + "===============================" + Main.Colors.RESET);
//    }

//    -----------------------------------------------------------


    public SavingAccount(String accountNumber, String dateOfBirth, String gender, String phoneNumber, String userName) {
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }
//    -------------------------------------------------------------
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

//    ------------------------------------------------------------------
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
