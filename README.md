# Restaurant_Service_Simulation

## A restaurant service simulation utilizing synchronized object for multi-threading in Java
* [Restaurant.jar](Restaurant.jar) is the executable jar file for this application.
* [minions.txt](minions.txt) and [general.txt](general.txt) are both example input files for [Restaurant.jar](Restaurant.jar)
* The [src\restaurant](src\restaurant) contains 4 java files, [Restaurant](src\restaurant\Restaurant.java), [Customer](src\restaurant\Customer.java), 
 [Table](src\restaurant\Table.java), and [Waiter](src\restaurant\Waiter.java), and the `main()` method is inside [Restaurant](src\restaurant\Restaurant.java)
* The [doc](doc) contains the Jaca Docs for all the aforementioned java files.

## Details:
1. [Restaurant](src\restaurant\Restaurant.java) : takes in a `.txt` file in the same directory and start the restaurant service simulation according to the it.
2. [Customer](src\restaurant\Customer.java): contains a synchronization object for multi-threading and a `Customer` object that simulates a customer behavior of consuming three courses in the specified order according the  `.txt` file.
3. [Table](src\restaurant\Table.java): contains a `Table` object simulating a table where the served courses are put
4. [Waiter](src\restaurant\Waiter.java): contains a synchronization object for multi-threading and a `Waiter` object that simulates a waiter behavior of serving courses in the specified order according the  `.txt` file.
5. [minions.txt](minions.txt) / [general.txt](general.txt) : 

* The first line specifies the number of waiters
* All the lines starting from the second line are in the same format:
`waiter_name`  `num_of_customers_handled` `first_customer_name` `meal1` `meal2` `meal3` `second_customer_name` `meal1` `meal2` `meal3` ...

For example:
---
1

`Bob` ``2 `Phil` `bread` `pizza` `banana_bread` `Jerry` `chips_and_salsa` `tacos` `banana_flan` 

**NOTE**: Each waiter has to serve each customer courses in the order of `meal1`, `meal2`, `meal3`
