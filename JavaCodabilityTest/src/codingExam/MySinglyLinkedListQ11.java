package codingExam;
/*Write a java program to implement your own singly linked list in which delete method deletes an given element
 *  in the singly linked list*/
public class MySinglyLinkedListQ11 {
	private CreateNodeQ11 head;
	private int size;
	
	
	public void add(int element) {
		if(head==null) {
			head= new CreateNodeQ11(element);
		}else
		{
			CreateNodeQ11 next=head;
			while(next.getPointer()!=null ) {
				next= next.getPointer();
			}
			next.setPointer(new CreateNodeQ11(element));
		}
		size++;
		}
	
	public void delete(int element) {
		if(head==null) {
		System.out.println("No Elements to delete");	
		}else 
		{
			size--;
			if(head.getData()==element ) {
				head=head.getPointer();
			}else
			{
				CreateNodeQ11 next=head;
				CreateNodeQ11 previous=head;
				while(next != null && next.getData()!=element) {
					previous = next;
					next= next.getPointer();
				}
				if (next != null && next.getData()==element) {
					previous.setPointer(next.getPointer());
				} else {
					System.out.println("element " + element + " not found in list");
				}
			}
			
		}
	}
	public void display() {
		CreateNodeQ11 next=head;
		while(next !=null ) {
			System.out.print(next.getData() + " -> ");
			next= next.getPointer();
		}
		System.out.println();
	}
	
	public void printSize() {
		System.out.println(size);
	}
	 
	public static void main(String[] args) {
		MySinglyLinkedListQ11 list = new MySinglyLinkedListQ11();
		list.add(29);
		list.add(16);
		list.add(94);
		list.add(63);
		list.add(74);
		list.display();
		list.delete(29);
		list.display();
		list.delete(83);
		list.display();
		list.delete(94);
		list.display();
		
	}

}
