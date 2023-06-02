<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="assets/css/login.css" rel="stylesheet" >
</head>
<body>
	<%@ include file="header.html" %>
	<div class="login-container">
        <div class="login-header">
            <div class="signin-title">Sign In</div>
        </div>

        <div class="login-body">
            <form class="login-form" action = "<%= request.getContextPath() %>/login" method="post">
                <input type="email" name="email" class="username" placeholder="Email" required>
                <input type="password" name="password" class="password" placeholder="Password" required>
                <div>
		    <%
				if ((String) session.getAttribute("error") != null) {
			%>
				<h2 style="color: red; font-size: 15px" class="error"><% out.print( session.getAttribute("error")); %></h2>
			<% } %>
		</div>
                <div  class="forgot-password"><a href="ForgotPassword.jsp">Forgot password?</a></div>
                <div class="login">
                    <!--input type="checkbox" class="remember-me" value="Remember me">
                    <label for="remember-me">Remember me</label> -->
    
    
                    <button type="submit" name="loginbtn" class="loginbtn">LOG IN</button>				
                </div>
                <div class="signup-direct">
                    <div class="a-text">
                        Don't have an account?
                        <a href="Busreg.jsp">Sign Up</a>
                    </div>
                    
                </div>
    
                
            </form>
        </div>
        

		
	</div>
	
	
	<%@ include file="footer.html" %>
 
 
</body>
</html>