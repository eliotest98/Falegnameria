<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,Beans.*,Database.*,Servlet.*,java.math.BigDecimal"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
	ArrayList<Lavori> lavori = new ArrayList<>();
    ArrayList<Cliente> clienti = new ArrayList<>();
    lavori = (ArrayList) request.getAttribute("listaLavori");
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
<br><br><br>
<%
if(lavori.size()>0)
{
	%>
<table class="c">
<h1 class="b">Lista dei Lavori da Completare</h1>
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
<%	
for (int i = 0; i < lavori.size(); i++) 
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
						BigDecimal num2 = lavori.get(i).getSpeseMateriale();
						BigDecimal ricavo = num.subtract(num2);
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
						<input type="hidden" value=<%=ricavo%> name="Ricavo">
						<input type="hidden" value=<%=lavori.get(i).getIdLavoro()%> name="idLavoro">
						<input type=submit class="subm" value="Cancella">
						</form>
						<%
						}
						%>
</tr>
						<%
							}
						%>
				</table>
				<form method="post" action="AggiungiLavoro.jsp">
				<input type="submit" class="submi2" value="Aggiungi Lavoro">
				</form>
				<form method="post" action="GetListaLavoriDaPagare">
				<input type="submit" class="submi2" value="Paga Lavoro">
				</form>
					<br><br><br>
<%}
else{
	%>
	<h1 class="a">Non ci sono lavori da svolgere prenditi un giorno libero!</h1><br>
	<form method="post" action="AggiungiLavoro.jsp">
	<input type="submit" class="submi" value="Aggiungi Lavoro">
	</form>
	<%
}%>
		<br><br><br>
</div>
<footer>
<h2>Creator page:Testa Elio | Per Info 3496858082</h2>
</footer>
</body>
</html>