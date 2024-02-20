package com.filmotheque.bo;

public class Member extends Person {

	private String email;
	private String password;
	private boolean isAdmin;
	
	public Member() {
	}
	
	public Member(long id, String firstname, String lastname, String email, String password, boolean isAdmin) {
		super(id, firstname, lastname);
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
