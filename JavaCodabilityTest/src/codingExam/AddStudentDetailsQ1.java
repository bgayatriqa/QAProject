package codingExam;

/*. Write a java program to store 5 student information in a treeMapNote: 
 * student object has student name and student reg no
 * */
import java.util.Map.Entry;
import java.util.TreeMap;

public class AddStudentDetailsQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 TreeMap<StudentQ1,Integer> tmap = new TreeMap<>();
 
 
 tmap.put(new StudentQ1("Asha",12), 1);
 tmap.put(new StudentQ1("Bonsla",11), 2); 
 tmap.put(new StudentQ1("Latha",13), 3);  
 tmap.put(new StudentQ1("Mangeshkar",14), 4);
 tmap.put(new StudentQ1("SPB",9),0);
 for(Entry<StudentQ1, Integer> eachStudent : tmap.entrySet()) {
	 System.out.println("Student Details :"+eachStudent.getKey());
	 
 }
	}

}
