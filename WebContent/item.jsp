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
	
	function goToCart() {
    	const userID = '<%=request.getSession().getAttribute("userID")%>';
		if (!userID || userID === "null" || userID.trim() === "") {
			alert('You must be logged in to view your cart.');
			return false; // prevent redirection
		}
		return true; // allow redirection
	}
	
	function addToCart(itemID) {
		if(!goToCart()){
			return;
		}
	    const quantity = document.getElementById("quantity").value;
	    console.log("itemID: " + itemID);
	    console.log("Pre-URL itemID:", itemID, "Quantity:", quantity);
	    
	    const contextPath = '<%=request.getContextPath()%>';
	    const url = contextPath + "/addToCart?itemID=" + itemID + "&quantity=" + quantity;
	    console.log("Constructed URL:", url);
	    
	    window.location.href = url;
	}
	
	 function voteUseful(buttonElement) {
		 
		 const userID = '<%=request.getSession().getAttribute("userID")%>';

		console.log("UserID:", userID);

		if (!userID || userID === "null" || userID.trim() === "") {
			alert('You must be logged in to vote.');
			return;
		}
		const reviewID = buttonElement.getAttribute('data-review-id');
		const voteType = buttonElement.getAttribute('data-vote-type');

		// Send a request to your server to register the vote
		// Here's an example using jQuery:
		$.ajax({
			url : './voteUseful',
			method : 'POST',
			data : {
				reviewID : reviewID,
				userID : userID,
				helpful : voteType,
			},
			success : function(response) {
				// Update the count displayed next to the button
				if (response.success) {
					let voteCountElement;
					if (voteType == '1') {
						voteCountElement = $(buttonElement).next(
								'.useful-vote-count');
					} else {
						voteCountElement = $(buttonElement).next(
								'.unuseful-vote-count');
					}
					const newCount = parseInt(voteCountElement.text()) + 1;
					voteCountElement.text(newCount);

					// Disable the button
					$('.useful-vote-button[data-review-id="'+reviewID+'"], .unuseful-vote-button[data-review-id="'+reviewID+'"]').prop('disabled', true).text('Voted');
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
	<div class="search_bar">
		<div class="search">
			<form action="<%=request.getContextPath()%>/searchPage" method="get">
				<input type="text" class="text" name="keyword">
				<button type="submit">
					<img src="images/search.png" width="40px">
				</button>
			</form>
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
				<c:choose>
					<c:when test="${item.salePrice != null}">
						<div class="x-price_num">
							<strike>${item.price}</strike> ${item.salePrice}
						</div>
					</c:when>
					<c:otherwise>
						<div class="x-price_num">${item.price}</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="x-action">
				<label for="quantity">Quantity:</label>
				<input type="number" id="quantity" name="quantity" min="1" value="1">
				<div class="liji">
					<a href="javascript:void(0);" onclick="addToCart(${item.itemID})">Add to Cart</a>
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
					<c:if test="${not empty review.reviewText}">
							<div class="review-text">Comment: ${review.reviewText}</div>
					</c:if>
					
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
					<button class="useful-vote-button" data-vote-type="1"
						data-review-id="${review.reviewsID}" onclick="voteUseful(this)">Vote
						as Useful</button>
					<span class="useful-vote-count">${review.helpfulCount}</span>
					people found this useful.
				</div>
				<div class="useful-vote-section">
					<button class="useful-vote-button" data-vote-type="0"
						data-review-id="${review.reviewsID}" onclick="voteUseful(this)">Vote
						as Unuseful</button>
					<span class="unuseful-vote-count">${review.unHelpfulCount}</span>
					people found this unUseful.
				</div>
				
				<br />
				<br />
			</c:forEach>
		</div>
	</div>


</body>
</html>
