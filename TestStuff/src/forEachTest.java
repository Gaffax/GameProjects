import java.util.ArrayList;


public class forEachTest {

	
	public static void main(String[] args){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("Test");
//		arrayList.add("Test");
//		arrayList.add("Test");
		
		boolean testBool = true;
		for (String string : arrayList){
			testBool = false;

		}
		
		System.out.println(testBool);
		
		
		testBool = true;
		//arrayList.clear();
		arrayList.remove(0);
		for (String string : arrayList){
			testBool = false;
		}
		
		System.out.println(testBool);
	}
	
}
