package com.cmsenergy.electricityservice.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="customer")
@XmlRootElement
public class Customer implements Serializable{
	
	private static final long serialVersionUID = -5577579081118070434L;
	
	@Id()
	private int id;
	
	@Column(name ="firstname") private String firstname;		
	@Column(name ="lastname") private String lastname; 	
	@Column(name ="username") private String username; 	
	@Column(name ="password") private String password;
	
	public int getCid() {
		return id;
	}
	public void setCid(int cid) {
		this.id = cid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
