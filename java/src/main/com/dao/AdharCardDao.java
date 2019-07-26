package com.dao;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.model.AdharCard;
import com.model.Candidate;

public interface AdharCardDao {

	public  Long  showAll(String adharCardNumber); 
	public List<AdharCard> showAll(); 
	public AdharCard getNumber(String adharCardNumber);
	public AdharCard getCity(String adharCardNumber);
//	public List<String> candidateDetails(String adharCardNumber); 
//	public List<Integer> candidateDetailsId(String adharCardNumber); 
	public String showAllCityCandidate(String adharCardNumber) ;
	public List<String> getBirthDate(String adharCardNumber);

	//public List<Integer> getCandiadateIdByName(String adharCardNumber);
	public int calculateAge(Date birthDate,Date currentDate);
public List<Candidate> fetchAll(String adharCardNumber);
public void updateCount(int id);
	
	
}