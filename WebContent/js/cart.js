$(function(){
    // $(".c-sum_num").click(function(){
    // 	console.info($(this).text());
    // })
    //totl();
    //goodsnum();
    // check all
    $(".all").click(function() {
        all = $(this).prop("checked")
        $(".each").each(function() {
            $(this).prop("checked", all);
        })
    })
    // reduce items
    $(".reduce").click(function(){
        var num = $(this).siblings(".text_num").val();
        if(num>0){
            num--;
            $(this).siblings(".text_num").val(num);
        };
        var price=$(this).parents().siblings(".c-price").children(".c-price_num").text();
        var sum_num = $(this).parents().siblings(".c-sum").children(".c-sum_num");
        var sum = parseFloat(price*num);
        // console.log(sum);
        $(sum_num).text(sum);
        totl();
        goodsnum();
    });
    // add item
    $(".add").click(function(){
        var num = $(this).siblings(".text_num").val();
        num++;
        $(this).siblings(".text_num").val(num);
        var price=$(this).parents().siblings(".c-price").children(".c-price_num").text();
        var sum_num = $(this).parents().siblings(".c-sum").children(".c-sum_num");
        var sum = parseFloat(price*num);
        // console.log(sum);
        $(sum_num).text(sum);
        totl();
        goodsnum();
    });
    // remove item
    $(".remove").click(function(){
        $(this).parents(".carts-goods").remove();
        totl();
        goodsnum();
    });
    // sum
    function totl(){
    	let sumprice = 0;
        $(".each:checked").each(function() {
            // Find the parent container for the checked item
            let cartItem = $(this).parents(".carts-goods");

            // Fetch the quantity and price for the checked item
            let quantity = parseInt(cartItem.find(".text_num").val());
            let price = parseFloat(cartItem.find(".c-price_num").text());
            
            sumprice += quantity * price;
        });

        $(".show-money span").text(sumprice);
    };
    // total count
    function goodsnum(){
        let goods_num=0;
        $(".each:checked").each($(".text_num"),function() {
            goods_num+=parseInt($(this).val());
            $(".goods_num span").text(goods_num);
        });
    }

});