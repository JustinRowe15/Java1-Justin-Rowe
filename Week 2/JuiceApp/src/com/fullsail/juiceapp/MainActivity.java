/*
 *  project		JuiceApp
 * 
 *  package		com.fullsail.juiceapp
 * 
 *  @author		Justin Rowe
 * 
 *  date		Aug 8, 2013
 */
package com.fullsail.juiceapp;

import java.util.ArrayList;
import java.util.HashMap;

import com.fullsail.juiceapp.enums.Food;
import com.fullsail.juiceapp.lib.JuiceMenu;
import com.fullsail.juiceapp.lib.OrderForm;
import com.fullsail.juiceapp.lib.Recipes;
import com.fullsail.juiceapp.lib.json;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {
	
	LinearLayout.LayoutParams layoutParams;
	TextView result1;
	TextView result2;
	TextView result3;
	TextView result4;
	TextView result5;
	TextView result6;
	TextView result7;
	TextView result8;
	TextView resultsView;
	RadioGroup recipeOptions;
	ArrayList<Recipes> recipes;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout linearlayout = new LinearLayout(this);
		linearlayout.setOrientation(LinearLayout.VERTICAL);
		layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		linearlayout.setLayoutParams(layoutParams);
		
		TextView textView = new TextView(this);
		textView.setText("Hello! Welcome to the Juice Bar!");
		
		TextView textView2 = new TextView(this);
		textView2.setText("Please enter the amount of money you wish to spend.");
		
		result1 = new TextView(this);
		result2 = new TextView(this);
		result3 = new TextView(this);
		result4 = new TextView(this);
		result5 = new TextView(this);
		result6 = new TextView(this);
		result7 = new TextView(this);
		result8 = new TextView(this);
		resultsView = new TextView(this);
		
		LinearLayout entryBox = OrderForm.orderFormEntries(this, "Enter Amount of Money For Food", "Go!");
		Button recipeButton = (Button)entryBox.findViewById(2);
		
		recipeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/*int id = recipeOptions.getCheckedRadioButtonId();
				RadioButton rb = (RadioButton)findViewById(id);
				String selected = rb.getText().toString();
				resultsView.setText(json.readJSON(selected)); */
				
				/*int selectedRadioId = recipeOptions.getxCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton)recipeOptions.findViewById(selectedRadioId);
				String radioText = (String)selectedRadio.getText();
				
				double price = 0;
				for(int i=0; i<recipes.size(); i++){
					if(radioText.compareTo(recipes.get(i).getRecipeName()) == 0){
						price = recipes.get(i).getRecipePrice();
					}
				} */
				
				EditText recipeText = (EditText)v.getTag();
				double foodDouble = Double.parseDouble(recipeText.getText().toString());
				
				//double moneyBackForMoreJuice = foodDouble - price;
				
				HashMap<Food, Integer> difference = Food.getTotal(foodDouble);
				
						result1.setText("Strawberry: " + difference.get(Food.STRAWBERRY));
						result2.setText("Blueberry: " + difference.get(Food.BLUEBERRY));
						result3.setText("Rasberry: " + difference.get(Food.RASBERRY));
						result4.setText("Apple: " + difference.get(Food.APPLE));
						result5.setText("Orange: " + difference.get(Food.ORANGE));
						result6.setText("Carrot: " + difference.get(Food.CARROT));
						result7.setText("Celery: " + difference.get(Food.CELERY));
						result8.setText("Spinich: " + difference.get(Food.SPINICH));
				
			}
		});
		
		ArrayList<Recipes> recipes = new ArrayList<Recipes>();
		recipes.add(new JuiceMenu("Strawberry Smoothie", 4.00));
		recipes.add(new JuiceMenu("Apple and Rasberry Smoothie", 5.00));
		recipes.add(new JuiceMenu("Carrot and Spinach Smoothie", 4.50));
		recipes.add(new JuiceMenu("Orange Smoothie", 4.00));
		recipes.add(new JuiceMenu("Rasberry and Blueberry Smoothie", 5.00));
		
		String[] recipeNames = new String[recipes.size()];
		for(int i=0; i<recipes.size(); i++){
			recipeNames[i] = recipes.get(i).getRecipeName();
		}
		
		final RadioGroup recipeOptions = OrderForm.getRecipeOptions(this, recipeNames);
		
		//Button instructionsButton = new Button(this);
		//instructionsButton.setLayoutParams(layoutParams);
		//instructionsButton.setText("Get Instructions");
		/*recipeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		}); */
		
		//resultsView.setLayoutParams(layoutParams);
		//resultsView.setText("Select Smoothie For Instructions");
		
		
		linearlayout.addView(textView);
		linearlayout.addView(textView2);
		linearlayout.addView(entryBox);
		linearlayout.addView(recipeOptions);
		//linearlayout.addView(instructionsButton);
		linearlayout.addView(resultsView);
		linearlayout.addView(result1);
		linearlayout.addView(result2);
		linearlayout.addView(result3);
		linearlayout.addView(result4);
		linearlayout.addView(result5);
		linearlayout.addView(result6);
		linearlayout.addView(result7);
		linearlayout.addView(result8);
		setContentView(linearlayout);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
