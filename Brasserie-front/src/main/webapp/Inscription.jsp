<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<title>Inscription Client</title>
<main align="center">
  <h1> Inscription client </h1>

  <form action="compte" method="post">
			<input type="hidden" name="tache" value="insert">
			<input type="hidden" name="typeCompte" value="client">
			<div>
				Mail : <input required type="text" name="mail" placeholder="Saisissez un mail">
			</div>
			<div>
				Password : <input required type="password"
					placeholder="Saisissez un password" name="password">
			</div>
			
			
				<div>Tel : <input  type="text" name="tel" placeholder="Saisissez le tel"> </div>
				<div>Numero : <input  type="text" name="numero" placeholder="Saisissez le numero"> </div>
				<div>Voie : <input  type="text" name="voie" placeholder="Saisissez la voie"> </div>
				<div>CP : <input  type="text" name="cp" placeholder="Saisissez le CP"> </div>
				<div>Ville : <input  type="text" name="ville" placeholder="Saisissez la ville"> </div>
			
	

			<input type="submit" class="btn btn-success mb-2"
				value="Inscription">
		</form>


</main>