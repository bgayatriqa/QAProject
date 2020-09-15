package codingExam;
/*Q16.Write a java program to create three threads T1, T2 and T3 
 * and ensure sequence T1,T2,T3 in java.
 * */
public class ThreeThreadsQ16 extends Thread {
	public void run()
	{
		
		System.out.println("Thread started"+this.getName());
		for(int i=0;i<500;i++) {
			System.out.print(i);
		}
		System.out.println("500");
		System.out.println("Thread completed"+this.getName());
		
	}

	public static void main(String[] args) throws InterruptedException {
		
ThreeThreadsQ16 t1= new ThreeThreadsQ16();
t1.start();
t1.join();
ThreeThreadsQ16 t2= new ThreeThreadsQ16();
t2.start();
t2.join();
ThreeThreadsQ16 t3= new ThreeThreadsQ16();
t3.start();
t3.join();
	}

}
