<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:if test="${connected.getClass().getSimpleName()!='Brasseur'}">
	<c:redirect url="home" />
</c:if>

<title>Menu Brasseur</title>

<main align="center">

	<h3>Welcome ${connected.mail}</h3>
	<div id="banniere">
		<div>
			<a href="produits"><i>"Gestion des produits"</i></a>
		</div>
		<div>
			<a href=""><i>"Gestion des clients"</i></a>
		</div>
		<div>
			<a href=""><i>"Gestion des évènements"</i></a>
		</div>
		<div>
			<a href=""><i>"Gestion des ingrédients"</i></a>
		</div>
	</div>
	<br>
	<a href="disconnect"><input value="Se deconnecter" type="submit"></a>

</main>