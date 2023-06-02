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
            <div class="signin-title">Admin Login</div>
        </div>

        <div class="login-body">
            <form class="login-form" action = "<%= request.getContextPath() %>/adminLogin" method="post">
                <input type="email" name="email" class="username" placeholder="Email" required>
                <input type="password" name="password" class="password" placeholder="Password" required>
                <div  class="forgot-password"><a href="forgotPassword.java">Forgot password?</a></div>
                <div class="login">
                    <!--input type="checkbox" class="remember-me" value="Remember me">
                    <label for="remember-me">Remember me</label> -->
    
    
                    <button type="submit" name="loginbtn" class="loginbtn">LOG IN</button>				
                </div>
                
    
                
            </form>
        </div>
		
		
	</div>
	<%@ include file="footer.html" %>
 
 
</body>
</html>