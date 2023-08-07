<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Main Page</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/mainpage.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript"
	charset="ISO-8859-1"></script>
<script src="js/front_page.js" type="text/javascript"
	charset="ISO-8859-1"></script>
<script>
	function goToCart() {
    	const userID = '<%=request.getSession().getAttribute("userID")%>';
		if (!userID || userID === "null" || userID.trim() === "") {
			alert('You must be logged in to view your cart.');
			return false; // prevent redirection
		}
		return true; // allow redirection
	}
</script>
</head>
<body>
	<%
		String username = request.getParameter("username");
		request.getAttribute("items");
		request.getAttribute("electronics");
		request.getAttribute("pets");
		request.getAttribute("health");
	%>
	<div class="head">
		<div class="head_sub">
			<c:if test="${not empty username}">
				<div class="welcome">
					Welcome, <a class="welcome" href="<%=request.getContextPath()%>/order"><%=request.getSession().getAttribute("username")%></a>
				</div>
			</c:if>
			<div class="cart">
				<a href="<%=request.getContextPath()%>/cart"
					onclick="return goToCart();"><img src="images/cart.png"
					height="28px"> <span>Cart</span> </a>
			</div>
			<c:if test="${empty username}">
				<div class="login">
					<div>
						<a href="login.jsp">Login/Register</a>
					</div>
					<div></div>
				</div>
			</c:if>

		</div>
	</div>

	<div class="search_bar">
		<div class="search">
			<input type="text" class="text">
			<button>
				<img src="images/search.png" width="40px">
			</button>
		</div>
	</div>
	<div class="shop">
		<div class="carousel">
			<span class="right" id="right"></span> <span class="left" id="left"></span>
			<div id="carousel">
				<c:forEach items="${items}" var="item">
					<div>
						<a
							href="<%=request.getContextPath() %>/detail?itemID=${item.itemID}"><img
							src="${item.coverPicture}"></a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="cate">
			<div class="box_tit w">
				<h2 class="title">Electronics</h2>
				<div class="cate_photo">
					<ul>
						<c:forEach items="${electronics}" var="item">
							<li class="item_pic"><a
								href="<%=request.getContextPath() %>/detail?itemID=${item.itemID}">
									<div class="ph">
										<img src="${item.coverPicture}">
									</div>
									<div class="na">${item.itemName}</div>
									<p>$${item.price}</p>
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="box_tit w">
				<h2 class="title">Pets</h2>
				<div class="cate_photo">
					<ul>
						<c:forEach items="${pets}" var="item">
							<li class="item_pic"><a
								href="<%=request.getContextPath() %>/detail?itemID=${item.itemID}">
									<div class="ph">
										<img src="${item.coverPicture}">
									</div>
									<div class="na">${item.itemName}</div>
									<p>$${item.price}</p>
							</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="box_tit w">
				<h2 class="title">Health</h2>
				<div class="cate_photo">
					<ul>
						<c:forEach items="${health}" var="item">
							<li class="item_pic"><a
								href="<%=request.getContextPath() %>/detail?itemID=${item.itemID}">
									<div class="ph">
										<img src="${item.coverPicture}">
									</div>
									<div class="na">${item.itemName}</div>
									<p>$${item.price}</p>
							</a></li>
						</c:forEach>
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
