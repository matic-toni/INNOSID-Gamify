<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>Add form</title>
	    <style><%@include file="/WEB-INF/css/style.css"%></style>
	</head>
	
	<header>
		<a href="/index">
			<img class="img" src="http://sociallab.fer.hr/wordpress/wp-content/uploads/2020/01/innosid_logo_header.png" width="200" alt="Sociallab Logo">
		</a>
		<form method="GET" action="/logout">
			<input type="submit" class="input pink" value="Log out">
		</form>
		<br>	
	</header>
	
	<body>
	    <h1>Enter form data:</h1>
	    <form id="formForm" action="/forms/add" method="POST">
	    	<div>
	            <label for="title">Title:</label><br><br>
	            <input type="text" name="title" id="title" placeholder="What is it about?">
	        </div>
	        <br>
	        <div>
	            <label for="link">URL:</label><br><br>
	            <input type="text" name="link" id="link" placeholder="www.link-of-the-form.com">
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