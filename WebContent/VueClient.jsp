<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyleVue.css">
<script type="text/javascript">
	function confirmer(url) {
		var rep = confirm("Etes vous sûre de le supprimer?");
		if (rep == true)
			document.location = url;

	}
</script>

<title>INDEX</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">L'êntete</div>
			<div class="panel-body">
				<div>
					<form action="controlleur.do" method="post">
						<table class="table table-striped">
							<tr>
								<td>Mot Clé : <input type="text" name="motCle"
									value="${ model.motCle}" /> <input class="btn btn-primary"
									type="submit" value="Chercher" name="action" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div>

					<form action="controlleur.do" method="post">
						<input type="hidden" name="mode" value="${model.mode }" />
						<div class="form-group">
							<c:if test="${model.mode=='ajouter' }">
								<label for="refProduit">Réference: </label>
								<input type="text" class="form-control " id="refProduit"
									name="refProduit" value="${model.client.ref_prod }"
									required="required" placeholder="Ecrire le réference">
							</c:if>
							<c:if test="${model.mode=='edit' }">
								<label for="refProduit">Réference: </label>
								<input type="hidden" class="form-control" id="refProduit"
									name="refProduit" value="${model.client.ref_prod }"
									required="required" placeholder="Ecrire le réference">
								<label class="bg-success text-success">${model.client.ref_prod }</label>
							</c:if>
						</div>
						<div class="form-group">
							<label for="designation">Désignation:</label> <input type="text"
								class="form-control" id="designation" name="designation"
								value="${model.client.designation }"
								placeholder="Ecrire la désignation">
						</div>
						<div class="form-group">
							<label for="prix">Prix:</label> <input type="text"
								class="form-control" id="prix" name="prix"
								value="${model.client.prix }">
						</div>
						<div class="form-group">
							<label for="quantite">Quantité:</label> <input type="text"
								class="form-control" id="quantite" name="quantite"
								value="${model.client.quantite }">
						</div>
						<button type="reset" class="btn btn-primary">Annuler</button>
						<button type="submit" class="btn btn-primary" name="action"
							value="Save">Save</button>
					</form>
				</div>
				<div class="alert alert-danger">
					<strong>${model.erreur }</strong>
				</div>

				<div>
					<table class="table table-striped">
						<tr>
							<th>Réference</th>
							<th>Désignation</th>
							<th>Prix</th>
							<th>Quantité</th>
						</tr>
						<c:forEach items="${model.clients }" var="c">
							<tr>
								<td>${c.ref_prod }</td>
								<td>${c.designation }</td>
								<td>${c.prix }</td>
								<td>${c.quantite }</td>
								<td><a
									href="javascript:confirmer('controller.do?ref=${c.ref_prod }&action=delete')"
									class="glyphicon glyphicon-remove-sign"></a></td>
								<td><a
									href="controller.do?ref=${c.ref_prod }&action=editer"
									class="glyphicon glyphicon-pencil"></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>