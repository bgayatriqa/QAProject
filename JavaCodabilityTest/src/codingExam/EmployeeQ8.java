package codingExam;
/*8. Store user defined employee objects into arraylist and
 *  Remove duplicates from arraylist without using collections.*/
public class EmployeeQ8 {
private String employeeName;
private int employeeId;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + employeeId;
	result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EmployeeQ8 other = (EmployeeQ8) obj;
	if (employeeId != other.employeeId)
		return false;
	if (employeeName == null) {
		if (other.employeeName != null)
			return false;
	} else if (!employeeName.equals(other.employeeName))
		return false;
	return true;
}
@Override
public String toString() {
	return "EmployeeQ7 [employeeName=" + employeeName + ", employeeId=" + employeeId + "]";
}
public EmployeeQ8(String employeeName, int employeeId) {
	super();
	this.employeeName = employeeName;
	this.employeeId = employeeId;
}

}
