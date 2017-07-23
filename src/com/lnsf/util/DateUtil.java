package com.lnsf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMAT = "HH:mm:ss";

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATETIME_FORMAT);
	private static SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
	
	
	public static Date getDateFromString(String date_s){
		Date date=null;
		try {
			date=dateFormat.parse(date_s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public static String getStringFromDate(Date date){
		return dateFormat.format(date);
	}
}
