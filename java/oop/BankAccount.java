package java.oop;

public class BankAccount {
	// ATTRIBUTES (VARIABLES, PROPERTIES)
	// Accout Number
	// Account Type (checking vs savings)
	// Branch number
	String name;
	String accountNumber;
	String accountType;
	double balance;
	
	
	// METHODS (FUNCTIONS)
	// join -- Constructor
	public BankAccount(String name, double initDeposit) {
		System.out.println("NEW ACCOUNT");
		// initialize name and balance
		this.name = name;
		balance = initDeposit;
		System.out.println("Thank you " + name +
				" for opening an account with $" + initDeposit);
	}
	
	// withdraw
	public void withdraw(double debit) {
		balance = balance-debit;
		System.out.println("Withdraw funds");
		showBalance();
	}
	// deposit
	public void deposit(double credit) {
		balance = balance+credit;
		System.out.println("Depositing funds");
		showBalance();
	}
	
	private void showBalance() {
		System.out.println("Your current balance is: $" + balance);
	}
	
	public void showInfo() {
		System.out.println("----\nName: " + name +
				"\nBalance: $" + balance);
	}
	
	// pay bill
	// transfer

}