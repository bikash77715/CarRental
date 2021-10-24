package domain;

public class Employee extends Client {

	private String type = "Employee";
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public double getDiscout(double amount) {
		// TODO Auto-generated method stub
		return amount*.2;
	}

	public String getType() {
		return type;
	}


}
