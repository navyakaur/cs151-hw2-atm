import java.util.ArrayList;

public class ATM {

	private Bank id;
	private int maxWithdrawal;
	
	public ATM(Bank x, int max) {
		id = x;
		maxWithdrawal = max;
	}
	
	public Bank getBank() {
		return id;
	}
	
	public int getMax() {
		return maxWithdrawal;
	}
}
