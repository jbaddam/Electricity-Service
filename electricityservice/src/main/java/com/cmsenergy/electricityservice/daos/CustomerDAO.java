package com.cmsenergy.electricityservice.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.cmsenergy.electricityservice.models.Customer;
import com.cmsenergy.electricityservice.util.JdbcUtil;

@Repository
public class CustomerDAO {
	
	JdbcUtil util = new JdbcUtil();
	Customer cust = new Customer();	
	
	/*ApplicationContext context = new ClassPathXmlApplicationContext("context-servlet.xml");
	SessionFactory mySessionFactory = (SessionFactory) context.getBean("mySessionFactory");*/
	public  Customer getCustomerById(int id){
		
		
		/*Session session = mySessionFactory.openSession();
		System.out.println("session opened");
		Customer customer = (Customer) session.load(Customer.class, id);
		System.out.println(customer.getFirstname());
		return customer;*/
		
		Connection con = util.createMySqlConnection();
		try {
			Statement st = con.createStatement();
			System.out.println(id);
			ResultSet rs = st.executeQuery("select * from customer where id ="+id);
			
				while(rs.next()){
					cust.setCid(rs.getInt(1));
					cust.setFirstname(rs.getString(2));
					cust.setLastname(rs.getString(3));
					cust.setUsername(rs.getString(4));
					cust.setPassword(rs.getString(5));
					}		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cust;			
			
	}
	
}
