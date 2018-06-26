<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Grayscale - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="../layout/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../layout/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="../layout/css/grayscale.css" rel="stylesheet">
    <link href="../layout/css/style.css" rel="stylesheet">
    
  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Riscos e Vulnerabilidades</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<c:url value='index'/>">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#clientes">Clientes</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#usuarios">Usuarios</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Section Clientes -->
    <section id="clientes" class="section section-clientes">

        <div class="div-clientes">

            <h2>Clientes</h2>

            <div class="row clientes">

				<c:forEach var="cliente" items="${clienteList}">
	                <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
	                    <div class="card h-100 cartao">
	                        <a href="#"><img class="card-img-top" src="${cliente.foto}" alt=""></a>
	                        <div class="card-body">
	                            <h4 class="card-title">
	                                <a href="#">${cliente.nome}</a>
	                            </h4>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>

            </div>
        </div>
    </section>

    <!-- Section usuarios -->
    <c:if test="${not empty usuarioList}">
	    <section id="usuarios" class="section section-usuarios">
	         <div class="div-clientes">
	
	            <h2>Usuarios</h2>
	            
	
	
	            <table style="width:60%" class="table">
	                <thead>
	                    <tr>
	                        <th scope="col">#</th>
	                        <th scope="col">Nome</th>
	                        <th scope="col">Senha</th>
	                        <th scope="col">Permissao</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<c:forEach var="usuario" items="${usuarioList}">
		                    <tr>
		                        <th scope="row">${usuario.id}</th>
		                        <td>${usuario.nome }</td>
		                        <td>${usuario.senha }</td>
		                        <td>${usuario.permissao }</td>
		                    </tr>
	                    </c:forEach>                   
	                </tbody>
	            </table>
	            
	         </div>       
    	</section>
    </c:if>
    
    
    <!-- Tabela Usuario -->
    


    <!-- Footer -->
    <footer>
      <div class="container text-center">
        <p>Copyright &copy; Your Website 2018</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../layout/vendor/jquery/jquery.min.js"></script>
    <script src="../layout/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../layout/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

    <!-- Custom scripts for this template -->
    <script src="../layout/js/grayscale.min.js"></script>

  </body>

</html>

