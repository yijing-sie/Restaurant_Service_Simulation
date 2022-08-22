package restaurant;

public class Table {
    private String course; // the name of the course
    private boolean isEmpty; // a flag used to see if the table is empty or is not empty(i.e., has an unfinished course)

    /**
     * default constructor
     */
    public Table() {
        isEmpty = true;
    } 

    /**
     * implements the Waiter serving a course
     * @param course  the name of the course
     */
    public synchronized void serve( String course ) {
        while(isEmpty == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException occurred while waking serve thread");
            }
        }
        isEmpty = false;
        this.course = course;
        notifyAll();
    } 

    /**
     * implements the Customer eating a course
     * @return	the course that customer is eating
     */
    public synchronized String eat() {
        while(isEmpty == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException occurred while waking eat thread");
            }
        }		
        isEmpty = true;
        notifyAll();
        return course;		
    }
}
