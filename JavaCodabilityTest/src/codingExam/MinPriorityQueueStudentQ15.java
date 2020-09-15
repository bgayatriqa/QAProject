package codingExam;
/*Q15.Implement minimum priority queue to store student information.
 *  Each student has student name(string)and student id number(int) 
 *  and priority is nothing but student id. Implement the fallowing methods
 *   EnQueue()-adds student info to queue which maintains order of minimum prioprity DeQueue()- which deletes minimum id holder information
 *  peekMin() which returns student information having minimum id value
 * */
import java.util.Arrays;
import java.util.Comparator;

public class MinPriorityQueueStudentQ15 {
	private class StudentComparator implements Comparator<StudentQ1> {
		@Override
		public int compare(StudentQ1 o1, StudentQ1 o2) {
			if (o1 == null || o2 == null) {
				return 0;
			} else {
				return o1.getStudentRegNo() - o2.getStudentRegNo();
			}
				
		}

	}

	private StudentQ1[] items;
	private Comparator<StudentQ1>comparator;
	private int size;
	private int front, rear;
	
	public MinPriorityQueueStudentQ15(int size) {
		this.size = size;
		items = new StudentQ1[size];
		comparator = new StudentComparator();
		front = 0;
		rear = -1;
	}
	
	public void enQueue(StudentQ1 item) {
		if (rear == size-1) {
			System.out.println("Queue is full");
		} else {
			rear++;
			items[rear] = item;
			Arrays.sort(items, comparator);
		}
	}
	
	public StudentQ1 deQueue() {
		if (front > rear) {
			System.out.println("Queue is empty");
			return null;
		} else {
			StudentQ1 item = items[front];
			front++;
			return item;
		}
	}
	
	public StudentQ1 minPeek() {
		if (front > rear) {
			System.out.println("Queue is empty");
			return null;
		} else {
			StudentQ1 item = items[front];
			return item;
		}
	}
	
	public void display() {
		for (int i=front; i<=rear; i++) {
			System.out.println(items[i]);
		}
	}
	
	public static void main(String[] args) {
		MinPriorityQueueStudentQ15 minQueue = new MinPriorityQueueStudentQ15(10);
		minQueue.enQueue(new StudentQ1("Asha",12));
		minQueue.enQueue(new StudentQ1("Bonsla",11)); 
		minQueue.enQueue(new StudentQ1("Latha",13));  
		minQueue.enQueue(new StudentQ1("Mangeshkar",14));
		minQueue.enQueue(new StudentQ1("SPB",15));
		System.out.println("************* After Enqueue");
		minQueue.display();
		System.out.println("************* MinPeek");
		System.out.println(minQueue.minPeek());
		minQueue.deQueue();
		System.out.println("************* After Dequeue");
		minQueue.display();
	}
	
}
