package codingExam;
/*14. Implement your own QUEUE using STACKS data structure
 * */
public class MyQueueQ14 {
	int size;
	int front;
	int rear;
	int items[];
	public MyQueueQ14(int size) {
		this.size=size;
		items = new int[size];
		rear =-1;
	}
	public void enqueue(int element) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else{	
		rear++;
		items[rear]=element;
		}
	}
	public int dequeue() {
		int deletedItem=-1;
		if(isEmpty()) {
			System.out.println("Queue is empty");
		}
		else {
			deletedItem=items[front];
			front++;
			
			
	}
		return deletedItem ;
		}
	public void display() {
		for(int i=front;i<=rear;i++) {
			System.out.println(items[i]);
		}
	}
	public int frontPeek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			throw new RuntimeException("Queue is empty");
		}else {
			return items[front];
		}
		
	}
	public boolean isEmpty() {
		if(rear==-1) {
			return true;
		}
		else return false;
	}
	public boolean isFull() {
		if(rear==size-1) {
			
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		
MyQueueQ14 mq = new MyQueueQ14(5);
mq.enqueue(10);
mq.enqueue(20);
mq.enqueue(30);
mq.enqueue(40);
mq.enqueue(50);
System.out.println("Displayed inserted items");
mq.display();
System.out.println("After deletion");
mq.dequeue();
System.out.println("displaying remaining elements in queue");
mq.display();
System.out.println("peeking the element "+mq.frontPeek());


	}

}
