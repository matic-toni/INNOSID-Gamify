<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Add Speaker</title>
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
	
	<h1>Enter speaker data:</h1>
	
	<form action="/speakers/add" id="speakerForm" method="POST">
	    <div>
	        <label for="name">Name:</label><br>
	        <input id="name" name="name" placeholder="John" type="text">
	    </div>
	 	<br>
	    <div>
	        <label for="surname">Surname:</label><br>
	        <input id="surname" name="surname" placeholder="Doe" type="text">
	    </div>
	    <br>
	    <div>
	        <label for="role">Role:</label><br>
	        <input id="role" name="role" placeholder="Profession" type="text">
	    </div>
	    <br>
	    <div>
	        <label for="institution">Institution:</label><br>
	        <input id="institution" name="institution" placeholder="Workplace" type="text">
	    </div>
	    <br>
	    <div>
	    <label for="pictureURL">Choose image:</label><br>
        	<select id="pictureURL" name="pictureURL">
            	<c:forEach items="${images}" var="image">
       				<option value="${image.name}" <b>${image.name}</b></option>
            	</c:forEach>
        	</select>
	    </div>
	    
	    <br><br>
	    
	    <div>
	        <input class="input blue" type="submit" value="Submit" onClick="return isEmpty()">
	        <input class="input blue" type="reset" value="Reset">
	    </div>
	</form>
	<br><br>
	
	<c:if test="${not empty message}">
		<p class="message">${message}</p>
	</c:if>
	
	</body>
</html>