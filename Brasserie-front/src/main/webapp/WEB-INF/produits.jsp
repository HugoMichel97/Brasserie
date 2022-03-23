<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<title>Gestion des produits</title>

<main>

	<h2 align="center">Produits de la brasserie</h2>


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
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${listeProduits}" var="p">
				<c:choose>
					<c:when test="${p.getClass().getSimpleName()=='Biere'}">
						<tr>
							<td>${p.id}</td>
							<td>${p.getClass().getSimpleName()}</td>
							<td>${p.nom}</td>
							<td>${p.description}</td>
							<td>${p.prix}</td>
							<td>${p.stock}</td>
							<td>${p.points}</td>
							<td><a href='produits?id=${p.id}'><input
									type='button' class='btn btn-warning' value='Modifier'></a>
								<form action='produits' method='post'>
									<input type='hidden' name='tache' value='delete'> <input
										name='id' type='hidden' value='${p.id}'> <input
										type='submit' class='btn btn-danger' value='Supprimer'>
								</form></td>
						</tr>
					</c:when>
					<c:when test="${p.getClass().getSimpleName()=='Snack'}">
						<tr>
							<td>${p.id}</td>
							<td>${p.getClass().getSimpleName()}</td>
							<td>${p.nom}</td>
							<td>${p.description}</td>
							<td>${p.prix}</td>
							<td>${p.stock}</td>
							<td>${p.points}</td>
							<td><a href='produits?id=${p.id}'><input
									type='button' class='btn btn-warning' value='Modifier'></a>
								<form action='produits' method='post'>
									<input type='hidden' name='tache' value='delete'> <input
										name='id' type='hidden' value='${p.id}'> <input
										type='submit' class='btn btn-danger' value='Supprimer'>
								</form></td>
						</tr>
					</c:when>

				</c:choose>
			</c:forEach>

		</tbody>
	</table>

	<hr>
	<input type="button" align="center" value="Ajouter un produit ?" id="btnShowAddForm"
		class="btn btn-success">
	<br>
	<form action="produits" method="post" id="addFormProduits">
		<input type="hidden" name="tache" value="insert">
		<div>
			Type de produit : <input id="typeProduitsBiere"  type="radio"
				name="typeProduits" value="biere"> Biere <input
				id="typeProduitsSnack" type="radio" name="typeProduits"
				value="snack"> Snack
			<div>
				Nom : <input required type="text" name="nom"
					placeholder="Saisissez un nom">
			</div>
			<div>
				Description : <input required type="text"
					placeholder="Saisissez une description" name="description">
			</div>
			<div>
				Prix : <input required type="number" name="prix"
					placeholder="Saisissez un prix" min=0 step=0.1>
			</div>
			<div>
				Stock : <input required type="number"
					placeholder="Saisissez le stock" name="stock" min=0>
			</div>
			
			<div id="addBiere">
                <div>
                    Points de fidélité : <input type="number" id="fid" name="points"
                        placeholder="Saisissez les points" min=0 step=1>
                </div>
            </div>
           
			</table>
			<br> <input type="submit" class="btn btn-success"
				value="Valider l'ajout">
	</form>
</main>

<script>
	typeProduitsBiere.onchange = showFormBiere;
	typeProduitsSnack.onchange = showFormSnack;

	btnShowAddForm.onclick = function() {
		$("#addFormProduits").show();
	}

	function showFormBiere() {
		$("#addBiere").show();
		//$("#addSnack").hide();
	}

	function showFormSnack() {
		$("#addBiere").hide();
		//$("#addSnack").show();
		$("#fid").val("0")
	}
</script>