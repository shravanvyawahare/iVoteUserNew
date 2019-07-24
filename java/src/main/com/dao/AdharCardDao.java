package com.dao;

import java.util.Date;
import java.util.List;

import com.model.AdharCard;

public interface AdharCardDao {

	public  Long  showAll(String adharCardNumber); 
	public List<AdharCard> showAll(); 
	public AdharCard getNumber(String adharCardNumber);
	public AdharCard getCity(String adharCardNumber);
	public List<String> candidateDetails(String adharCardNumber); 
	public String showAllCityCandidate(String adharCardNumber) ;
	public List<String> getBirthDate(String adharCardNumber);
//	public int calculateAgeWithJodaTime(
//			  org.joda.time.LocalDate birthDate,
//			  org.joda.time.LocalDate currentDate);
	
	public int calculateAgeWithJava7(Date birthDate,Date currentDate);

}
