<link rel="stylesheet" type="text/html" href="../css/style.css">
<style>
@charset "UTF-8";

/* main colors: #CDD183 #FFEA97 #FFD595 #FFBD98 #FFA29D
title font: 'Bebas Neue', cursive */
.body {
	color: grey;
}

.input {
	border: 0px;
	outline: none;
	margin: 1px 1px 2px 2px;
}

.a {
	color: inherit;
	text-decoration: none;
}

.titlewrapper {
	/* includes title text and login & signup buttons */
	text-align: center;
}

.headertitle {
	/* page top, title text */
	font-family: 'Bebas Neue', cursive;
	display: block;
	text-align: center;
	margin: 2rem;
	margin-top: 1.3rem;
	color: #CDD183;
	font-size: 3rem;
}

.headerlogin {
	float: right;
	margin: 3px 4px 0 0;
}

.button {
	font-family: 'Bebas Neue';
	margin-right: 2px;
	background-color: inherit;
	border: #CDD183 1px solid;
	border-radius: 8px;
	color: #CDD183;
	font-size: 0.9rem;
	padding: 3px 5px 3px 5px;
}

.headersearch {
	/* search div in the header, including search box and button */
	text-align: center;
}

.headersearchform {
	/* includes search box and button */
	width: 40%;
	display: inline-block;
	text-align: center;
	border: #FFEA97 2px solid;
	border-radius: 15px;
	padding: 2px 2px 2px 2px;
}

.searchinput {
	width: 80%;
	font-size: 2rem;
	color: grey;
}

.searchbutton {
	border: 0px;
	background-color: inherit;
	color: #FFD595;
}
</style>
<%@page import="skku_flea_market.model.User"%>
<%
	User user = (User) request.getAttribute("user");
	User selected_user = (User) request.getAttribute("selected_user");
	session.setAttribute("user", user);
	session.setAttribute("selected_user", selected_user);
%>

<header>
	<nav class="titlewrapper">
		<div class="headerlogin">
			<%
				if (user == null) {
			%>

			<a href="login&register.jsp" class="button">Login / Signup</a>
			<%
				} else if (user.getType() == "ADMINISTRATOR") {
			%>

			<a href="<%=request.getContextPath()%>/list" class="button">Manage</a>
			<a href="<%=request.getContextPath()%>/logout" class="button">Logout</a>
			<h2>
				Hello,
				<%=user.getUserID()%></h2>
			<%
				} else if (user.getType() == "BUYER") {
			%>

			<a href="<%=request.getContextPath()%>/mypage" class="button">Mypage</a>
			<a href="<%=request.getContextPath()%>/logout" class="button">Logout</a>
			<h2>
				Hello,
				<%=user.getUserID()%></h2>
			<%
				} else {
			%>

			<a href="<%=request.getContextPath()%>/mypage" class="button">Mypage</a>
			<a href="product_sell.jsp" class="button">Sell</a> <a
				href="<%=request.getContextPath()%>/logout" class="button">Logout</a>
			<h2>
				Hello,
				<%=user.getUserID()%></h2>
			<%
				}
			%>
		</div>

		<div class="headertitle">
			<a href="Servlet?command=home"> SKKU FLEA MARKET </a>
		</div>

		<div class="headersearch">
			<form class="headersearchform" action="search" method="get">
				<input type="text" class="searchinput" name="search_word">
				<button class="searchbutton">
					<i class="fas fa-search fa-2x"></i>
				</button>
			</form>
		</div>
	</nav>
</header>

