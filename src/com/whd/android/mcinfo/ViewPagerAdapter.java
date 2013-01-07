package com.whd.android.mcinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	
	String pages[] = {"Home", "Settings"};

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int page) {
		Bundle b = null;
		b.putInt("page", page+1);
		new MyFragment().setArguments(b);
		return null;
	}

	@Override
	public int getCount() {
		return pages.length;
	}

}