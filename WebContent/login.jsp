<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="css/public.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
        <script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/login.js" type="text/javascript" charset="utf-8"></script>

    </head>
    <body>
        <div class="head">
            <div class="mainpage_head">
                <a href="<%=request.getContextPath() %>/homepage">Main page</a>
            </div>
        </div>
        <div class="dowebok" id="dowebok">
            
            <div class="form-container sign-up">
                <form action="<%=request.getContextPath() %>/register" method="post" class="register">
                    <h1>Register</h1>
                    <input type="text"  id="username" name="username" placeholder="Username" />
                    <input type="text"  id="firstname" name="firstname" placeholder="First name" />
                    <input type="text"  id="lastname" name="lastname" placeholder="Last name" />
                    <input type="password" id="pwd" name="password" placeholder="Password" />
                    <input type="password" id="second_pwd" name="second_pwd" placeholder="Please type password again" />
                    <input type="text" id="phonenum" name="phonenum" placeholder="Please enter phone number">
                    <input type="text" id="email" name="email" type="email" placeholder="Please enter email address">
                    <input type="text" id="address" name="address" placeholder="Please enter street adress" />
                    <input type="text" id="city" name="city" placeholder="Please enter city" />
                    <input type="text" id="state" name="state" placeholder="Please enter state" />
                    <input type="text" id="zipcode" name="zipcode" placeholder="Please enter zipcode" />
                    <button>Register</button>
                </form>
            </div>
            <!-- login -->
            <div class="form-container sign-in">
                <form action="<%=request.getContextPath() %>/login" method="post" class="sign">
                    <h1>Login</h1>
                    <input type="text" name="username" placeholder="username">
                    <input type="password"  name="password" placeholder="password">
                     <%
						if(request.getAttribute("msg")!=null){
							out.println("<p style='color:#FF0000'>"+request.getAttribute("msg") + "</p>");
						}
					%>
                    <a href="###">Forgot password?</a>
                    <button>Login</button>
                </form>
            </div>
     	
            <div class="overlay-container">
                <div class="overlay">
                    
                    <div class="overlay-panel mask-left">
                        <h1>Already have a account?</h1>
                        <p>Please use your account to login</p>
                        <button class="ghost" id="signIn">Login</button>
                    </div>
                   
                    <div class="overlay-panel mask-right">
                        <h1>Have no account?</h1>
                        <p>Let's register now</p>
                        <button class="ghost" id="signUp">Register</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>