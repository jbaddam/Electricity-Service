package com.bootcampjava.electricityservice.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author Jagan Reddy 
 * This class has functionality send the asynchronous
 * message to other application
 */
public class MessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * @param message
	 * This method takes input as String message and sends that
	 * message to other application
	 */
	public void sendMessage(final String message) {
		
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
