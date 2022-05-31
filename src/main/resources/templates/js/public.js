// JavaScript Document

  $(function () {
	  /*顶部导航*/
	  $(".menu ul li").hover(function(){
	  		 $(this).find("ul").slideDown(100);
	  },function(){
	  		 $(this).find("ul").hide();
	  })
	  // 学生首页页签切换体侧报告/老师帮助
 	
// 	   $('#myTab a:first').tab('show'); 
//         $('#myTab a').click(function (e) { 
//           e.preventDefault();//阻止a链接的跳转行为 
// 		  $(this).addClass('active').siblings().removeClass('active');
//           $(this).tab('show');//显示当前选中的链接及关联的content 
//         }) 
		
		
		
	  /*全校综合情况*/
	  //成绩分布/按年级查看 选项卡切换
	  		$('.category ul li').click(function(){
	  			indexC = $(this).index();
	  			$(this).addClass('active').siblings().removeClass('active');
	  			$('.cont').eq(indexC).addClass('active').siblings().removeClass('active');
	  		})
//合格率选项卡切换
		$('.category ul li').click(function(){
			indexC = $(this).index();
			$(this).addClass('active').siblings().removeClass('active');
			$('.cont').eq(indexC).addClass('active').siblings().removeClass('active');
		})
		
		
		
		//按钮箭头
		var catew = $('.category').width()-280;
		var cateLiw = 0;
		$('.category ul li').each(function(){
			cateLiw +=$(this).outerWidth();
		})
		var i =0;
		$('.next').click(function(){
			$('.category ul').animate({
				"margin-left":-catew+'px'
			},500)
			i++;
			if((catew+220)*i+(catew+220)>=cateLiw){
				$('.prev').show();
				$('.next').hide();
			}
		})
		$('.prev').click(function(){
			$('.category ul').animate({
				"margin-left":0+'px'
			},500)
			$(this).hide();$('.next').show();
		})
		
		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	

})
  
  

  
  
  
  