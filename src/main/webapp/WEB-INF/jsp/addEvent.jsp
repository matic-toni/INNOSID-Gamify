<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>Add event</title>
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
	    <h1>Enter event data:</h1>
	    
	    <form id="eventForm" action="/events/add" method="POST">
	    	<div>
	            <label for="date">Date:</label><br><br>
	            <input type="text" name="date" id="date" placeholder="yyyy-mm-dd">
	        </div>
	        <br>
	        <div>
	            <label for="time">Time:</label><br><br>
	            <input type="text" name="time" id="time" placeholder="hh:mm:ss">
	        </div>
	        <br>
	        <div>
	            <label for="location">Location:</label><br><br>
	            <input type="text" name="location" id="location" placeholder="Which city?">
	        </div>
	        <br>
	        <div>
	            <label for="description">Description:</label><br><br>
	            <input type="text" name="description" id="description" placeholder="It is event about...">
	        </div>
	        
	        <br><br>
	        
	        <div>
	            <input class="input blue" type="submit" value="Submit" onClick="return isEmpty()">
	            <input class="input blue" type="reset" value="Reset">
	    	</div>
	    	
	    	<br><br>
	   
			<c:if test="${not empty message}">
				<p class="message">${message}</p>
			</c:if>
	    </form>
	</body>
</html>