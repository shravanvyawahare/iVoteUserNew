package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;

public class UpdateCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session = request.getSession(false);
	int id= (Integer) session.getAttribute("id");
	PrintWriter out= response.getWriter();
	out.print(id);
		AdharCardDao adao= new AdharCardImpl();
		adao.updateCount(id);
		response.sendRedirect("Home.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
