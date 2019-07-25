package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;
public class EnterVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EnterVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		AdharCardDao ad= new AdharCardImpl()	;
		HttpSession session = request.getSession(false);
		String adharCardNo= (String) session.getAttribute("adharcard");
		//out.print(session.getAttribute("adharcard"));
		List<String> date11= ad.getBirthDate(adharCardNo);
		Date date1 = null;
		String dateOfBirth=null;
		Date dt=new Date();
		for (String string : date11) {		
			dateOfBirth= string;	
			System.out.println("in for each");
		}
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		} catch (ParseException e) {			
			e.printStackTrace();
		}  
		    int age= ad.calculateAgeWithJava7(date1, dt);
		    System.out.println(dateOfBirth+"\t"+date1+"\t"+age); 
		    
		    if(age>=18)
		    {
		    	System.out.println("in if loop");
		    	RequestDispatcher rd = request.getRequestDispatcher("showPhone");
	            rd.forward(request, response);   
	          		
		    	
		    }
		    else {
		    	System.out.println("in else	loop");
				request.setAttribute("errorMessage", "you are not eligible for voting. ");
				RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
	            rd.forward(request, response);   
	            session.invalidate();		
		    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
