package TransactionDataModel.java;

public class Transaction {
    
    private static long idCounter = 1;

    private static synchronized String generateTransactionId() {
        return "TI" + idCounter++;
    }

    private String transactionId;
    private long timestamp;
    private String transactionType;
    private double amount;

    public Transaction(String transactionType, double amount) {
        this.transactionId = generateTransactionId();
        this.timestamp = System.currentTimeMillis();
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", timestamp=" + timestamp +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
