package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String rePassword = request.getParameter("repassword");
		String userOTP = request.getParameter("otp");
		
		
		
		//create database connection
		DatabaseConnection connection = new DatabaseConnection();
		Connection con = connection.connect();
		
		//ManageOTP getOTP = new ManageOTP();
		//String otp = getOTP.getOtp();
		//String email = getOTP.getEmail();
		
		String otp = (String) session.getAttribute("otp");
		String email = (String) session.getAttribute("email");
		
		System.out.println(otp);
		System.out.println(email);
		
		System.out.println(newPassword);
		System.out.println(rePassword);
		
		
		
		
		
		if(otp.equals(userOTP)) {
			if(newPassword.equals(rePassword)) {
				 
				try {
					String sqlQuery = SqlQueries.updatePassword();
					
					PreparedStatement st = con.prepareStatement(sqlQuery);
		            st.setString(1, email);
		            st.setString(2, newPassword);
		            st.executeUpdate();
		            
					System.out.println("exeucted");
					
					session.setAttribute("error", "");
					session.setAttribute("Message", "");
					
					response.sendRedirect("ChangePassword.jsp");
					
				}
				catch(Exception e){
					System.out.println("Error" + e);
					e.printStackTrace();
				}
			}else {
				response.getWriter().print("Passwords dont match!");
			}
		}else {
			response.getWriter().print("OTP dont match!");
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
