package com.model;

public class VotersAdharAfterVoting {

	private int id;
	private String Adharcard;
	
	public VotersAdharAfterVoting() {
		super();
	}
	public VotersAdharAfterVoting(int id, String adharcard) {
		super();
		this.id = id;
		Adharcard = adharcard;
	}
	public VotersAdharAfterVoting(String adharcard) {
		super();
		
		Adharcard = adharcard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdharcard() {
		return Adharcard;
	}
	public void setAdharcard(String adharcard) {
		Adharcard = adharcard;
	}
	@Override
	public String toString() {
		return "VotersAdharAfterVoting [id=" + id + ", Adharcard=" + Adharcard + "]";
	}
}
