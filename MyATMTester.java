import java.time.LocalDate;
import java.util.Scanner;

public class MyATMTester {
	public static void main (String[] args) {
		//creates the bank
		Bank A = new Bank("A");
		Bank B = new Bank("B");
		
		//creates the ATMs
		ATM ATM1_A = new ATM(A, 50);
		ATM ATM2_A = new ATM(A, 100);
		ATM ATM1_B = new ATM(B, 20);
		ATM ATM2_B = new ATM(B, 10);
		
		//creates customers + checking accounts
		Customer navya = new Customer("Navya");
		A.addCustomer(navya);
		B.addCustomer(navya);
		navya.createCheckingAccount(A, "october");
		navya.createCheckingAccount(B, "halloween");

		
		Customer mannat = new Customer("Mannat");
		mannat.createCheckingAccount(A, "seattle");
		mannat.createCheckingAccount(B, "coffee");
		A.addCustomer(mannat);
		B.addCustomer(mannat);
		
		LocalDate nw = LocalDate.now().minusDays(1);
		
		//sets a different expiration date and password
		A.getCustomers().get(0).getA().setExpiration(nw);
		A.getCustomers().get(1).getA().setPassword("CDF");
		
		//prints state of the two banks
		System.out.println("Two Banks");
		System.out.println("Assume all accounts have $100 preloaded.");
		System.out.println();
		System.out.println("Bank A has " + A.getCustomers().size() + " customers");
		for (int i = 0; i < A.getCustomers().size(); i++) {
			System.out.print(A.getCustomers().get(i).getName() + " - ");
			System.out.print("Cash Card (bank ID: A, account number: ");
			System.out.print(A.getCustomers().get(i).getA().getAccountNum());
			System.out.print(", expiration date: " + A.getCustomers().get(i).getA().getExpiration().toString() + ", password: ");
			System.out.println(A.getCustomers().get(i).ckA().getCashCard().password() + ")");
		}
		System.out.println();
		System.out.println("Bank B has " + B.getCustomers().size() + " customers");
		for (int i = 0; i < B.getCustomers().size(); i++) {
			System.out.print(B.getCustomers().get(i).getName() + " - ");
			System.out.print("Cash Card (bank ID: B, account number: ");
			System.out.print(B.getCustomers().get(i).getB().getAccountNum());
			System.out.print(", expiration date: " + B.getCustomers().get(i).getB().getExpiration().toString() + ", password: ");
			System.out.println(B.getCustomers().get(i).ckB().getCashCard().password() + ")");
		}
		System.out.println();
	
		//prints the state of the four ATMs
		System.out.println("Four ATMs");
		System.out.println();
		
		System.out.println("ATM1_A: (ATM from Bank A)");
		System.out.println("The maximum amount that can be withdrawal per transaction from this ATM is $" + ATM1_A.getMax() + ".");
		
		System.out.println("ATM2_A: (ATM from Bank A)");
		System.out.println("The maximum amount that can be withdrawal per transaction from this ATM is $" + ATM2_A.getMax() + ".");
		
		System.out.println("ATM1_B: (ATM from Bank B)");
		System.out.println("The maximum amount that can be withdrawal per transaction from this ATM is $" + ATM1_B.getMax() + ".");
		
		System.out.println("ATM2_B: (ATM from Bank B)");
		System.out.println("The maximum amount that can be withdrawal per transaction from this ATM is $" + ATM2_B.getMax() + ".");
		
		
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your choice of ATM: ");
		String atm = in.next();
		System.out.println();
		
		System.out.print("Enter your card: ");
		
		
		Bank whichone = null;
		ATM idk = null;
		boolean accepted = false;
		
		//keeps asking for cashcard until it passes through
		CashCard n = null;
		while (!accepted) {
			String card = in.next();
			if (atm.equals("ATM1_A") || atm.equals("ATM2_A")) {
				whichone = A;
				if (!(card.substring(0,1).equals("A"))) {
					System.out.println("This card is not supported by this ATM. Try again.");
				}
				if (atm.equals("ATM1_A")) {
					idk = ATM1_A;
				}
				else {
					idk = ATM2_A;
				}
			}
			
			else if (atm.equals("ATM1_B") || atm.equals("ATM2_B")) {
				whichone = B;
				if (!(card.substring(0,1).equals("B"))) {
					System.out.println("This card is not supported by this ATM. Try again.");
				}
				if (atm.equals("ATM1_B")) {
					idk = ATM1_B;
				}
				else {
					idk = ATM2_B;
				}
			}
			else {
				System.out.println("Error: This ATM does not exist.");
			}
			
			LocalDate c = LocalDate.now();
			
			for (CashCard i : whichone.getCashCards()) {
				if (i.getCardNum().equals(card) && (i.getExpiration().isAfter(c))) {
					System.out.println("This card is accepted. Please enter your password.");
					System.out.print("Password: ");
					n = i;
					accepted = true;
				}
				else if (i.getCardNum().equals(card) && (i.getExpiration().isBefore(c))) {
					System.out.println("This card is expired. Try again.");
				}
			}
		}
		
		String password = in.next();
		if (password.equals(n.password())) {
			System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
			System.out.print("$");
		}
		else {
			System.out.println("This is a wrong password. Enter your password.");
			String password2 = in.next();
			System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
			System.out.print("$");
		}
		
		//keeps reading the next line unless there is a Quit signal
		while (in.hasNext()) { 
			String money = in.next();
			if (money.equals("Quit")) {
				System.out.println("Thank you for visiting.");
				return;
			}
			int mon = Integer.parseInt(money);
			if (mon > idk.getMax()) {
				System.out.println("Error: This amount exceeds the maximum amount you can withdraw per transaction. Please enter another amount or quit.");
			}
			else if (mon > n.getCurrAmount()) {
				System.out.println("Error: This amount exceeds the current balance. Enter another amount or quit.");
			}
			else {
				System.out.println("$" + mon + " is withdrawn from your account.");
				n.withdraw(mon);
				System.out.println("The remaining balance is " + "$" + n.getCurrAmount());
				System.out.println("If you have more transactions, enter the amount or quit.");
			}
		}
		
	}
}
