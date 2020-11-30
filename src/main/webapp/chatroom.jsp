<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="es.ubu.lsi.Practica3ChatWeb.*"%>

<!-- Error al instanciar las clases -->

<jsp:useBean id="servidorweb"  class="es.ubu.lsi.Practica3ChatWeb.ChatServerWeb" scope="application"/>
<%-- <jsp:useBean id="clienteweb"  class="es.ubu.lsi.Practica3ChatWeb.ChatClientWeb" scope="session" />
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Chat Room</title>
</head>

<%
	//clienteweb.setNickname(request.getParameter("username"));
	//servidorweb.checkIn(cliente);
%>

<script type="text/javascript">
	// jQuery Document
	$(document).ready(function() {
		//If user wants to end session
		$("#exit").click(function() {
			var exit = confirm("Are you sure you want to end the session?");
			if (exit == true) {
				window.location = 'index.html';
			}
		});
	});
</script>

<body>


	<script type="text/javascript">
		setInterval(refreshIframe, 5000); // establece el tiempo a 5 seg.
		function refreshIframe() { // recarga el iframe de la página
			frames[0].location.reload(true);
		}
	</script>

	<h1>
		Chat Room:
		<%=request.getParameter("username")%></h1>

	<!-- <form action="sendMessage"></form> -->

	<div id="wrapper">
		<div id="menu">
			<p class="welcome">
				Welcome,
				<%=request.getParameter("username")%><b></b>
			</p>
			<p class="logout">
				<a id="exit" href="#">Exit Chat</a>
			</p>
			<div style="clear: both"></div>
		</div>

		<div id="chatbox"></div>

		<%
			//Para mostrar los mensajes de un cliente
		ChatClientWeb cliente = (ChatClientWeb) session.getAttribute("cliente");
		ChatServerWeb servidor = (ChatServerWeb) application.getAttribute("servidor");

		/*
		for (int i = 0; i < servidor.getMessages(clienteweb).size(); i++){
			out.print( servidor.getMessages(clienteweb).get(i));
		}
		*/
		%>

		<form name="message" action="">
			<input name="usermsg" type="text" id="usermsg" size="63" /> <input
				name="submitmsg" type="submit" id="submitmsg" value="Send" />
		</form>
	</div>

	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
	<script type="text/javascript">
		// jQuery Document
		$(document).ready(function() {

		});
	</script>

	<%
		String msg = request.getParameter("usermsg");
	//servidorweb.sendMessage(clienteweb, msg);
	%>

</body>
</html>