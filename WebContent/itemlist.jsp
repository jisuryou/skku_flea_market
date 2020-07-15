<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SKKU FLEA MARKET</title>
<style>
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

.wrapper {
	display: grid;
	grid-template-columns: 20% 80%;
	padding: 30px 40px 10px 40px;
}

.category {
	/* need to implement: if the width changes, category becomes into horizontal form */
	/* by: @media (min-width: 700px){} */
	grid-column: 1/2;
	min-width: 80px;
	height: 600px;
	overflow-y: auto;
	margin-right: 20px;
	border: #FFEA97 2px solid;
	padding: 20px 10px 20px 10px;
}

.categorylist li {
	font-family: 'Source Sans Pro', sans-serif;
	font-size: 1.2rem;
	text-align: center;
	list-style: none;
	padding: 5px 2px 5px 2px;
}

/* 클릭시 하위메뉴 노출 유지: script */
.categorylist li:hover {
	background-color: #FFEA97;
	color: black;
	font-style: italic;
}

.categorylist li ol, .categorylist li ol li {
	display: none;
	list-style: none;
	text-align: center;
	background-color: #FFFFFF;
	padding-inline-start: 0;
	margin-block-end: 0;
	margin-block-start: 0;
}

.categorylist li:hover ol, .categorylist li:hover ol li {
	display: block;
}

.contents {
	grid-column: 2/3;
	display: inline;
	min-width: 750px;
	overflow-y: scroll;
	border: #FFEA97 2px solid;
}

.itemwrap {
	float: left;
	text-align: center;
	width: 220px;
	margin: 20px 10px 20px 20px;
	padding: 10px;
	border: #000000 1px solid;
}

.itemthumb img {
	width: 200px;
	height: 200px;
	overflow: hidden;
}

.itemwrap span {
	display: inline;
}

.itempic img {
	width: 400px;
	height: 400px;
	overflow: hidden;
	margin: 20px;
	display: inline;
	float: left;
}

.itemdetail {
	display: inline;
	width: auto;
	overflow-y: scroll;
	margin: 20px 50px 20px 0;
}

.itemdetail .group {
	margin: 50px 20px 40px 20px;
	width: inherit;
}

.groupname {
	text-align: left;
	font-size: 0.9rem;
}

.groupdetail {
	text-align: right;
	font-size: 1.2rem;
}

.itemcomment {
	display: block;
	margin: 20px;
	text-align: center;
}

.itemcommenttext {
	margin: 20px;
}

.commentlist {
	
}

/* Scroll style */
::-webkit-scrollbar {
	width: 5px;
	/* 세로축 스크롤바 길이 */
}

::-webkit-scrollbar-track {
	background-color: #FFFFFF;
}

::-webkit-scrollbar-track-piece {
	background-color: #FFFFFF;
}

::-webkit-scrollbar-thumb {
	border-radius: 8px;
	background-color: #FFEA97;
}

::-webkit-scrollbar-button {
	background-color: #FFEA97;
	width: 10px;
	height: 5px;
}

::-webkit-scrollbar-button:start {
	background-color: #ffffff;
	/* Top, Left 방향의 이동버튼 */
}

::-webkit-scrollbar-button:end {
	background-color: #ffffff;
	/* Bottom, Right 방향의 이동버튼 */
}

::-webkit-scrollbar-corner {
	background-color: #FFEA97;
	/* 우측 하단의 코너 부분 */
}

::-webkit-resizer {
	background-color: #FFEA97;
}
</style>
<link rel="stylesheet" type="text/html" href="../css/style.css">
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
	<div class="wrapper">
		<div class="category">
			<ul class="categorylist">
				<li><a href="Servlet?command=category&category=<%="Bathroom"%>">Bathroom</a></li>
				<li><a href="Servlet?command=category&category=<%="Books"%>">Books</a></li>
				<li><a
					href="Servlet?command=category&category=<%="Computers"%>">Computers</a></li>
				<li><a
					href="Servlet?command=category&category=<%="Electronics"%>">Electronics</a></li>
				<li><a href="Servlet?command=category&category=<%="Fashion"%>">Fashion</a></li>
				<li><a
					href="Servlet?command=category&category=<%="Furnitures"%>">Furnitures</a></li>
				<li><a href="Servlet?command=category&category=<%="Health"%>">Health</a></li>
				<li><a
					href="Servlet?command=category&category=<%="Industrial"%>">Industrial</a></li>
				<li><a href="Servlet?command=category&category=<%="Kitchen"%>">Kitchen</a></li>
				<li><a
					href="Servlet?command=category&category=<%="Pet Supplies"%>">Pet
						Supplies</a></li>
				<li><a href="Servlet?command=category&category=<%="Software"%>">Software</a></li>
				<li><a
					href="Servlet?command=category&category=<%="Sports & Outdoors"%>">Sports
						& Outdoors</a></li>
				<li><a href="Servlet?command=category&category=<%="Tools"%>">Tools</a></li>
			</ul>
		</div>
	</div>
	<div class="contents">
		<c:forEach items="${products}" var="product">
			<a href="Servlet?command=product&id=${product.getID()}">
				<div class="itemwrap">

					<div class="itemthumb">
						<!--상품 이미지 썸네일-->
						<img src="../images/${product.getImg()}" />
					</div>
					<div class="itemname">
						<!--[판매/경매]상품 이름-->
						<h3>${product.getName()}</h3>
					</div>
					<div class="itemprice">
						<!--상품 가격, 경매의 경우 최고입찰가-->
						<p>${product.getPrice()}</p>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</body>
</html>