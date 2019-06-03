<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>

<script type="text/javascript">
	
</script>
<style type="text/css">

.footer {
	position: fixed;
	bottom: 0;
	width: 100%; 
	
}

.main {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
}

.middle {
	position: absolute;
	margin-top: 30px;
	margin-bottom: 30px;
}

.infoSearch {
	float: left;
	width: 680px;
	height: 300px;
	background-color: #234234;
	margin-right: 20px;
}

.weather {
	float: right;
	width: 300px;
	height: 300px;
	background-color: #666666;
}
</style>
</head>

<body>
	<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />
	
	<div class="main">
		<!-- slider -->
		<c:import url="/WEB-INF/views/layout/slider.jsp" />

		<div class="middle">
			<div class="infoSearch"></div>
			<div class="weather"></div>
		</div>
	</div>
	

	<c:import url="/WEB-INF/views/layout/footer.jsp" />
	