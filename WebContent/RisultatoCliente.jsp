<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,Beans.*,Database.*,Servlet.*,java.math.BigDecimal"%>
     <%
	ArrayList<Cliente> clienti = new ArrayList<>();
    clienti = (ArrayList) request.getAttribute("listaClienti");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Falegnameria</title>
<link rel="stylesheet" type="text/css" href="stile/style.css" title="style" />
</head>
<body>
<section id="nn"></section>
<header>
<h1 ><a class="b"href="index.jsp">Falegnameria Da Raffaele Testa</a></h1>
<section id="menubar">
<ul id="menu">
<li id="menu"><a href="index.jsp">Home</a></li>
<li id="menu"><a href="GetListaLavori">Lavori</a></li>
<li id="menu"><a href="AggiungiLavoro.jsp">Aggiungi</a></li>
<li id="menu"><a href="GetListaLavoriDaPagare">Pagamenti</a></li>
<li id="menu"><a href="GetSaldoServlet">Saldo</a></li>
<li class="selected" id="menu"><a href="GetListaClienti">Clienti</a></li>
</ul>
</section>
</header>
<div>
<br><br>
<h1  class="a">Vuoi cercare un lavoro?</h1>
<form method="get" action="CercaLavoroServlet">
<input class="text" type="text" name="nomeLavoro" placeholder="Cerca Lavoro...">
<input class="submit" name="cerca" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="foto/cerca.png" alt="Cerca" title="Cerca">
</form>
</div>
<div>
<h1  class="a">Vuoi cercare un Cliente?</h1>
<form method="get" action="CercaClienteServlet">
<input class="text" type="text" name="nomeCliente" placeholder="Cerca Cliente...">
<input class="submit" name="cerca" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="foto/cerca.png" alt="Cerca" title="Cerca">
</form>
</div>
<div>
<%if(clienti.size()>0){ %>
<h1 class="b">La ricerca ha prodotto i seguenti risultati:</h1>
<table class="g">
<tr class="c">
<th><h2 class="b">idCliente</h2></th>
<th><h2 class="b">Nome Cliente</h2></th>
<th><h2 class="b">Numero Telefono</h2></th>
<th><h2 class="b">Cancella Cliente</h2>
</tr>
<%for(int i=0;i<clienti.size();i++)
	{
	%>
						<tr>
						<td><h2 class="a"><%=clienti.get(i).getIdCliente()%></h2></td>
						<td><h2 class="a"><%=clienti.get(i).getNomePersona()%></h2></td>
						<td><h2 class="a"><%=clienti.get(i).getNumeroTelefono()%></h2></td>
						<td>
						<form method="post" action="CancellaCliente">
						<input type="hidden" name="idCliente" value=<%=clienti.get(i).getIdCliente()%>>
						<input type="submit" class="subm2" value="Cancella">
						</form>
						</td>
</tr>
						<%
							}
						}else
						{
						%>
						<br><br><br><br>
						<h1  class="a">La ricerca non ha prodotto risultati!</h1>
						<br><br><br><br><br><br><br>
						<%
						}
						%>
</table><br><br><br><br>
</div>
<footer>
<h2>Creator page:Testa Elio | Per Info 3496858082</h2>
</footer>
</body>
</html>