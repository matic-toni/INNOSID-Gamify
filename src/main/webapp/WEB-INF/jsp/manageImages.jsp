<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Images</title>
		<style><%@include file="/WEB-INF/css/style.css"%></style>
	</head>
	
	<header>
		<a href="/index">
			<img class="img" src="http://sociallab.fer.hr/wordpress/wp-content/uploads/2020/01/innosid_logo_header.png" width="200" alt="Sociallab Logo">
		</a>
		<form method="GET" action="/logout">
				<input type="submit" class="input pink" value="Log out">
		</form><br>
	</header>

	<body>
		<br>
		<div>
			<h1> Search by name: </h1>
			<form action="/images/manage?name=${image.name}" method="GET">
				<input type="text" id="name" name="name" placeholder="imageName.jpg"> &nbsp
	    		<input class="input dark-blue" type="submit" value="Search"/>
			</form>
		</div>
		<br>
		<h1> All Found Images:</h1>
		<c:forEach items="${list}" var="image">
			<div>
				<img src="/images/${image.name}" alt="image" width="35%">
				<p>${image.name}</p>
				<form action="/images/delete/${image.name}" method="POST">
	    			<input class="input dark-blue" type="submit" value="Delete Image" />
				</form>
			</div>
			<br><br>
		</c:forEach>
		
	</body>
</html>
