package codingExam;
/*7. Write a java program to implement your own ArrayList which has two methods
 *  a) add b) remove and store 5 student information in your ArrayList.
 * */

public class NewArrayListGenericQ7<T> {
public int index=0;
public Object number[];
public NewArrayListGenericQ7() {
	//number=(T[])Array.newInstance(t, 10);
	number=new Object[10];
}

public   void add(T element) {
		
		number[index]=element;
		index++;
}
public void delete(T element) {
	int deleteElementIndex=-1;
	for(int i=0;i<index;i++) {
		if(number[i].equals(element)) {
			
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
	NewArrayListGenericQ7<StudentQ1> nal=new NewArrayListGenericQ7<>();
//	nal.add("45");
//	nal.add("36");
//	nal.add("51");
//	nal.display();
//	System.out.println("After adding");
//	nal.delete("32");
//	nal.display();
//	System.out.println();
//	nal.deleleByIndex(1);
//	System.out.println("After deleting");
//	nal.display();
	nal.add(new StudentQ1("ajay",43));
	nal.add(new StudentQ1("vijay",67));
	nal.add(new StudentQ1("sachin",82));
	nal.add(new StudentQ1("rahul",23));
	nal.add(new StudentQ1("dravid",9));
	nal.display();
	System.out.println("***************");
	//nal.deleleByIndex(2);
	nal.delete(new StudentQ1("rahul",23));
	System.out.println("After deleting");
	nal.display();
}


}

