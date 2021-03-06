<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CUSTOMER LIST</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a class="navbar-brand">CUSTOMER MANAGEMNT</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">CUSTOMERS</a></li>
			</ul>
		</nav>


	</header>


	<div class="row">
		<div class="container">
			<h3 class="text-center">LIST OF CUSTOMERS</h3>
			<hr>


			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">ADD NEW CUSTOMER</a>

			</div>

			<br>

			<table class="table-bordered table">
				<thead style="background-color:green">
					<tr>
						<th>Customer Code</th>
						<th>Name</th>
						<th>Email</th>
						<th>Country</th>
						<th>Action
						<th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="customer"  items="${listCustomer}">

					<tr>

						<td><c:out value="${customer.id} " /></td>
						<td><c:out value="${customer.name} " /></td>
						<td><c:out value="${customer.email} " /></td>
						<td><c:out value="${customer.country} " /></td>
						<td><a href="edit?id=<c:out value='${customer.id}'/>">Edit</a>
						<a href="delete?id=<c:out value='${customer.id}'/>">Delete</a>
					
					</tr>
					</c:forEach>
				</tbody>

			</table>


		</div>
	</div>

</body>
</html>