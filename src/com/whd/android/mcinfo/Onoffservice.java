package com.whd.android.mcinfo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class Onoffservice extends Service {
	private static final int notif1 = 1;
    public Notification not1 = null;
    private static final int notif2 = 2;
    public Notification not2 = null;
    private static final int notif3 = 3;
    public Notification not3 = null;
    
	public static int delay = 900000;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		new Cs().cs1();
		new Cs().cs2();
		new Cs().cs3();
		
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		//Server 1
        if (Cs.s1 == "online") {
        	int icon = Vars.onlinei;
        	CharSequence text = "Survival Server 1 is now online";
        	long when = System.currentTimeMillis();
        	this.not1 = new Notification(icon, text, when);
        } else {
        	
        }
    
        //Server 2
        if (Cs.s2 == "online") {
        	int icon = Vars.onlinei;
        	CharSequence text = "Survival Server 2 is now online";
        	long when = System.currentTimeMillis();
        	this.not2 = new Notification(icon, text, when);
        } else {
        	
        }
    
        //Server 3
        if (Cs.s3 == "online") {
        	int icon = Vars.onlinei;
        	CharSequence text = "Creative Server 1 is now online";
        	long when = System.currentTimeMillis();
        	this.not3 = new Notification(icon, text, when);
        } else {
        
        }
        
        if (not1 != null){
        	nm.notify(notif1, not1);
        }
        if (not2 != null){
        	nm.notify(notif2, not2);
        }
        if (not3 != null){
        	nm.notify(notif3, not3);
        }
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
		
		
	}



}
