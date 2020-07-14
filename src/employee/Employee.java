package employee;

public class Employee {
	int employeeId;
	String firstName;
	String email;
	int salary;
	
	public Employee(int employeeId, String firstName, String email, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.email = email;
		this.salary = salary;
	}


	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
