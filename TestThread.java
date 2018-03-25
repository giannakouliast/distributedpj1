public class TestThread {
   public static void main(String args[]) {

	/* Declare and construct one print Demo object */
	// missing code here
	PrintDemo PD = new PrintDemo();


	/* Create two thread demo objects with names "thread1"
	* and "thread2"
	*/
	// missing code here
	ThreadDemo T1 = new ThreadDemo("Thread1",PD);
	ThreadDemo T2 = new ThreadDemo("Thread2",PD);
	ThreadDemo T3 = new ThreadDemo("Thread3",PD);
	/* Run the threads*/
	// missing code here
		T1.start();
		T2.start();

      /* wait for threads to end*/
      try {
	// missing code here
			T1.join();
			T2.join();
	
      } catch( Exception e) {
         System.out.println("Interrupted");
      }
   }
}