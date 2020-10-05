package com.thread;

public class Account {
	private int balance = 10000;

	public void diposite(int amt) {
		balance += amt;
	}

	public void withdraw(int amt) {
		balance -= amt;
	}

	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account ac1,Account ac2, int amt) {
		ac1.withdraw(amt);
		ac2.diposite(amt);
	}

}
