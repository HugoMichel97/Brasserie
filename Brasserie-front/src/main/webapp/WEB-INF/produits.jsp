<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Gestion des produits</title>

<main>

	<h2 align="center">Produits Brasserie</h2>

	<input type="button" value="Ajouter" id="btnShowAddForm"
		class="btn btn-success">

	<table style="width: 100%" border align="center" id="produits">
		<thead>
			<tr align="center">
				<th>Id</th>
				<th>Type produit</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Stock</th>
				<th>Points de fidélité</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.getClass().getSimpleName()}</td>
					<td>${p.nom}</td>
					<td>${p.description}</td>
					<td>${p.prix}</td>
					<td>${a.stock}</td>
					<td>${a.pts_produit}</td>
					<td><a href='produits?id=${p.id}'><input type='button'
							class='btn btn-warning' value='Modifier'></a>
						<form action='produits' method='post'>
							<input type='hidden' name='tache' value='delete'> <input
								name='id' type='hidden' value='${p.id}'> <input
								type='submit' class='btn btn-danger' value='Supprimer'>
						</form></td>
				</tr>


			</c:forEach>

		</tbody>
	</table>

	<hr>
	<br>
	<form action="produits" method="post" id="addFormProduits">
		<input type="hidden" name="tache" value="insert">
		<table>
			<tr>
				<td>Type produit :</td>
				<td><select name="typeProduit">
						<option value="Biere">Biere</option>
						<option value="Snack">Snack</option>

				</select></td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td><input required type="text" name="nom"
					placeholder="Saisissez un modele"></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><input required type="text" name="description"
					placeholder="Saisissez une description"></td>
			</tr>
			<tr>
				<td>Prix :</td>
				<td><input required type="number" name="prix"
					placeholder="Saisissez un prix"></td>
			</tr>
			<tr>
				<td>Stock :</td>
				<td><input required type="number" name="stock"
					placeholder="Saisissez le stock"></td>
			</tr>
			<tr>
				<td>Points de fidélité :</td>
				<td><input required type="number" name="pts_fidelite"
					placeholder="Saisissez le nombre de points"></td>
			</tr>
			
		</table>
		<br> 
		<input type="submit" class="btn btn-success"
					value="Ajouter un produit">
	</form>
</main>

<script>

btnShowAddForm.onclick = function() {
	$("#addFormProduits").show();
}

</script>