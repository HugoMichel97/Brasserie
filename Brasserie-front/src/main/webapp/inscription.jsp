<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<title>Inscription Client</title>
<main align="center">
  <h1> Inscription client </h1>

  <form action="clients" method="post">
			<input type="hidden" name="tache" value="insert">
			<div>
				Mail : <input required type="text" name="mail" placeholder="Saisissez un mail">
			</div>
			<div>
				Password : <input required type="password"
					placeholder="Saisissez un password" name="password">
			</div>
			
			<div>Nom : <input  type="text" name="nom" placeholder="Saisissez votre nom"> </div>
			<div>Prenom : <input  type="text" name="prenom" placeholder="Saisissez votre prenom"> </div>
			<div>Tel : <input  type="text" name="tel" placeholder="Saisissez le tel"> </div>
	

			<input type="submit" class="btn btn-success mb-2"
				value="Inscription">
		</form>


</main>