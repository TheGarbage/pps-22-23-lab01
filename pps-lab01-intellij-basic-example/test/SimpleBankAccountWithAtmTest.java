import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest {

    private SimpleBankAccountWithAtm bankAccountWithAtm;

    @Nested
    class AtmTest{
        @BeforeEach
        void beforeEach(){
            accountHolder = new AccountHolder("Mario", "Rossi", 1);
            bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
        }

        @Test
        void testAtmDeposit() {
            bankAccountWithAtm.atmDeposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
            assertEquals(INITIAL_DEPOSIT_AMOUNT - bankAccountWithAtm.ATM_FEE_AMOUNT, bankAccountWithAtm.getBalance());
        }

        @Test
        void testWrongAtmDeposit() {
            bankAccountWithAtm.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
            bankAccountWithAtm.atmDeposit(WRONG_USERID, WRONG_DEPOSIT_AMOUNT);
            assertEquals(INITIAL_DEPOSIT_AMOUNT, bankAccountWithAtm.getBalance());
        }

        @Test
        void testAtmWithDraw(){
            atmWithdraw(accountHolder.getId());
            assertEquals(INITIAL_DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - bankAccountWithAtm.ATM_FEE_AMOUNT, bankAccountWithAtm.getBalance());
        }

        @Test
        void testWrongAtmWithdraw() {
            atmWithdraw(WRONG_USERID);
            assertEquals(INITIAL_DEPOSIT_AMOUNT, bankAccountWithAtm.getBalance());
        }

        private void atmWithdraw(int userId){
            bankAccountWithAtm.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
            bankAccountWithAtm.atmWithdraw(userId, WITHDRAW_AMOUNT);
        }
    }
}
