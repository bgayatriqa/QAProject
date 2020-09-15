package codingExam;
/*Write a java program to implement your own ArrayList which has two methods
 *  a) add b) remove and store 5 student information in your ArrayList.*/
import java.util.ArrayList;
import java.util.List;
/*8. Store user defined employee objects into arraylist and
 *  Remove duplicates from arraylist without using collections.*/
public class ArrayListQ8 {
	public static void main(String args[])
{
		List<EmployeeQ8> al =new ArrayList<>();
		
         al.add(new EmployeeQ8("john",89));
         al.add(new EmployeeQ8("johncarter",49));
         al.add(new EmployeeQ8("john",89));
         al.add(new EmployeeQ8("carter",65));
         al.add(new EmployeeQ8("paul",74));
         System.out.println(al);
         for(int i=0;i<al.size();i++)
         {
        	 for(int j=i+1;j<al.size();j++) {
        		 if(al.get(i).equals(al.get(j))) {
        			 al.remove(i);
        		 }
        	 }
        	
         }
         System.out.println("After Deleting the duplicates");
         System.out.println(al);

}
}