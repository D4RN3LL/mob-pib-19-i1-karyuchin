package program.accounting;

import java.math.BigDecimal;
import java.util.*;

public final class Account {

    private static final HashMap<Integer, Account> accounts = new HashMap<>();

    private final List<Transaction> transactions;
    private final int id;

    private BigDecimal balance;
    private int quantity;

    private Account(int id) {
        transactions = new ArrayList<>();
        balance = new BigDecimal(0);
        accounts.put(id, this);
        this.id = id;
    }

    public static void MakeTransaction(int creditID, int creditQuantity, int debitID, int debitQuantity, BigDecimal balance, String comment) {
        var transaction = new Transaction(creditID, creditQuantity, debitID, debitQuantity, balance, comment);

       var credit =  getInstance(transaction.creditID());
       var debit =  getInstance(transaction.debitID());

        credit.setBalance(credit.getBalance().subtract(transaction.balance()));
        debit.setBalance(debit.getBalance().add(transaction.balance()));

        credit.setQuantity(credit.getQuantity() - transaction.creditQuantity());
        debit.setQuantity(debit.getQuantity() + transaction.debitQuantity());

        credit.transactions.add(transaction);
        debit.transactions.add(transaction);
    }

    public static Account getInstance(int id) {
        if (accounts.containsKey(id)) return accounts.get(id);
        else return new Account(id);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Transaction> getConduits() {
        return transactions;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getID() {
        return id;
    }
}
