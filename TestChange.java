/*This program is used to test Change.java file
 Author: Jaeden Mah
 email: jaedenmah@gmail.com
 File Name: Change.java
 Date Last Edited: 15/09/2022
 Assignment 1
 Purpose: Contains data relating to money values and methods that manipulate these values
 Assumptions: amount is in American dollars as cents and an integer. The same goes for output values
 */
import java.util.Scanner;

public class TestChange {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		Change[] person = new Change[200];
		Boolean loopAgain = true;
		String name;
		int amount;
		int option = 0;
		int numPeople = 0;
		
		
		StudentInfo();
		
		System.out.println("Please enter at least 10 records to test the program");
		
		//numPeople = hardCodedValues(person);
	
		while (loopAgain) {
			
			name = getName(kb);
			
			amount = getAmount(kb);
			
			
			
			person[numPeople] = new Change(name, amount);
			
			numPeople++;
			
			loopAgain = getContinueOption(kb);
						  }
		
		
		Change.searchDuplicateName(person, numPeople);
		Change.calcChange(person, numPeople);
		
		
		while (option != 6) {
		option = getMenuOption(kb);
		displayResults(option, person, numPeople, kb);
							}
		
		kb.close();
}
//End main	
	
	
	
	//Displays students basic information for the unit
	/*Postcondition: displays name, ID, mode of study, tutor name and tutorial day/time
	 */
	public static void StudentInfo() {
		System.out.println("Name: Jaeden Mah");
		System.out.println("ID: 34317578");
		System.out.println("Mode of Enrolemt: Internal");
		System.out.println("Tutor Name: Maryam");
		System.out.println("Tutorial Day/Time: Wednesday / 10:30am\n");
	}
	
	
	
	//Method with hardcoded data for marker to use
	public static int hardCodedValues(Change[] person) 
	{
		person[0] = new Change("kia", 65);
		person[1] = new Change("bob", 25);
		person[2] = new Change("samantha", 125);
		person[3] = new Change("mike", 95);
		person[4] = new Change("lily", 45);
		person[5] = new Change("bob", 5);
		person[6] = new Change("samantha", 75);
		person[7] = new Change("shane", 30);
		person[8] = new Change("cameron", 15);
		person[9] = new Change("shane", 200);
		person[10] = new Change("shane", 70);
		
		
		return 11;
	}
	
	
	
	//gets name from user as a one worded string
	/*Precondition: takes kb an object of Scanner class as parameter
	 * returns name as a one word string
	 */
	public static String getName(Scanner kb) 
	{
		String name;
		
		System.out.print("Please enter the name of the person: ");
		name = kb.next();
		
		return name;
	}
	
	
	
	//gets amount from user as a an integer
	/*Precondition: takes kb an object of Scanner class as parameter
	 * Postcondition: returns amount as a positive integer greater or equal to 3 and a multiple of 5
	 */
	public static int getAmount(Scanner kb) 
	{
		int amount;
		
		System.out.println("Please enter an amount: ");
		amount = kb.nextInt();
		amount = Change.validateAmount(amount, kb);
		amount = Change.roundMultiple5(amount);
		
		return amount;
	}
	
	
	
	//gets yes or no answer from user regarding if they want to enter another persons details
	/*Precondition: takes kb an object of Scanner class as parameter
	 * Postcondition: returns statusFinal which is true if yes is selected and false if no is selected
	 */
	public static boolean getContinueOption(Scanner kb) 
	{
		boolean statusFinal = true;
		String choice;
		
		System.out.println("Do you have another person to enter? (Y/N): ");
		choice = kb.nextLine();
		choice = kb.nextLine();
		statusFinal = Change.validateContinueOption(choice, kb);

		return statusFinal;
	}
	
	
	
	//gets menu option choice from user 
	/*Precondition: takes kb an object of Scanner class as parameter
	 * Postcondition: returns option which is an integer between 1 and 6 inclusive
	 */
	public static int getMenuOption(Scanner kb) 
	{
		int option;
		Change.displayMenu();
		System.out.println("Choose a menu option: ");
		option = kb.nextInt();
		option = Change.validateMenuChoice(option, kb);
			
		return option;
	}
	
	

	//Displays results of the option selected by user from the menu
	/*Precondition: takes as parameters choice a positive integer representing which option was chosen from the menu, arrayPeople
	 *  which is an array of objects and numPeople an integer representing the number of objects in the array and kb an object of Scanner class as parameter
	 * Postcondition: displays the results of the menu option chosen by the user
	 */
	public static void displayResults(int choice, Change[] arrayPeople, int numPeople, Scanner kb) 
	{
	int index, sum;
	int[] totalNumCoin = new int[4];
	String name;
	
	switch(choice){
	case 1: 
		System.out.println("Enter a name: ");
		name = kb.next();
		index = Change.searchName(name, arrayPeople, numPeople);
		
		if(index == -1) {
			System.out.println("Name: " + name);
			System.out.println("Not found");
		}
		else {
			displayChange(arrayPeople, numPeople, index);
			}
		break;
		
	case 2: 
		index = Change.findLargestAmount(arrayPeople, numPeople);
		displayChange(arrayPeople, numPeople, index);
		break;
		
	case 3:
		index = Change.findSmallestAmount(arrayPeople, numPeople);
		displayChange(arrayPeople, numPeople, index);
		break;
		
	case 4:
		totalNumCoin = Change.findTotalNumCoinsEach(arrayPeople, numPeople);
		System.out.println("Total number of coins per denomination is: ");
		System.out.println("1 dollar: " + totalNumCoin[0]);
		System.out.println("50 cents: " + totalNumCoin[1]);
		System.out.println("25 cents: " + totalNumCoin[2]);
		System.out.println("10 cents: " + totalNumCoin[3]);
		System.out.println("5 cents: " + totalNumCoin[4]);
		System.out.println("");
		break;
		
	case 5:
		sum = Change.findSumCoins(arrayPeople, numPeople);
		System.out.println("Sum is: " + sum);
		System.out.println("");
		break;
		
	case 6:
		System.out.println("You chose to exit. Have a nice day!");
		System.exit(0);
	
				}
	}

	

	//Displays change for a one person
	/*Precondition: takes as parameters arrayPeople which is an array of objects and numPeople an integer representing the number of objects in the array and index
	 * an integer representing location of the object person in the array
	 * Postcondition: returns the change for the person
	 */
	private static void displayChange(Change[] arrayPeople, int numPeople, int index) 
	{
		System.out.println("Customer:\n" + arrayPeople[index].getName() + " " + arrayPeople[index].getAmount() + " cents\n");
		System.out.println("Change: ");
		if(arrayPeople[index].getNumCoin1() != 0) {
			System.out.println("1 dollar: " + arrayPeople[index].getNumCoin1());
												  }
		if(arrayPeople[index].getNumCoin2() != 0) {
			System.out.println("50 cents: " + arrayPeople[index].getNumCoin2());
												  }
		if(arrayPeople[index].getNumCoin3() != 0) {
			System.out.println("25 cents: " + arrayPeople[index].getNumCoin3());
												  }
		if(arrayPeople[index].getNumCoin4() != 0) {
			System.out.println("10 cents: " + arrayPeople[index].getNumCoin4());
												  }
		if(arrayPeople[index].getNumCoin5() != 0) {
			System.out.println("5 cents: " + arrayPeople[index].getNumCoin5());
												  }
		System.out.println("");
	}
	
}

