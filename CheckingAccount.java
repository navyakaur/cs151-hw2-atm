
public class CheckingAccount {
	private CashCard only1;
	
	//ctor
	public CheckingAccount(Bank b, String pass) {
		this.only1 = new CashCard(b, pass);
		b.addCashCard(only1);
	}
	
	public CashCard getCashCard() {
		return only1;
	}
	
}
