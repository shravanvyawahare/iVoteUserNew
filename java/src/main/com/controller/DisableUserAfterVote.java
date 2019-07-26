package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.VotersAdharAfterVotingDao;
import com.dao.VotersAdharAfterVotingDaoImpl;
import com.model.VotersAdharAfterVoting;


public class DisableUserAfterVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisableUserAfterVote() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		PrintWriter out= response.getWriter();
		out.print("hello");
		
		int id= Integer.parseInt( request.getParameter("id"));
		out.print(id);
	session.setAttribute("id", id);
		String session_adharCard=(String) session.getAttribute("adharcard");
		out.print(session_adharCard);
		 VotersAdharAfterVotingDao vdao= new VotersAdharAfterVotingDaoImpl();
       
         String adharCard = null;
       List<String> list = vdao.showAll(session_adharCard);
       if(list==null)
       {
    	  
    	   RequestDispatcher rd=request.getRequestDispatcher("Logout.jsp");
    	   rd.forward(request, response);
       }
       else {
      for (String string : list) {
    	  		adharCard=string;    	  
      		}
    }
      if(session_adharCard.equals(adharCard))
      {
   	   RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
   	   rd.forward(request, response);
      }
      else {
   	   RequestDispatcher rd= request.getRequestDispatcher("SubmitVote");
   	   rd.forward(request, response);
   	  
      }	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
