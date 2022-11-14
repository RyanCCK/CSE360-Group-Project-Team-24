import java.io.File;  //To Create New File
import java.io.IOException;
import java.io.FileWriter;
public class Thankyou {
	
	public static void Customer(String CustomerName, String OrderPizza)
	{
		
	}
	class CreateFile {
	 public static void main(String[] args) {
		    try {
		      File myObj = new File("Email.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("Email created: " + myObj.getName());
		      } else {
		        System.out.println("Email already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }
		}
	
	 class WriteToFile {
		  public static void main(String[] args) {
		    try {
		      FileWriter myWriter = new FileWriter("Email.txt");
		      myWriter.write("Thank you for the order!\n[Customer name], your order: [pizzas] is ready to be picked up");
		      myWriter.close();
		      System.out.println("Email sent to the customer");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }
		}
}
