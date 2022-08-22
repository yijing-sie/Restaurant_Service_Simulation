package restaurant;

import java.util.Random;
public class Waiter implements Runnable{
    private final static int MAX_WAITER_MILLIS = 4000; // must wait for between 0 and 4 seconds.
    private final static int N_COURSES = 3; // number of courses is exactly three.
    private Table[] tables; // array of Table objects this Waiter waits on
    private String waiterName; // name of this Waiter
    private String[] customerNames; // names of Customers served by Waiter	
    private String[][] courses; //courses[i][j] has the j-th course for the i-th Customer of this Waiter
    private Object obj = new Object(); //for synchronization
    /**
     * initializes the data
     * @param tables  array of Table objects this Waiter waits on
     * @param waiterName	name of this Waiter
     * @param customerNames	 names of Customers served by Waiter	
     * @param courses	courses[i][j] has the j-th course for the i-th Customer of this Waiter
     */
    public Waiter( Table[] tables, String waiterName, String[] customerNames, String[][] courses ) {
        this.tables = tables;
        this.waiterName = waiterName;
        this.customerNames = customerNames;
        this.courses = courses;
    }

    /**
     * For each customer,a thread on this Waiter object serves the three courses in the correct order
     */
    public void run() {
        Random random = new Random();
        for(int j = 0 ; j < 3 ; j++) {
            for(int i = 0 ; i < tables.length ; i++ ) {
                synchronized(obj) {
                    System.out.println(waiterName + " serves " + customerNames[i] + " " + courses[i][j]);
                    tables[i].serve(courses[i][j]);					
                }
                try {
                    Thread.sleep( random.nextInt( MAX_WAITER_MILLIS ) );
                } catch (InterruptedException e) {
                    System.err.println("InterruptedException occurred while waking waiter thread");
                }
                if(j==2) tables[i].serve("DONE");
            }
        }

    }

}

	