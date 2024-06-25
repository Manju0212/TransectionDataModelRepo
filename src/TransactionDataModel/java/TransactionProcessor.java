
package TransactionDataModel.java;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

public class TransactionProcessor {
    private BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    
    private TransactionHistory transactionHistory = new TransactionHistory();
    
    private volatile boolean running = true;

    private class TransactionProducer implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            try {
                while (running) {
                    Transaction transaction = new Transaction("Type" + random.nextInt(5), random.nextDouble() * 1000);
                    transactionQueue.put(transaction);
                    System.out.println("Produced: " + transaction);
                    Thread.sleep(1000);           
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private class TransactionConsumer implements Runnable {
        @Override
        public void run() {
            try {
                while (running) {
                    Transaction transaction = transactionQueue.take();
                    System.out.println("Consumed: " + transaction);
                    transactionHistory.add(transaction);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void startProcessing(int numProducers, int numConsumers) {
        for (int i = 0; i < numProducers; i++) {
            new Thread(new TransactionProducer()).start();
        }

        for (int i = 0; i < numConsumers; i++) {
            new Thread(new TransactionConsumer()).start();
        }
    }

    public void stopProcessing() {
        running = false;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
}
