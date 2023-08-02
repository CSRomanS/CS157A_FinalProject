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
                <a href="first.jsp">Main page</a>
            </div>
        </div>
        <div class="dowebok" id="dowebok">
            
            <div class="form-container sign-up">
                <form action="<%=request.getContextPath() %>/register.do" method="post" class="register">
                    <h1>Register</h1>
                    <input type="text"  id="username" name="username" placeholder="Username" />
                    <input type="text"  id="firstName" name="firstName" placeholder="First name" />
                    <input type="text"  id="lastName" name="lastName" placeholder="Last name" />
                    <input type="password" id="pwd" name="password" placeholder="Password" />
                    <input type="password" id="second_pwd" name="second_pwd" placeholder="Please type password again" />
                    <input id="email" id="email" name="email" type="email" placeholder="Please enter email address">
                    <input type="text" id="birth" name="birth" placeholder="Birthday YYYY-MM-DD" />
                    <input type="text" id="phone" name="phone" placeholder="Phone number" />
                    <input type="text" id="address" name="address" placeholder="Please enter adress" />
                    <button>Register</button>
                </form>
            </div>
            <!-- login -->
            <div class="form-container sign-in">
                <form action="login.do" method="post" class="sign">
                    <h1>Login</h1>
                    <input type="text" name="user_id" placeholder="userId">
                    <input type="password"  name="password" placeholder="password">
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