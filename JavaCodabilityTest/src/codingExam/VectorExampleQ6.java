package codingExam;
/*6. Write a program to insert "tekarch" into vector then insert user inputed number(N)
 *  of Z's from 3rd position.delete N charactors from 6th position from vector
 *  Example:if user input =5Then vector stores="tekZZZZZarch"
 * Delete 5 character from 6th position so final string="tekZZZh"*/
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class VectorExampleQ6 {

	public static void main(String[] args) {
		Vector<Character> v= new Vector<>();
		v.add('t');
		v.add('e');
		v.add('k');
		v.add('a');
		v.add('r');
		v.add('c');
		v.add('h');
		System.out.println(v);
		System.out.println(v.size());
		System.out.println("please enter how many z's should be inserted at 3rd positon :");
		Scanner sc= new Scanner(System.in);
		int postion = sc.nextInt();
		//v.setSize(postion+v.size());
		
		for(int i=0;i<postion;i++) {
		v.insertElementAt('z', i+3);
		}
		System.out.println("vector after inserting z : "+v);
		System.out.println("vector size after increasing capacity "+v.size());
		System.out.println("Enter how many characters shouldbe deleted from 6th position ");
		int deleteFrom = sc.nextInt();
		int i=0;
		while(i<deleteFrom) {
			v.remove(6);
			i++;
		}
		System.out.println("Vector after deleting : "+v);	
			
		
		
		
		
		
	}

}
