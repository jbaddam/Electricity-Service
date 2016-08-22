package com.cmsenergy.electricityservice.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cmsenergy.electricityservice.daos.ServicePlanDAO;

/**
 * @author Jagan Reddy
 * this class has a functionality to listen the message
 * from activeMQ
 */
public class MessageReceiver implements MessageListener {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicatationcontext.xml");

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message m) {
		
		TextMessage message = (TextMessage) m;
		ServicePlanDAO srvDAO = (ServicePlanDAO) context.getBean("srvDAO");
		try {

			String[] messageArray = message.getText().split(":");
			srvDAO.updateCustomer(Integer.parseInt(messageArray[0]), Integer.parseInt(messageArray[1]));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}