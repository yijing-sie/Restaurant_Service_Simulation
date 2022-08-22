package restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Restaurant {

    private static String fileName;
    private static int numOfWaiters;
    private static int numOfCustomerForWaiter;

    public static void main(String[] args) {
        System.out.println("What is your file name?");
        Scanner input = new Scanner(System.in);
        fileName = input.nextLine();
        try {
            Scanner	scan = new Scanner( new File(fileName) );
            numOfWaiters =  scan.nextInt();
            String[] line = new String[numOfWaiters];
            ArrayList<Waiter> waiters = new ArrayList<Waiter>();
            ArrayList<Customer> customers = new ArrayList<Customer>();
            ArrayList<Table> tables =new ArrayList<Table>();
            int i = 0;
            scan.nextLine();//nonused space
            while( scan.hasNext() ) {
                line[i] = scan.nextLine();
                i++;
            }

            String waiterName;
            String[] customerNames;
            String[] subLineArray;
            int length;
            String[][] courses;
            Table[] table;
            int preNumOfCustomerForWaiter = 0;
            for(i = 0; i < numOfWaiters ; i++) {
                subLineArray = line[i].split(" ");
                length = subLineArray.length;				
                numOfCustomerForWaiter = Integer.parseInt(subLineArray[1]);				
                customerNames = new String[numOfCustomerForWaiter];				
                waiterName = subLineArray[0];
                courses = new String[numOfCustomerForWaiter][3];
                for(int j = 0; j< (int) ((length-2)/4) ; j++) {
                    tables.add(new Table());
                    customerNames[j] = subLineArray[2+4*j];
                    for(int k = 0 ; k < 3 ; k++) {
                        courses[j][k] = subLineArray[3 + j*4+k];
                    }	
                    customers.add(new Customer(tables.get(tables.size()-1),subLineArray[2+4*j]));
                }
                table = new Table[numOfCustomerForWaiter];
                for (int l = 0 ; l < numOfCustomerForWaiter ; l++) {
                    table[l] = tables.get(l+preNumOfCustomerForWaiter);
                }
                waiters.add(new Waiter(table,waiterName,customerNames,courses));
                preNumOfCustomerForWaiter += numOfCustomerForWaiter;
            }

            Thread waiterThread;
            Thread customerThread;
            for(Waiter waiter : waiters) {
                waiterThread = new Thread(waiter);
                waiterThread.start();

            }
            for(Customer customer : customers) {
                customerThread = new Thread(customer);
                customerThread.start();
            }
        }catch(IndexOutOfBoundsException iobe){
            System.err.println("IndexOutOfBoundsException occurred: "+ iobe.getMessage() );
        }catch(FileNotFoundException fnfe) {
            System.err.println("Couldn't find the file : " + fileName);
        }catch(InputMismatchException ime) {
            System.err.println("first line is not integer");
        }catch(IOException ioe) {
            System.err.println("IOException occurred");
        }

    }

}

