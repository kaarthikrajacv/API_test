package interfaceTest;

public class EngineeringEmployee implements Employee{
	
	int employeeId;
	
	String employeeName;
	
	public EngineeringEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public EngineeringEmployee(int employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	
	

	@Override
	public void printEmployeeDetails() {
		
		System.out.println("The is an Engineering EMployee class" + employeeName);
		
	}

	@Override
	public String getEmployeeDepartment() {
		// TODO Auto-generated method stub
		return "Engineering";
	}
	
	public int returnemployeeId() {
		
		return employeeId;
	}

}
