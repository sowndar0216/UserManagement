package com.bridgeit.utility;

import com.bridgeit.model.User;

public class Utility {
	public static void emailOtp(User user,String token ) {
		
	      
		Mailer.send("thermoamigo18@gmail.com","ccjxydwuynbqglcw",user.getEmail(),token);  
	}
}
