<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Upload Status</title>
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
		
		<c:if test="${isSuccesful}">
			<h1>Image has been succesfully uploaded!</h1>
		</c:if>
		
		<c:if test="${not isSuccesful}">
			<h1>Image upload has failed!  </h1> <br>
			 <h3> Try using a different name for the file.</h3>
		</c:if>
		
		<br>
		
		<form method="GET" action="/images/upload">
				<input type="submit" class="input blue" value="Upload more images"></button>
		</form>
		
		<form method="GET" action="/index">
			<input type="submit" class="input dark-blue" value="Go to home page"></button>
		</form>
	
	</body>
</html>
