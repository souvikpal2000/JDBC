# JAVA DATABASE CONNECTIVITY (JDBC)

### Prerequisite to run JDBC Program in your System :-

1. You must have MySQL or XAMPP on your System.
2. You must have JDK on your System. 
3. You must have Eclipse on your System.

### Setup Eclipse

1. Click : [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)
2. Then, select Operating System **Platform Independent** 
3. Then, download the ZIP File **Platform Independent (Architecture Independent), ZIP Archive**.
4. Extract the Downloaded File.
5. Clone this GIT Repository into your Local System.
5. Open Eclipse & Import the **Existing Projects into Workspace**.
6. Right Click on the Imported Project, then click on **Build Path** -> **Configure Build Path**.
7. Then, click on **Add External JARs**.
8. Select the *mysql-connector.jar* from your Local System.
9. Then, click on **Apply & Close**.

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
2. Right click on the project, select **Run As** -> **Java Application**.

## Note

If you don't have Eclipse then switch to *feature* branch of this GIT Repository.