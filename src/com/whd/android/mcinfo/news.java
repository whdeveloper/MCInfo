package com.whd.android.mcinfo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class news {
    HttpPost post;
    ResponseHandler<String> resp;
    String result;
    HttpClient c;
    
    public void getnews() {
    	c = new DefaultHttpClient();
    	post = new HttpPost("http://wservers.zzl.org/apps/news.php");
    	resp = new BasicResponseHandler();
    	try {
    		result = c.execute(post, resp);
    		if (result != null) {
    			Vars.news = result;
    		}
    	} catch (ClientProtocolException e) {
    		Log.e("[WHD MC Info]", "An error occured:");
    		e.printStackTrace();
    	} catch (IOException e) {
    		Log.e("[WHD MC Info]", "An error occured:");
    		e.printStackTrace();
    	}
    }
}
