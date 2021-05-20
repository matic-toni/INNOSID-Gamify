<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Event Images</title>
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
		<h1>Event info:</h1>
		<p class="plain-text">Date: ${event.date}  |  Time: ${event.time}  |  Location: ${event.location}</p> 
		<br>
		<p><h2>Add image:</h2></p>
			<div>
				<form action="/events/images/add/foreign" id="imageFormForeign" method="POST">
					<input id="eventID" name="eventID"  type="hidden" value="${event.eventID}">
					<label for="imageURL">Paste link to an image:</label><br><br>
					 	 
		       		<input id="imageURL" name="imageURL" placeholder="http://www.image.com" type="text">
		       		<br><br>
		       		<div>
		       			<input class="input blue" type="submit" value="Add" onClick="return isEmpty()">
		    		</div>
				</form>
			</div>
			
			<div>
				<form action="/events/images/add" id="imageForm" method="POST">
					<input id="eventID" name="eventID"  type="hidden" value="${event.eventID}">
        			
					<label for="eventID">Choose one or more images to add to the event:</label><br><br>
        			
					<select id="imageNames" name="imageNames" multiple>
            			<c:forEach items="${images}" var="image">
                			<option value="${image.name}" <b>${image.name}</b></option>
            			</c:forEach>
        			</select>
					<br><br>
        			<div>
						<input class="input blue" type="submit" value="Add" onClick="return isEmpty()">
		    		 </div>
				</form>
    		</div>
    		
			<br>
				
			<p>Current Images:</p>
			<c:forEach items="${event.imageResources}" var="imageResource">
				<img src="${imageResource.imageURL}" alt="event image" width="20%"><br>
				<br>
				<form action="/events/images/remove?eventID=${event.eventID}&imageResourceID=${imageResource.imageResourceID}" method="POST">
	    			<input class="input dark-blue" type="submit" value="Remove" />
				</form>
			</c:forEach>
				
				<br>
			</div>
		</div>
	</body>
</html>
