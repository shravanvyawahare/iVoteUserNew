package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OTPVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OTPVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String OTPUser=request.getParameter("OTP");
		String OTPSystem="";
		HttpSession session=request.getSession();
		
		if(session.getAttribute("OTPVerify")!=null)
		{
			OTPSystem=session.getAttribute("OTPVerify").toString();
			System.out.println(" user OTP :"+OTPUser);
			System.out.println(" System OTP :"+OTPSystem);
			
		}
		if(OTPSystem.equals(OTPUser))
		{
			request.removeAttribute("wrongOTP");
//		session.invalidate();
		System.out.println("Success");
		response.sendRedirect("Ajax.jsp");
		}else
		{
			//System.out.println("failed");
			request.setAttribute("wrongOTP", "invalid OTP");
			RequestDispatcher rd = request.getRequestDispatcher("OTPVerifyUser.jsp");
            rd.forward(request, response);   
            session.invalidate();		
			//response.sendRedirect("OTPVerifyUser.jsp");
		}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
