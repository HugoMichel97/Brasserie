<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="css/style_temp.css">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="icon" href="img/logo_onglet.JPG">
</head>


<!-- <header>
	<img src="img/banniere.png" alt="bannière"> <a href="index.jsp"><div
			id="logo"></div></a>
</header> -->

<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div>

						<ul>
							<div>
								<input type="date" id="start" name="trip-start"
									value="2022-03-11" min="2022-01-01" max="2024-12-31">
							</div>
						</ul>

						<marquee behavior="scroll" scrollamount="6">Evenements à
							venir : Vendredi 18 mars 2022, fête de la bière ! Rdv au parc des
							Expositions à partir de 18H </marquee>


					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="header__top__right">
						<div class="header__top__right__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a> <a href="#"><i
								class="fa fa-pinterest-p"></i></a>
						</div>
						<div class="header__top__right__language">
							<div>Français</div>
							<span class="arrow_carrot-down"></span>
							<ul>
								<li><a href="#">Español</a></li>
								<li><a href="#">English</a></li>
							</ul>
						</div>
						<div class="header__top__right__auth">
							<a href="connexion.jsp"><i class="fa fa-user"></i> Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="index.jsp"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-8">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="index.jsp">Accueil</a></li>
						<li><a href="./shop-grid.html">Nos Bières</a></li>
						<li><a href="#">Snacking</a>
							<ul class="header__menu__dropdown">
								<li><a href="./shop-details.html">Fruits secs</a></li>
								<li><a href="./shoping-cart.html">Biscuits apéritifs</a></li>
								<li><a href="./checkout.html">Charcuterie</a></li>
								<li><a href="./blog-details.html">Légumes à croquer</a></li>
							</ul></li>
						<li><a href="./blog.html">Actualités</a></li>
						<li><a href="./contact.html">Qui sommes nous</a></li>

					</ul>
				</nav>
			</div>
			<div class="col-lg-1">
				<div class="header__cart">
					<ul>

						<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>2</span></a></li>
					</ul>
					<div class="header__cart__price">
						<span>€35.24</span>
					</div>
				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
