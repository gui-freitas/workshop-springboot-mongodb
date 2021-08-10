package com.gapp.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertDate(String textDate, Instant defaultValue) {
		if (textDate.equals("")){
			return defaultValue;
		}
		else {
			Instant instant = Instant.parse(textDate);
			return instant;
		}
	}
}