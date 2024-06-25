package TransactionDataModel.java;

public class Main {

    public static void main(String[] args) {
       
        Transaction transaction1 = new Transaction("get", 100.0);                          // Create transactions
        Transaction transaction2 = new Transaction("give", 150.0);

      
        TransactionHistory history = new TransactionHistory();
        history.add(transaction1);
        history.add(transaction2);                                     // Create transaction history

       
        System.out.println("\nTransaction History:");
        for (Transaction transaction : history) {
            System.out.println(transaction);
        }


        TransactionProcessor processor = new TransactionProcessor();
        processor.startProcessing(2, 3); 

      
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    
        processor.stopProcessing();

     
        try {
            Thread.sleep(1000);    // Wait a moment for threads to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

      
        System.out.println("History after processing:");
        for (Transaction transaction : processor.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}


