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

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;

public class UserSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		HttpSession session =  null;
			String m_adharCard= request.getParameter("AadharCardNo");
			
			AdharCardDao adao= new AdharCardImpl();
			long result=adao.showAll(m_adharCard);
			System.out.println(result);
			Date date1 = null;
			String dateOfBirth=null;
			Date dt=new Date();

			if(result!=0)
			{
						session= request.getSession(true);					
						session.setAttribute("adharcard", m_adharCard);							

						List<String> date11= adao.getBirthDate((String)session.getAttribute("adharcard"));
						
						for (String string : date11) {		
							dateOfBirth= string;	
							System.out.println("in for each"+dateOfBirth);
						}
						try {
							date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
						} catch (ParseException e) {			
							e.printStackTrace();
						}  
						    int age= adao.calculateAgeWithJava7(date1, dt);
						    System.out.println(dateOfBirth+"\t"+date1+"\t"+age); 
							   
						    if(age>=18)
						    {
						    	System.out.println("in if loop");
						    	request.getRequestDispatcher("showPhone").forward(request, response);
						    	//response.sendRedirect("showPhone");		
						    	
						    }
						    else {
						    	System.out.println("in else	loop");
								request.setAttribute("errorMessages", "you are not eligible for voting. ");
								RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
					            rd.forward(request, response); 
					           session.invalidate();		
				    	
						    }
						//RequestDispatcher rd = request.getRequestDispatcher("EnterVote");
		            //rd.forward(request, response); 
						//response.sendRedirect("EnterVote");
					}
					else {
						
						request.setAttribute("errorMessages", "invalid adhar card");
						RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
			            rd.forward(request, response);   
			            session.invalidate();					
					}
		}
	
}
