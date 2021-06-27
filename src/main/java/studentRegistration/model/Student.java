package studentRegistration.model;

public class Student {
	private String rollNo;
	private double marks;
	private String Name;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", marks=" + marks + ", Name=" + Name + "]";
	}
	
}
