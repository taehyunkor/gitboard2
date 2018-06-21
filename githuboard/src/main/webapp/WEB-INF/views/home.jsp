<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="jqplot/excanvas.js"></script><![endif]-->
 

<link rel="jqplot/stylesheet" href="jqplot/jquery.jqplot.min.css" />
  <head>

    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Grayscale - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="./resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="./resources/css/grayscale.min.css" rel="stylesheet">


  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">SpringBoard</a>
       <c:if test="${member != null}">
	
		  <div>${member.nickname}님 환영합니다</div>
	
       </c:if>
       
      
       
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
             <c:if test="${member == null}">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="login">로그인</a>
            </li>
                         
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">sign up</a>
            </li>
            
            </c:if>
            
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#download">그래프보기</a>
            </li>
          
           <c:if test="${member != null}">
          <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="chat">채팅</a>
            </li>
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="logout">Logout</a>
            </li>
            
            
           </c:if>
          
          </ul>
        </div>
      </div>
    </nav>

    <!-- Intro Header -->
    <header class="masthead">
      <div class="intro-body">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h1 class="brand-heading">SpringBoard</h1>
              <p class="intro-text">STS,ORACLE을 이용한 게시판만들기</p>
              <a href="#download" class="btn btn-circle js-scroll-trigger">
                <i class="fa fa-angle-double-down animated"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </header>

  

    <!-- Download Section -->
    <section id="download" class="download-section content-section text-center">
      <div class="container">
        <div class="col-lg-8 mx-auto">
          
        
          <a href="boardlist" class="btn btn-default btn-lg">게시판 보러가기</a>
       
         
          
          <a href="register" class="btn btn-default btn-lg">회원 가입</a>
         
       
      
     
      </div>
      </div>
        <a href="#contact" class="btn btn-circle js-scroll-trigger">
       <i class="fa fa-angle-double-down animated"></i>
      </a>
    </section>

    <!-- Contact Section -->
    <section id="contact" class="content-section text-center">
      <div class="container">
       <h2>ip 별 트래픽 합계</h2>
		<div id="chartdiv" style="height:400px; width:1080px"></div>
       
       </div>
    </section>


    <!-- Footer -->
    <footer>
      <div class="container text-center">
        <p>Copyright &copy; Your Website 2018</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="./resources/vendor/jquery/jquery.min.js"></script>
    <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="./resources/vendor/jquery-easing/jquery.easing.min.js"></script>


  </body>
<script src="jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="jqplot/plugins/jqplot.barRenderer.js"></script>
<script type="text/javascript" src="jqplot/plugins/jqplot.pieRenderer.js"></script>
<script type="text/javascript" src="jqplot/plugins/jqplot.categoryAxisRenderer.js"></script>
<script type="text/javascript" src="jqplot/plugins/jqplot.pointLabels.js"></script>
<script>
	$.ajax({
		url:"traffic",
		data:{},
		dataType:"json",
		success:function(data){
			 var s1 = new Array();
		     var ticks = new Array();
			for(key in data){
				ticks.push(key);
				s1.push(data[key]);
			}
			
			 $.jqplot.config.enablePlugins = true;
		       
		        plot1 = $.jqplot('chartdiv', [s1], {
		            // Only animate if we're not using excanvas (not in IE 7 or IE 8)..
		            animate: !$.jqplot.use_excanvas,
		            seriesDefaults:{
		                renderer:$.jqplot.BarRenderer,
		                pointLabels: { show: true }
		            },
		            axes: {
		                xaxis: {
		                    renderer: $.jqplot.CategoryAxisRenderer,
		                    ticks: ticks
		                }
		            },
		            highlighter: { show: false }
		        });
		        $('#chartdiv').bind('jqplotDataClick', 
			            function (ev, seriesIndex, pointIndex, data) {
			                $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
			            }
			        );

		}
	});
</script>






</html>
