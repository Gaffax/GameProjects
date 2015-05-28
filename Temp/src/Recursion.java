
public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word1 = "anna";
		String word2 = "Hansi Von Burgenstein II";
		boolean result;
		char[] wordArray;
		
		long initTime;
		long finalTime;
		long durationOfTask;

		initTime = System.nanoTime();
		
		wordArray = word1.toCharArray();
		result = palindrom(wordArray);
		System.out.println(result);
	
		wordArray = word2.toCharArray();
		result = palindrom(wordArray);
		System.out.println(result);
	finalTime = System.nanoTime();
	durationOfTask = finalTime - initTime;
	System.out.println(durationOfTask);

	System.out.println();
	
		initTime = System.nanoTime();
			
			result = palidromRecursive(word1);
			System.out.println(result);
			
			result = palidromRecursive(word2);
			System.out.println(result);
		finalTime = System.nanoTime();
		durationOfTask = finalTime - initTime;
		System.out.println(durationOfTask);

		
		


		

		
		//System.out.println(factorialRecursion(5));
		
		//System.out.println(factorialNonRecursive(5));
		
	}

	
	public static boolean palidromRecursive(String input){

		if(input.length() == 0 || input.length() == 1) //Base case
			//if lenght =0 OR 1 then it is
			return true;
		
		if(input.charAt(0) == input.charAt(input.length()-1)) //Recursive
			
			return palidromRecursive((input).substring(1, input.length()-1));
		
		return false;
	}
	
	public static boolean palindrom(char[] word){
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
	
	
	public static long factorialRecursion(int n){
		if (n==1)
			return 1;
		else
			return n * factorialRecursion(n-1);
	}
	
	public static long factorialNonRecursive(int n){
		
		int tempValue = 1;
		
		for(int i = n; i > 0; i--){
			tempValue = tempValue * i;
		}
		
		return tempValue;
	}
}
