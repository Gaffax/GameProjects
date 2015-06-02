
public class TestMain {

	public static void main(String[] args) {

		
		Bclass anotherTest = new Bclass(69);
		
		Aclass test = new Aclass(2, anotherTest);

		
		test.getBClass().getCclass().multiplyTheMonkey();;
		int tempValue = test.getBClass().getCclass().getTheMonkey();;
		System.out.println(tempValue);
		
	}
}
