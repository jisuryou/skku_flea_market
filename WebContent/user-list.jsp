<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SKKU FLEA MARKET - User Management</title>
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

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Password</th>
						<th>Email</th>
						<th>Buy/Sell</th>
						<th>Mod/Del</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="selected_user" items="${listUser}">

						<tr>
							<td><c:out value="${selected_user.getUserID()}" /></td>
							<td><c:out value="${selected_user.getPassword()}" /></td>
							<td><c:out value="${selected_user.getEmail()}" /></td>
							<td><c:out value="${selected_user.getType()}" /></td>

							<td><a href="<%=request.getContextPath()%>/edit?userID=<c:out value="${selected_user.getUserID()}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/delete?userID=<c:out value="${selected_user.getUserID()}" />">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>