
public class DimensionalArrayLengthTest {

	public static void main(String[] args) {

		String map[][] = new String[2][20];
		
		map[0][0] = "dude test";
		map[0][1] = "dude test";
		
		map[1][0] = "dude";
		map[1][1] = "dude";
		
		int YValue = map[0].length;
		int XValue = map.length;
		
		System.out.println(YValue);
		System.out.println(XValue);
	}

}
