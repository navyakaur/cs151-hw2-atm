import java.util.ArrayList;

public class Bank {
	private ArrayList<Customer> bank;
	private ArrayList<CashCard> cashcards;
	private int acc = 0;
	
	
	private String bank_id;
	
	public Bank(String x) {
		bank = new ArrayList<>();
		bank_id = x;
		cashcards = new ArrayList<>();
	}
	
	public String getBankID() {
		return bank_id;
	}
	
	public void addCustomer(Customer name) {
		bank.add(name);
	}
	
	public void addCashCard(CashCard c) {
		acc++;
		c.setCardNum(acc);
		cashcards.add(c);
	}
	
	public ArrayList<CashCard> getCashCards() {
		return cashcards;
	}
	
	public ArrayList<Customer> getCustomers() {
		return bank;
	}
	
	public int getAcc() {
		return acc;
	}

}
