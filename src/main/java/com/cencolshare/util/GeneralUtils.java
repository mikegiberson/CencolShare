package com.cencolshare.util;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtils {
	
	public String generateToken() {
		
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
