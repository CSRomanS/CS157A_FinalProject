<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>

<html>
<head>
<meta charset="UTF-8">
<title>Item Detail</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/mainpage.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript"
	charset="ISO-8859-1"></script>
<script src="js/front_page.js" type="text/javascript"
	charset="ISO-8859-1"></script>
<script>
	function changeMainImage(clickedImage) {
		document.getElementById('mainImage').src = clickedImage.src;
	}
</script>
</head>
<body>

	<%
		String username = request.getParameter("username");
	%>
	<div class="head">
		<div class="head_sub">
			<c:if test="${not empty username}">
				<div class="welcome">
					Welcome, <a class="welcome" href="manage.jsp"><%=request.getSession().getAttribute("username")%></a>
				</div>
			</c:if>
			<div class="cart">
				<a href="cart.jsp"><img src="images/cart.png" height="28px">
					<span>Cart</span> </a>
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
	<div class="w">
		<div class="preview" id="preview">
			<div class="photo_xi">
				<div class="main-image">
					<img id="mainImage" src="${item.coverPicture}"
						style="width: 300px; height: 300px;" alt="Main product image" />
				</div>

				<!-- Other Images -->
				<div class="other-images"
					style="display: flex; flex-direction: row;">
					<!-- Include the cover picture in the smaller images -->
					<c:forEach var="image" items="${item.photos}" varStatus="status">
						<img class="smallImage" src="${image}"
							style="width: 100px; height: 100px; margin-right: 10px;"
							alt="Product image" onclick="changeMainImage(this)" />
					</c:forEach>
				</div>

			</div>
		</div>
		<div class="itemInfo-wrap">
			<div class="x-goodsname">
				<h3>${item.itemName}</h3>
			</div>
			<div class="news">
				<div class="">${item.categoryDescription}</div>
			</div>
			<div class="news">
				<div class="">${item.mainDescription}</div>
			</div>
			<div class="x-price">
				<span>$</span>
				<div class="x-price_num">${item.price}</div>
			</div>
			<div class="x-action">
				<div class="liji">
					<a href="#">Buy Now</a>
				</div>
				<div class="add_cart">
					<a href="./addcart.do?id=${item.itemID}">Add to Cart</a>
				</div>
			</div>
		</div>

	</div>

	<div class="review-section">
		<h2>Reviews</h2>
		<c:forEach var="review" items="${item.reviews}">
			<div class="review">
				<div class="star-rating">Star Rating: ${review.starRating}</div>
				<div class="review-text">${review.reviewText}</div>
				<div class="review-author">Reviewed by: ${review.authorName}</div>
				<c:if test="${not empty review.picture}">
					<div class="review-image">
						<img src="${review.picture}" alt="Review Image"
							style="width: 100px; height: 100px;">
					</div>
				</c:if>
			</div>
			<hr>
		</c:forEach>
	</div>
</body>
</html>
