package com.whd.android.mcinfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.util.Log;

public class Cs {
	
	static String s1 = null; //Server 1 = Survival 1
    static String s2 = null; //Server 2 = Survival 2
    static String s3 = null; //Server 3 = Creative 1
    
	public void cs1(){
        try {
        	Log.e("[WHD Info}", "Start checking server 1");
        	Socket cSocket = new Socket(Proxy.NO_PROXY);
		    cSocket.connect(new InetSocketAddress(Vars.ip, Vars.port5), 3000);
	    	BufferedWriter lbw = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));
            lbw.flush();
	        lbw.write("GET / HTTP/1.1\r\nHost: " + Vars.ip + "\r\n\r\n");
	        lbw.flush();
    	    Cs.s1 = "online";
    	    Log.e("[WHD Info}", "Server 1 online!");
    	    Log.e("[WHD Info}", "Finished checking server 1");
        } catch (SocketTimeoutException e){
        	Cs.s1 = "offline";
        	Log.e("[WHD Info}", "Server 1 offline!");
    	    Log.e("[WHD Info}", "Finished checking server 1");
	    } catch (IOException e) {
        	Cs.s1 = "offline";
		    e.printStackTrace();
		    Log.e("[WHD Info}", "Server 1 offline!");
    	    Log.e("[WHD Info}", "Finished checking server 1");
	    }
    }
    
    public void cs2(){
        try {
        	Log.e("[WHD Info}", "Start checking server 2");
        	Socket cSocket = new Socket(Proxy.NO_PROXY);
		    cSocket.connect(new InetSocketAddress(Vars.ip, Vars.port4), 3000);
	    	BufferedWriter lbw = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));
            lbw.flush();
	        lbw.write("GET / HTTP/1.1\r\nHost: " + Vars.ip + "\r\n\r\n");
	        lbw.flush();
	        Cs.s2 = "online";
	        Log.e("[WHD Info}", "Server 2 online!");
	        Log.e("[WHD Info}", "Finished checking server 2");
        } catch (SocketTimeoutException e){
        	Cs.s2 = "offline";
        	Log.e("[WHD Info}", "Server 2 offline!");
    	    Log.e("[WHD Info}", "Finished checking server 2");
	    } catch (IOException e) {
        	Cs.s2 = "offline";
		    e.printStackTrace();
		    Log.e("[WHD Info}", "Server 2 offline!");
    	    Log.e("[WHD Info}", "Finished checking server 2");
	    }
    }
    
    public void cs3(){
        try {
        	Log.e("[WHD Info}", "Start checking server 3");
        	Socket cSocket = new Socket(Proxy.NO_PROXY);
		    cSocket.connect(new InetSocketAddress(Vars.ip, Vars.port3), 3000);
	    	BufferedWriter lbw = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));
            lbw.flush();
	        lbw.write("GET / HTTP/1.1\r\nHost: " + Vars.ip + "\r\n\r\n");
	        lbw.flush();
	        Cs.s3 = "online";
	        Log.e("[WHD Info}", "Server 3 online!");
	        Log.e("[WHD Info}", "Finished checking server 3");
        } catch (SocketTimeoutException e){
        	Cs.s3 = "offline";
        	Log.e("[WHD Info}", "Server 3 offline!");
    	    Log.e("[WHD Info}", "Finished checking server 3");
	    } catch (IOException e) {
        	Cs.s3 = "offline";
		    e.printStackTrace();
		    Log.e("[WHD Info}", "Server 3 offline!");
    	    Log.e("[WHD Info}", "Finished checking server 3");
	    }
    }
}
