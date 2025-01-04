package dels;

public class ShapMaker {
	Shape cicle;
	Shape ractangle;
	
	public ShapMaker(){
		cicle=new Circle();
		ractangle=new Ractangle();
	}
	
	public void drawCircle() {
		cicle.draw();
	}
	
	public void drawRactangle() {
		ractangle.draw();
	}

}
