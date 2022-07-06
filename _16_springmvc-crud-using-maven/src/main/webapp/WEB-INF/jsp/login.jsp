<style>
* {
  font-family: verdana;
  font-size: 9px;
}
</style>
<body>
	<hr>
	Sign In
	<hr>
	<p>
		<font color="red">${errorMessage}</font>
		<font color="green">${logoutMessage}</font>
	</p>
	<ul
		style='  background: conic-gradient(lightpink, white, powderblue);
		; list-style-type: none; text-align: center; margin: 0; padding: 0;'>
		<form method="post" action="login">
			Name : <input type="text" name="name"  value="admin"/> Password : <input
				type="password" name="password" value=""/> <input type="submit" />
		</form>
	</ul>
</body>
