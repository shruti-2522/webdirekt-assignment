<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
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



	<div class="container col-md-5 mt-2">
		<div class="card">
			<div class="card-body">



				<c:if test="{customer!=null}">
					<form method="post" action="update">
				</c:if>

				<c:if test="{customer==null}">
					<form method="post" action="insert">
				</c:if>

				<caption>
					<h2>

						<c:if test="{customer!=null}">
	Edit Customer
  </c:if>

						<c:if test="{customer==null}">
	Add Customer
  </c:if>

					</h2>
				</caption>

				<c:if test="{customer!=null}">
					<input type="hidden" id="id" value="<c:out value='${customer.id}'">
				</c:if>



				<fieldset class="form-group">
					<label>Customer Name:</label> <input type="text"
						class="form-control" placeholder="Enter customer name" name="name"
						required>
				</fieldset>


				<fieldset class="form-group">
					<label>Address 1:</label>
					<textarea class="form-control" name="addr1"
						placeholder="Enter address here"></textarea>
				</fieldset>



				<fieldset class="form-group">
					<label>Address 2:</label>
					<textarea class="form-control" name="addr2"
						placeholder="Enter address here"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label>Street:</label> <input type="text" class="form-control"
						placeholder="Enter customer name" name="street">
				</fieldset>


				<fieldset class="form-group">
					<label>Country:</label> <select name="country" class="form-control">
						<option>India</option>
						<option>America</option>
						<option>Chin</option>
						<option>Other</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Zip:</label> <input type="number" class="form-control"
						placeholder="Enter customer name" name="zip">
				</fieldset>


				<fieldset class="form-group">
					<labell>City:</label> <input type="text" class="form-control"
						placeholder="Enter city here" name="city">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone Number:</label> <input type="number"
						class="form-control" placeholder="Enter phonbe  number"
						name="phone">
				</fieldset>
				<fieldset class="form-group">
					<label>Email:</label> <input type="text" class="form-control"
						placeholder="Enter  email here  (a@gmail.com)" name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Fax:</label> <input type="number" class="form-control"
						placeholder="Enter Fax" name="fax">
				</fieldset>
				<fieldset class="form-group">
					<label>Website:</label> <input type="text" class="form-control"
						placeholder="Enter website" name="web">
				</fieldset>


				<fieldset class="form-group">
					<label>Notes:</label> <input type="text" class="form-control"
						placeholder="Enter notes" name="Notes">
				</fieldset>



				<button type="submit" class="btn  btn-success  ">ADD-CUSTOMER</button>
				</form>
			</div>

		</div>
	</div>




</body>
</html>