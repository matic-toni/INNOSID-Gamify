<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Forms</title>
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
		
		<h1>All forms:</h1>
		<c:forEach items="${list}" var="form">
			<div class="plain-text">
				<p>Title: ${form.title}</p>
				<p>Link: ${form.link}</p>
				<br>
				<form action="/forms/update/${form.formID}" method="GET">
                	<input class="input blue" type="submit" value="Update Form"/>
                </form>
                
				<form action="/forms/delete/${form.formID}" method="POST">
	    			<input class="input dark-blue" type="submit" value="Delete Form" />
				</form>
				
			</div>
			<br><br><br><br>
		</c:forEach>
		
	</body>
</html>
