package tests;

public class Employee {

	String accountno;
//	public String getAccountno() {
//		return accountno;
//	}
//	public void setAccountno(String accountno) {
//		this.accountno = accountno;
//	}
//	public String getDepartmentno() {
//		return departmentno;
//	}
//	public void setDepartmentno(String departmentno) {
//		this.departmentno = departmentno;
//	}
//	public String getSalary() {
//		return salary;
//	}
//	public void setSalary(String salary) {
//		this.salary = salary;
//	}
//	public String getPincode() {
//		return pincode;
//	}
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
	String departmentno;
	String salary;
	String pincode;

	public Employee(String acc, String dept, String sal, String pin) {
		this.accountno = acc;
		this.departmentno = dept;
		this.salary = sal;
		this.pincode = pin;

	}

}
