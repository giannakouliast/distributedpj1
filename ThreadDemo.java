public class ThreadDemo extends Thread {
   	/*
	 *1) Declare the appropriate variables
	 */

	/*
	 * Write your code here
	 */
	private Thread t;
	private String threadName;
	PrintDemo PD;

	/*
	 *2) Define the class constructor
	 */
	public ThreadDemo(String name, PrintDemo pd){
		threadName = name;
		PD = pd;
	}
	
	
	/*
	 * Write your code here
	 */




	public void run() {
		
		synchronized(PD){
			
			PD.printCount();
		
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}

	public void start (){
		/*
		 * Write your code here
		 */
		System.out.println("Starting " +  threadName );

    	if (t == null){
      		t = new Thread (this, threadName);
      		t.start ();
    	}

   	}
}