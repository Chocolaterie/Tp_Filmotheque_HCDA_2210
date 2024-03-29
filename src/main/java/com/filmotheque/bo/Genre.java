package com.filmotheque.bo;

public class Genre {

	private long id;
	
	private String title;
	
	public Genre() {

	}
	
	public Genre(long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
