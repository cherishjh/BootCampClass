package C14Interface.BankService;

public class BankAccount {
    private int accountNumber;
    private int balance;
    BankAccount(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void addmoney(int depositmoney){
        this.balance+= depositmoney;
    }

    public void setBalance(int balance) {
        this.balance = balance;

    }

    public int getBalance() {
        return balance;
    }

}

