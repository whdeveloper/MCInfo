package com.whd.android.mcinfo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class CheckServer {
	public static final Boolean ONLINE  = true;
	public static final Boolean OFFLINE = false;
	
	private SocketAddress sa;
	private Socket        s;
	private String        se;
	private int           p;

	/** Public constructor
	  * String ServerAddress
	  * int    PortNumber */
	public CheckServer(String server, int port) {
		this.se = server;
		this.p  = port;
	}

	/** Checks the server from the info specified in the constructor */
	public Boolean check() {
		try {
			sa = new InetSocketAddress(this.se, this.p);
			s.connect(sa, 5000);
			return true;
		} catch (IOException e) {
			return false;
		} finally {
			if(s !=null){try {s.close();} catch (IOException e) {}}
		}
	}
}