<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Page Client</title>
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<script type="text/javascript">
	function confirmer(url) {
		var rep = confirm("Ëtes vous sûre de voire supprimer?");
		if (rep == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>
	<div>
		<form action="controlleur.do" method="post">
			<table class="table1">
				<tr>
					<td>Mot Clé : <input type="text" name="motCle"
						value="${model.motCle }" /> <input class="btn btn-primary"
						type="submit" value="Chercher" name="action" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<form action="controlleur.do" method="post">
			<input type="hidden" name="mode" value="${model.mode }" />
			<table class="table1">
				<c:if test="${model.mode=='ajouter' }">
					<tr>
						<td>Réference :</td>
						<td><input type="text" name="refProduit"
							value="${model.client.ref_prod }" required="required" /></td>
					</tr>
				</c:if>
				<c:if test="${model.mode=='edit' }">
					<tr>
						<td>Réference :</td>
						<td>${model.client.ref_prod }<input type="hidden" name="refProduit"
							value="${model.client.ref_prod }" required="required" /></td>
					</tr>
				</c:if>

				<tr>
					<td>Désignation :</td>
					<td><input type="text" name="designation"
						value="${model.client.designation }" /></td>
				</tr>
				<tr>
					<td>Prix :</td>
					<td><input type="text" name="prix"
						value="${model.client.prix }" /></td>
				</tr>
				<tr>
					<td>Quantité :</td>
					<td><input type="text" name="quantite"
						value="${model.client.quantite }" /></td>
				</tr>
				<tr>
					<td><input type="reset" value="Annuler" /></td>
					<td><input type="submit" value="Save" name="action" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>${model.erreur }</div>
	<div>
		<table class="table1">
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
						href="javascript:confirmer('controller.do?ref=${c.ref_prod }&action=delete')">Supprimer</a>
					</td>
					<td><a href="controller.do?ref=${c.ref_prod }&action=editer">Modifier</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>