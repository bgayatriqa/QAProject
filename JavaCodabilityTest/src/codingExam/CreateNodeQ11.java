package codingExam;

public class CreateNodeQ11 {
private CreateNodeQ11 pointer;
private int data;
public CreateNodeQ11() {
	pointer=null;
	data=Integer.MIN_VALUE;
}
public CreateNodeQ11(int data) {
	this.data=data;
	this.pointer=null;
}
@Override
public String toString() {
	return "CreateNode [ data=" + data + "]";
}
public CreateNodeQ11 getPointer() {
	return pointer;
}
public void setPointer(CreateNodeQ11 pointer) {
	this.pointer = pointer;
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}

}
