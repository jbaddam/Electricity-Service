package com.cisco.cassandra.CassandraTest;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class CassandraTest {
	public static void main(String[] args) {

		// Connect to the cluster and keyspace "customer"
		final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		final Session session = cluster.connect("customer");

		
		// Retrieve all User details from customerinfo table
		System.out.println("\n*********Retrive User Data Example *************");
		getUsersAllDetails(session);

		// Insert new User into customerinfo table
		System.out.println("\n*********Insert User Data Example *************");
		session.execute(
				"INSERT INTO customerinfo (cid, cname,email,salary) VALUES (333, 'Srinivas', 's_kondapaneni@gmail.com',7500)");
		getUsersAllDetails(session);

		// Update user data in customerinfo table
		System.out.println("\n*********Update User Data Example *************");
		session.execute("update customerinfo set salary = 6500 where cid = 111");
		getUsersAllDetails(session);

		// Delete user from customerinfo table
		System.out.println("\n*********Delete User Data Example *************");
		session.execute("delete FROM customerinfo where cid = 333");
		getUsersAllDetails(session);

		// Close Cluster and Session objects
		System.out.println("\nIs Cluster Closed :" + cluster.isClosed());
		System.out.println("Is Session Closed :" + session.isClosed());
		cluster.close();
		session.close();
		System.out.println("Is Cluster Closed :" + cluster.isClosed());
		System.out.println("Is Session Closed :" + session.isClosed());
	}

	private static void getUsersAllDetails(final Session inSession) {
		
		// Use select to get the customerinfo table data
		ResultSet results = inSession.execute("SELECT * FROM customerinfo");
		
		for (Row row : results) {
			System.out.format("%d %s %s %d \n", row.getInt("cid"), row.getString("cname"), row.getString("email"),
					row.getInt("salary"));
		}
	}
}
