package com.whd.android.mcinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		String msg = bundle.getString("alarm_message");
		
		Intent newintent = new Intent(context, Onoffservice.class);
		newintent.putExtra("alarm_message", msg);
		context.startService(newintent);
	}
	

}
