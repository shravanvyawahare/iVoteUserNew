package com.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.VotersAdharAfterVoting;
import com.util.HibenateUtil;

public class VotersAdharAfterVotingDaoImpl implements VotersAdharAfterVotingDao
{

	public int insertAdharCard(VotersAdharAfterVoting voterAdhar)
	{		Session session= null;
		Transaction tx= null;
		int result=0;
		try {
		session= HibenateUtil.getSession();
		tx= session.beginTransaction();
		result = (Integer) session.save(voterAdhar);
		tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
				
		return result;
		
	}

	public List<String> showAll(String Adharcard)
	{
		Session session= null;
		Transaction tx= null;
		List<String> list= null;		
		try {
		session= HibenateUtil.getSession();
		tx= session.beginTransaction();
		Query q1 = session.createQuery("select Adharcard from VotersAdharAfterVoting  where Adharcard=:Adharcard");
		q1.setParameter("Adharcard",Adharcard);
	    list = q1.getResultList();	  
		tx.commit();
		}catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
		
		
		return list;
	}
	}

	

