<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,Beans.*,Database.*,Servlet.*,java.math.BigDecimal"%>
     <%
	ArrayList<Cliente> clienti = new ArrayList<>();
    ArrayList<Lavori> lavori = new ArrayList<>();
    clienti = (ArrayList) request.getAttribute("listaClienti");
    lavori = (ArrayList) request.getAttribute("listaLavori");
    String visible = (String)request.getAttribute("vis");
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
<li class="selected" id="menu"><a href="GetListaLavori">Lavori</a></li>
<li id="menu"><a href="AggiungiLavoro.jsp">Aggiungi</a></li>
<li id="menu"><a href="GetListaLavoriDaPagare">Pagamenti</a></li>
<li id="menu"><a href="GetSaldoServlet">Saldo</a></li>
<li id="menu"><a href="GetListaClienti">Clienti</a></li>
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
<% if(visible.equalsIgnoreCase("visible")){%>
<h1 class="b">La ricerca ha prodotto i seguenti risultati:</h1>
<table class="c">
<tr class="c">
<th><h2 class="b">idLavoro</h2></th>
<th><h2 class="b">Descrizione</h2></th>
<th><h2 class="b">Data Prenotazione</h2></th>
<th><h2 class="b">Nome Persona</h2></th>
<th><h2 class="b">Numero Telefono</h2></th>
<th><h2 class="b">Spese Materiale</h2></th>
<th><h2 class="b">Pagamento</h2></th>
<th><h2 class="b">Cancella</h2></th>
</tr>
<%for(int i=0;i<clienti.size();i++)
	{
	Date g = lavori.get(i).getDataPrenotazione();
	int giorno = g.getDate();
	int mese = g.getMonth();
	int anno = g.getYear();
	%>
						<tr>
						<td><h2 class="a"><%=lavori.get(i).getIdLavoro()%></h2></td>
						<td><h2 class="a"><%=lavori.get(i).getDescrizione()%></h2></td>
						<td><h2 class="a"><%=giorno+1%>/<%=mese+1 %>/<%=anno+1900 %></h2></td>
						<td><h2 class="a"><%=clienti.get(i).getNomePersona()%></h2></td>
						<td><h2 class="a"><%=clienti.get(i).getNumeroTelefono()%></h2></td>
						<td><h2 class="a"><%=lavori.get(i).getSpeseMateriale()%>&#8364</h2></td>
						<td><h2 class="a"><%=lavori.get(i).getPagamento()%>&#8364</h2>
						<td class="a">
						<%
						BigDecimal num = lavori.get(i).getPagamento();
						double a = num.doubleValue();
						if(a == 0)
						{
						%>
						<h2 class="a">Non Abilitato</h2>	
						<%
						}
						else{
						%>
						<form method=post action="CancellaLavoroServlet">
						<input type="hidden" value=<%=lavori.get(i).getIdLavoro()%> name="idLavoro">
						<input type=submit class="subm" value="Cancella">
						</form>
						<%
						}
						%>
</tr>
						<%
							}
						}else if(visible.equalsIgnoreCase("nulla"))
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