package com.fullsail.juiceapp.lib;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OrderForm {

	public static LinearLayout orderFormEntries(Context context, String hint, String buttonText) {
		LinearLayout linearlayout = new LinearLayout(context);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearlayout.setLayoutParams(layoutParams);
		
		EditText editText = new EditText(context);
		layoutParams = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		editText.setHint(hint);
		editText.setLayoutParams(layoutParams);
		editText.setId(1);
		
		Button button = new Button(context);
		button.setText(buttonText);
		button.setId(2);
		button.setTag(editText);
		
		linearlayout.addView(editText);
		linearlayout.addView(button);
		
		return linearlayout;
	};
	
	public static RadioGroup getRecipeOptions(Context context, String[] options){
		RadioGroup boxes = new RadioGroup(context);
		
		for(int i=0; i<options.length; i++){
			RadioButton radioButton = new RadioButton(context);
			radioButton.setText(options[i]);
			radioButton.setId(i+1);
			boxes.addView(radioButton);
		}
		
		return boxes;
	}
	
}
