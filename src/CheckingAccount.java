public class CheckingAccount extends Account {

    private String accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance = 0;


    @Override
    void deposit(double amount) {
        balance += amount;
    }

    @Override
    void withdraw(double amount) {
        if(balance >amount){
            balance -= amount;
        }else {
            System.out.println(Main.Colors.RED + "You don't have enough money to withdrew! you balance is:" + " $" + balance + Main.Colors.RESET);
        }
    }

    @Override
    void transfer(double amount, Account account) {

    }
    @Override
    void display() {
        System.out.println(Main.Colors.YELLOW + "\n===== Account Information =====" + Main.Colors.RESET);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("User Name: " + userName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: $" + balance);
        System.out.println(Main.Colors.YELLOW + "===============================" + Main.Colors.RESET);

    }
//    -----------------------------------------

    public CheckingAccount(String accountNumber, String dateOfBirth, String gender, String phoneNumber, String userName) {
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }


//    -------------------------------------------

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

//    ------------------------------------------------

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
