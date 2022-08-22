# Restaurant_Service_Simulation

## A restaurant service simulation utilizing synchronized object for multi-threading in Java
* [Restaurant.jar](Restaurant.jar) is the executable jar file for this application.
* [minions.txt](minions.txt) and [general.txt](general.txt) are both example input files for [Restaurant.jar](Restaurant.jar)
* The [src/restaurant](src/restaurant) contains 4 java files, [Restaurant](src/restaurant/Restaurant.java), [Customer](src/restaurant/Customer.java), 
 [Table](src/restaurant/Table.java), and [Waiter](src/restaurant/Waiter.java), and the `main()` method is inside [Restaurant](src/restaurant/Restaurant.java)
* The [doc](doc) contains the Jaca Docs for all the aforementioned java files.

## Details:
1. [Restaurant](src/restaurant/Restaurant.java) : takes in a `.txt` file in the same directory and start the restaurant service simulation
2. [Customer](src/restaurant/Customer.java): contains a synchronization object for multi-threading and a `Customer` object that simulates a customer behavior of consuming three courses in the specified order according the  `.txt` file
3. [Waiter](src/restaurant/Waiter.java): contains a synchronization object for multi-threading and a `Waiter` object that simulates a waiter behavior of serving courses in the specified order according the  `.txt` file.
4. [Table](src/restaurant/Table.java): contains a `Table` object simulating a table where the served courses are placed
5. [minions.txt](minions.txt) / [general.txt](general.txt) : 

* The first line specifies the number of waiters
* All the lines starting from the second line are in the same format:


`waiter_name`  `num_of_customers_handled` `first_customer_name` `meal1_1` `meal1_2` `meal1_3` `second_customer_name` `meal2_1` `meal2_2` `meal2_3` ...

=> `waiter_name` has  to serve `num_of_customers_handled` customers who are `first_customer_name`, `second_customer_name` ..., and the **serving order has to follow the ordering order**, namely `meali_1` `meali_2` `meali_3`.

For example:
---
1

`Bob` `2` `Phil` `bread` `pizza` `banana_bread` `Jerry` `chips_and_salsa` `tacos` `banana_flan` 
