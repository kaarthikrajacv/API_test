package interfaceTest;

public class MarketingEmployee implements Employee{

	@Override
	public void printEmployeeDetails() {
		System.out.println("This is marketing employee class");
		
	}

	@Override
	public String getEmployeeDepartment() {
		// TODO Auto-generated method stub
		return "Marketing";
	}

}
