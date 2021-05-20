<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Speakers</title>
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
		
		<h1>All Speakers:</h1>
		<c:forEach items="${list}" var="speaker">
			<div class="plain-text">
				<p>Name: ${speaker.name}</p>
				<p>Surname: ${speaker.surname}</p>
				<p>Role: ${speaker.role}</p>
				<p>Institution: ${speaker.institution}</p>
				<p>Picture URL: ${speaker.pictureURL}</p>
				<br>
				<form action="/speakers/update/${speaker.speakerID}" method="GET">
                	 <input class="input blue" type="submit" value="Update Speaker" />
                </form>
				
				<form action="/speakers/delete/${speaker.speakerID}" method="POST">
	    			<input class="input dark-blue" type="submit" value="Delete Speaker" />
				</form>
			
			</div>
			<br><br><br><br>
		</c:forEach>
		
	</body>
</html>
