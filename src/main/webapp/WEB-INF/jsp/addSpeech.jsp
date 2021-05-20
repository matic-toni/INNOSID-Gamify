<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Add Speech</title>
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
		<h1>Enter speech data:</h1>
		
		<form action="/speeches/add" id="speechForm" method="POST">
		    <div>
		        <label for="title">Title:</label><br>
		        <input id="title" name="title" placeholder="" type="text">
		    </div>
		    <br>
		    <div>
		        <label for="startTime">Start time:</label><br>
		        <input id="startTime" name="startTime" placeholder="hh:mm:ss" type="text">
		    </div>
		    <br>
		    <div>
		        <label for="endTime">End time:</label><br>
		        <input id="endTime" name="endTime" placeholder="hh:mm:ss" type="text">
		    </div>
		    <br>
		    <div>
		        <label for="eventID">Event on which speech will be held:</label><br><br>
		        
		        <select id="eventID" name="eventID" >
		            <c:forEach items="${eventsList}" var="event">
		                <option value="${event.eventID}">${event.location}   ${event.date}</option>
		            </c:forEach>
		        </select>
		    </div>
		    <br>
		    <div>
		       <label for="speakerID">Speech will be held by (possible to choose multiple):</label><br><br>
                   <c:forEach items="${speakersList}" var="speaker">
                      <input type="checkbox" name="speakerID" value="${speaker.speakerID}">${speaker.name}&nbsp${speaker.surname}<br>
                   </c:forEach>

                   <!-- <select id="speakerID" name="speakerID" multiple>
                    <c:forEach items="${speakersList}" var="speaker">
                      <option value="${speaker.speakerID}"
                       <c:if test = "${}"> selected </c:if>>
                         <b>${speaker.name}&nbsp${speaker.surname}</b>&nbsp-&nbsp${speaker.role}&nbsp&nbsp(<i>${speaker.institution}</i>)</option>
                        </c:forEach>
                    </select> -->
		    </div>
		    
		    <br>
		    
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