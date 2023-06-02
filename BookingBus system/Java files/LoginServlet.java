package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }
    
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Customer user = new Customer();
		
		try {
			String username = request.getParameter("email");
			String passwordc= request.getParameter("password");
			
			DatabaseConnection connection = new DatabaseConnection();
			Connection con = connection.connect();
			
			Statement stmt = con.createStatement();
			
			String sql = SqlQueries.selectEmailAndPassword(username, passwordc);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.first()) {
				do{
					int id =rs.getInt("userID");
					String fname = rs.getString("firstName");
					String lname = rs.getString("lastName");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String nic = rs.getString("NIC");
					String uname = rs.getString("userName");
					String pass = rs.getString("password");
					
					user = new Customer(id,fname,lname,phone,email,nic,uname, pass);
				}while(rs.next());
				
				
				session.setAttribute("userID", user.getUserID());
				session.setAttribute("firstName", user.getfName());
				session.setAttribute("lastName", user.getlName());
				session.setAttribute("username", user.getUserName());
				session.setAttribute("NIC", user.getNic());
				session.setAttribute("email", user.getEmail());
				
				System.out.println(session.getAttribute("firstName"));
				System.out.println(session.getAttribute("lastName"));
				System.out.println(session.getAttribute("email"));
				
				response.getWriter().print(session.getAttribute("firstName"));
				response.getWriter().print(session.getAttribute("lastName"));
				response.getWriter().print(session.getAttribute("email"));
				
				response.sendRedirect("profile.jsp");
			}else {
				System.out.print("Invalid username or password");
				session.setAttribute("error", "Invalid Username or Password");
				response.sendRedirect("busLogin.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	
	

}
