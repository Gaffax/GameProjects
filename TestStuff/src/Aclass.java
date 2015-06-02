public class Aclass {

	private int someValue;
	private Bclass theBteam;
	
	public Aclass(int someValue, Bclass theBteam) {
		this.someValue = someValue;
		this.theBteam = theBteam;
	}

	public int getSomeValue() {
		return someValue;
	}

	public int multiplySomeValue(int toBeMultiplied) {
		return toBeMultiplied * 2;

	}
	
	public Bclass getBClass(){
		return theBteam;
	}
}
