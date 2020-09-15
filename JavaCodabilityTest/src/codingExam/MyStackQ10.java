package codingExam;
/*Write a java program to implement your own stack data structure to store any number of items. And implement the following operations 
 * 1.push 2. pop 3. peek 4.display stack content
 * */
public class MyStackQ10<G> {
	
	//int size=10;
	int top =-1;
	Object item[] = new Object[10];
	public void push(G element) {
		top++;
		item[top] =element;
		System.out.println("Element pushed to stack");	
		
	}
	public G  pop() {
		if(top==-1) {
			System.out.println("Stack is empty");
		}
		G topItem =	(G) item[top];
		top--;
		return topItem;
	}
	public  Object peek() {
		if(top==-1) {
			System.out.println("Stack is empty");
			return null;
		}
			else 
				return item[top];
			
		
	}
	public void display() {
		for(int i=0;i<=top;i++) {
			System.out.println(item[i]);
		}
	}
	public static void main(String[] args) {
		MyStackQ10<Integer> ms= new MyStackQ10<>();
		ms.push(23);
		ms.push(67);
		ms.push(82);
		ms.push(50);
		ms.push(18);
		ms.display();
		System.out.println("****");
		ms.pop();
		System.out.println("After Deleting");
		ms.display();
		System.out.println("peeking");
	System.out.println(ms.peek());
	
		
	}

}
