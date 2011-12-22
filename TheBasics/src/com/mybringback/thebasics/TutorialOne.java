package com.mybringback.thebasics;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class TutorialOne extends Activity implements OnCheckedChangeListener{
	
	TextView textOut;
	EditText textIn;
	RadioGroup gravityG, styleG;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial1);
		textOut = (TextView) findViewById(R.id.tvChange);
		textIn = (EditText) findViewById(R.id.editText1);
		gravityG = (RadioGroup) findViewById(R.id.rgGravity);
		gravityG.setOnCheckedChangeListener(this);
		styleG = (RadioGroup) findViewById(R.id.rgStyle);
		styleG.setOnCheckedChangeListener(this);
		Button gen = (Button) findViewById(R.id.bGenerate);
		gen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textOut.setText(textIn.getText());
			}
		});
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId){
		case R.id.rbLeft:
			textOut.setGravity(Gravity.LEFT);
			break;
		case R.id.rbCenter:
			textOut.setGravity(Gravity.CENTER);
			break;
		case R.id.rbRight:
			textOut.setGravity(Gravity.RIGHT);
			break;
		case R.id.rbNormal:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
			break;
		case R.id.rbItalic:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
			break;
		case R.id.rbBold:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
			break;
		}
		
	}

}
