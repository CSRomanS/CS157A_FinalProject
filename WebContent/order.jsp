<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<html>
<head>
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/carts.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript"
	charset="ISO-8859-1"></script>
<script>


	$(document).ready(function() {

	});
</script>
<script type="text/javascript">
var modal;

document.addEventListener('DOMContentLoaded', function() {
    modal = document.getElementById("reviewModal");

    document.getElementsByClassName("close-btn")[0].onclick = closeReviewModal;

    // Close the modal if clicked outside of the content
    window.onclick = function(event) {
        if (event.target === modal) {
            closeReviewModal();
        }
    }
});

function showReviewModal(itemID) {
	const modal = document.getElementById('reviewModal');
    modal.style.display = "block";
    modal.setAttribute('data-itemid', itemID);
}


function closeReviewModal() {
    modal.style.display = "none";
}

function submitReview() {
    const itemID = modal.getAttribute('data-itemid');

    const starRatingElems = document.querySelectorAll('#starRating input[type="radio"]');
    let starRating = null;

    for (let i = 0; i < starRatingElems.length; i++) {
        if (starRatingElems[i].checked) {
            starRating = starRatingElems[i].value;
            break;
        }
    }
    const reviewText = document.getElementById('reviewText').value;
    const reviewPicURL = document.getElementById('reviewPicURL').value;
    
    if (!starRating) {
        alert("Please select a star rating.");
        return;
    }
    if (!reviewText.trim()) {
        alert("Review text cannot be empty.");
        return;
    }
    if (!reviewPicURL.trim()) {
        alert("Review picture URL cannot be empty.");
        return;
    }

    $.ajax({
        url: './submitReview',
        method: 'POST',
        data: {
            itemID: itemID,
            starRating: starRating,
            reviewText: reviewText,
            reviewPicURL: reviewPicURL
        },
        success: function(response) {
            if (response.success) {
                // Close the modal
                modal.style.display = "none";
             // Redirect to the item detail page
            const contextPath = '<%=request.getContextPath()%>';
		    const url = contextPath + "/detail?itemID=" + itemID;
		    
		    window.location.href = url;
		    
            } else {
                // Display error message
                document.getElementById('errorMessage').textContent = response.message;
            }
        }
    });
}
</script>
<style>
.orders-table {
	width: 80%; /* You can adjust this value */
	margin: 0 auto; /* This will center the table on the page */
	border-collapse: collapse;
}

.orders-table th, .orders-table td {
	border: 1px solid #e0e0e0;
	padding: 10px;
	text-align: center;
}

.orders-table th {
	background-color: #f5f5f5;
}

.orders-table tr:nth-child(even) {
	background-color: #f9f9f9;
}

.orders-table .g-images table, .orders-table .g-images table tr,
	.orders-table .g-images table td {
	border: none;
}

.review-modal {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.7);
	overflow-y: auto;
	/* To add scroll if the modal gets longer than screen */
}

.modal-content {
	position: absolute;
	top: 10%; /* Changed from 50% to place it more towards the top */
	left: 50%;
	transform: translate(-50%, 0);
	background-color: #f4f4f4;
	padding: 40px; /* Increased padding */
	border-radius: 5px;
	width: 60%; /* Increase to 60% of screen width */
	max-width: 700px; /* Increased max width */
}

.close-btn {
	color: #aaa;
	float: right;
	font-size: 28px;
	cursor: pointer;
	margin: -25px -25px 0 0; /* Position adjustment */
}

.star-rating {
	margin-bottom: 20px;
}

/* Styles for the textarea and input */
textarea, input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #ccc;
}

button {
	padding: 10px 15px;
	border: none;
	background-color: #333;
	color: #fff;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #555;
}
</style>
</head>
<title>Your Orders</title>
<body>
	<div class="head">
		<div class="main_head">
			<a href="<%=request.getContextPath()%>/homepage">Main Page</a>
		</div>
	</div>

	<div class="cart">
		<table class="orders-table">
			<thead>
				<tr>
					<th class="g-images">Order Items</th>
					<th class="g-goodsname">Order Cost</th>
					<th class="g-props">Taxes</th>
					<th class="g-price">Address</th>
					<th class="g-quantity">Date Placed</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orderList}">
					<tr>
						<td class="g-images">
							<table>
								<c:forEach var="orderItem" items="${order.orderItems}">
									<tr>
										<td><img src="${orderItem.item.coverPicture}"
											alt="${orderItem.item.itemName}" width="50"></td>
										<td>${orderItem.item.itemName}</td>
										<td>Quantity: ${orderItem.itemCount}</td>
										<td>$${orderItem.itemCost}</td>
										<td><button
												onclick="showReviewModal(${orderItem.itemID})">Review</button></td>
									</tr>
								</c:forEach>
							</table>
						</td>
						<td class="g-goodsname">$${order.cost}</td>
						<td class="g-props">$${order.taxes}</td>
						<td class="g-price">${order.address},${order.city},
							${order.state} ${order.zipCode}</td>
						<td class="g-quantity">${order.datePlaced}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- Review Modal -->
	<div id="reviewModal" class="review-modal">
		<div class="modal-content">
			<span class="close-btn">&times;</span>

			<h2>Add Your Review</h2>

			<!-- Star Rating -->
			<div class="star-rating" id="starRating">
				Start Rate: <input type="radio" name="stars" value="1">1 <input
					type="radio" name="stars" value="2">2 <input type="radio"
					name="stars" value="3">3 <input type="radio" name="stars"
					value="4">4 <input type="radio" name="stars" value="5">5
			</div>

			<textarea id="reviewText" placeholder="Your review..." rows="4"></textarea>

			<input id="reviewPicURL" type="text" placeholder="Image URL">

			<button type="button" onclick="submitReview()">Submit Review</button>
			<div id="errorMessage" style="color: red;"></div>
		</div>

	</div>
</body>
</html>
