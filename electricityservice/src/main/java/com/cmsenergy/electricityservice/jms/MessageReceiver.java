package com.cmsenergy.electricityservice.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.cmsenergy.electricityservice.daos.ServicePlanDAO;

public class MessageReceiver implements MessageListener {

	@Override
	public void onMessage(Message m) {
		TextMessage message = (TextMessage) m;
		ServicePlanDAO msgDAO = new ServicePlanDAO();
		try {
			
			String[] messege = message.getText().split(":");
			if (msgDAO.updateCustomer(Integer.parseInt(messege[0]), Integer.parseInt(messege[1]))) {

				// ResponseSender response = new ResponseSender();
				// response.sendMessage("success");
				// send sucess messge to consumer
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}