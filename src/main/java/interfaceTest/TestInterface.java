package interfaceTest;



public class TestInterface {
	
	int ada =1;
	
	private static EnumConstants.TestEnum en = null;

	public static void main(String[] args) {
		
		TestInterface ti = new TestInterface();
		
		//Boolean ddd = new Boolean(true);
		
		
		ti.changeEnum(en);
		
		System.out.println(en);

	}
	
	
	
	
	public void changeEnum(EnumConstants.TestEnum enumu) {
		
		en = EnumConstants.TestEnum.B;
		
	}

}
