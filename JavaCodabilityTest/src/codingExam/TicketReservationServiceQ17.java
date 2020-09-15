package codingExam;
/*Q17.	Implement ticket reservation application using multithreading
 *  where it has available seats information.
 *   Create 4 threads to access this data to book tickets and ensure data consistency
 *    Ex available seats=10 T1 requires 6 seats T2 requires 3 seats T2 requires 4 seats
 *  If available seats < seats required proper error message should get printed
 * */
public class TicketReservationServiceQ17 {
	private int totalTickects;
	public TicketReservationServiceQ17(int totalTickects) {
		this.totalTickects=totalTickects;
	}
	public synchronized int reserveTickects(int n) {
		if(totalTickects>=n) {
			totalTickects=totalTickects-n;
			return totalTickects;
		}
		else
			throw new RuntimeException("The Available seats are less than the requested seats"); 
		
	}

}
