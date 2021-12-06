package com.ojas.model;

public class Customer {
	
	private int cust_id;
	private String cust_name;
	private String cust_add;
	private String cust_email;
	private long cut_phone;
	private String possword;
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_add() {
		return cust_add;
	}
	public void setCust_add(String cust_add) {
		this.cust_add = cust_add;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public long getCut_phone() {
		return cut_phone;
	}
	public void setCut_phone(long cut_phone) {
		this.cut_phone = cut_phone;
	}
	public String getPossword() {
		return possword;
	}
	public void setPossword(String possword) {
		this.possword = possword;
	}
	public Customer(int cust_id, String cust_name, String cust_add, String cust_email, long cut_phone,
			String possword) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_add = cust_add;
		this.cust_email = cust_email;
		this.cut_phone = cut_phone;
		this.possword = possword;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_add=" + cust_add + ", cust_email="
				+ cust_email + ", cut_phone=" + cut_phone + ", possword=" + possword + "]";
	}
	

}
