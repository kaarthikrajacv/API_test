package interfaceTest;



public class TestInterface {
	
	int ada =1;
	
	private static EnumConstants.TestEnum en = null;

	public static void main(String[] args) {
		
		EngineeringEmployee enggEMp = new EngineeringEmployee(1, "Kaarthik");
		
		System.out.println(enggEMp);

	}
	
	
	
	
	public void changeEnum(EnumConstants.TestEnum enumu) {
		
		en = EnumConstants.TestEnum.B;
		
	}

}
