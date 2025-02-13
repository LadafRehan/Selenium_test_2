package prac3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccount {
    private String owner;
    private double balance;

    // Constructor
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Overloaded constructor for default balance of 0
    public BankAccount(String owner) {
        this(owner, 0);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for owner
    public String getOwner() {
        return owner;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000);
        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance()); // Output: 1500.0
        account.withdraw(300);
        System.out.println("Balance after withdrawal: " + account.getBalance()); // Output: 1200.0
        
        // Run tests manually
        BankAccountTest test = new BankAccountTest();
        test.runTests();
    }
}

// Test class inside the same file for quick testing
class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("John Doe", 100);
    }

    @Test
    void testInitialBalance() {
        assertEquals("John Doe", account.getOwner());
        assertEquals(100, account.getBalance(), 0.001);
    }

    @Test
    void testDepositValidAmount() {
        account.deposit(50);
        assertEquals(150, account.getBalance(), 0.001);
    }

    @Test
    void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount() {
        account.withdraw(40);
        assertEquals(60, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawExcessAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-20);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    // Method to manually run tests without JUnit framework execution
    void runTests() {
        setUp();
        testInitialBalance();
        testDepositValidAmount();
        testDepositNegativeAmount();
        testWithdrawValidAmount();
        testWithdrawExcessAmount();
        testWithdrawNegativeAmount();
        System.out.println("All tests passed!");
    }
}
