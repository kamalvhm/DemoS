package com.patterns;
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}