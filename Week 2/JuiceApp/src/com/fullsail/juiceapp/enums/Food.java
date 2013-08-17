package com.fullsail.juiceapp.enums;

import java.util.HashMap;

public enum Food {
	BLUEBERRY(1),
	RASBERRY(5),
	STRAWBERRY(10),
	CELERY(20),
	CARROT(30),
	SPINICH(50),
	ORANGE(100),
	APPLE(90);
	
	private final int value;
	
	Food(int value){
		this.value = value;
	}
	
	public static HashMap<Food, Integer> getTotal(double amount){
		HashMap<Food, Integer> total = new HashMap<Food, Integer>();
		Food[] foodTypes = {APPLE,ORANGE,SPINICH,CARROT,CELERY,STRAWBERRY,RASBERRY,BLUEBERRY};
		double difference = amount*100;
		for(int i=0; i<foodTypes.length; i++) {
			Food foodType = foodTypes[i];
			int num = (int) Math.floor(difference/foodType.value);
			difference = difference%foodType.value;
			total.put(foodType, num);
		}
		return total;
	}
	
}
