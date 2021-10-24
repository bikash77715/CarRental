package domain;

public abstract class Client {
	public static int c = 1;
	private int id;
	private String name;
//	boolean staff, loyalty;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
		this.id = Client.c++;
	}
	public Client(String name) {
		super();
		this.id = Client.c++;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String getType();
	public abstract double getDiscout(double amount);	
		
}
