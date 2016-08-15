package com.cmsenergy.electricityservice.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.cmsenergy.electricityservice.daos.MessegeDAO;

public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message m) {
		TextMessage message = (TextMessage) m;
		MessegeDAO msgDAO = new MessegeDAO();
		try {
			System.out.println(message.getText());
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