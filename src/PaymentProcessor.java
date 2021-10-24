import java.util.ArrayList;
import java.util.Scanner;

import domain.Employee;
import domain.LoyaltyClient;
import domain.Payment;
import domain.StandardClient;


public class PaymentProcessor implements PaymentProcess {

	Scanner scanInput = new Scanner(System.in);
	ArrayList<Payment> payments= new ArrayList<Payment>();
	
	public PaymentProcessor(){
		super();
		payments.add(new Payment(200, new StandardClient("Ivan") ) );
		payments.add(new Payment(300, new LoyaltyClient("Jim") ) );
		payments.add(new Payment(100, new Employee("Gobbs") ) );
	}


	@Override
	public void processStandardPayment() {
		// TODO Auto-generated method stub
		displayClients();
		
		System.out.println(" Enter id of existing client or 0 to enter a new one: ");
		
		if (scanInput.hasNextInt()) {
			int choice = scanInput.nextInt();
			double amount;
			if(choice == 0) {
				
				System.out.print("Enter the name of Client: ");
				String name = scanInput.next();
				System.out.print("Enter the amount of this payment: ");
				amount = scanInput.nextDouble();
				
				payments.add(new Payment(amount, new StandardClient(name))) ;
				
			}
			else if(choice <= payments.size() && payments.get(choice-1).getClient().getType() == "Standard") {
				
				System.out.print("Enter the amount of this payment: ");
				amount = scanInput.nextDouble();
				payments.get(choice-1).updateAmount(amount);
			}
			
			else {
				System.out.println(" Wrong input! Try again.");
				printDivider();
			}
		}
		
	}

	@Override
	public void processLoyaltyPayment() {
		// TODO Auto-generated method stub
		displayClients();
		
		printSeparator();
		System.out.println(" Enter id of existing client or 0 to enter a new one: ");
				
		

		if(scanInput.hasNext()) {
		
			int choice = scanInput.nextInt();
			double amount;
			if(choice == 0) {
				
				System.out.print("Enter the name of Client: ");
				String name = scanInput.next();
				System.out.print("Enter the amount of this payment: ");
				amount = scanInput.nextDouble();
				
				payments.add(new Payment(amount, new LoyaltyClient(name))) ;
				
			}
			else if(choice <= payments.size() && payments.get(choice-1).getClient().getType() == "Loyalty") {
				
				System.out.print("Enter the amount of this payment: ");
				amount = scanInput.nextDouble();
				payments.get(choice-1).updateAmount(amount);
			}
			
			else {
				System.out.println(" Wrong input! Try again.");
				printDivider();
			}
		}
	}

	@Override
	public void processEmployeePayment() {
		// TODO Auto-generated method stub
		displayClients();
		
		
		System.out.println(" Enter id of existing client or 0 to enter a new one: ");

		if (scanInput.hasNext()) {
			int choice = scanInput.nextInt();
			double amount;

			if(choice == 0) {
				
				System.out.print("Enter the name of Client: ");
				String name = scanInput.next();
				System.out.print("Enter the amount of this payment: ");
				amount = scanInput.nextDouble();
				
				payments.add(new Payment(amount, new Employee(name))) ;
				
			}
			else if(choice <= payments.size() && payments.get(choice-1).getClient().getType() == "Employee") {
				
				System.out.print("Enter the amount of this payment: ");
				amount = scanInput.nextDouble();
				payments.get(choice-1).updateAmount(amount);
			}
			
			else {			
				System.out.println(" Wrong input! Try again.");
				printDivider();
			}
		}
	}
	

	public void displayClients() {
		
		if(payments.isEmpty()) {
			System.out.println("*** No clients to display at the moment ***");
		}else {
			int i = 90;
			printSeparator(i);
			System.out.println("Client id \t Client type \t Name \t\t Amount \t Discounted Amount");
			printSeparator(i);
			for(Payment p: payments) {
				System.out.println("\t"+p.getClient().getId()+" \t "+p.getClient().getType()+" \t "+p.getClient().getName()+" \t\t "+(p.getAmount() - p.getDiscountAmount())+" \t\t "+p.getDiscountAmount());
			}
			printSeparator(i);
		}
	}


	public void generateReport() {
		// TODO Auto-generated method stub
		
		double standardPaySum, loyaltyPaySum, employeePaySum, loyaltyDisSum, employeeDisSum ;
		standardPaySum = loyaltyPaySum = employeePaySum = loyaltyDisSum = employeeDisSum = 0; 
		for(Payment p: payments) {
			if(p.getClient().getType().equalsIgnoreCase("standard"))
				standardPaySum += p.getAmount();
				
			else if(p.getClient().getType().equalsIgnoreCase("loyalty")) {
				loyaltyPaySum += (p.getAmount()-p.getDiscountAmount());
				loyaltyDisSum += p.getDiscountAmount();
			}
			
			else if (p.getClient().getType().equalsIgnoreCase("employee")) {
				employeePaySum += (p.getAmount()-p.getDiscountAmount());
				employeeDisSum += p.getDiscountAmount();
			}
			else
				continue;
			
		}
		
		printSeparator();
		System.out.println("Client Type \t Total Amount Received \t Total Discount Given");

		printSeparator();
		System.out.println("Standard \t\t"+ standardPaySum + "\t\t 0");
		System.out.println("Loyalty \t\t"+ loyaltyPaySum + " \t\t "+loyaltyDisSum);
		System.out.println("Employee \t\t"+ employeePaySum + "\t\t " + employeeDisSum);
		
		printSeparator();
		System.out.println("Total \t\t\t"+ (employeePaySum + loyaltyPaySum + standardPaySum) + "\t\t " + (employeeDisSum + loyaltyDisSum + standardPaySum));
		printSeparator();		
	}


	private void printSeparator() {
		// TODO Auto-generated method stub
		for(int n=0; n<65 ; n++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}
	private void printSeparator(int i) {
		// TODO Auto-generated method stub
		for(int n=0; n<i ; n++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}
	
	private void printDivider() {
		for(int n=0; n<200 ; n++) {
			System.out.print("-");
		}
		System.out.print("\n");
		
	}
}
