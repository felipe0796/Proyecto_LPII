<jsp:include page="menuIndex.jsp"/>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>LOGIN UNSLG</title>
<link rel="shortcut icon" type="image/png" href="Imagenes/imgIndex/icono.png"/>
<link rel="stylesheet" type="text/css" href="CSS/estiloLogin.css">
<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<c:if test="${requestScope.MENSAJE!=null}">
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
		  <strong>${requestScope.MENSAJE}</strong>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		  </button>
		</div>
	  </c:if>
	<img class="wave" src="Imagenes/imgLogin/fondoLogin.png">
	<div class="container">
		<div class="img">
			<img src="Imagenes/imgLogin/loginSO.png">
		</div>
		<div class="login-content">
			<form action="ServletUsuario?accion=INICIAR" method="post">
				<img src="Imagenes/imgLogin/loginUSUARIO.png">
				<h2 class="title">Bienvenido a UNSLG</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>USUARIO</h5>
           		   		<input type="text" class="input" name="login">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>CONTRASEÑA</h5>
           		    	<input type="password" class="input" name="clave">
            	   </div>
            	</div>
            	<a href="#">OLVIDASTE TU CONTRASEÑA?</a>
            	<input type="submit" class="btn">
            </form>
        </div>
    </div>
    <script type="text/javascript" src="JS/login.js"></script>
    
</body>
</html>