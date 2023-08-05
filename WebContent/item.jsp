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
	
	 function voteUseful(buttonElement) {
		 
		 const userID = '<%=request.getSession().getAttribute("userID")%>';
		 
		 console.log("UserID:", userID);

		if (!userID || userID === "null" || userID.trim() === "") {
			alert('You must be logged in to vote.');
			return;
		}
		const reviewID = buttonElement.getAttribute('data-review-id');
		// Print the userID to the console for debugging
	    console.log("reviewID:", reviewID);

		// Send a request to your server to register the vote
		// Here's an example using jQuery:
		$.ajax({
			url : './voteUseful',
			method : 'POST',
			data : {
				reviewID : reviewID,
				userID : userID
			},
			success : function(response) {
				// Update the count displayed next to the button
				if (response.success) {
					const voteCountElement = $(buttonElement).next(
							'.useful-vote-count');
					const newCount = parseInt(voteCountElement.text()) + 1;
					voteCountElement.text(newCount);
					
					// Disable the button
	                $(buttonElement).prop('disabled', true).text('Voted');
				} else {
					alert(response.message);
				}
			}
		});
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
					<a href="./addcart.do?id=${item.itemID}">Add to Cart</a>
				</div>
			</div>
		</div>
		<div class="review-section">
			<br />
			<h2>Reviews</h2>
			<br />
			<c:forEach var="review" items="${item.reviews}">
				<div class="review">
					<div class="star-rating">Rating: ${review.starRating}</div>
					<div class="review-text">Comment: ${review.reviewText}</div>
					<div class="review-author">Reviewed by: ${review.authorName}</div>
					<div class="review-author">Date: ${review.reviewTime}</div>
					<c:if test="${not empty review.picture}">
						<div class="review-image">
							<img src="${review.picture}" alt="Review Image"
								style="width: 100px; height: 100px;">
						</div>
					</c:if>
				</div>
				<div class="useful-vote-section">
					<button class="useful-vote-button"
						data-review-id="${review.reviewsID}" onclick="voteUseful(this)">Vote
						as Useful</button>
					<span class="useful-vote-count">${review.helpful}</span> people
					found this useful.
				</div>
				<br/>
				<br/>
			</c:forEach>
		</div>
	</div>


</body>
</html>
