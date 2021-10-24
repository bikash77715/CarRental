package domain;

public class LoyaltyClient extends Client {
	
	private String type = "Loyalty";
	
	public LoyaltyClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoyaltyClient(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public double getDiscout(double amount) {
		// TODO Auto-generated method stub
		return amount*.1;
	}

	public String getType() {
		return type;
	}
	

}
