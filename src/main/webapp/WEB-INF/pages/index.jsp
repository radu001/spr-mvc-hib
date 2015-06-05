<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <title>Markers</title>
        
<script>var ctx = "${pageContext.request.contextPath}"</script>
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/simple-line-icons.css" rel="stylesheet">
        <link href="css/fullscreen-slider.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/app.css" rel="stylesheet">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="notransition no-hidden">

        <!-- Hero -->

        <div id="hero-container-map">
            <div id="home-map"></div>
            <div class="home-header map">
                <div class="home-logo osLight"><span class="fa fa-home"></span> Markers</div>
                <a href="#" class="home-navHandler visible-xs"><span class="fa fa-bars"></span></a>
                <div class="home-nav">
                    <ul>
                    		 <%
        if(session.getAttribute("loggedIn") == null)
            {
            %>
                        <li style="padding-top:0px;"><a href="${pageContext.request.contextPath}/signin.html" class="btn btn-green">Sign In</a></li>
        <%                
            } else {
        %>
        				<li style="padding-top:0px;"><a href="${pageContext.request.contextPath}/admin/logout.html" class="btn btn-green">Log Out</a></li>
        <%                
            }
        %>
                        <li><a href="${pageContext.request.contextPath}/explore/explorePage" class="btn btn-green">List a Property</a></li>
                    </ul>
                </div>
            </div>
            <div class="search-panel form-inline">
                
                <div style="width: 280px;margin: 0 auto;">
                    <div class="form-group hidden-xs adv">
                        <div class="input-group">
                            <input class="form-control price" type="text" placeholder="Search for Markers" onkeypress="handle(event)" id="searchInput">
                        </div>
                    </div>
                    <div class="form-group">
                        <a href="#" class="btn btn-green" onclick="return searchButton();">Search</a>
                       
                    </div>
      		</div>
        </div>
        <div class="highlight">
            <div class="h-title osLight">Find your new place with Markers</div>
        </div>


        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery-ui-touch-punch.js"></script>
        <script src="js/jquery.placeholder.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/jquery.touchSwipe.min.js"></script>
        <script src="http://maps.googleapis.com/maps/api/js?sensor=true&amp;libraries=geometry&amp;libraries=places" type="text/javascript"></script>
        <script src="js/infobox.js"></script>
        <script src="js/jquery.visible.js"></script>
        <script src="js/home.js" type="text/javascript"></script>
    </body>
</html>