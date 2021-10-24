
import java.util.Scanner;

public class Menu {
	Scanner scanInput = null;
	PaymentProcessor processor = null;

	
	public void displayUserMenu() {
		// Control the menu navigation.  Includes display of menu, acceptance and processing of user input and
		// exiting the menu based on the user's selections.
		boolean blnContinue = true;
		
		processor = new PaymentProcessor();

		header();
		
		try {		//try-catch-finally to ensure compatibility with all java versions. 
			scanInput = new Scanner(System.in);
			while (blnContinue) {
				displayMenu();
			
				if (scanInput.hasNextInt()) {
					blnContinue = processMenuSelection(scanInput.nextInt());
				}
				else {
					scanInput.nextLine();
					blnContinue = processMenuSelection(0);
				}
			}
		}
		catch (Exception e){
			// Generic error catch - this can be made more specific to the expected errors.
			System.out.println("An unexpected exception has occurred with input "+e.toString());
		}
		finally {
			// Close the scanner
			if (scanInput != null) {
				scanInput.close();
			}
		}
		
	}

	private void header() {
		// Display program header information
		System.out.println("Federation Car Rental Payment Tracking System");
		System.out.println("=============================================");
	}

	private void displayMenu() {
		// Display the menu for user to select which function to run
		System.out.println();
		System.out.println("Select an option from the menu below:");
		System.out.println("1. Standard Payment");
		System.out.println("2. Loyalty Payment");
		System.out.println("3. Employee Payment");
		System.out.println("4. Display List of Clients");
		System.out.println("5. Generate Report To View Payments Received");
		System.out.println("6. Exit");
		System.out.print("Enter your option: ");
		System.out.println();

	}
	
	private boolean processMenuSelection(int menuSelection) {
		// Use the input provided by the user to activate the appropriate code function

		boolean blnContinue = true;
		
		
		
		switch (menuSelection){
		case 1:
			// call method to process standard payments here
			System.out.println("--Processing Standard Payment--");
			
			processor.processStandardPayment();
			
			System.out.println("--Finished Processing Standard Payment--");
						
			break;
		case 2:
			// call method to process loyalty rewards payments here
			System.out.println("--Processing Loyalty Payment--");
			processor.processLoyaltyPayment();
			System.out.println("--Finished Processing Loyalty Payment--");
			break;
		case 3:
			// call method to process employee payments here
			System.out.println("--Processing Employee Payment--");
			processor.processEmployeePayment();
			System.out.println("--Finished Processing Employee Payment--");
			break;
		case 4:
			// call method to  display list of clients here
			System.out.println("--List of Clients--");
			
			processor.displayClients();
			
			break;
		case 5:
			// call method to generate report to display payments received here
			System.out.println("--Report to View Payments Received--");
			
			processor.generateReport();
			break;
		case 6:
			System.out.println("-- Exiting Federation Car Rental Payment Tracking System --\n ....\n  -- Goodbye! --\n");
			blnContinue = false;
			break;
		default:
			// no valid selection made
			System.out.println("Invalid selection! A number between 1 and 6 was expected.");
		}		
		return blnContinue;
	}
	
	

}//public class Menu
