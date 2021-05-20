<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Events</title>
		<style><%@include file="/WEB-INF/css/style.css"%></style>
	</head>
	
	<header class="header-manage">
		<a href="/index">
			<img class="img" src="http://sociallab.fer.hr/wordpress/wp-content/uploads/2020/01/innosid_logo_header.png" width="200" alt="Sociallab Logo">
		</a>
		<form method="GET" action="/logout">
				<input type="submit" class="input pink" value="Log out">
		</form><br>
	</header>
	
	<body class="body-manage">
	
		<c:if test="${not empty message}">
			<p class="message">${message}</p>
		</c:if>
		
		<h1>All Events:</h1>
		<c:forEach items="${list}" var="event">
			<div class="plain-text">
				<p>Date: ${event.date}</p>
				<p>Time: ${event.time}</p>
				<p>Location: ${event.location}</p>
				<p>Description: ${event.description}</p>
				
				<form action="/events/update/${event.eventID}" method="GET">
                	<input class="input blue" type="submit" value="Update Event"/>
                </form>
                
				<form action="/events/delete/${event.eventID}" method="POST">
	    			<input class="input dark-blue" type="submit" value="Delete Event" />
				</form>
				
				<form action="/events/images/manage/${event.eventID}" method="GET">
	    			<input class="input blue" type="submit" value="Manage images" />
				</form>
			</div>
			<br><br><br><br>
		</c:forEach>
		
	</body>
</html>
