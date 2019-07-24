package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.hibernate.Session;

import org.hibernate.query.Query;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;
import com.model.AdharCard;
import com.model.Candidate;
import com.util.HibenateUtil;


/**
 * Servlet implementation class DisplayCandidate
 */
public class DisplayCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session s =null;
		Transaction tx=null; 		
		 try{

		PrintWriter out= response.getWriter();
		String n="551634244425";
		AdharCardDao ad=new AdharCardImpl();
		List<String> details = ad.candidateDetails(n);
		//System.out.println(details);
		//out.print(details);
		
		out.write("<table class='table table-stripped table-primary'><tr><th>Candidate Name</th><th>Vote</th></tr>");
		
		for (String string : details) {
			out.write ("<tr><td>"+string+
					"</td><td><input type='submit' name='vote' value='submit vote'></td></tr>");
				System.out.println("table");
		}

		out.write("</table>");
		//response.sendRedirect("Ajax.jsp");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally{
			s.close();
		 }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
