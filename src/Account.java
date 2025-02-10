abstract class Account {
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void transfer(double amount, Account account);
    abstract void delete(double amount, Account account);
    abstract void display();
}
