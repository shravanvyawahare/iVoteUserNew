package com.model;

public class Candidate {
	public int candidateId;
	private String candidateName;
	private String city;
	private int pincode;
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Candidate() {
		super();
	}
	public Candidate(int candidateId, String candidateName, String city, int pincode) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.city = city;
		this.pincode = pincode;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
