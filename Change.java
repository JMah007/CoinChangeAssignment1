/*This program contains data relating to change as well as methods that manipulate these values
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: Change.java
 Date Last Edited: 15/09/2022
 Assignment 1
 Purpose: Contains data relating to money values and methods that manipulate these values
 Assumptions: Values are in American dollars as cents and an integer. Names must be one worded and the same goes for output values
 */
import java.util.Scanner;

public class Change {
	public static final int COIN1 = 100;
	public static final int COIN2 = 50;
	public static final int COIN3 = 25;
	public static final int COIN4 = 10;
	public static final int COIN5 = 5;
	
	private String name;
	private int amount;
	
	private int numCoin1 = 0;
	private int numCoin2 = 0;
	private int numCoin3 = 0;
	private int numCoin4 = 0;
	private int numCoin5 = 0;
	
	
	
	//Default constructor which sets name and amount to default values
	/*Postcondition: sets amount and name to default values 
	 */
	public Change() 
	{
		
		set("No name was given", 0);
		
	}
	
	
	
	
	//constructor which sets name and amount to values passed in as parameters
	/*Precondition: takes parameters enteredName a string and enteredAmount an integer
	 * Postcondition: creates a new object 
	 */
	public Change(String enteredName, int enteredAmount) 
	{

		set(enteredName, enteredAmount);
	
	}
	
	
	
	//Mutator method that modifies name and amount
	/*Precondition: takes parameters enteredName a string and enteredAmount an integer
	 * Postcondition: sets name as a string and amount as an integer
	 */
	private void set(String enteredName, int enteredAmount) 
	{
		name = enteredName;
		amount = enteredAmount;
	}
	
	
	
	//Mutator method that modifies the number of coins for each denomination
	/*Precondition: takes as parameters setNumCoin1, setNumCoin2, setNumCoin3, setNumCoin4, setNumCoin5 which are all positive integers
	 * Postcondition: sets setNumCoin1, setNumCoin2, setNumCoin3, setNumCoin4, setNumCoin5 as positive integers
	 */
	private void set(int setNumCoin1, int setNumCoin2, int setNumCoin3, int setNumCoin4, int setNumCoin5) 
	{
		numCoin1 = setNumCoin1;
		numCoin2 = setNumCoin2;
		numCoin3 = setNumCoin3;
		numCoin4 = setNumCoin4;
		numCoin5 = setNumCoin5;
	}
	
	
	
	//Assessor method which retrieves the number of coins for numCoin1
	/*Postcondition: returns numCoin1 an integer 
	 */
	public int getNumCoin1() 
	{
		return numCoin1;
	}
	
	//Assessor method which retrieves the number of coins for numCoin2
	/*Postcondition: returns numCoin2 an integer 
	*/
	public int getNumCoin2() 
	{
		return numCoin2;
	}
	
	//Assessor method which retrieves the number of coins for numCoin3
	/*Postcondition: returns numCoin3 an integer 
	*/
	public int getNumCoin3() 
	{
		return numCoin3;
	}
	
	//Assessor method which retrieves the number of coins for numCoin4
	/*Postcondition: returns numCoin4 an integer 
	*/
	public int getNumCoin4() 
	{
		return numCoin4;
	}
	
	//Assessor method which retrieves the number of coins for numCoin5
	/*Postcondition: returns numCoin5 an integer 
	*/
	public int getNumCoin5() 
	{
		return numCoin5;
	}
	
	
	
	
	//assessor method which retrieves name
	/*Postcondition: returns name a string
	 */
	public String getName() 
	{
		return name;
	}
	
	//assessor method which retrieves amount
	/*Postcondition: returns amount an integer
	 */
	public int getAmount() 
	{
		return amount;
	}

	
	

	//Validates amount passed as a parameter 
	/*Precondition: parameters are amount which is an integer and kb which is an object of the Scanner class
	 * Postcondition: returns amount which is a positive integer equal to or greater than 3
	 */
	public static int validateAmount(int amount, Scanner kb)
	{
		while (amount < 3) {
			System.out.println("Error, please enter a number greater than or equal to 3: ");
			amount = kb.nextInt();
							  }
		return amount;
	}
	
	
	

	//Displays menu to user 
	/*Postcondition: displays a menu filled with options the user can choose  
	 */
	public static void displayMenu() 
	{
		System.out.print("1. Enter a name\n"
				+ "2. Find the name with the largest amount and display change to be given for each denomination\n"
				+ "3. Find the name with the smallest amount and display change to be given for each denomination\n"
				+ "4. Calculate and display the total number of coins for each denomination\n"
				+ "5. Calculate and display the total amount for the sum of all denominations\n"
				+ "6. Exit\n");
	}
	
	
	
	
	//Validates input to make sure either Y for yes and N for no is entered 
	/*Precondition: parameters choice which is is a string of letters and kb which is an object of the Scanner class
	 * Postcondition: returns true if user enters Y/y and false if user enters N/n
	 */
	public static boolean validateContinueOption(String choice, Scanner kb) 
	{
		boolean yes;
		boolean no;
		boolean statusFinal;
	
	
		yes = choice.equalsIgnoreCase("Y");
		no = choice.equalsIgnoreCase("N");
		
		//If input is not equal to yes or no
		while((yes == false) && (no == false)) {
			System.out.println("Error, enter either Y or N");
			choice = kb.nextLine();
			yes = choice.equalsIgnoreCase("Y");
			no = choice.equalsIgnoreCase("N");
											   }
		if(yes == true) {
			statusFinal = true;
		
					    }
		else {
			statusFinal = false;
		     }
	
		return statusFinal;
	}




	//Validates input to make sure one of the options displayed in the menu is chosen
	/*Precondition: takes parameters choice which is an integer and kb is an object of the Scanner class
	 * Postcondition: returns an integer between and including 1 and 6
	 */
	public static int validateMenuChoice(int choice, Scanner kb) 
	{
		
		while(((choice < 1) || (choice > 6))) {
			System.out.println("Error, please choose an option between 1-6: ");
			choice = kb.nextInt();
											  }
		return choice;
	}
	
	
	

	//Checks array to ensure the same name doesnt exist in the system and informs the user if so
	/*Precondition: takes as parameters arrayPeople which is an array of objects and numPeople which is an integer representing the number of objects in arrayPeople
	 * Postcondition: returns a message if duplicate name is found in the array
	 */
	public static void searchDuplicateName(Change[] arrayPeople, int numPeople) 
	{
		int i, j;
		boolean foundDuplicate;
		
		for(j=0; j<numPeople; j++) {
			for(i=j+1; i<numPeople; i++) {
				foundDuplicate = (arrayPeople[j].getName()).equalsIgnoreCase(arrayPeople[i].getName());
				if(foundDuplicate) {
					System.out.println("Name: " + arrayPeople[i].getName());
					System.out.println("Already exists in the system");
								   }
			
										 }
								   }
	}


	

	//Gets name from parameter and searches for it in the array and returns location of it 
	/*Precondition: takes as parameters name which is a one worded string, arrayPeople which is an array of objects and numPeople an integer representing the number of objects in the array
	 * Postcondition: returns index an integer representing where the location of the found name is
	 */
	public static int searchName(String name, Change[] arrayPeople, int numPeople)
	{
		boolean foundName;
		int i;
		int index = -1;
	
		for(i=0; i<numPeople; i++) {
			foundName = name.equalsIgnoreCase(arrayPeople[i].getName());
		
			if(foundName) {
				index = i;
						  }
								   }
	
		return index;
	}



	
	//calculates change for each person
	/*Precondition: takes as parameters arrayPeople an array of objects and numPeople an integer representing the number of objects in the array
	 * Postcondition: returns the number of coins as an integer for each denomination for each person in the array with as much of the higher values as possible
	 */
	public static void calcChange(Change[] arrayPeople, int numPeople) 
	{
		int calcNumCoin1,calcNumCoin2, calcNumCoin3, calcNumCoin4, calcNumCoin5;
		int i;
		
		
		for(i=0; i<numPeople; i++) {
		
		 calcNumCoin1 = ((arrayPeople[i].getAmount()) / (COIN1));
		 calcNumCoin2 = ((arrayPeople[i].getAmount()) % (COIN1) / (COIN2));
		 calcNumCoin3 = ((arrayPeople[i].getAmount()) % (COIN1) % (COIN2) / (COIN3));
		 calcNumCoin4 = ((arrayPeople[i].getAmount()) % (COIN1) % (COIN2) % (COIN3) / (COIN4));
		 calcNumCoin5 = ((arrayPeople[i].getAmount()) % (COIN1) % (COIN2) % (COIN3) % (COIN4) / (COIN5));
		 
		arrayPeople[i].set(calcNumCoin1, calcNumCoin2, calcNumCoin3, calcNumCoin4, calcNumCoin5);
								   }
	}

	


	//Rounds amount to nearest multiple of 5
	/*Precondition: takes as parameters amount which is a positive integer 
	 * Postcondition: returns amount as an integer and a multiple of 5
	 */
	public static int roundMultiple5(int amount) 
	{
		
		double remainder;
		double quotient;
		
		remainder = (double)amount % 5;
		
		quotient = (double)amount / 5;
		
				
		if (remainder == 1.0 || remainder == 2.0) {
			amount = (int)(5 *(Math.floor(quotient)));
												 }
		else {
			amount = (int)(5 *(Math.ceil(quotient)));
			 }
		
		return amount;
	}
		
		
		
		
	//Finds object in the array	with the largest amount and returns the location of that object
	/*Precondition: takes as parameters arrayPeople which is an array of objects and numPeople an integer representing the number of objects in the array
	 * Postcondition: returns index as an integer which represents the location of the object containing the largest amount
	 */
	public static int findLargestAmount(Change[] arrayPeople, int numPeople) 
	{
		int i, index = 0;
		double larger;
	 
		larger = arrayPeople[0].getAmount();
	 
	 
		for(i=0; i<numPeople; i++) {
			if(larger < arrayPeople[i].getAmount()) {
				larger = arrayPeople[i].getAmount();
				index = i;
		 
		 										    }
	 							   }
	 
		return index;
	}
 
	
	
	
	//Finds object in the array	with the smallest amount and returns the location of that object
	/*Precondition: takes as parameters arrayPeople which is an array of objects and numPeople an integer representing the number of objects in the array
	 * Postcondition: returns index as an integer which represents the location of the object containing the smallest amount
	 */
	public static int findSmallestAmount(Change[] arrayPeople, int numPeople) 
	{
		int i, index = 0;
		double smaller;
	 
		smaller = arrayPeople[0].getAmount();
	 
	 
		for(i=0; i<numPeople; i++) {
			if(smaller > arrayPeople[i].getAmount()) {
		 			smaller = arrayPeople[i].getAmount();
		 			index = i;
		 										     }
	 							   }
		return index;
	}
 
 
 

	//Calculates the total number of coins in the program for each denomination
	/*Precondition: takes as parameters arrayPeople which is an array of objects and numPeople an integer representing the number of objects in the array
	 * Postcondition: returns totalNumCoin which is an array with each element representing total number of coins from all objects for each denomination
	 */
 	public static int[] findTotalNumCoinsEach(Change[] arrayPeople, int numPeople) 
 	{
 		int i;
 		int[] totalNumCoin = {0, 0, 0, 0, 0,};
 		
 		
			
 		for(i=0; i<numPeople; i++) {
 			totalNumCoin[0] = totalNumCoin[0] + arrayPeople[i].getNumCoin1();
 			totalNumCoin[1] = totalNumCoin[1] + arrayPeople[i].getNumCoin2();
 			totalNumCoin[2] = totalNumCoin[2] + arrayPeople[i].getNumCoin3();
 			totalNumCoin[3] = totalNumCoin[3] + arrayPeople[i].getNumCoin4();
 			totalNumCoin[4] = totalNumCoin[4] + arrayPeople[i].getNumCoin5();
 								   }
 		return totalNumCoin;
 	}
 	
 	
 	
 	
 	//Finds the total sum of amount from each person in the program
 	/*Precondition: takes as parameters arrayPeople which is an array of objects and numPeople an integer representing the number of objects in the array
 	 * Postcondition: returns sum an integer representing the sum of all amounts from each object in the program
 	 */
 	public static int findSumCoins(Change[] arrayPeople, int numPeople) 
 	{
 		int i, sum = 0;
 	
 		for(i=0; i<numPeople; i++) {
 			sum = sum + (100 * arrayPeople[i].getNumCoin1()) + (50 * arrayPeople[i].getNumCoin2()) + (25 * arrayPeople[i].getNumCoin3()) + (10 * arrayPeople[i].getNumCoin4()) + (5 * arrayPeople[i].getNumCoin5());
 								   }
 		return sum;
 	}
 
}