package dels;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance=new Connection();
	private int connections=0;
	private Connection() {}
	private Semaphore sem=new Semaphore(50);
	
	public static Connection  getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doconnect();
		}finally {
			sem.release();

		}
	}
	
	public void doconnect() {
		
		synchronized (this) {
			connections++;
			System.out.println("current Connections "+connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}
	}
}
