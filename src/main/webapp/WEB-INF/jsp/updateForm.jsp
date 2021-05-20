<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update form</title>
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
		<h1>Enter form data:</h1>
		
		<form id="formForm" action="/forms/update" method="POST">
		    <div>
        		<input type="hidden" id="formID" name= "formID" value="${form.formID}">
        	</div>
			<div>
				<label for="formTitle">Form Title:</label><br><br>
		  		<input type="text" id="formTitle" name= "title" value="${form.title}">
		  	</div>
		  	<br>
		  	<div>
		  		<label for="formLink">Link:</label><br><br>
		  		<input type="text" id="formLink" name="link" value="${form.link}">
		  	</div>
		  	
		  	<br><br>
		  	
		  	<div>
		  		<input class="input blue" type="submit" value="Submit" onClick="return isEmpty()">
		  		<input class="input blue" type="reset" value="Reset" onClick="return initialData()">
			</div>
		</form>
		
		<br><br>
		
		<c:if test="${not empty message}">
				<p class="message">${message}</p>
		</c:if>
	</body>
</html>