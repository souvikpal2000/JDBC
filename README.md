# JAVA DATABASE CONNECTIVITY (JDBC)

### Prerequisite to run JDBC Program in your System :-

1. You must have MySQL or XAMPP on your System.
2. You must have JDK on your System. 

### Setup Database 

You may either run the following Commands Present in *Queries.txt* or You may import *wipro.sql*

### Steps to import wipro.sql (For XAMPP Only)

*(Tested in XAMPP v3.3.0)*

1. Open XAMPP Control Panel.
2. Start **Apache** & **MySQL** Module.
3. Click the **Admin** Button of MySQL Module.
4. Create *wipro* Database either by using **GUI** or by running a **Query** :-
	* **GUI Method :-**
		* Click on **New** Button on Side Navbar.
		* In *Database name* Field write *wipro*.
		* Click on **Create** Button.
	* **Query Method :-**
		* Click on **SQL** Button present in the Header.
		* Type this Query :- *CREATE DATABASE wipro;*
		* Click on **Go** Button
5. Click the **Import** Button present in the Header.
6. Click on **Choose File** Button & select the file *wipro.sql*.
7. Click on **Go** Button.

### Steps to run the Program

1. Please note that your MySQL server is still running.
2. Open a Terminal in *src* Folder.
3. Copy paste the Command :- *javac -classpath ..\lib\mysql-connector-j-8.0.31.jar; Main.java*
4. Copy paste the Command :- *java -classpath ..\lib\mysql-connector-j-8.0.31.jar; Main*