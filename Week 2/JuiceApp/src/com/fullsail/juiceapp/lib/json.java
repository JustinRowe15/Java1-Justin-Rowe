package com.fullsail.juiceapp.lib;

import org.json.JSONObject;
import org.json.JSONException;
import com.fullsail.juiceapp.lib.JuiceInfo;

public class json {

	public static JSONObject buildJSON() {

		// New JSONObject
		JSONObject juiceObject = new JSONObject();
		try {
			// creation of the query JSONObject
			JSONObject queryObject = new JSONObject();

			//For loop through the enums
			for (JuiceInfo juice : JuiceInfo.values()) {

				//Create game review object
				JSONObject juices = new JSONObject();

				juices.put("ingredients", juice.setIngredients());
				juices.put("amounts", juice.setAmounts());
				juices.put("blendTime", juice.setBlendTime());
				juices.put("cupSize", juice.setCupSize());
				queryObject.put(juice.name().toString(), juices);
			}

			juiceObject.put("juices", queryObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return juiceObject;
	}
	
	//Setting up the result text that is populated from the JSON
	public static String readJSON(String selected){
		String instructions, ingredients, amounts, blendTime, cupSize;

		JSONObject object = buildJSON();

		try {
			ingredients = object.getJSONObject("juices").getJSONObject(selected).getString("ingredients");
			amounts = object.getJSONObject("juices").getJSONObject(selected).getString("amounts");
			blendTime = object.getJSONObject("juices").getJSONObject(selected).getString("blendTime");
			cupSize = object.getJSONObject("juices").getJSONObject(selected).getString("cupSize");

			instructions = "\r\n" + "Ingredients: "+ ingredients + "\r\n" 
					+"Amounts: " + amounts + "\r\n"
					+"Blend Time: " + blendTime + "\r\n"
					+"Size of Cup: " + cupSize + "\r\n";

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				instructions = e.toString();
			}		

			return instructions;
		}
}
