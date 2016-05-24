package com.web.crawler;

import java.sql.Timestamp;

public class Common {
	
	public static Timestamp getTimestamp(){
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}
}
