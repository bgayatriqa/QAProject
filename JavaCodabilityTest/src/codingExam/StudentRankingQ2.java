package codingExam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/*	Q2)Write a java program to store 5 student information and award the students with 1st rank,
 *  2nd rank and 3rd rank according to marks obtained where each student has student name,
 *  student marks and student reg no information
 * */
public class StudentRankingQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeSet<StudentWithMarksQ2> tset = new TreeSet<>();
tset.add(new StudentWithMarksQ2("Radha",12,826));
tset.add(new StudentWithMarksQ2("John",10,798));
tset.add(new StudentWithMarksQ2("Bansi",15,2826));
tset.add(new StudentWithMarksQ2("yuvan",9,950));
tset.add(new StudentWithMarksQ2("Agsya",19,933));
Iterator<StudentWithMarksQ2> itr = tset.iterator();
int i=1;
while(itr.hasNext()) {
	System.out.println(itr.next());
i++;
if(i==4) {
	break;
}
}	//System.out.println(ll.get(i));

		
	}

}
