package C14Interface.BankService;

public interface BankService {
    //    예금
    void deposit(BankAccount bankAccount, long money);

    //    출금
    void withdraw(BankAccount bankAccount, long money);


}

