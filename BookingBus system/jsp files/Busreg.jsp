<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="assets/css/signup.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.html" %>
	<div class ="signup-container">
		<div class="register-container">
            <div class="signup-card-header">Sign Up</div>

            <div class="signup-card-body">
                <form class="login-form" action = "<%= request.getContextPath() %>/register" method="post">
                
                    <div class="input-container">
                        <div class="label">Name</div>
                        <div class="names-container">
                            <input type="text" name="firstName" class="name" placeholder="First Name" required>
                            <input type="text" name="lastName" class="name" placeholder="Last Name" required>
                        </div>
                    </div>
                    
                    <div class="input-container">
                        <div class="label">Username</div>
                        <input type="text" name="username" class="reg-input" placeholder="Username" required>
                    </div>
                    
                    <div class="input-container">
                        <div class="label">Email</div>
                        <input type="email" name="email" class="reg-input" placeholder="Email" required>
                    </div>
                    
                    <div class="input-container">
                        <div class="label">Password</div>
                        <input type="password" name="password" class="reg-input" placeholder="Password" required>
                    </div>
                    
                    <div class="input-container">
                        <div class="label">Re-Password</div>
                        <input type="password" name="repassword" class="reg-input" placeholder="Retype Password" required>
                    </div>
        
                    <div class="input-container">
                        <div class="label">Phone</div>
                        <input type="text" name="phone" class="reg-input" placeholder="Phone" required>
                    </div>
        
                    <div class="input-container">
                        <div class="label">NIC</div>
                        <input type="text" name="NIC" class="reg-input" placeholder="NIC" required>
                    </div>
                    <div>
                    	<%
							if ((String) session.getAttribute("error") != null) {
						%>
						<h2 style="color: red; font-size: 15px" class="error"><% out.print( session.getAttribute("error")); %></h2>
						<% } %>
                    </div>
                    <button type="submit" name="registerbutton" class="registerbutton">REGISTER</button>
                    
        
                    
                </form>
            </div>
            
	</div>  
	
		
		
	</div>
	<%@ include file="footer.html" %>
	

</body>
</html>