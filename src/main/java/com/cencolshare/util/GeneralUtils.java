package com.cencolshare.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtils {
	
	public String generateToken() {
		
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	public String getCurrentTimeStamp() {
		String DATE_FORMAT = "E yyyy.MM.dd hh:mm:ss a zzz";
		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat (DATE_FORMAT);
		String currentDateTime = ft.format(dNow);
		return currentDateTime;
	}

}
