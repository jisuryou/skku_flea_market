<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SKKU FLEA MARKET - User Management</title>
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
				<form action="update" method="post">
					<caption>
						<h2>Edit User</h2>
					</caption>

					<fieldset class="form-group">
						<label>User ID</label> <input type="text"
							value="<c:out value='${selected_user.getUserID()}' />"
							class="form-control" name="userID" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>User Password</label> <input type="text"
							value="<c:out value='${selected_user.getPassword()}' />"
							class="form-control" name="userPW">
					</fieldset>

					<fieldset class="form-group">
						<label>User Email</label> <input type="text"
							value="<c:out value='${selected_user.getEmail()}' />" class="form-control"
							name="user_email">
					</fieldset>

					<fieldset class="form-group">
						<label>User Type</label> <input type="text"
							value="<c:out value='${selected_user.getType()}' />" class="form-control"
							name="user_type">

					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>