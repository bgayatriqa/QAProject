package codingExam;
/*3. Write a java program to implement the fallowing Consider vehicle parking application where each vehicle information which enters into the parking location stored in 2 lists. 
 * at the end of each day these lists to be merged into single list and one vehicle information which has highest parked hour should be retrieved,
 *  where each vehicle information has vehicle number,
 *  vehicle model, total duration parked in minutes.
 * */
import java.util.Comparator;

public class VehicleInfoQ3 implements Comparator<VehicleInfoQ3>{
private String vehicleNumber;
public VehicleInfoQ3(String vehicleNumber, String model, int minutes) {
	super();
	this.vehicleNumber = vehicleNumber;
	this.model = model;
	this.minutes = minutes;
}
public VehicleInfoQ3() {
	
}
@Override
public String toString() {
	return "VehicleInfo [vehicleNumber=" + vehicleNumber + ", model=" + model + ", minutes=" + minutes + "]";
}
private String model;
private int minutes;

public String getVehicleNumber() {
	return vehicleNumber;
}
public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getMinutes() {
	return minutes;
}
public void setMinutes(int minutes) {
	this.minutes = minutes;
}


@Override
public int compare(VehicleInfoQ3 v1, VehicleInfoQ3 v2) {
	// TODO Auto-generated method stub
	return v1.minutes-v2.minutes;

}
}
