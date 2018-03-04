package com.bindschaedel.nachhilfe.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateFormatter {
	public Date HTMLtoSQLDate(String htmlDate) {
		
		DateFormat df = new SimpleDateFormat("YYYY-mm-dd");
		Date date;
		try {
			date = df.parse(htmlDate);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			date = new Date();
			return date;
		}
	}
}
