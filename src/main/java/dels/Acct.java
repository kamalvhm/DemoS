package dels;

public class Acct {
	int balance;

	public void deposite(int i) {
		balance+=i;
	}
	
	public void withdraw(int i) {
		balance-=i;
	}
	
	public int getbalance() {return balance;}
	
	public static void transfer(Acct one ,Acct two,int amt) {
		one.withdraw(amt);
		two.deposite(amt);
	}

}
