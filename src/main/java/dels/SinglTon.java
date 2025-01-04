package dels;

public class SinglTon {
	
	public static void main(String args[]) {
		ShapMaker s=new ShapMaker();
		s.drawCircle();
		s.drawRactangle();
	}

}


class Circle implements Shape{

	@Override
	public void draw() {
		System.out.print("CIRCLE !!!");		
	}
	
}

class Ractangle implements Shape{

	@Override
	public void draw() {
		System.out.print("Ractangle !!!");		
	}
	
}