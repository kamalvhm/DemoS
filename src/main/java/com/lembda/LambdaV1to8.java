package com.lembda;

public class LambdaV1to8 {
	//Passing a behaviour to greetM method Java 7 way Impletaion is sparatly passed
	public void greetM(Greet g) {
		g.perform();
	}
	public static void main(String args[]) {
		/*why lambda? It enables function programming ,secound we get readable code 
		 * 
		 */
		LambdaV1to8 l=new LambdaV1to8();
		GreetImplementation g=new GreetImplementation();
		l.greetM(g);
		
		//holding return value in functional interface variable type FunctionalGreet can be replace by Greet interface
		FunctionalGreet greet=()->System.out.println("hello");
		greet.greet();
		
		FunctionalAdd ad=(int a,int b)->a+b;
		System.out.print(ad.add(10, 20));
		
	}
	//to convert this Method to lambda remove public int add and add arrow to it  in line 20
	public int add(int a,int b ) {
		return a+b;
	}
	
	//Lambda holding functional interface [Functional interface should  have only ONE abstract method (*can have with body*)]
	public interface FunctionalAdd {
		public int add(int a,int b);
	}
	

}
