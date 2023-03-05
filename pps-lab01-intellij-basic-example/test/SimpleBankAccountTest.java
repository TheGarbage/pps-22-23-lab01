import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;
    protected final int INITIAL_DEPOSIT_AMOUNT = 100;
    protected final int WITHDRAW_AMOUNT = 70;
    protected final int WRONG_USERID = 2;
    protected final int WRONG_DEPOSIT_AMOUNT = 50;

    void initializzation(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Nested
    class TestInitialCondition{
        @Test
        void testInitialBalance() {
            initializzation();
            assertEquals(0, bankAccount.getBalance());
        }
    }

    @Nested
    class TestDeposit{
        @BeforeEach
        void beforeEach(){
            initializzation();
            bankAccount = new SimpleBankAccount(accountHolder, 0);
            bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
        }

        @Test
        void testRightDeposit() {
            assertEquals(100, bankAccount.getBalance());
        }

        @Test
        void testWrongDeposit() {
            bankAccount.deposit(WRONG_USERID, WRONG_DEPOSIT_AMOUNT);
            assertEquals(INITIAL_DEPOSIT_AMOUNT, bankAccount.getBalance());
        }
    }

    @Nested
    class TestWithdraw{
        @BeforeEach
        void beforeEach(){
            initializzation();
            bankAccount = new SimpleBankAccount(accountHolder, INITIAL_DEPOSIT_AMOUNT);
        }

        @Test
        void testRightWithdraw() {
            bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
            assertEquals(INITIAL_DEPOSIT_AMOUNT - WITHDRAW_AMOUNT, bankAccount.getBalance());
        }

        @Test
        void testWrongWithdraw() {
            bankAccount.withdraw(WRONG_USERID, WITHDRAW_AMOUNT);
            assertEquals(INITIAL_DEPOSIT_AMOUNT, bankAccount.getBalance());
        }
    }
}