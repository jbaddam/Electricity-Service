package com.cmsenergy.electricityservice.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.cmsenergy.electricityservice.daos.ServicePlanDAO;

/**
 * @author Jagan Reddy
 * this class has a functionality to listen the message
 * from activeMQ
 */
public class MessageReceiver implements MessageListener {

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message m) {
		
		TextMessage message = (TextMessage) m;
		ServicePlanDAO msgDAO = new ServicePlanDAO();
		try {

			String[] messege = message.getText().split(":");
			msgDAO.updateCustomer(Integer.parseInt(messege[0]), Integer.parseInt(messege[1]));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}