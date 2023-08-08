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
	
</script>
<style type="text/css">
.cell.c-images, .column g-images {
	width: 15%;
}
</style>

</head>
<body>
	<div class="head">
		<div class="main_head">
			<a href="<%=request.getContextPath()%>/homepage">Main Page</a>
		</div>
	</div>
	<div class="cart">
		<div class="cart-head">
			<div class="column g-images">Photo</div>
			<div class="column g-goodsname">Item Name</div>
			<div class="column g-props">Item Detail</div>
			<div class="column g-price">Price</div>
			<div class="column g-action">Action</div>
		</div>

		<c:forEach items="${wishlist}" var="cart">
			<div class="carts-goods">
				<div class="cell c-images">
					<a
						href="<%=request.getContextPath()%>/detail?itemID=${cart.item.itemID}"
						title="${cart.item.itemName}" id="itemID"
						data-item-id="${cart.item.itemID}"><img
						src="${cart.item.coverPicture}" alt="${cart.item.coverPicture}"></a>
				</div>
				<div class="cell c-goodsname">
					<a href="#" title="${cart.item.itemName}">${cart.item.itemName}</a>
				</div>
				<div class="cell c-props">${cart.item.categoryDescription}</div>
				<div class="cell c-price">
					<span>$</span>
					<c:choose>
						<c:when test="${cart.item.salePrice != null}">
							<div class="c-price_num" data-price="${cart.item.salePrice}">
								<strike>${cart.item.price}</strike> ${cart.item.salePrice}
							</div>
						</c:when>
						<c:otherwise>
							<div class="c-price_num" data-price="${cart.item.price}">${cart.item.price}</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="cell c-action">
					<form action="<%=request.getContextPath()%>/removeWishItem"
						method="post">
						<input type="hidden" name="itemID" value="${cart.item.itemID}" />
						<button type="submit" class="remove">Remove</button>
					</form>
				</div>
			</div>

		</c:forEach>

	</div>

</body>
</html>
