package com.msr.oms.email.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.msr.oms.email.service.EmailSenderService;
/**
 * the class EmailSenderServiceImpl.
 * this class is used for sending an email's to the customers.
 * @author vamshib
 */
@Component
public class EmailSenderServiceImpl implements EmailSenderService {
	
	/** The email sender. */
	@Autowired
	public JavaMailSender emailSender;

	/** The from mail. */
	@Value("${spring.mail.username}")
	public String fromMail;

	/* (non-Javadoc)
	 * @see com.lgndu.oms.email.service.impl.sendMessageWithAttachment#sendMail(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	 */
	@Override
	public void sendMail(String toMail, String subject, String text, String pathToAttachment) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(fromMail);
		helper.setTo(toMail);
		helper.setSubject(subject);
		helper.setText(text,true);
		if(pathToAttachment != null) {
			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment("Image", file);
		}
		emailSender.send(message);
	}
}
