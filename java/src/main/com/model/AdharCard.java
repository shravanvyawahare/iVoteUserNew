package com.model;

public class AdharCard {
	private int id;
	private String adharCardNumber;
	private String name;
	private String dateOfBirth;
	private String state;
	private String district;
	private String taluka;
	private String village;
	private String pincode;
	private long phoneNumber;
	

	public AdharCard(int id, String adharCardNumber, String name, String dateOfBirth, String state, String district,
			String taluka, String village, String pincode, long phoneNumber) {
		super();
		this.id = id;
		this.adharCardNumber = adharCardNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.state = state;
		this.district = district;
		this.taluka = taluka;
		this.village = village;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
	}
	
	
	public AdharCard() {
		super();
	}


	public String getAdharCardNumber() {
		return adharCardNumber;
	}
	public void setAdharCardNumber(String adharCardNumber) {
		this.adharCardNumber = adharCardNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTaluka() {
		return taluka;
	}
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", adharCardNumber=" + adharCardNumber + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", state=" + state + ", district=" + district + ", taluka=" + taluka + ", village="
				+ village + ", pincode=" + pincode + ", phoneNumber=" + phoneNumber + "]";
	}
}