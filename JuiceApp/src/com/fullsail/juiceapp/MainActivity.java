package com.fullsail.juiceapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout linearLayout;
	LinearLayout.LayoutParams layoutParams;
	EditText editText;
	TextView result1;
	TextView result2;
	TextView result3;
	TextView result4;
	TextView result5;
	TextView result6;
	TextView result7;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		linearLayout.setLayoutParams(layoutParams);
		
		//Create Text View to show introduction to the Juice Maker Application
		TextView textView = new TextView(this);
		textView.setText("Hello! How many are with your customer party?");
		linearLayout.addView(textView);
		
		//Ability to Edit Text
	    editText = new EditText(this);
		editText.setHint("Enter Value Here");
		linearLayout.addView(editText);
		
		//Add Button with Event Listener to add all fruits
		Button button = new Button(this);
		button.setText("Get Juice Amounts!");
		linearLayout.addView(button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int strawberries = getResources().getInteger(R.integer.strawberry);
				int blackberries = getResources().getInteger(R.integer.blackberry);
				int apples = getResources().getInteger(R.integer.apple);
				int oranges = getResources().getInteger(R.integer.orange);

				int entry = Integer.parseInt(editText.getText().toString());
				
				int numStrawberries = (strawberries/10)*entry;
				int numBlackberries = (blackberries/10)*entry;
				int numApples = (apples/3)*entry;
				int numOranges = (oranges/2)*entry;
				
				boolean shopOpen = true;
				
				if(shopOpen == false)
					result6.setText("Our shop is currently closed, please come back for more juice later!");
				else
					result6.setText("We're open, come on in!");
				
				result1.setText("For that amount of people, we can make " + numStrawberries +" strawberry juices.");
				result2.setText("For that amount of people, we can make " + numBlackberries +" blackberry juices.");
				result3.setText("For that amount of people, we can make " + numApples +" apple juices.");
				result4.setText("For that amount of people, we can make " + numOranges +" orange juices.");
				
				int carrotsOnHand = 30;
				int spinachOnHand = 50;
				
				if (carrotsOnHand == 0 && spinachOnHand == 0)
					result5.setText("We currently have no carrots or spinach left.");
				else
					result5.setText("We currently have " + carrotsOnHand + " bunches of carrots and " + spinachOnHand + " bags of spinach left in our stock to make more juice!");
				
				int spinachRemaining = 50;
				while (spinachRemaining > 10) {
					result7.setText("Our remaining bunches of spinach after each spinach juice made is " + spinachRemaining + " .");
					spinachRemaining--;
				}
			}
		});
		
		layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		result6 = new TextView(this);
		result6.setLayoutParams(layoutParams);
		linearLayout.addView(result6);
		
		result1 = new TextView(this);
		result1.setLayoutParams(layoutParams);
		linearLayout.addView(result1);
		
		result2 = new TextView(this);
		result2.setLayoutParams(layoutParams);
		linearLayout.addView(result2);
		
		result3 = new TextView(this);
		result3.setLayoutParams(layoutParams);
		linearLayout.addView(result3);
		
		result4 = new TextView(this);
		result4.setLayoutParams(layoutParams);
		linearLayout.addView(result4);

		result5 = new TextView(this);
		result5.setLayoutParams(layoutParams);
		linearLayout.addView(result5);
		
		result7 = new TextView(this);
		result7.setLayoutParams(layoutParams);
		linearLayout.addView(result7);
		
		setContentView(linearLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
