<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home page</title>
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
			<br/>
		<div>
		
			<div>
				<h2>Questions</h2>
				<form method="GET" action="/questions/add">
					<input type="submit" class="input-index blue" value="Add">
				</form>
				<br/>
				<form method="GET" action="/questions/manage">
					<input type="submit" class="input-index dark-blue" value="Update or delete">
				</form>
			</div>
            </br>
			<div>
                <h2>Events</h2>
            	<form method="GET" action="/events/add">
            	    <input type="submit" class="input-index blue" value="Add">
            	</form>
            	<br/>
            	<form method="GET" action="/events/manage">
            		<input type="submit" class="input-index dark-blue" value="Update or delete">
            	</form>
            </div>
			</br>
			<div>
				<h2>Speakers</h2>
				<form method="GET" action="/speakers/add">
					<input type="submit" class="input-index blue" value="Add">
				</form>	
				<br/>
				<form method="GET" action="/speakers/manage">
					<input type="submit"  class="input-index dark-blue" value="Update or delete">
				</form>
			</div>
			</br>
			<div>
				<h2>Speeches</h2>
	            <form method="GET" action="/speeches/add">
	                <input type="submit" class="input-index blue" value="Add">
	            </form>
	            <br/>
	            <form method="GET" action="/speeches/manage">
	                <input type="submit" class="input-index dark-blue" value="Update or delete">
	            </form>
	        </div>
			</br>
		  	<div>
		 		<h2>Forms</h2>
				<form method="GET" action="/forms/add">
					<input type="submit" class="input-index blue" value="Add">
				</form>
				<br/>
				<form method="GET" action="/forms/manage">
					<input type="submit" class="input-index dark-blue" value="Update or delete">
				</form>
		  	
		  	</div>
			</br>
		 	<div>
		 		<h2>Images</h2>
				<form method="GET" action="/images/upload">
					<input type="submit" class="input-index blue" value="Upload image">
				</form>
				<br/>
				<form method="GET" action="/images/manage">
					<input type="submit" class="input-index dark-blue" value="Delete image">
				</form>
		  	</div>

			
		</div>
	</body>
</html>