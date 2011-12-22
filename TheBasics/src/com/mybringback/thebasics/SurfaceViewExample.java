package com.mybringback.thebasics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceViewExample extends Activity implements OnTouchListener{

	OurView v;
	Bitmap ball, blob;
	float x, y;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.blueball);
		blob = BitmapFactory.decodeResource(getResources(), R.drawable.spritesheet);
		x = y = 0;
		setContentView(v);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
	}


	public class OurView extends SurfaceView implements Runnable{
		
		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK = false;
		Sprite sprite, sprite2, sprite3, sprite4;
		boolean spriteLoaded = false;
		
		public OurView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			
			holder = getHolder();
			
		}


		public void run() {
			// TODO Auto-generated method stub
			
			//20 fps
			sprite = new Sprite(OurView.this, blob);
			
		
			
			
			while (isItOK){
				//perform canvas drawing
				if (!holder.getSurface().isValid()){
					continue;
				}
			
				
				 Canvas c = holder.lockCanvas();	
				 onDraw(c);
				 holder.unlockCanvasAndPost(c);
			}
		}
		
		protected void onDraw(Canvas canvas){
			canvas.drawARGB(255, 150, 150, 10);
			canvas.drawBitmap(ball, x - (ball.getWidth()/2), y - (ball.getHeight()/2), null);
			sprite.onDraw(canvas);
			
		
			
			
		}
		
		public void pause(){
			isItOK = false;
			while(true){
				try{
					t.join();
				}catch ( InterruptedException e){
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}
		public void resume(){
			isItOK = true;
			t = new Thread(this);
			t.start();
		}
	}


	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		switch(me.getAction()){
		case MotionEvent.ACTION_DOWN:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_UP:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			x = me.getX();
			y = me.getY();
			break;
		}
		
		return true;
	}
	
}
