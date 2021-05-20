<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Upload image</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<header>
	<a href="/index">
		<img class="img" src="http://sociallab.fer.hr/wordpress/wp-content/uploads/2020/01/innosid_logo_header.png" width="200" alt="Sociallab Logo">
	</a>
	<form method="GET" action="/logout">
		<input type="submit" class="input pink" value="Log out">
	</form>
	<br><br><br>
</header>

<body>

<form id="myForm" action="/images/upload" method="POST" enctype="multipart/form-data">
 
  <p><label class="upload-label" for="file"> Click here to upload from your computer </label></p>
  <p><input type="file" id="file" accept="image/*" name="file" onchange="loadFile(event)" style="display: none; " ></p>
  
  <br>
  
  <p><img id="display" width="300" alt=" Upload a picture to see the preview "/></p>
  
  <br>
  
  <p><input class="input dark-blue" type="submit" value=" Upload Image " name="submit"></p>
  
</form>
	<script>
		var loadFile = function(event) {
	    	var image = document.getElementById('display');
        	image.src = URL.createObjectURL(event.target.files[0]);
        	var form = document.getElementById("myForm");
        	form.append(getElementById(image.namespaceURI));
        };
	</script>
</body>
</html>