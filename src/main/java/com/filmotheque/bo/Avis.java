package com.filmotheque.bo;

public class Avis {

	private long id;
	private int note; 
	private String comment;
	
	private Member member;
	
	public Avis(long id, int note, String comment) {
		super();
		this.id = id;
		this.note = note;
		this.comment = comment;
	}
	
	public Avis(long id, int note, String comment, Member member) {
		super();
		this.id = id;
		this.note = note;
		this.comment = comment;
		this.member = member;
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
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}
}
