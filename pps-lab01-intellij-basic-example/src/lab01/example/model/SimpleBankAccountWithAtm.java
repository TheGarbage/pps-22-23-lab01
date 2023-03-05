package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{
    public final int ATM_FEE_AMOUNT = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    public void atmDeposit(int userID, double amount) {
        deposit(userID, amount);
        payFee(userID);
    }

    public void atmWithdraw(int userID, double amount) {
        withdraw(userID, amount);
        payFee(userID);
    }

    private void payFee(int userID){
        if(checkUser(userID))
            this.balance -= ATM_FEE_AMOUNT;
    }
}
