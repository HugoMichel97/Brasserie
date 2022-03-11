<!-- A voir pour le css -->

<!-- <style>
  body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: #34495e;
}
.box{
  width: 300px;
  padding: 40px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: #191919;
  text-align: center;
}
.box h1{
  color: white;
  text-transform: uppercase;
  font-weight: 500;
}
.box input[type = "text"],.box input[type = "password"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
}
.box input[type = "text"]:focus,.box input[type = "password"]:focus{
  width: 280px;
  border-color: #2ecc71;
}
.box input[type = "submit"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #2ecc71;
  padding: 14px 40px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}
.box input[type = "submit"]:hover{
  background: #2ecc71;
}
</style> -->

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<c:if test="${connected.getClass().getSimpleName()=='Client'}">
	<c:redirect url = "client.jsp"/>
</c:if>
<c:if test="${connected.getClass().getSimpleName()=='Brasseur'}">
	<c:redirect url = "brasseur.jsp"/>
</c:if>

<title>Accueil</title>
<main align="center">
	<h4>Connexion</h4>
	<form action="home" method="post">
		<div>
			Compte : <input checked id="typeCompteClient" type="radio"
				name="typeCompte" value="client">Client <input
				id="typeCompteBrasseur" type="radio" name="typeCompte"
				value="brasseur">Brasseur
		</div>
		<table align="center">
			<tr>
				<td>Email :</td>
				<td><input required placeholder="Email" name="mail" type="email"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input required placeholder="Password" name="password"
					type="password"></td>
			</tr>
		</table>
		<br>
        <div id="errorConnect">${error}</div>
        <br> <input value="Se connecter" type="submit">
	</form>
	<a href="inscription.jsp"> Inscription </a>
</main>