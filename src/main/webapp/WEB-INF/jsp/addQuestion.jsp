<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add question</title>
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
		<h1>Enter question data:</h1>
		
		<form id="questionForm" action="/questions/add" method="POST">
			<div>
				<label for="questionText">Question Text:</label><br><br>
		  		<input type="text" id="questionText" name= "questionText" placeholder="What is...?">
		  	</div>
		  	<br>
		  	<div>
		  		<label for="correctAnswer">Correct Answer:</label><br><br>
		  		<input type="text" id="correctAnswer" name="correctAnswer" placeholder="Correct Answer">
		  	</div>
		  	<br>
		  	<div>
		  		<label for="wrongAnswer1">Wrong Answer 1:</label><br><br>
		  		<input type="text" id="wrongAnswer1" name="wrongAnswer1" placeholder="Wrong Answer">
		  	</div>
		  	<br>
		  	<div>
		  		<label for="wrongAnswer2">Wrong Answer 2:</label><br><br>
		  		<input type="text" id="wrongAnswer2" name="wrongAnswer2" placeholder="Another Wrong Answer">
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