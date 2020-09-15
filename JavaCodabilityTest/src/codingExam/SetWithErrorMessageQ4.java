package codingExam;
/*Q4.Write a java program to store 5 unique elements in sorted order. 
 * Error should exist if user tries to add duplicates.
 * */
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetWithErrorMessageQ4
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeSet<String> names = new TreeSet<>();
Scanner sc= new Scanner(System.in);
int namesSize;
System.out.println("Enter the length");
namesSize=sc.nextInt();
System.out.print("Enter the names");
//String[] name= new String[namesSize];
	for(int i=0;i<namesSize;i++) {
		String name =sc.next();
		
		if(names.contains(name)) {
			System.err.print(name+" Already exists");
		}
		names.add(name);
		
	}



	}

}
