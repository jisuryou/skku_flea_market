<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="skku_flea_market.model.User"%>
<%
	User user = new User();
	HttpSession HttpSession = request.getSession();
	user = (User) HttpSession.getAttribute("user");
	request.setAttribute("user", user);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SKKU FLEA MARKET - Sell</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/adminstyle.css">
<link href="js/script.js">
<!--fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<!--fontawesome-->
<script src="https://kit.fontawesome.com/ff96cc4049.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="sell" method="post">
					<caption>
						<h2>Sell Product</h2>
					</caption>

					<div class="group">
						<label>Product Name</label> <input name="product_name" type="text"
							class="input" required>
					</div>
					<div class="group">
						<label>Product Price</label> <input name="product_price"
							type="text" class="input" required>
					</div>
					<div class="group">
						<label>Product Image</label> <input name="product_image"
							type="file" class="input" accept="image/*" required>
					</div>
					<div class="group">
						<label>Product Description</label> <input name="product_desc"
							type="text" class="input" required>
					</div>
					<div class="group">
						<label>Product Category</label> <select name="category">
							<option value="Bathroom" selected>Bathroom</option>
							<option value="Books">Books</option>
							<option value="Computers">Computers</option>
							<option value="Electronics">Electronics</option>
							<option value="Fashion">Fashion</option>
							<option value="Furnitures">Furnitures</option>
							<option value="Health">Health</option>
							<option value="Industrial">Industrial</option>
							<option value="Kitchen">Kitchen</option>
							<option value="Pet Supplies">Pet Supplies</option>
							<option value="Software">Software</option>
							<option value="Sports & Outdoors">Sports & Outdoors</option>
							<option value="Tools">Tools</option>
						</select>
					</div>
					<div class="group">
						<input id="sellcheck1" type="radio" name="product_status"
							value="purchased in progress" checked> <label
							for="sellcheck1"><span class="upcheck"></span>Flea market</label>
						<input id="sellcheck2" type="radio" name="product_status"
							value="auction" checked> <label for="sellcheck2"><span
							class="upcheck"></span>Auction</label>
					</div>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>