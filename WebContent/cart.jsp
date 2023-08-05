<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" type="text/css" href="css/public.css"/>
        <link rel="stylesheet" type="text/css" href="css/carts.css"/>
        <script src="js/jquery-3.6.0.js" type="text/javascript" charset="ISO-8859-1"></script>
        <script src="js/cart.js" type="text/javascript" charset="ISO-8859-1"></script>
    </head>
    <body>
        <div class="head">
            <div class="main_head">
                <a href="main.jsp">Main Page</a>
            </div>
        </div>
        <div class="cart">
            <div class="cart-head">
                <div class="column g-select">
                    <div class="g-checkbox">
                        <input type="checkbox" class="all each">
                    </div>
                </div>
                <div class="column g-images">Photo</div>
                <div class="column g-goodsname">Item Name</div>
                <div class="column g-props">Item Detail</div>
                <div class="column g-price">Price</div>
                <div class="column g-quantity">Quantity</div>
                <div class="column g-sum">Sum</div>
                <div class="column g-action">Action</div>
            </div>

            <c:forEach items="${carList}" var="item">
                <div class="carts-goods">
                    <div class="cell c-select">
                        <div class="c-checkbox">
                            <input type="checkbox" class="each">
                        </div>
                    </div>
                    <div class="cell c-images">
                        <a href="./detail?id=${item.itemId}" title="${item.itermName}"><img src="${item.pic}" alt="${item.picture}"></a>
                    </div>
                    <div class="cell c-goodsname"><a href="#" title="${item.itermName}">${item.itermName}</a></div>
                    <div class="cell c-props">${item.itermName}</div>
                    <div class="cell c-price">
                        <span>$</span>
                        <div class="c-price_num">${item.price}</div>
                    </div>
                    <div class="cell c-quantity">
                        <button type="button"  class="reduce">-</button>
                        <input type="text" value="${item.itemCount}" class="text_num">
                        <button type="button" class="add">+</button>
                    </div>
                    <div class="cell c-sum">
                        <span>$</span>
                        <div class="c-sum_num">${item.price}</div>
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
                    <div class="select_all">
                        <input type="checkbox" class="all each">
                        Check All
                    </div>
                    <div class="goods_num">
                        Item Number:
                        <span>0</span>
                        
                    </div>
                </div>
                <div class="pay-right">
                    <div class="right_jie">
                        <div class="btn">
                            <a href="#">Pay</a>
                        </div>
                        <div class="price-sum">
                            <div class="price-show">Total:</div>
                            <div class="show-money">
                                $
                                <span>00.00</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">

        </script>
    </body>
</html>
