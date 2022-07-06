${thisIsModel}

<style>
body {
	font-family: Jura, verdana,arial,sans-serif;
	font-size:14px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
</style>
<script>
	for (var x = 0; x < 10; x++) {
		document.write("<br/>");
	}
</script>
<hr />
Message recevied at -
<%=new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date())%>
<hr />

