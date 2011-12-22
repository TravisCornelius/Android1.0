package com.mybringback.thebasics;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class main extends Activity {
    /** Called when the activity is first created. */
	MediaPlayer logoMusic;
	
	@Override
    public void onCreate(Bundle TravisIsAwesome) {
        super.onCreate(TravisIsAwesome);
        setContentView(R.layout.splash);                    
        logoMusic = MediaPlayer.create(main.this, R.raw.splash_sound);
        logoMusic.start();
        
 
        
        Thread logoTimer = new Thread(){
        	public void run(){
        		try{	
        			sleep(1000);
        			Intent menuIntent = new Intent("com.mybringback.thebasics.MENU");
        			startActivity(menuIntent);
        		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
        			finish();
        		}
        	}
        };
        logoTimer.start();
      
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		logoMusic.release();
	}
}