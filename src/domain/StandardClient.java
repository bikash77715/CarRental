package domain;

public class StandardClient extends Client {

	private String type = "Standard";
		
	public StandardClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardClient(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public double getDiscout(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getType() {
		return type;
	}

	
}
