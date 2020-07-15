<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SKKU FLEA MARKET - LOGIN</title>
<style>
@charset "UTF-8";

.titlewrapper {
	/* includes title text and login & signup buttons */
	text-align: center;
}

.headertitle {
	/* page top, title text */
	display: block;
	text-align: center;
	margin: 3.2rem;
	color: #CDD183;
	font-family: 'Bebas Neue', cursive;
	font-size: 3rem;
}

input {
	border: 0px;
	outline: none;
}

/* below referenced: T.A lecture login page practice code */
body {
	color: #ffffff;
	font-family: 'Bebas Neue', cursive;
}

*, :after, :before {
	box-sizing: border-box;
}

.clearfix:after, .clearfix:before {
	content: '';
	display: table;
}

.clearfix:after {
	clear: both;
	display: block;
}

a {
	color: inherit;
	text-decoration: none;
}

.login-wrap {
	width: 100%;
	margin: auto;
	max-width: 525px;
	min-height: 670px;
	position: relative;
}

.login-html {
	width: 100%;
	height: 100%;
	position: absolute;
	padding: 90px 70px 50px 70px;
	background: rgba(255, 189, 152, 0.4);
}

.login-html .sign-in-htm, .login-html .sign-up-htm {
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	position: absolute;
	transform: rotateY(90deg);
	backface-visibility: hidden;
	transition: all .3s linear;
}

.login-html .sign-in, .login-html .sign-up, .login-form .group .check {
	display: none;
}

input[type="radio"] {
	display: none;
}

input[type="radio"]+label span {
	width: 15px;
	height: 15px;
	margin-right: 5px;
	border-radius: 2px;
	position: relative;
	display: inline-block;
	background: rgba(255, 189, 152, 0.2);
}

input[type="radio"]:checked+label span {
	transition: all .2s ease-in-out 0s;
	background: rgba(255, 189, 152);
}

.login-html .tab, .login-form .group .label, .login-form .group .button
	{
	text-transform: uppercase;
}

.login-html .tab {
	font-size: 22px;
	margin-right: 15px;
	padding-bottom: 5px;
	margin: 0 15px 10px 0;
	display: inline-block;
	border-bottom: 2px solid transparent;
}

.login-html .sign-in:checked+.tab, .login-html .sign-up:checked+.tab {
	color: #FFA29D;
	border-color: #FFA29D;
}

.login-form {
	min-height: 345px;
	position: relative;
	perspective: 1000px;
	transform-style: preserve-3d;
}

.login-form .group {
	margin-bottom: 15px;
}

.login-form .group .label, .login-form .group .input, .login-form .group .button
	{
	width: 100%;
	color: #ffffff;
	display: block;
}

.login-form .group .input, .login-form .group .button {
	border: none;
	padding: 15px 20px;
	border-radius: 25px;
	background: rgba(255, 189, 152, 0.2);
}

.login-form .group input[data-type="password"] {
	text-security: circle;
	-webkit-text-security: circle;
}

.login-form .group .label {
	font-size: 1rem;
}

.login-form .group .button {
	background: rgba(255, 162, 157, 0.6);
}

.login-form .group label .icon {
	width: 15px;
	height: 15px;
	margin-right: 5px;
	border-radius: 2px;
	position: relative;
	display: inline-block;
	background: rgba(255, 189, 152, 0.2);
}

.login-form .group label .icon:before, .login-form .group label .icon:after
	{
	content: '';
	width: 10px;
	height: 2px;
	background: #fff;
	position: absolute;
	transition: all .2s ease-in-out 0s;
}

.login-form .group label .icon:before {
	left: 3px;
	width: 5px;
	bottom: 6px;
	transform: scale(0) rotate(0);
}

.login-form .group label .icon:after {
	top: 6px;
	right: 0;
	transform: scale(0) rotate(0);
}

.login-form .group .check:checked+label {
	color: #fff;
}

.login-form .group .check:checked+label .icon {
	background: rgba(255, 189, 152);
}

.login-form .group .check:checked+label .icon:before {
	transform: scale(1) rotate(45deg);
}

.login-form .group .check:checked+label .icon:after {
	transform: scale(1) rotate(-45deg);
}

.login-html .sign-in:checked+.tab+.sign-up+.tab+.login-form .sign-in-htm
	{
	transform: rotate(0);
}

.login-html .sign-up:checked+.tab+.login-form .sign-up-htm {
	transform: rotate(0);
}

.login-form .group .button:hover {
	transition: all .2s ease-in-out 0s;
	background-color: rgba(255, 162, 157);
}

.hr {
	height: 2px;
	margin: 60px 0 50px 0;
	background: rgba(255, 189, 152, 0.2);
}

.foot-lnk {
	text-align: center;
}
</style>
<link
	href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap"
	rel="stylesheet">
</head>
<body>
	<header>
		<nav class="titlewrapper">
			<div class="headertitle">
				<a href="Servlet?command=home"> SKKU FLEA MARKET </a>
			</div>
		</nav>
	</header>

	<div class="login-wrap">

		<div class="alert alert-success center" role="alert">
			<p>${NOTIFICATION}</p>
		</div>

		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
				for="tab-1" class="tab">Sign In</label> <input id="tab-2"
				type="radio" name="tab" class="sign-up"><label for="tab-2"
				class="tab">Sign Up</label>
			<div class="login-form">
				<form class="sign-in-htm" action="login" method="post">
					<div class="group">
						<label for="user" class="label">ID</label> <input id="user"
							name="user_login_id" type="text" class="input" required>
					</div>
					<div class="group">
						<label for="pass" class="label">Password</label> <input id="pass"
							name="user_login_pw" type="password" class="input"
							data-type="password" required>
					</div>
					<div class="group">
						<input id="check" type="checkbox" class="check" checked> <label
							for="check"><span class="icon"></span>Keep me Signed in</label>
					</div>
					<div class="group">
						<input type="submit" class="button" name="action" value="Sign In">
					</div>
					<div class="hr"></div>
					<div class="foot-lnk">
						<a href="#forgot">forgot password?</a>
					</div>
				</form>
				<form class="sign-up-htm" action="register" method="post">
					<div class="group">
						<label for="user" class="label">ID</label> <input id="user"
							name="user_register_id" type="text" class="input" required>
					</div>
					<div class="group">
						<label for="pass" class="label">Password</label> <input id="pass"
							name="user_register_pw" type="password" class="input"
							data-type="password" required>
					</div>
					<div class="group">
						<label for="pass" class="label">Repeat Password</label> <input
							id="pass" name="user_register_pwc" type="password" class="input"
							data-type="password" required>
					</div>
					<div class="group">
						<label for="pass" class="label">Email Address</label> <input
							id="pass" name="user_register_email" type="email" class="input"
							required>
					</div>
					<div class="group">
						<input id="signupcheck1" type="radio" name="signupcheck"
							value="BUYER" checked> <label for="signupcheck1"><span
							class="upcheck"></span>BUYER</label> <input id="signupcheck2"
							type="radio" name="signupcheck" value="SELLER"> <label
							for="signupcheck2"><span class="upcheck"></span>SELLER</label>
					</div>
					<div class="group">
						<input type="submit" class="button" name="action" value="Sign Up">
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>