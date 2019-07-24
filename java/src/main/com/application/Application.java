package com.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.criteria.*;
import org.hibernate.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.dao.*;
import com.model.AdharCard;
import com.model.Candidate;
import com.util.HibenateUtil;


public class Application {

	public static void main(String[] args) throws ParseException {		
		AdharCardDao ad= new AdharCardImpl();
		List<String> date11= ad.getBirthDate("551634244429");
		
		for (String string : date11) {
			System.out.println(string);
			 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(string);  
			    System.out.println(string+"\t"+date1); 
//			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
//			 
//			String dateInString = string;
//			DateTime dateTime = DateTime.parse(dateInString, formatter);
//			System.out.println(dateTime);
			    Date dt=new Date();
  int age= ad.calculateAgeWithJava7(date1, dt);
  System.out.println(age);
		}
		
		
		
		
		
		
		
//		List<AdharCard> details = ad.showAll();
//		System.out.println(details);
//		ListIterator<AdharCard> iterator =details.listIterator(); 
//		  while (iterator.hasNext()) { 
//            System.out.println(iterator.next()); 
//        } 
//		
//	AdharCard add= ad.getNumber("551634244425");
//	
//	AdharCard city= ad.getCity("551634244425");
//	System.out.println(city);
	

		//AdharCardDao a=new AdharCardImpl();
		List<String> details = ad.candidateDetails("551634244425");
		//System.out.println(details);
		
		
		
		
//		ListIterator<Candidate> iterator =details.listIterator(); 
//		  while (iterator.hasNext()) { 
//            System.out.println(iterator.next()); 
//		
//		for (Candidate candidate : details) {
//			System.out.println(candidate);
//		}
        
//		for (Candidate candidate : details) {
//			System.out.println(candidate.getCandidateId());
//			System.out.println(candidate.getCandidateName());
//			System.out.println(candidate.getCity());
//		}
		
		for (String string : details) {
			System.out.println(string);

		}
		
	
		
		
		
		
		
		
		
		
		
		
//	List<AdharCard> manageCandidate=ad.showAll("551634244425");
//   System.out.println(manageCandidate);
//
//	 for (AdharCard manage_Candidate : manageCandidate) {
//         System.out.println(manage_Candidate);
//      } 
	
	
	//  ListIterator<AdharCard> iterator =manageCandidate.listIterator(); 
//		  while (iterator.hasNext()) { 
//              System.out.println("Value is : "+ iterator.next()); 
//          } 
		
//		 long number=ad.showAll("551634244425");		
//		 
//		System.out.println(number);
//     	 for (AdharCard manage_Candidate : l) {
//	            System.out.println(manage_Candidate);
//	         } 
	 
	 
	 
//	 
//	 long no= ad.getNumber("551634244425");
//	 System.out.println(no);
// 
}
}
