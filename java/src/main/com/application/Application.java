package com.application;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;
import com.model.AdharCard;
import com.model.Candidate;
import com.util.HibenateUtil;

public class Application {	
	public static void main(String[] args) {		

		/*Session session =null;
		Transaction tx=null;
		List<AdharCard> eList=null;
		try{
			session=HibenateUtil.getSession();
			tx = session.beginTransaction();
			System.out.println("enter id");
			Scanner sc= new Scanner(System.in);
			int id=sc.nextInt();
			Candidate candidate= session.load(Candidate.class,id);
		int count=candidate.getNumbercount();
			candidate.setNumbercount(count+1);
			session.update(candidate);
			tx.commit();
			}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}*/
		
		AdharCardDao adao= new AdharCardImpl();
	//	adao.updateCount(2);
//		String candidate= adao.showAllCityCandidate("551634244425");
//		System.out.println(candidate);
		List<String> clist= adao.candidateDetails("551634244425");		
		for (String string : clist) {
			System.out.println(string.toString());
		}
     
		List<Integer> idlist= adao.getCandiadateIdByName("551634244425");
 for (Integer integer : idlist) {
	System.out.println(integer);
}

	}
	
}     
