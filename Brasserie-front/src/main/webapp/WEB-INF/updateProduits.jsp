<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<title>Gestion des produits</title>
<main align="center">

	<form action="produits" method="post" id="updateProduits">
		<input type="hidden" name="tache" value="update"> <input
			type="hidden" name="id" value="${produits.id}">
		<!-- id ou id_produit ? -->
		<input type="hidden" name="version" value="${produits.version}">

		<fieldset>
			<legend>Modifier un produit</legend>
			<table align="center">
				<tr>
					<td>Nom du produit :</td>
					<td><input name="nom" value="${produits.nom}" type="text"
						placeholder="Saisissez le nom"></td>
				</tr>

				<tr>
					<td>Type de produit :</td>
					<td><select name="typeProduits">
							<option
								<c:if test="${produits.getClass().getSimpleName()=='Biere'}"> selected </c:if>>Biere</option>
							<option
								<c:if test="${produits.getClass().getSimpleName()=='Snack'}"> selected </c:if>>Snack</option>
					</select></td>
				</tr>

				<tr>
					<td>Description du produit :</td>
					<td><input name="description" value="${produits.description}"
						type="text" placeholder="Saisissez la description">
					</td>
				</tr>

				<tr>
					<td>Prix :</td>
					<td><input name="prix" type="number" placeholder="Saisissez un prix"
						value="${produits.prix}" min=0 max=999 step=0.01>€
					</td>
				</tr>
				
				<tr>
					<td>Stock :</td>
					<td><input name="stock" type="number" placeholder="Saisissez le stock"
						value="${produits.stock}" min=0 max=999 step=1>
					</td>
				</tr>
				
				<tr>
					<td>Points de fidélité :</td>
					<td><input name="pts_fidelite" type="number" placeholder="Saisissez le nombre de points"
						value="${produits.pts_fidelite}" min=0 max=999 step=1>
					</td>
				</tr>

			</table>
			<br>

			<button type="submit" class="btn btn-warning">Modifier</button>
			<a href="produits"><button type="button" class="btn btn-danger">Annuler</button></a>
		</fieldset>
	</form>
</main>
