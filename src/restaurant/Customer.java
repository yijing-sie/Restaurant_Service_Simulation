package restaurant;

import java.util.Random;
public class Customer implements Runnable{
    private final static int MAX_CUSTOMER_MILLIS = 4000; // must wait for between 0 and 4 seconds.
    private Table table; // Table object that this Customer sits at
    private String customerName; // name of this Customer
    private Object obj = new Object(); //for synchronization
    /**
     * initializes the data
     * @param table	Table object that this Customer sits at
     * @param customerName	name of this Customer
     */
    public Customer( Table table, String customerName ) {
        this.table = table;
        this.customerName = customerName;
    }

    /**
     *  For each customer, a thread on this Customer object eats the three courses in the correct order
     */
    public void run() {
        Random random = new Random();
        String course;
        while(!(course = table.eat()).equals("DONE")) {
            synchronized(obj) {				
                System.out.println(customerName + " is eating: " + course);
            }
            try {
                Thread.sleep( random.nextInt( MAX_CUSTOMER_MILLIS ) );
            } catch (InterruptedException e) {
                System.err.println("InterruptedException occurred while waking waiter thread");
            }

        }
    }

}
