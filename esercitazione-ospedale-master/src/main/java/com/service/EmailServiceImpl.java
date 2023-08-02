package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;

	SimpleMailMessage message = new SimpleMailMessage();

	public void sendPositiveEmail(String to) {
		message.setFrom("fullstacktest@gmx.com");
		message.setTo(to);
		message.setSubject("Richiesta cambio orario/data");
		message.setText("Richiesta accettata!");
		mailSender.send(message);
	}

	public void sendNegaviteEmail(String to) {
		message.setFrom("fullstacktest@gmx.com");
		message.setTo(to);
		message.setSubject("Richiesta cambio orario/data");
		message.setText("Richiesta non accettata");
		mailSender.send(message);
	}

}
