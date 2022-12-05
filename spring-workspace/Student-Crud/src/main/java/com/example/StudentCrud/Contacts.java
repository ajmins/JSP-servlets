package com.example.StudentCrud;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Contacts  {
	
	@EmbeddedId
	private ContactPK Id;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String PHONE;
	
	
	
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public ContactPK getId() {
		return Id;
	}
	public void setId(ContactPK id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Contacts [Id=" + Id + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME + ", EMAIL=" + EMAIL
				+ ", PHONE=" + PHONE + "]";
	}
	
	

}
