package com.patterns;
public class Currency {
	//https://www.digitalocean.com/community/tutorials/chain-of-responsibility-design-pattern-in-java

	private int amount;
	
	public Currency(int amt){
		this.amount=amt;
	}
	
	public int getAmount(){
		return this.amount;
	}
}