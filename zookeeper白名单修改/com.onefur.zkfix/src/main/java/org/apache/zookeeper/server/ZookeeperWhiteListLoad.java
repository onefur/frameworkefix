package org.apache.zookeeper.server;

import java.util.HashSet;
import java.util.Set;


/**
 * Description: Load the zookeeper custom white list 
 * Copyright (c) Department of Research and Development/Beijing
 * All Rights Reserved.
 * 2016-11-14 2:24:43  by yanglei
 */
public class ZookeeperWhiteListLoad {
	
	 public static final  Set<String> IP_SETS = loadIps();
	
	 /**
	  * Description:Load segment/IP white list 
	  * 2016-11-14 2:28:35 by yanglei
	  */
	 private static final Set<String> loadIps(){
		 Set<String> ips = new HashSet<String>();
		 
		 //**Because here is not its own Intranet, so precise to IP, 
		 //**late have own Intranet can set the network segment. example ips.add("10.251.");
		 
		 //product Intranet ip
		 ips.add("10.163.118.54");
		 ips.add("10.165.52.212");
		 ips.add("10.251.22.104");
		 ips.add("10.165.54.165");
		 ips.add("10.251.30.59");
		 ips.add("10.163.173.57");
		 ips.add("10.164.4.214");
		 
		 //product Extranet ip
		 ips.add("120.27.43.148");
		 ips.add("121.42.29.193");
		 ips.add("121.42.165.209");
		 ips.add("121.42.12.16");
		 ips.add("121.42.145.253");
		 ips.add("114.215.106.251");
		 ips.add("114.215.155.190");
		 return ips ;
	 }
	
}
