package com.lembda;

public class ClosuresExampleV18 {

	public static void main(String[] args) {
		int a = 10;
		//compiler make sure it not changed its called closure as it passed in lambda
		int b = 20;
		
		//Do process will execute out side main and there will be no value of b so a effectivelly final value is passed to that method from main
		doProcess(a, new process() {

			@Override
			public void process(int i) {
				System.out.print(i+b);
			}
		});
		
		//Threre is b used in this lembda compliler froze value of b and supplie same (same at line 11 with annonimous)
		doProcess(a, i->System.out.print(i+b));
	}
	
	public static void doProcess(int i, process p) {
		p.process(i);
	}

}

interface process {
	void process(int i);
}