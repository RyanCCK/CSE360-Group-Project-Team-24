public class Accounts {
	private static int databaseSize = 10;
	private static String[] customerId = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private static String[] customerPassword = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private static String[] employeeId = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private static String[] employeePassword = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	
	public static boolean verifyCustomerLogin(String id, String password)
	{
		boolean valid = false;
		for (int i=0; i<databaseSize; ++i)
		{
			if (customerId[i].equals(id))
			{
				if (customerPassword[i].equals(password))
					valid = true;
			}
		}
		return valid;
	}
	
	public static boolean verifyEmployeeLogin(String id, String password)
	{
		boolean valid = false;
		for (int i=0; i<databaseSize; ++i)
		{
			if (employeeId[i].equals(id))
			{
				if (employeePassword[i].equals(password))
					valid = true;
			}
		}
		return valid;
	}
}
