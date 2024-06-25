
package TransactionDataModel.java;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class TransactionHistory implements Iterable<Transaction> {
    private List<Transaction> transactionList;

    public TransactionHistory() {
        this.transactionList = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized boolean add(Transaction transaction) {
        return transactionList.add(transaction);
    }

    public synchronized Transaction remove(int index) {
        return transactionList.remove(index);
    }

    public synchronized void clear() {
        transactionList.clear();
    }

    public synchronized Transaction get(int index) {
        return transactionList.get(index);
    }

    @Override
    public synchronized Iterator<Transaction> iterator() {
        return transactionList.iterator();
    }
}
