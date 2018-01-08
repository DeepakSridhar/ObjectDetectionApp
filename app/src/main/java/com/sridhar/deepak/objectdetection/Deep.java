package com.sridhar.deepak.objectdetection;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Deep extends Activity {
MediaPlayer song;
	@Override
	protected void onCreate(Bundle deep) {
		// TODO Auto-generated method stub
		super.onCreate(deep);
		setContentView(R.layout.enguins);
	    song= MediaPlayer.create(Deep.this,R.raw.swordsound );
		
	    SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    boolean music=sp.getBoolean("checkbox",true );
	   
	    if(music==true)
	    song.start();
	    
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent os=new Intent("com.sridhar.deepak.objectdetection.MENU");
					startActivity(os);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
	

}
