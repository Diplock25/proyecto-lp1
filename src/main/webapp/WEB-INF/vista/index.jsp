<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="" rel=""/>

</head>
<body>
	<div class="container">
			<header>
				<a> <img id="logo" src="../images/logo.jpg" alt="logo" />
					LaptoTech
				</a>

				<nav>
					<a href="./pages/index.html">Inicio</a> <a
						href="./pages/productos.html">Productos</a> <a
						href="./pages/servicio.html">Servicios</a> <a
						href="./pages/soporte.html">Soporte</a>
				</nav>

			</header>
			<h2 id="subtitle">Explora nuestras gamas de productos</h2>

			<section class="gamas">
				<%
				for (int i = 0; i < 4; i++) {
				%>
				<section class="gama">
					<figure>
						<img src="./static/laptop.webp" alt="Camiseta roja" height="100" width="150">
						<figcaption>Laptop</figcaption>
					</figure>

					<div class="informacion-producto">
						<p class="descripcion">Laptop intel core i9 pantalla HD...</p>

						<div class="precio">
							<span class="precio-actual">Precio actual: $19.99</span>
						</div>

						<button class="boton-comprar">Añadir al carrito</button>
					</div>
				</section>


				<%
				}
				%>
			</section>

			<main>
				<h1>"No dejes para mañana lo que puedes comprar hoy"</h1>

				<section class="contenedorDescuentos">
					<p class="descuento">
						¡Hasta <strong>30%</strong> de descuento en todos nuestros
						productos, sólo en pedidos online!
					</p>

					<a class="enlaceProducto" href="../pages/productos.html">Ver
						productos</a>
				</section>

				<h2 class="subtitulo">Nuestros Productos más populares</h2>

				<section class="section-products" 
					style="display: grid;
					grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
					gap: 2.5em;" >
					
					<%
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
					%>
					<div class="card" >
						<img src="./static/laptop2.png" class="card-img-top" alt="laptop">

						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
					</div>


					<%
						}
					}
					%>
				</section>

				<section>
					<img id="banner2" src="../images/baner2.jpg" alt="banner" />
				</section>
			</main>

			<footer>
				<img id="logo-footer" src="../images/logo.jpg" alt="logo" />

				<section>
					<article>
						<h3>Sobre nuestros Servicios</h3>
						<ul>
							<li><a href="../pages/servicios.html">Servicio 1</a></li>
							<li><a href="../pages/servicios.html">Servicio 2</a></li>
							<li><a href="../pages/servicios.html">Servicio 3</a></li>
						</ul>
					</article>

					<article>
						<h3>Contacto y Atención al cliente</h3>
						<ul>
							<li><a href="/">WhatsApp: +51 987 654 321</a></li>
							<li><a href="/">Teléfono: (01) 456-7891</a></li>
							<li><a href="/">Correo: soporte@power.pe</a></li>
						</ul>
					</article>

					<article>
						<h3>Políticas y Términos</h3>
						<ul>
							<li><a href="/">Términos y condiciones</a></li>
							<li><a href="/">Políticas de privacidad</a></li>
							<li><a href="/">Información sobre derechos</a></li>
						</ul>
					</article>
				</section>

				<p>Power Parts. Todos los derechos reservados.</p>
			</footer>
	</div>

</body>
</html>