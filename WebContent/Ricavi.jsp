<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,Beans.*,Database.*,Servlet.*,java.math.BigDecimal"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
    	ArrayList<Ricavo> ricavo = new ArrayList<>();
   		ricavo = (ArrayList) request.getAttribute("listaRicavi");
   		BigDecimal tot=new BigDecimal(0);
   		String mese=null;
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
<li class="selected" id="menu"><a href="GetSaldoServlet">Saldo</a></li>
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
<h1  class="a">Vuoi cercare per Mese?</h1>
<form method="get" action="GetSaldoByMese">
<input class="text" type="text" name="Mese" placeholder="Cerca Mese...">
<input class="submit" name="cerca" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="foto/cerca.png" alt="Cerca" title="Cerca">
</form>
</div>
<div>
<%
if(ricavo.size()>0)
{
	%>
<table class="e">
<h1 class="b">Ricavi Totali</h1>
<tr class="c">
<th><h2 class="b">idRicavo</h2></th>
<th><h2 class="b">Ricavi</h2></th>
<th><h2 class="b">Mese</h2></th>
</tr>
<%	
for (int i = 0; i < ricavo.size(); i++) 
{
	tot = ricavo.get(i).getRicavo().add(tot);
	if(ricavo.get(i).getMese()==1)
	{
		mese = "Gennaio";
	}else if(ricavo.get(i).getMese()==2)
	{
		mese="Febbraio";
	}
	else if(ricavo.get(i).getMese()==3)
	{
		mese="Marzo";
	}
	else if(ricavo.get(i).getMese()==4)
	{
		mese="Aprile";
	}
	else if(ricavo.get(i).getMese()==5)
	{
		mese="Maggio";
	}
	else if(ricavo.get(i).getMese()==6)
	{
		mese="Giugno";
	}
	else if(ricavo.get(i).getMese()==7)
	{
		mese="Luglio";
	}
	else if(ricavo.get(i).getMese()==8)
	{
		mese="Agosto";
	}
	else if(ricavo.get(i).getMese()==9)
	{
		mese="Settembre";
	}
	else if(ricavo.get(i).getMese()==10)
	{
		mese="Ottobre";
	}
	else if(ricavo.get(i).getMese()==11)
	{
		mese="Novembre";
	}
	else if(ricavo.get(i).getMese()==12)
	{
		mese="Dicembre";
	}
%>
<tr>
						<td><h2 class="a"><%=ricavo.get(i).getIdRicavo()%></h2></td>
						<td><h2 class="a"><%=ricavo.get(i).getRicavo()%></h2></td>
						<td><h2 class="a"><%=mese%></h2></td>
</tr>
<%
}%>
<tr>
<td><h2 class="a">Totale Ricavi</h2></td><td colspan="2"><h2 class="a"><%=tot%></h2></td>
</tr>
</table>
<form method="post" action="ResetRicavi">
<input type="submit" class="submi3" value="Cancella Ricavi">
</form>
<br><br>
<%
}else{
%>
<br><br><br><br>
<h1 class="a">Non ci sono ricavi lavora di più!</h1><br><br><br><br><br><br><br><br>
<%} %>
</div>
<footer>
<h2>Creator page:Testa Elio | Per Info 3496858082</h2>
</footer>
</body>
</html>