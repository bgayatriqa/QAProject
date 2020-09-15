package codingExam;

public class NewArrayList {
public int index=0;
public int number[]=new int[10];

public   void add(int element) {
		
		number[index]=element;
		index++;
}
public void delete(int element) {
	int deleteElementIndex=-1;
	for(int i=0;i<index;i++) {
		if(number[i]==element) {
			
			deleteElementIndex= i;
			
		}
	}
	deleleByIndex(deleteElementIndex);
	
	}
public void deleleByIndex(int element) {
	
	//deleteElementIndex=element;
	if(element==-1) {
		System.out.println("can't find entered element ");
	
}else {
	for(int i=element;i<index;i++)
	{
		number[i]=number[i+1];
	}
	index--;
}
}
public void display() {
	
	for(int i=0;i<index;i++) {
		System.out.println(number[i]);
	}
	}
public static void main(String args[]) {
	NewArrayList nal=new NewArrayList();
	nal.add(45);
	nal.add(36);
	nal.add(51);
	nal.display();
	System.out.println("After adding");
	nal.delete(32);
	nal.display();
	System.out.println();
	nal.deleleByIndex(1);
	System.out.println("After deleting");
	nal.display();
}


}

