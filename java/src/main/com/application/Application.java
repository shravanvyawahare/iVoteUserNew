package com.application;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;
import com.dao.VotersAdharAfterVotingDao;
import com.dao.VotersAdharAfterVotingDaoImpl;
import com.model.AdharCard;
import com.model.Candidate;
import com.util.HibenateUtil;

public class Application {	
	public static void main(String[] args) {		

//		AdharCardDao adao= new AdharCardImpl();
//		adao.updateCount(4);
				
		VotersAdharAfterVotingDao vdao= new VotersAdharAfterVotingDaoImpl();
		 List<String> list = vdao.showAll("551634244425");
	       
	      for (String string : list) {
	    	  System.out.println(string);
	      }
		
	}
	
}     
