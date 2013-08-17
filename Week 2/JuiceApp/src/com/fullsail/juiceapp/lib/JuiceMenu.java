package com.fullsail.juiceapp.lib;

public class JuiceMenu implements Recipes {

	String name;
	double price;
	
	public JuiceMenu(String name, double price){
		setRecipeName(name);
		setRecipePrice(price);
	}
	
	@Override
	public boolean setRecipeName(String name) {
		this.name = name;
		return false;
	}

	@Override
	public boolean setRecipePrice(double price) {
		this.price = price;
		return false;
	}

	@Override
	public String getRecipeName() {
		return this.name;
	}

	@Override
	public double getRecipePrice() {
		return this.price;
	}

}
