
public class Bclass {

	private int anotherValue;
	public String punk = "WhatChaWant... Punk!";
	public Cclass monkey = new Cclass();

	public Bclass(int anotherValue){
	

		this.anotherValue = anotherValue;
		
	}
	
	public int getAnotherValue(){
		return anotherValue;
	}
	
	public Cclass getCclass(){
		return monkey;
	}
}
