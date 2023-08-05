<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Main Page</title>
        <link rel="stylesheet" type="text/css" href="css/public.css"/>
        <link rel="stylesheet" type="text/css" href="css/mainpage.css"/>
        <script src="js/jquery-3.6.0.js" type="text/javascript" charset="ISO-8859-1"></script>
        <script src="js/front_page.js" type="text/javascript" charset="ISO-8859-1"></script>
    </head>
    <body>
        <%String username = request.getParameter("username");%>
        <div class="head">
            <div class="head_sub">
	            <c:if test="${not empty username}">
	                <div class="welcome">
	                    Welcome, <a class="welcome" href="manage.jsp"><%=request.getSession().getAttribute("username")%></a>
	                </div>
                </c:if>
                <div class="cart">
                    <a href="cart.jsp"><img src="images/cart.png" height="28px">
                        <span>Cart</span>
                    </a>
                </div>
                <c:if test="${empty username}">
	                <div class="login">
	                    <div><a href="login.jsp">Login</a></div>
	                    <div><a href="login.jsp">Register</a></div>
	                </div>
                </c:if>

            </div>
        </div>

        <div class="search_bar">
            <div class="search">
                <input type="text" class="text">
                <button><img src="images/search.png" width="40px"></button>
            </div>
        </div>
        <div class="shop">
            <div class="carousel" >
                <span class="right" id="right"></span>
                <span class="left" id="left"></span>
                <div id="carousel" >
                    <div>
                        <a href="#"><img src="images/milkbone.png" ></a>
                    </div>
                    <div>
                        <a href="#"><img src="images/roku.jpg" ></a>
                    </div>
                    <div>
                        <a href="#"><img src="images/discplayer.jpg"></a>
                    </div>
                    <div>
                        <a href="#"><img src="images/tide.png" ></a>
                    </div>
                    <div>
                        <a href="#"><img src="images/bangaid_.jpg"></a>
                    </div>
                </div>
            </div>
            <div class="cate">
                <div class="box_tit w">
                    <h2 class="title">Electronics</h2>
                    <div class="cate_photo">
                        <ul>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="box_tit w">
                    <h2 class="title">Pets</h2>
                    <div class="cate_photo">
                        <ul>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="box_tit w">
                    <h2 class="title">Health</h2>
                    <div class="cate_photo">
                        <ul>
                           <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                            <li class="item_pic">
                                <a href="./detail?id=*">
                                    <div class="ph">
                                        <img src="images/roku.jpg" >
                                    </div>
                                    <div class="na">Roku Streaming Stick 4K</div>
                                    <p>$47.54</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="nav">
            <ul>
                <li class="current">Electronics</li>
                <li>Pets</li>
                <li>Health</li>
                <div class="back">Back to Top</div>
            </ul>
        </div>

        <div class="footer">
            <div class="translate">
                <div class="footer-links">
                    <h5>Company</h5>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Event</a></li>
                        <li><a href="#">Advisors</a></li>
                        <li><a href="#">Careers</a></li>
                    </ul>
                </div>
                <div class="footer-links">
                    <h5>Our Culture</h5>
                    <ul>
                        <li><a href="#">Community</a></li>
                        <li><a href="#">Store Locations</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms of Use</a></li>
                    </ul>
                </div>
                <div class="footer-links">
                    <h5>Customer Service</h5>
                    <ul>
                        <li><a href="#">Help Desk</a></li>
                        <li><a href="#">Returns</a></li>
                        <li><a href="#">Warranty</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
