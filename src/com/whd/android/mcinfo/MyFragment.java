package com.whd.android.mcinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {
	int page;
	
	public MyFragment () {
		page = getArguments().getInt("page");
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat){
		if (page == 0) {
			TextView tv = new TextView(getActivity());
			tv.setText("Page 0");
			return tv;
		}
		return null;
	}
}