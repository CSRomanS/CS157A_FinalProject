var index = $(this).index();
index=0;

$(function() {

	var flag = true;

	let boxTop = $(".cate").offset().top;
	toggleTool();
	function toggleTool(){
		if ($(document).scrollTop() >= boxTop){
			$(".nav").fadeIn(800);
		}else {
			$(".nav").fadeOut(800);
		}
	};

	$(window).scroll(function(){

		toggleTool();

		if(flag) {
			$(".cate .w").each(function(i,e){
				if($(document).scrollTop() >= $(e).offset().top){
					// console.info(i);
					$(".nav li").eq(i).addClass("current").siblings().removeClass("current");
				}
			})
		}
	});

	$(".back").click(function(){
		$("body,html").stop().animate({
			scrollTop:0,
		});
	});

	$(".nav li").click(function() {
		flag = false;
		console.info($(this).index());
		let current = $(".cate .w").eq($(this).index()).offset().top;
		$("body,html").stop().animate({
			scrollTop:current
		},function (){
			flag = true;
		});

		$(this).addClass("current").siblings().removeClass("current");
	})

	$("#right").click(function (){
		index++;
		console.info(index);
		// console.info('1');
		$("#carousel div ").eq(index).stop().slideDown(100).siblings().stop().slideUp(100);
	});
	$("#left").click(function (){
		index--;
		console.info(index);
		$("#carousel div ").eq(index).stop().slideDown(100).siblings().stop().slideUp(100);
	});
});