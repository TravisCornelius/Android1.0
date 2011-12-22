package com.mybringback.thebasics;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class TutorialThree extends Activity implements OnClickListener {

	ImageView display;
	int toPhone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.wallpaper);
		
		toPhone = R.drawable.back_abstract;

		display = (ImageView) findViewById(R.id.IVdisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		ImageView image6 = (ImageView) findViewById(R.id.IVimage6);
		ImageView image7 = (ImageView) findViewById(R.id.IVimage7);
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);

		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		image7.setOnClickListener(this);
		setWall.setOnClickListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.IVimage1:
			display.setImageResource(R.drawable.back_abstract);
			toPhone = R.drawable.back_abstract;
			break;
		case R.id.IVimage2:
			display.setImageResource(R.drawable.back_apple);
			toPhone = R.drawable.back_apple;
			break;
		case R.id.IVimage3:
			display.setImageResource(R.drawable.back_bacon);
			toPhone = R.drawable.back_bacon;
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.back_cheese);
			toPhone = R.drawable.back_cheese;
			break;
		case R.id.IVimage5:
			display.setImageResource(R.drawable.back_rainbow);
			toPhone = R.drawable.back_rainbow;
			break;
		case R.id.IVimage6:
			display.setImageResource(R.drawable.back_skull);
			toPhone = R.drawable.back_skull;
			break;
		case R.id.IVimage7:
			display.setImageResource(R.drawable.back_skunk);
			toPhone = R.drawable.back_skunk;
			break;
		case R.id.BsetWallpaper:
			InputStream yeaaaa  = getResources().openRawResource(toPhone);
			Bitmap whatever = BitmapFactory.decodeStream(yeaaaa);
			try{
				getApplicationContext().setWallpaper(whatever);
			}catch(IOException e){
				e.printStackTrace();
			}
			break;
		}
	}

}
