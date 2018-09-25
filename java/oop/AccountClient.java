package java.oop;

/*
 * Modify the BankAccount class to implement the
 * deposit() and withdraw() methods,
 * and add a showInfo() to display name and balance
 */

public class AccountClient {

	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("Ray Smith", 1000);
		
		acc1.deposit(200);
		acc1.withdraw(100);
		acc1.deposit(500);
		acc1.showInfo();
		
		
		// BankAccount acc2 = new BankAccount();
	}

}
