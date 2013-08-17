package com.fullsail.juiceapp.lib;

public enum JuiceInfo {
	StrawberrySmoothie("Strawberries", "12 Strawberries", "30 second blend", "12 ounce cup"),
	AppleAndRasberrySmoothie("Apples and Rasberries", "3 Apples and 16 Rasberries", "45 second blend", "12 ounce cup"),
	CarrotAndSpinachSmoothie("Carrots and Spinach", "4 Carrots and 2 Cups of Spinach", "45 second blend", "12 ounce cup"),
	OrangeSmoothie("Oranges", "4 Oranges", "45 second blend", "12 ounce cup"),
	RasberryAndBlueberrySmoothie("Rasberries and Blueberries", "16 Rasberries and 16 Blueberries", "45 second blend", "12 ounce cup");
	
	private final String ingredients;
	private final String amounts;
	private final String blendTime;
	private final String cupSize;
	
	private JuiceInfo(String ingredients, String amounts, String blendTime, String cupSize) {
		this.ingredients = ingredients;
		this.amounts = amounts;
		this.blendTime = blendTime;
		this.cupSize = cupSize;
	}
		
	public String setIngredients(){
		return ingredients;
	}
	
	public String setAmounts(){
		return amounts;
	}
	
	public String setBlendTime(){
		return blendTime;
	}
	
	public String setCupSize(){
		return cupSize;
	}
	
}
