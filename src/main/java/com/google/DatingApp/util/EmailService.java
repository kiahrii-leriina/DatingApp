package com.google.DatingApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.google.DatingApp.entity.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender jms;
	
	
	public void sendFirstEmail(User u) {
		
		MimeMessage message = jms.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(u.getEmail());
			helper.setSubject("Account created successfully");
			helper.setText("Dear "+u.getName()+" your account has been created successfully for DearApp");
			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		jms.send(message);
		
	}


	public int getOTP() {
		int otp = 0;
		while(otp <= 999) {
			otp = (int)(Math.random()*100000);
		}
		return otp;
	}
}
