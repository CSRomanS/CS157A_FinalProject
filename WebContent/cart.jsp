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

	var taxRate = <%= session.getAttribute("taxRate") %>;
	$(document).ready(
			function() {
				
				$("#submitLink").click(function(event){
				    event.preventDefault(); // Prevents the default action of the <a> tag.
				    $("#orderForm").submit(); // Submits the form.
				});
				
				$("#orderForm").on('submit', function(event){
			        // Clear the form to avoid multiple submissions
			        $(this).find('.dynamic-input').remove();

			        // Loop over each cart item and add it to the form
			        $('.carts-goods').each(function(index, cartItem){
			            var itemCount = $(cartItem).find('.text_num').text(); // Or however you're storing item count
			            var itemID = $(cartItem).find('.item-id').data('item-id');

			            // Add these values to the form
			            $("#orderForm").append('<input type="hidden" class="dynamic-input" name="itemCount" value="' + itemCount + '">');
			            $("#orderForm").append('<input type="hidden" class="dynamic-input" name="itemID" value="' + itemID + '">');
			        });

			    });
				
				
				function updateTotals() {
					let totalItems = 0;
					let totalPrice = 0;

					$(".carts-goods").each(
							function() {
								let count = parseInt($(this)
										.find('.text_num').val());
								let price = parseFloat($(this).find(
										'.c-price_num').data('price'));

								totalItems += count;
								totalPrice += (count * price);

								// Update line total for this item
								$(this).find('.c-sum_num').text(
										'$' + (count * price).toFixed(2));
							});
					
					console.log("taxRate:", taxRate);

					let tax = totalPrice * taxRate; // Calculate the tax.
				    let totalPriceWithTax = totalPrice + tax; // Add tax to total.

					$("#total-items").text("Item Number: " + totalItems);
					$("#total-price").text('$' + totalPriceWithTax.toFixed(2));
					$("#tax").text("$" + tax.toFixed(2))
				}

				$(".add").click(function() {
					let input = $(this).prev('.text_num');
					input.val(parseInt(input.val()) + 1);
					updateTotals();
				});

				$(".reduce").click(function() {
					let input = $(this).next('.text_num');
					let currentValue = parseInt(input.val());
					if (currentValue > 1) {
						input.val(currentValue - 1);
						updateTotals();
					}
				});

				// Initial update
				updateTotals();
			});
</script>
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
			<div class="column g-quantity">Quantity</div>
			<div class="column g-sum">Sum</div>
			<div class="column g-action">Action</div>
		</div>

		<c:forEach items="${cartList}" var="cart">
			<div class="carts-goods">
				<div class="cell c-images">
					<a href="<%=request.getContextPath()%>/detail?itemID=${cart.item.itemID}"
						title="${cart.item.itemName}" data-item-id="${cart.item.itemID}"><img
						src="${cart.item.coverPicture}" alt="${cart.item.coverPicture}"></a>
				</div>
				<div class="cell c-goodsname">
					<a href="#" title="${cart.item.itemName}">${cart.item.itemName}</a>
				</div>
				<div class="cell c-props">${cart.item.categoryDescription}</div>
				<div class="cell c-price">
					<span>$</span>
					<div class="c-price_num" data-price="${cart.item.price}">${cart.item.price}</div>
				</div>
				<div class="cell c-quantity">
					<button type="button" class="reduce">-</button>
					<input type="text" value="${cart.itemCount}" class="text_num">
					<button type="button" class="add">+</button>
				</div>
				<div class="cell c-sum">
					<span></span>
					<div class="c-sum_num">${cart.item.price}</div>
				</div>
				<div class="cell c-action">
					<a href="#" class="remove">Remove</a>
				</div>
			</div>

		</c:forEach>

	</div>
	<div class="payment">
		<div class="cart-pay">
			<div class="pay-left">
				<div class="goods_num" id="total-items">
					 <span>0</span>
				</div>
			</div>
			<div class="pay-right">
				<div class="right_jie">
					<div class="btn">
						<form id="orderForm" action="<%=request.getContextPath()%>/placeOrder" method="post">
						    <!-- Dynamically added input fields will go here -->
						    <a href="#" id="submitLink">Pay</a>
						</form>
							
					</div>
					<div class="price-sum">
						<div class="price-show">Total:</div>
						<div class="show-money" id="total-price">
							$ <span>00.00</span>
						</div>
					</div>
					<div class="price-sum">
						<div class="price-show">Tax:</div>
						<div class="show-money" id="tax">
							$ <span>00.00</span>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>
