<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<title>Accueil</title>
<main align="center">
	<h4>Connexion</h4>
	<form>
		<div>
			Type Compte : <input checked id="typeCompteClient" type="radio"
				name="typeCompte" value="client">Client <input
				id="typeCompteBrasseur" type="radio" name="typeCompte"
				value="brasseur">Brasseur
		</div>
		<table align="center">
			<tr>
				<td>Email :</td>
				<td><input required placeholder="Email" type="email"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input required placeholder="Password" pattern="[A-z]{4,8}"
					type="password"></td>
			</tr>


		</table>
		<br>
		<div id="errorConnect">Identifiants invalides</div>
		<br> <input value="Se connecter" type="submit">
	</form>
	<a href="inscription.html"> Inscription </a>
</main>

