<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<li class="selected" id="menu"><a href="AggiungiLavoro.jsp">Aggiungi</a></li>
<li id="menu"><a href="GetListaLavoriDaPagare">Pagamenti</a></li>
<li id="menu"><a href="GetSaldoServlet">Saldo</a></li>
<li id="menu"><a href="GetListaClienti">Clienti</a></li>
</ul>
</section>
</header>
<div>
<br><br>
<h1 class="a">Vuoi cercare un lavoro?</h1>
<form method="get" action="CercaLavoroServlet">
<input class="text" type="text" name="nomeLavoro" placeholder="Cerca Lavoro...">
<input class="submit" name="cerca" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="foto/cerca.png" alt="Cerca" title="Cerca">
</form>
<br><br>
</div>
<div>
<form class="aggiungi" method="post" action="AggiungiLavoroServlet">
<label><h1>Aggiungi Lavoro</h1></label>
<h2 class="c">Nome della Persona:<input class="text" type="text" name="NomePersona" placeholder="Es. Mario"></h2>
<h2 class="c">Numero di telefono:<input class="text" type="text" name="NumeroTelefono"></h2>
<h2 class="c">Spese Materiale:<input class="number" type="number" name="SpeseMateriale"></h2>
<h2 class="c">Descrizione:<br><textarea rows="4" cols="20" name="DescrizioneLavoro" placeholder="Es. Portone Mario Via Casale San Felice n*98"></textarea></h2>
<br>
<input class="submi"type="submit" value="Conferma">
<input class="submi" type="reset" value="Cancella">
<br><br>
</form>
<br><br>
</div>
<footer>
<h2>Creator page:Testa Elio | Per Info 3496858082</h2>
</footer>
</body>
</html>