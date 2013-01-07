package com.whd.android.mcinfo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class InfoActivity extends Activity implements OnItemSelectedListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //News
        new news().getnews();
        TextView news = (TextView) findViewById(R.id.news);
        news.setText(Vars.news);
        
        //Start service if togglebutton is checked
        ToggleButton servicebutton = (ToggleButton) findViewById(R.id.meldingjanee);
        
        if (servicebutton.isChecked()){
        	//Set ToggleButton disabled
        	servicebutton.setEnabled(false);
        	
        	//Start service
        	startsc();
        	
        	//Set ToggleButton enabled
        	servicebutton.setEnabled(true);
        } else if (servicebutton.isChecked()== false) {
        	//Set ToggleButton disabled
        	servicebutton.setEnabled(false);
        	
        	//Stop service
        	stopsc();
        	
        	//Set ToggleButton Enabled
        	servicebutton.setEnabled(true);
        } else {
        	Log.e("[WHD MC Info]", "Not a valid state of ToggleButton");
        }
        
        //Check the servers
        new Cs().cs1();
        new Cs().cs2();
        new Cs().cs3();
        
        //Change layout
        //Creative 1
        ImageView c1onoffi = (ImageView) findViewById(R.id.c1onoffi);
        TextView c1onofft = (TextView) findViewById(R.id.c1onofft);
        
        //Survival 1
        ImageView s1onoffi = (ImageView) findViewById(R.id.s1onoffi);
        TextView s1onofft = (TextView) findViewById(R.id.s1onofft);
        
        //Survival 2
        ImageView s2onoffi = (ImageView) findViewById(R.id.s2onoffi);
        TextView s2onofft = (TextView) findViewById(R.id.s2onofft);
    	
        //If servers are online change text and images...
        // Server 1
        if (Cs.s1 == "online") {
    	    s1onoffi.setImageResource(Vars.onlinei);
        	s1onofft.setText(Vars.online);
        } else {
    	    s1onoffi.setImageResource(Vars.offlinei);
        	s1onofft.setText(Vars.offline);
        }
    
        //Server 2
        if (Cs.s2 == "online") {
    	    s2onoffi.setImageResource(Vars.onlinei);
        	s2onofft.setText(Vars.online);
        } else {
    	    s2onoffi.setImageResource(Vars.offlinei);
        	s2onofft.setText(Vars.offline);
        }
    
        //Server 3
        if (Cs.s3 == "online") {
    	    c1onoffi.setImageResource(Vars.onlinei);
        	c1onofft.setText(Vars.online);
        } else {
        	c1onoffi.setImageResource(Vars.offlinei);
        	c1onofft.setText(Vars.offline);
        }
    }

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long arg3) {
		Vars.delayt = parent.getItemAtPosition(pos).toString();
		if (Vars.delayt == "vijfmin") {
			Vars.interval = Vars.vijf;
		} else if (Vars.delayt == "tienmin") {
			Vars.interval = Vars.tien;
		} else if (Vars.delayt == "vijftienmin") {
			Vars.interval = Vars.vijftien;
		} else if (Vars.delayt == "dertigmin") {
			Vars.interval = Vars.dertig;
		} else if (Vars.delayt == "eenuur") {
			Vars.interval = Vars.eenuur;
		} else if (Vars.delayt == "tweeuur") {
			Vars.interval = Vars.tweeuur;
		} else if (Vars.delayt == "drieuur") {
			Vars.interval = Vars.drieuur;
		} else if (Vars.delayt == "vijfuur") {
			Vars.interval = Vars.vijfuur;
		} else {
			Vars.interval = Vars.vijftien;
		}
	}
    
    public void onNothingSelected(AdapterView<?> parent){
    	Vars.interval = 900000; 
    }
    
    //Get interval from spinner
    public void getspinterval() {
    	Spinner delay = (Spinner) findViewById(R.id.delay);
    	delay.setOnItemSelectedListener(this);
    	Onoffservice.delay = 1;
    }
    
    //Start the service
    public void startsc() {
    	Intent ofService= new Intent(this,Onoffservice.class);
    	PendingIntent pendingintent = PendingIntent.getService(this, 0, ofService, 0);
    	AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
    	Calendar cal = Calendar.getInstance();
    	cal.setTimeInMillis(System.currentTimeMillis());
    	cal.add(Calendar.MINUTE, Vars.interval);
    	am.setRepeating(AlarmManager.RTC, cal.getTimeInMillis(), Vars.interval, pendingintent);
    }
    
    //Stop the service
    public void stopsc() {
    	Intent ofService = new Intent(this, Onoffservice.class);
    	PendingIntent pendingintent = PendingIntent.getService(this, 0, ofService, 0);
    	AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
    	am.cancel(pendingintent);
    }
}