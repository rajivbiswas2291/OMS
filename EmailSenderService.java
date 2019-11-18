package com.msr.oms.email.service;

import javax.mail.MessagingException;
/**
 * the interface EmailSenderService
 * @author vamshib
 *
 */
public interface EmailSenderService {
	
	/**
	 * this method is used to send a mail with or without an attachment
	 * 
	 * @param toMail
	 * @param subject
	 * @param text
	 * @param attachmentPath
	 * @throws MessagingException
	 */
	public void sendMail(String toMail, String subject, String text, String attachmentPath) throws MessagingException;
}
