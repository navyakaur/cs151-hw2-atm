import java.util.ArrayList;

public class Customer {
	private int bankA = 0;
	private int bankB = 0;
	//private ArrayList<CheckingAccount> allAccounts;
	private CashCard CashCardA;
	private CashCard CashCardB;
	private CheckingAccount a;
	private CheckingAccount b;
	private String name;
	
	
	//private CheckingAccount checkingaccount;
	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public CashCard getA() {
		return CashCardA;
	}
	
	public CashCard getB() {
		return CashCardB;
	}
	
	public CheckingAccount ckA()  {
		return a;
	}
	
	public CheckingAccount ckB()  {
		return b;
	}
	
	//creates checking account, which in turn automatically initiliazes a cashcard assoicated with the checking account
	public void createCheckingAccount(Bank bk, String pass) {
		if (bk.getBankID().equals("A") && bankA < 2) {
			CheckingAccount x = new CheckingAccount(bk, pass);
			bankA++;
			a = x;
			CashCardA = x.getCashCard();
		}
		else if (bk.getBankID().equals("B") && bankB < 2) {
			CheckingAccount x = new CheckingAccount(bk, pass);
			bankB++;
			b = x;
			CashCardB = x.getCashCard();
		}
		else {
			System.out.print("Error: You may only create one checking account per bank.");	
		}
		
	}
	
}
