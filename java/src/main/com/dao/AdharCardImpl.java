package com.dao;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.query.Query;
import org.joda.time.Years;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;


import com.model.AdharCard;
import com.model.Candidate;
import com.util.HibenateUtil;
public class AdharCardImpl implements AdharCardDao{
	public List<AdharCard> showAll()
	{
		Session session =null;
		Transaction tx=null;
		List<AdharCard> eList=null;
		try{
			session=HibenateUtil.getSession();
			tx = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<AdharCard> query = builder.createQuery(AdharCard.class);
	         Root<AdharCard> root = query.from(AdharCard.class);
	         query.select(root);
	         Query<AdharCard> q=session.createQuery(query);
	         eList=q.getResultList();
	     
	         tx.commit();		
		}finally{
			session.close();	
        }
        return eList;
	}
	
	

	public Long showAll(String adharCardNumber) {

		Session session =null;
		Transaction tx=null;
		long result=0;
		long userId = 0;
		List<AdharCard>  alist=showAll();
		for (AdharCard adharCard : alist) {
			if(adharCard.getAdharCardNumber().equals(adharCardNumber))
			{
				result=adharCard.getPhoneNumber();
				System.out.println("in DAO  "+result);
			}
		}
		return result;
	}
	
	
	public AdharCard getNumber(String adharCardNumber) {
		
		Session session = null;
		Transaction tx = null;
		AdharCard e =null;
		try {
			session = HibenateUtil.getSession();
			tx = session.beginTransaction();
			
			e= session.get(AdharCard.class, adharCardNumber);
			System.out.println(e.getAdharCardNumber());
			tx.commit();
		} catch (HibernateException h) {
			System.out.println(h);
		} finally {
			session.close();
			
		}
		return e;
	}

	
public AdharCard getCity(String adharCardNumber) {
		
		Session session = null;
		Transaction tx = null;
		AdharCard e =null;
		try {
			session = HibenateUtil.getSession();
			tx = session.beginTransaction();
			e= session.get(AdharCard.class, adharCardNumber);
			System.out.println(e.getAdharCardNumber());
			tx.commit();
		} catch (HibernateException h) {
			System.out.println(h);
		} finally {
			session.close();
		
		}
		return e;
	}



	public List<String> candidateDetails(String adharCardNumber) 
	{
		Session session =null;// sessionFactory.openSession();
		Transaction tx=null;
		 List<String> list=null;
		try{
			session=HibenateUtil.getSession();
			tx = session.beginTransaction();
	         Scanner sc= new Scanner(System.in);
	      Query q1 = session.createQuery("select candidateName from Candidate where city=(select district from AdharCard where adharCardNumber=:adharCardNumber)");
	      q1.setParameter("adharCardNumber",adharCardNumber);
	     list = q1.getResultList();
	   
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally{			
				session.close();		
		}
		return list ;
	}

	public String showAllCityCandidate(String adharCardNumber) {
	
		Session session =null;
		Transaction tx=null;
		String result=null;		
		List<AdharCard>  alist=showAll();
		for (AdharCard adharCard : alist) {
			if(adharCard.getAdharCardNumber().equals(adharCardNumber))
			{
				result=adharCard.getDistrict();
				System.out.println("in DAO  "+result);
			}
		}
		return result;
	}



	public List<String> getBirthDate(String adharCardNumber) {

		Session session = null;
		Transaction tx = null;
		List<String> list=null;
		try {
			session = HibenateUtil.getSession();
			tx = session.beginTransaction();
			  Query q1 = session.createQuery("select dateOfBirth from AdharCard where adharCardNumber =:adharCardNumber");
			  q1.setParameter("adharCardNumber",adharCardNumber);
			  list = q1.getResultList();
			tx.commit();
		} catch (HibernateException h) {
			System.out.println(h);
		} finally {
			session.close();
		
		}
		return list;
	
	}
	public int calculateAgeWithJava7(
			  Date birthDate, 
			  Date currentDate) {            
			                                                                           
			    DateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
			    int d1 = Integer.parseInt(formatter.format(birthDate));                            
			    int d2 = Integer.parseInt(formatter.format(currentDate));                          
			    int age = (d2 - d1) / 10000;                                                       
			    return age;                                                                        
			}



	public List<Integer> getCandiadateIdByName(String adharCardNumber) {
		
		Session session = null;
		Transaction tx = null;
		List<Integer> list=null;
		try {
			session = HibenateUtil.getSession();
			tx = session.beginTransaction();
			List<String> nameList=candidateDetails(adharCardNumber);
			for (String string : nameList) {
				Query q1 = session.createQuery("select candidateId from Candidate where candidateName =:string");
				  q1.setParameter("string",string);
				  list = q1.getResultList();
			}			  
			tx.commit();
		} catch (HibernateException h) {
			System.out.println(h);
		} finally {
			session.close();
		
		}
		return list;
	
	}
}