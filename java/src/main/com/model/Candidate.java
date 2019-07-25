package com.model;

public class Candidate {
	public int candidateId;
	private String candidateName;
	private String city;
	private int pincode;
	private int numbercount;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getNumbercount() {
		return numbercount;
	}
	public void setNumbercount(int numbercount) {
		this.numbercount = numbercount;
	}
	public Candidate(int candidateId, String candidateName, String city, int pincode, int numbercount) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.city = city;
		this.pincode = pincode;
		this.numbercount = numbercount;
	}
	public Candidate() {
		super();
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", city=" + city
				+ ", pincode=" + pincode + ", numbercount=" + numbercount + "]";
	}
	
	
	
	
	

}
