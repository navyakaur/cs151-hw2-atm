import java.time.LocalDate;

public class CashCard {
	private LocalDate expiration_date = LocalDate.now().plusYears(10);	
	private String id;
	private int accountNum;
	private String cardNumber;
	private String password;
	private int currAmount = 100;
	
	//ctor
	public CashCard(Bank b, String password) {
		id = b.getBankID();
		accountNum = b.getAcc() + 1;
		cardNumber = id.toString() + accountNum;
		this.password = password;
	}
	
	public void setPassword(String pass) {
		password = pass;
	}
	
	public void withdraw(int x) {
		currAmount = currAmount - x;
	}
	
	public int getCurrAmount() {
		return currAmount;
	}
	
	public String password() {
		return password;
	}
	
	public LocalDate getExpiration() {
		return expiration_date;
	}
	
	public void setExpiration(LocalDate x) {
		expiration_date = x;
	}
	
	public int getAccountNum() {
		return accountNum;
	}
	
	public String getCardNum() {
		return cardNumber;
	}
	
	public void setAccNum(int acc) {
		accountNum = acc;
	}
	
	public void setCardNum(int acc) {
		accountNum = acc;
		cardNumber = id.toString() + accountNum;
	}
	
}

