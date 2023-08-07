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
    
    .orders-table .g-images table, 
    .orders-table .g-images table tr, 
    .orders-table .g-images table td {
        border: none;
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
                                <td><img src="${orderItem.item.coverPicture}" alt="${orderItem.item.itemName}" width="50"></td>
                                <td>Quantity: ${orderItem.itemCount}</td>
                                <td>$${orderItem.itemCost}</td>
                                <td><button onclick="openReviewModal(${orderItem.itemID})">Review</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td class="g-goodsname">$${order.cost}</td>
                <td class="g-props">$${order.taxes}</td>
                <td class="g-price">${order.address}, ${order.city}, ${order.state} ${order.zipCode}</td>
                <td class="g-quantity">${order.datePlaced}</td>
            </tr>
        </c:forEach>
    </tbody>
		</table>

	</div>
</body>
</html>
