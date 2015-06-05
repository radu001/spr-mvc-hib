<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page
	import="java.util.List, com.sprhib.model.MarkersCategory, com.sprhib.model.Marker"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>reales | real estate web application</title>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/simple-line-icons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/datepicker.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/app.css" rel="stylesheet">

<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body class="notransition">
	<!-- Header -->

	<div id="header">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/"> <span class="fa fa-home marker"></span> <span
				class="logoText">reales</span>
			</a>
		</div>
		<a href="#" class="navHandler"><span class="fa fa-bars"></span></a>
		<div class="search">
			<span class="searchIcon icon-magnifier"></span> 
			<input type="text" id="searchInput" placeholder="Search for Markers..." onkeypress="handle(event)">
		</div>
		<% 
if(session.getAttribute("loggedIn") != null)
            {
            %>
		<div class="headerUserWraper">
			<a href="#" class="userHandler dropdown-toggle"
				data-toggle="dropdown"><span class="icon-user"></span><span
				class="counter">5</span></a> <a href="#"
				class="headerUser dropdown-toggle" data-toggle="dropdown"> <img
				class="avatar headerAvatar pull-left" src="${pageContext.request.contextPath}/images/avatar-1.png"
				alt="avatar">
				<div class="userTop pull-left">
					<span class="headerUserName">Admin</span> <span
						class="fa fa-angle-down"></span>
				</div>
				<div class="clearfix"></div>
			</a>
			<div class="dropdown-menu pull-right userMenu" role="menu">
				<div class="mobAvatar">
					<img class="avatar mobAvatarImg" src="${pageContext.request.contextPath}/images/avatar-1.png"
						alt="avatar">
					<div class="mobAvatarName">Admin</div>
				</div>
				<ul>
					<li><a href="#"><span class="icon-settings"></span>Settings</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/admin/logout"><span class="icon-power"></span>Logout</a></li>
				</ul>
			</div>
		</div>
		<%} %>


		<a href="#" class="mapHandler"><span class="icon-map"></span></a>
		<div class="clearfix"></div>
	</div>

	<!-- Left Side Navigation -->

	<div id="leftSide">
		<nav class="leftNav scrollable">
			<div class="search">
				<span class="searchIcon icon-magnifier"></span> <input type="text"
					placeholder="Search for houses, apartments...">
				<div class="clearfix"></div>
			</div>
			<ul>
				<li><a href="${pageContext.request.contextPath}/explore/explorePage"><span
						class="navIcon icon-compass"></span><span class="navLabel">Explore</span></a></li>
				<li><a href="${pageContext.request.contextPath}/add"><span class="navIcon icon-plus"></span><span
						class="navLabel">New</span></a></li>
				<li class="hasSub"><a href="#"><span
						class="navIcon icon-link"></span><span class="navLabel">Pages</span><span
						class="fa fa-angle-left arrowRight"></span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/signin">Sign In</a></li>
						<li><a href="${pageContext.request.contextPath}/">Homepage</a></li>
						<li><a href="${pageContext.request.contextPath}/explore/explorePage">Explore</a></li>
						<li><a href="${pageContext.request.contextPath}/add">Add</a></li>
					</ul></li>
			</ul>
		</nav>

	</div>
	<div class="closeLeftSide"></div>

	<!-- Content -->

	<div id="wrapper">
		<div id="mapView">
			<div class="mapPlaceholder">
				<span class="fa fa-spin fa-spinner"></span> Loading map...
			</div>
		</div>
		<div id="content">
			<br><h2>Found markers:</h2> <br>
			<c:if test="${not empty notFound}">
   					<h2><c:out value="${notFound}"/></h2>
  			</c:if>
			<div class="resultsList" id="resultList">

				
			</div>
		</div>
		<div class="clearfix"></div>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui-touch-punch.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.placeholder.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.touchSwipe.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.slimscroll.min.js"></script>
	<script src="http://maps.googleapis.com/maps/api/js?v=3.9&libraries=geometry&libraries=places&sensor=false"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/infobox.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.tagsinput.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/js/search.js" type="text/javascript"></script>
	
</body>
</html>