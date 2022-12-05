package com.example.StudentCrud;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContactPK implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer CONTACT_ID;
	private Integer CUSTOMER_ID;
	public Integer getCONTACT_ID() {
		return CONTACT_ID;
	}
	public void setCONTACT_ID(Integer cONTACT_ID) {
		CONTACT_ID = cONTACT_ID;
	}
	public Integer getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(Integer cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public ContactPK(Integer cONTACT_ID, Integer cUSTOMER_ID) {
		super();
		CONTACT_ID = cONTACT_ID;
		CUSTOMER_ID = cUSTOMER_ID;
	}
	@Override
	public String toString() {
		return "ContactPK [CONTACT_ID=" + CONTACT_ID + ", CUSTOMER_ID=" + CUSTOMER_ID + "]";
	}
	
	
	
	
}
