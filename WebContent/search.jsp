<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Search Results</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/book.css" />
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

<style>
table {
	width: 80%;
	border-collapse: collapse;
	margin-top: 20px;
	margin: 0 auto;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
}
</style>
</head>
<body>
	<%
		String username = request.getParameter("username");
	%>
	<div class="head">
		<div class="head_sub">
			<c:if test="${not empty username}">
				<div class="welcome">
					Welcome, <span><%=request.getSession().getAttribute("username")%></span>
				</div>
				<div class="welcome">
					<a class="welcome" href="<%=request.getContextPath()%>/order">Orders</a>
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
	<div class="xi_nav">
		<div class="wrap">
			<ul class="menu-list">
				<li class="menu"><a
					href="<%=request.getContextPath()%>/homepage">Home Page</a></li>
				<li class="menu"><a href="#">All Category</a></li>
				<li class="menu"><a href="#">New Arrival</a></li>
				<li class="menu"><a href="#">Best Selling</a></li>
			</ul>
		</div>
	</div>


	<div class="search_bar">
		<div class="search">
			<form action="<%=request.getContextPath()%>/searchPage" method="get">
				<input type="text" class="text" name="keyword"
					placeholder="Search for items...">
				<button type="submit">
					<img src="images/search.png" width="40px">
				</button>
			</form>
		</div>
	</div>

	<h3></h3>

	<table>
		<thead>
			<tr>
				<th>Cover Picture</th>
				<th>Item Name</th>
				<th>Main Description</th>
				<th>Category Description</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${itemList}">
				<tr>
					<td><a
						href="<%=request.getContextPath()%>/detail?itemID=${item.itemID}">
							<img src="${item.coverPicture}" alt="${item.itemName}"
							width="100">
					</a></td>
					<td>${item.itemName}</td>
					<td>${item.mainDescription}</td>
					<td>${item.categoryDescription}</td>
					<td><c:choose>
							<c:when test="${item.salePrice != null && item.salePrice > 0}">
								<span style="text-decoration: line-through;">$${item.price}</span> $${item.salePrice}
		                    </c:when>
							<c:otherwise>
		                        $${item.price}
		                    </c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



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
