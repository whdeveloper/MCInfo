package com.whd.android.mcinfo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.app.Activity;

public class Info extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewPager vp = new ViewPager(this);
		setContentView(vp);
		
		Boolean online = new CheckServer("141.105.13.75", 255650).check();
		
		if (online == CheckServer.ONLINE){
			
		}
	}

}
