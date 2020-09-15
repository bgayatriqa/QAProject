package codingExam;
/*Q17.	Implement ticket reservation application using multithreading
 *  where it has available seats information.
 *   Create 4 threads to access this data to book tickets and ensure data consistency
 *    Ex available seats=10 T1 requires 6 seats T2 requires 3 seats T2 requires 4 seats
 *  If available seats < seats required proper error message should get printed
 * */
public class TicketsThreadQ17 extends Thread {
	TicketReservationServiceQ17 ts;
	int seatsRequired;
	public TicketsThreadQ17(TicketReservationServiceQ17 ts,int seatsRequired) {
		this.ts=ts;
		this.seatsRequired=seatsRequired;
	}
	@Override
	public void run() {
		System.out.println("Thread  started : "+this.getName());
		try {
	int remainingSeats =ts.reserveTickects(seatsRequired);
		
	System.out.println("Remaining seats : "+remainingSeats);
	} catch(Exception e) {
		System.err.println("Unable to complete the reservation for : "+seatsRequired + " thread " + this.getName() );
	}
		System.out.println("Thread completed : "+this.getName());
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TicketReservationServiceQ17 trs = new TicketReservationServiceQ17(10);
		TicketsThreadQ17 tr= new TicketsThreadQ17(trs,6);
//		Thread t1=new Thread(tr);
		tr.start();
		//tr.join();
		TicketsThreadQ17 tr2= new TicketsThreadQ17(trs,4);
		tr2.start();
		//tr2.join();
		TicketsThreadQ17 tr3= new TicketsThreadQ17(trs,3);
		tr3.start();
		//tr3.join();
		
	}

	

}
