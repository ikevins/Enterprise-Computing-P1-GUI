“Program Assignment 1:  Event-Driven Programming” 
 
Objectives:  To practice event-driven programming using  Java-based GUIs. To refresh your basic 
Java skills. To simulate (albeit at a very high-level) an enterprise application. 
 
Description:  Develop a Java program that creates a standalone GUI application that simulates an e-
store (we’ll call our store Nile Dot Com... we’re not quite as big as Amazon.com!)1 which allows the 
user to add in stock items to a shopping cart and once all items are included, total all costs (including 
tax), produces an invoice, and append a transaction log file. 
 
Your program development must include the following steps:   
1. Create a main GUI containing the following components: 
a. An area that allows the user to input data into the application along with the descriptive 
text that describes each input area. 
b. A total of six buttons as shown below with functionality as described below. 
c. As illustrated below, the various buttons on the interface are only accessible at certain 
points during a user’s interaction with the e-store.   
2. An input file named “inventory.txt”.  This is a comma separated file which contains the 
data that will be read by the application when the user makes a selection.  Each line in this file 
contains four entries: an item id (a string), a quoted string containing the description of the 
item, an in stock status (a string), and the unit price for one of the item (a double).  A sample 
file is provided for you on  WebCourses.  Feel free to create your own input file for testing 
purposes or augment the provided input file. 
3. An output file (append only) named “transactions.txt” must be created that uniquely 
logs each user transaction with the e-store.  The unique transaction id will be generated as a 
permutation of the date/time string when the transaction occurred (see below). 
 
Restrictions: 
Your source file shall begin with comments containing the following information: 
/*  Name:  <your name goes here> 
     Course: CNT 4714 – Fall 2022 
     Assignment title: Project 1 – Event-driven Enterprise Simulation 
     Date: Sunday September 11, 2022 
*/ 
 
Input Specification:  The file “inventory.txt” as described above (see example below as 
well).  
 
Output  Specification:    Output  is  to  appear  in  the  specified  components  of  the  GUI  and  various 
message boxes that appear, plus the contents of the 
“transactions.txt” log file that will be generated. 
