<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Speeches</title>
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
		
		<h1>All Speeches:</h1>
		<c:forEach items="${speechList}" var="speech">
			<div class="plain-text">
				<p>Title: ${speech.title}</p>
				<p>Start time: ${speech.startTime}</p>
				<p>End time: ${speech.endTime}</p>
				<p>Location of the event: ${speech.event.location}</p>
				<p>Date of the event: ${speech.event.date}</p>
				<p>Speakers:</p>
				
			    <c:forEach items="${speech.speakers}" var="speaker">
			        <p>${speaker.name}&nbsp${speaker.surname}&nbsp&nbsp(${speaker.institution})</p>
			    </c:forEach>
			    <br>
			    <form action="/speeches/update/${speech.speechID}" method="GET">
                	<input class="input blue" type="submit" value="Update Speech" />
                </form>
                
				<form action="/speeches/delete/${speech.speechID}" method="POST">
	    			<input class="input dark-blue" type="submit" value="Delete Speech" />
				</form>
			</div>
			<br><br><br><br>
		</c:forEach>
	</body>
</html>