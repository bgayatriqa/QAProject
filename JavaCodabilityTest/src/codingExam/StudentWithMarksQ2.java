package codingExam;
/*	Q2)Write a java program to store 5 student information and award the students with 1st rank,
 *  2nd rank and 3rd rank according to marks obtained where each student has student name,
 *  student marks and student reg no information
 * */
import java.util.Comparator;
import java.util.List;

public class StudentWithMarksQ2 implements Comparable<StudentWithMarksQ2>{
	private String studentName;
	private int studentRegNo;
	private long marks;
	public void setMarks(long marks) {
		this.marks = marks;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentRegNo() {
		return studentRegNo;
	}
	public void setStudentRegNo(int studentRegNo) {
		this.studentRegNo = studentRegNo;
	}
	
	@Override
	public String toString() {
		return "StudentWithMarks [studentName=" + studentName + ", studentRegNo=" + studentRegNo + ", marks=" + marks
				+ "]";
	}
	public StudentWithMarksQ2(String studentName, int studentRegNo, int marks) {
		super();
		this.studentName = studentName;
		this.studentRegNo = studentRegNo;
		this.marks = marks;
	}
	
	@Override
	public int compareTo(StudentWithMarksQ2 s) {
		// TODO Auto-generated method stub
		return (int) ( s.marks - this.marks);
	}
	
	

}
