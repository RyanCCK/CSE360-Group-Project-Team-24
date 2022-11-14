# CSE360-Group-Project-Team-24
An application for ordering pizzas, and for fulfilling those orders. Both customer-facing and employee-facing.

&nbsp;  

Uses:

Java (min. requirement JDK 11)

JavaFX Version 19
https://gluonhq.com/products/javafx/

How to use:

Install JDK version 11 or higher.
Install JavaFX Version 19, taking note of the location of the installed folder.

Download the project zip file from Google Drive and unzip it.

Navigate to Eclipse, click "File->Open Projects from File System" and paste the directory of the project into the "Import Source" box.
Click Finish.

Next, go to "Run->Run Configuration" and navigate to arguments.
Under the VM arguments tab, paste 
--module-path "PATH-TO-LIB" --add-modules javafx.controls,javafx.fxml
replacing "PATH-TO-LIB" with the path to the /lib fdirectory in the JavaFX folder you took note of previously.

Next, run the program in Eclipse.

To log in as a customer, use the username "jdoe123", and the password "password", then click the login button.

To log in as a chef employee, navigate to the employee tab at the top left and use the username "rwater100" and the password "waterfall".
To log in as a cashier employee, navigate to the employee tab at the top left and use the username "gbox000" and the password "models".

When submitting an order as a customer, use the username "jdoe123" as the ASU ID.

To view orders in process, log in as either a chef or cashier employee.
