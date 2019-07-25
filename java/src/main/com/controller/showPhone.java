package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdharCardDao;
import com.dao.AdharCardImpl;
public class showPhone extends HttpServlet
{
//	private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 1L;
	private int OTP;
	//private AdharCard phone_no;

    public showPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		PrintWriter out= response.getWriter();
		//out.println("hello");
//		String m_adharNumber= request.getParameter("AadharCardNo");
String adharcard= (String) session.getAttribute("adharcard");
		System.out.println("on show phone");
		//System.out.println(m_adharNumber);
		AdharCardDao ad= new AdharCardImpl()	;
		
		Long PhoneNo=ad.showAll(adharcard);
		
	//session.setAttribute("adharcard",m_adharNumber);
		System.out.println("Number  "+PhoneNo);
	
		try {
			String apiKey = "apikey=" + "YC0LiPIOPqg-zsLgWX99ndr4IAqvrvgwwA8sBmTQsi";
                        Random rand=new Random();
                        OTP= rand.nextInt(999999);
                        session.setAttribute("OTPVerify", OTP);
                       //String txtphone1=(String) request.getAttribute("phone_no");
			String message = "&message=" + "Hey your otp is"+OTP;
			String sender = "&sender=" + " ";
			String numbers = "&numbers=" + PhoneNo.toString();
			//System.out.println(""+txtphone1);
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
				//System.out.println(line);
			}
			rd.close();
			
			System.out.println("created OTP");
			response.sendRedirect("OTPVerifyUser.jsp");
           // JOptionPane.showMessageDialog(null, "send otp successfully");
			
		
		} catch (Exception e)
		{
			System.out.println("Failed OTP");
			response.sendRedirect("User.jsp");
                
		}		
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
