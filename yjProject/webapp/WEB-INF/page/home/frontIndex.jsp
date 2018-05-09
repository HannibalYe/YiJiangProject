<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/commonPage.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"><!--ie使用edge渲染模式-->
<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
<meta name="renderer" content="webkit"><!--360渲染模式-->
<meta name="format-detection" content="telephone=notelphone=no, email=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<meta name="apple-touch-fullscreen" content="yes"/><!-- 是否启用 WebApp 全屏模式，删除苹果默认的工具栏和菜单栏 -->
<meta name="apple-mobile-web-app-status-bar-style" content="black"/><!-- 设置苹果工具栏颜色:默认值为 default，可以定为 black和 black-translucent-->
<meta http-equiv="Cache-Control" content="no-siteapp" /><!-- 不让百度转码 -->
<meta name="HandheldFriendly" content="true"><!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
<meta name="MobileOptimized" content="320"><!-- 微软的老式浏览器 -->
<meta name="screen-orientation" content="portrait"><!-- uc强制竖屏 -->
<meta name="x5-orientation" content="portrait"><!-- QQ强制竖屏 -->
<meta name="browsermode" content="application"><!-- UC应用模式 -->
<meta name="x5-page-mode" content="app"><!-- QQ应用模式 -->
<meta name="msapplication-tap-highlight" content="no"><!-- windows phone 点击无高光 -->
<title>大连意匠装饰工程有限公司</title>
<link href="${resourcesUrl}/css/frontcss/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script type="text/javascript" src="${resourcesUrl}/js/frontjs/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--  -->
<link href="${resourcesUrl}/css/frontcss/style.css" rel='stylesheet' type='text/css' />
<!-- banner 滑动 -->
<link rel="stylesheet" href="${resourcesUrl}/css/frontcss/silder.css" />
<!--<link rel="stylesheet" href="${resourcesUrl}/css/frontcss/fonts/font-awesome/css/font-awesome.min.css">-->
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Theme files -->
<!-- START gallery -->
<link rel="stylesheet" href="${resourcesUrl}/common/components/dist/stylesheets/chromagallery.css">
<!-- END gallery -->
<!--//theme style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<!-- header -->
<div id="home" class="top-banner">
	 <div class="header">
		 <div class="container">
			 <div class="headr-left">
				 <div class="details">
					 <ul>
						<!--  <li><a href="mailto:@example.com"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>info(at)example.com</a></li> -->
						 <li><i class="fa fa-phone"></i>18525511611</li>
					 </ul>
				 </div>
				 <div class="clearfix"></div>
			 </div>
			 <div class="headr-right">
				 <!-- <div class="social">							
						<a href="#"><i class="facebook"></i></a>
						<a href="#"><i class="twitter"></i></a>
						<a href="#"><i class="dribble"></i></a>	
			     </div>		 -->		 
			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>	
<!---->
<div class="top-header">
	 <div class="container">	
		 <div class="logo">
			 <h1><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意匠</a></h1>
		 </div>
		 <div class="top-menu">
			  <nav class="cl-effect-1">
			 <span class="menu"><img src="${resourcesUrl}/img/frontimg/menu.png" alt=""/></span>
			 <ul>
				<li><a href="index.html">首页</a></li>
				<li><a class="scroll" href="#about">关于我们</a></li>
				<li><a class="scroll" href="#service">服务</a></li>				
				<li><a class="scroll" href="#gallery">装修展示</a></li>
				<li><a class="scroll" href="#testi">全包套餐</a></li>
				<li><a class="scroll" href="#contact">联系我们</a></li>
			 </ul>
			 </nav>
		  </div>
	 </div>
</div>	
<!---->
<!-- <div class="banner">
	 <div class="container">
			<div class="banner-info">
				 <h2>Lorem ipsum dolor consectetur adipiscing elit.</h2>
				 <h3>Aenean dictum accumsan tincidunt.</h3>
				 <a href="#">Click</a>
			</div>
	 </div>
</div> -->
<div class="js-silder">
      <div class="silder-scroll">
           <div class="silder-main">
               <div class="silder-main-img">
                   <img src="${resourcesUrl}/img/frontimg/silder/banner1.jpg" alt="">
               </div>
               <div class="silder-main-img">
                   <img src="${resourcesUrl}/img/frontimg/silder/banner2.jpg" alt="">
               </div>
               <div class="silder-main-img">
                   <img src="${resourcesUrl}/img/frontimg/silder/banner3.jpg" alt="">
               </div>
           </div>
       </div>
       <div class="js-silder-ctrl"></div>
   </div>
<!---->
<div class="copyrights">公司简介</div>
<div id="about" class="welcome">
	<div class="container">
		 <div class="welcm-grids">
			 <div class="col-md-6 welcm-left">
				 <h3>公司简介</h3>
				 <h4>大连意匠装饰工程有限公司</h4>
				 <p>本公司主要从事经营：家装、别墅、二手房翻新改造、商场、店铺、饭店、酒店、展厅、幼儿园、写字楼、办公室及绿化园林等装修设计与工程施工。施工人员经验丰富，施工队伍稳定，且有完善的售后服务体系免去客户后顾之忧。 </p>
				 <p class="text">透明化的预算方式，绿色健康的施工技艺，严格的质量监督体系赢得了业内人士的一致赞誉和广大客户的普遍信赖，全体员工一直秉承“以品质求生存，以信誉求发展”的经营理念，始终坚持以客户的需求和满意为核心，以“诚信”为宗旨，不断用优质、精美、具有创造力的空间装饰产品为客户提供更大的价值回报。致力于追求信誉、品质、服务与价格的完美比例。</p>
			 </div>
			 <div class="col-md-6 welcm-right">
				 <!-- <h3>Etiam aliquam arcu vitae maximus.</h3> -->
				 <img src="${resourcesUrl}/img/frontimg/bnr2.jpg" class="img-responsive" alt=""/>
				 <!-- <p>Mauris non suscipit mi. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed eros felis, faucibus ut dui sed, volutpat auctor nibh. Fusce ornare urna id risus dignissim luctus.</p> -->
			 </div>
			 <div class="clearfix"></div>
		 </div>
	</div>
</div>
<!---->

<div id="service" class="services">
	 <div class="container">
	 	
	 	<div style="position: relative;" style="width:100%;height:100%;">
	 		<span style="position: absolute;top:40%;left:6%;width: 12%;height:51%;cursor: pointer;" onclick="window.open('${base}/front/index');"></span>
	 		<span style="position: absolute;top:40%;left:22%;width: 12%;height:51%;cursor: pointer;" onclick="window.open('${base}/front/index');"></span>
	 		<span style="position: absolute;top:40%;left:37%;width: 12%;height:51%;cursor: pointer;" onclick="window.open('${base}/front/index');"></span>
	 		<span style="position: absolute;top:40%;left:52%;width: 12%;height:51%;cursor: pointer;" onclick="window.open('${base}/front/index');"></span>
	 		<span style="position: absolute;top:40%;left:67%;width: 12%;height:51%;cursor: pointer;" onclick="window.open('${base}/front/index');"></span>
	 		<span style="position: absolute;top:40%;left:83%;width: 12%;height:51%;cursor: pointer;" onclick="window.open('${base}/front/index');"></span>
	 		<img src="${resourcesUrl}/img/frontimg/FUWU.jpg">
	 	</div>
		<!--  <h3>服务</h3>
		 <div class="specialty-grids-top">
				<div class="col-md-4 service-box" style="visibility: visible; -webkit-animation-delay: 0.4s;">
					<figure class="icon">
						<span class="glyphicon3 glyphicon-edit" aria-hidden="true"></span>
					</figure>
					<h5>工程保障</h5>
					<p>工程保障 工程保障工程保障工程 工程保障 工程保障 工程保障 工程保障 工程保障 工程保障保障工程保障</p>
				</div>
				<div class="col-md-4 service-box wow bounceIn animated" data-wow-delay="0.4s" style="visibility: visible; -webkit-animation-delay: 0.4s;">
					<figure class="icon">
						<span class="glyphicon3 glyphicon-leaf" aria-hidden="true"></span>
					</figure>
					<h5>服务流程</h5>
					<p>服务流程>服务流程>服务流程>服务流程>服务流程>服务流程</p>
				</div>
				<div class="col-md-4 service-box wow bounceIn animated" data-wow-delay="0.4s" style="visibility: visible; -webkit-animation-delay: 0.4s;">
					<figure class="icon">
						 <span class="glyphicon3 glyphicon-hourglass" aria-hidden="true"></span>						
					</figure>
					<h5>设计优先</h5>
					<p>设计优先设计优先设计优先设计优先设计优先设计优先.设计优先设计优先设计优先设计优先</p>
				</div>
				<div class="clearfix"> </div>
		 </div> -->
	 </div>
</div>
<!-- gallery -->
<div id="gallery" class="gallery-top">
  	<div class="container">
				<div class="gallery-info">
					<h3>装修展示</h3>
				</div>
				<div class="chroma-gallery mygallery">
				    <img src="${resourcesUrl}/img/frontimg/1.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/1.jpg">
				    <img src="${resourcesUrl}/img/frontimg/2.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/2.jpg">
				    <img src="${resourcesUrl}/img/frontimg/3.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/3.jpg">
				    <img src="${resourcesUrl}/img/frontimg/4.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/4.jpg">
				    <img src="${resourcesUrl}/img/frontimg/5.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/5.jpg">
				    <img src="${resourcesUrl}/img/frontimg/6.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/6.jpg">
				    <img src="${resourcesUrl}/img/frontimg/7.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/7.jpg">
				    <img src="${resourcesUrl}/img/frontimg/8.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/8.jpg">
				    <img src="${resourcesUrl}/img/frontimg/9.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/9.jpg">
				    <img src="${resourcesUrl}/img/frontimg/10.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/10.jpg">
				    <img src="${resourcesUrl}/img/frontimg/11.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/11.jpg">
				    <img src="${resourcesUrl}/img/frontimg/12.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/12.jpg">
				    <img src="${resourcesUrl}/img/frontimg/13.jpg" alt="" data-largesrc="${resourcesUrl}/img/frontimg/13.jpg">
				</div>
  	</div>
</div>


<div id="testi" class="testimonal">
	 <div class="container">
		 <div class="testi-top">
			 <h3>全包套餐</h3>
			<div style="display:block;width: 100%;height: 400px;">
			 	<span style="display:inline-block;background-color:#004D60;width: 30%;height:90%;cursor: pointer;" onclick="window.open('${base}/front/index');">
			 		全包
			 	</span>
		 		<span style="display:inline-block;background-color:#004D60;width: 30%;height:90%;cursor: pointer;" onclick="window.open('${base}/front/index');">
		 			半包
		 		</span>
		 		<span style="display:inline-block;background-color:#004D60;width: 30%;height:90%;cursor: pointer;" onclick="window.open('${base}/front/index');">
		 			大包
		 		</span>
			</div> 
		</div>
	 </div>
</div>
<!---->
<!--team-->
<div class="team">
	 <div class="container">
			<h3>团队精英</h3>
			<div class="team-info">
				<div class="col-md-4 team-grids">
					<a href="#">
						<img class="img-responsive" src="${resourcesUrl}/img/frontimg/members/1.jpg" alt="">
						<div class="captn">
							<h4>刘立彬</h4>
							<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
						</div>
					</a>
				</div>					
				<div class="col-md-4 team-grids">
					<a href="#">
						<img class="img-responsive" src="${resourcesUrl}/img/frontimg/members/2.jpg" alt="">
						<div class="captn">
							<h4>杨雨</h4>
							<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
						</div>
					</a>
				</div>
				<div class="col-md-4 team-grids">
					<a href="#">
						<img class="img-responsive" src="${resourcesUrl}/img/frontimg/members/3.jpg" alt="">
						<div class="captn">
							<h4>王申卿</h4>
							<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
						</div>
					</a>
				</div>
				<div class="clearfix" style="padding:10px 0;"> </div>
				<div class="col-md-4 team-grids">
					<a href="#">
						<img class="img-responsive" src="${resourcesUrl}/img/frontimg/members/4.jpg" alt="">
						<div class="captn">
							<h4>张玉超</h4>
							<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
						</div>
					</a>
				</div>
				<div class="col-md-4 team-grids">
					<a href="#">
						<img class="img-responsive" src="${resourcesUrl}/img/frontimg/members/5.jpg" alt="">
						<div class="captn">
							<h4>吴淼</h4>
							<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
						</div>
					</a>
				</div>
				<div class="clearfix"> </div>
			</div>
	  </div>
</div>
<!---->
<div id="contact" class="contact">
	    <!--<h3>联系我们</h3>		-->
	 <div class="container">
	 <div class="contact-grids">
		 <div class="contact-icons">
				<div class="contact-grid">
					<div class="contact-fig">
						<i class="fa fa-phone fa-lg"></i>
					</div>
					<p>18525511611</p>
				</div>
				<div class="contact-grid">
					<div class="contact-fig1">
						<i class="fa fa-map-marker fa-lg"></i>
					</div>
					<p>辽宁省大连市甘井子区大连市甘井子区
						<span>黄浦路537号泰德大厦07屋08A单元</span></p>
				</div>
				<div class="contact-grid">
					<div class="contact-fig2">
						<i class="fa fa-envelope fa-lg"></i>
					</div>
					<p><a href="mailto:info@example.com">example@mail.com</a></p>
				</div>
				<div class="clearfix"> </div>
			 </div>
			<!-- <iframe width="504" height="781" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://j.map.baidu.com/wWbAL"></iframe> -->
			<!--  <form>
				<input type="text" placeholder="Name">
				<input type="text" placeholder="Email">
				<input type="text" placeholder="Website">
				<textarea placeholder="Message..."></textarea>
				<input type="submit" value="SEND">
			 </form> -->
			 </div>			 
	 </div>
</div>
<!---->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>Copyright &copy; 2017.大连意匠装修工程有限公司 </p>
		 </div>		 
	 </div>
</div>
<!---->


<script type="text/javascript" src="${resourcesUrl}/js/frontjs/move-top.js"></script>
<script type="text/javascript" src="${resourcesUrl}/js/frontjs/easing.js"></script>
<!-- banner 滑动 -->
<script src="${resourcesUrl}/js/silder/wySilder.js" type="text/javascript"></script>

<script src="${resourcesUrl}/common/components/dist/scripts/modernizr-chrg.min.js"></script>
<script src="${resourcesUrl}/common/components/dist/scripts/imagesloaded.min.js"></script>
<script src="${resourcesUrl}/common/components/dist/scripts/masonry.min.js"></script>
<script src="${resourcesUrl}/common/components/dist/scripts/chromagallery.js"></script>

<!-- Start gallery  -->
<script type="text/javascript">
    $(document).ready(function(){
			$(".mygallery").chromaGallery
		    ({
		        color:'#000',
		        gridMargin:15,
		        maxColumns:5,
		        dof:true,
		        screenOpacity:0.8
		    });
		});
</script>
<!-- Begin gallery -->
<script>
	$(function (){
		$(".js-silder").silder({
            auto: true,//自动播放，传入任何可以转化为true的值都会自动轮播
            speed: 25,//轮播图运动速度
            sideCtrl: true,//是否需要侧边控制按钮
            defaultView: 0,//默认显示的索引
            interval: 3000,//自动轮播的时间，以毫秒为单位，默认3000毫秒
            activeClass: "active",//小的控制按钮激活的样式，不包括作用两边，默认active
        });
	});
 </script>
 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
			
		});
	</script>
<!---->
<!--script-->
<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
</script>

<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>