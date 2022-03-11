<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>

<title>Gestion des produits</title>

<main>

	<h2 align="center">Produits de la brasserie</h2>

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
		<div>
				Type produits : <input id="typeProduitsBiere" checked type="radio" name="typeProduits" value="biere">
				Biere <input id="typeProduitsSnack" type="radio" name="typeProduits" value="snack">
				Snack
		<div>
				Nom : <input required type="text" name="nom" placeholder="Saisissez un nom">
			</div>
			<div>
				Description : <input required type="text"
					placeholder="Saisissez une description" name="description">
			</div>
			<div>
				Prix : <input required type="number" name="prix" placeholder="Saisissez un prix">
			</div>
			<div>
				Stock : <input required type="number"
					placeholder="Saisissez le stock" name="stock">
			</div>
			<div id="addBiere">
				<div>Points de fidélité : <input  type="number" name="pts_fidelite" placeholder="Saisissez le nombre de points"> </div>
			</div>
			
		</table>
		<br> 
		<input type="submit" class="btn btn-success"
					value="Ajouter un produit">
	</form>
</main>

<script>
typeProduitsBiere.onchange=showFormBiere;
typeProduitsSnack.onchange=showFormSnack;

btnShowAddForm.onclick = function() {
	$("#addFormProduits").show();
}

function showFormBiere()
{
	$("#addBiere").show();
}

function showFormSnack()
{
	$("#addBiere").hide();
}


</script>