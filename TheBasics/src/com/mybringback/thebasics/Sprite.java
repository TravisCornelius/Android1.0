package com.mybringback.thebasics;

import com.mybringback.thebasics.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	private int x, y;
	private   int xSpeed, ySpeed;
	private   int height, width;
	private  Bitmap b;
	private  OurView ov;
	private  int currentFrame = 0;
	private  int direction = 3;
	
	
	public Sprite(OurView ourView, Bitmap blob) {
		// TODO Auto-generated constructor stub
	
		b = blob;
		ov = ourView;
		// 4 rows
	    height = b.getHeight() / 4;
		width = b.getWidth() / 4;
		x = y = 0;
		xSpeed = 5;
		ySpeed = 0;
		
	}
	

	private void update() {
		// TODO Auto-generated method stub
		
		// 0 = up
		// 1 = down
		// 2 = left
		// 3 = right
		
		//facing down
		if (x > ov.getWidth() - width - xSpeed){
			xSpeed = 0;
			ySpeed = 5;
			direction = 1;
		}
		//going left
		if (y > ov.getHeight() - height - ySpeed){
			xSpeed = -5;
			ySpeed = 0;
			direction = 2;
		}
		//facing up
		if (x + xSpeed < 0){
			x = 0;
			xSpeed = 0;
			ySpeed = -5;
			direction = 0;
		}
		//facing right
		if ( y + ySpeed < 0){
			y = 0;
			xSpeed = 5;
			ySpeed = 0;
			direction = 3;
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentFrame = ++currentFrame % 4;
		x += xSpeed;
		y += ySpeed;
	}
	
	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		update();
		int srcX = currentFrame *width;
		int srcY = direction * height;
		Rect src = new Rect (srcX, srcY,  srcX + width, srcY + height);
		Rect dst = new Rect (x, y, x+width, y +height);
		canvas.drawBitmap(b, src, dst, null);
	}

}
