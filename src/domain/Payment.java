package domain;

public class Payment {
	private double amount;
	public Client client;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(double amount, Client client) {
		super();
		this.amount = amount;
		this.client = client;
				
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void updateAmount(double amount2) {
		// TODO Auto-generated method stub
		this.amount += amount2;
	}
	public double getDiscountAmount() {
		// TODO Auto-generated method stub
		return client.getDiscout(amount);
	}
	
	
	
}
