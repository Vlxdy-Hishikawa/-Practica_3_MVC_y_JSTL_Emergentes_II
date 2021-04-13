<%-- 
    Document   : Index
    Created on : 10-abr-2021, 16:05:19
    Author     : Vlxdy Hishikawa
--%>
<%@page import="com.Vlxdy.modelo.Productos"%>
<%@page import="com.Vlxdy.modelo.GestorProductos"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (session.getAttribute("stock") == null){
        GestorProductos objeto1 = new GestorProductos(); 
        objeto1.insertarProductos(new Productos(1, "COCACOLA",8.5,100));
        objeto1.insertarProductos(new Productos(2, "PEPSI", 11.0,50));
        objeto1.insertarProductos(new Productos(3, "FRACK",6.0,100));
        objeto1.insertarProductos(new Productos(4, "SERRANITAS",2.5,80));
        session.setAttribute("stock", objeto1);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logo.png">
        <title> PRACTICA 3 </title>
    </head>
    <style>
        body {
  		background-image: linear-gradient(
     		rgba(0, 0, 0, 0.6),
     		rgba(0, 0, 0, 0.6)
   			), url("Fondo.png");
  			background-repeat: no-repeat;
 			background-attachment: fixed;
  			background-size: 100% 100%;
  			padding: 20px;
  			background-color:#dbffcc;
            }
        #heading { color: #fff; }
	a,h1,h2,h4,li{
		color: white;
                }
        b{
	   color: yellow;
        }
        table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        }
        th {
          border: 1px solid white;
          background-color:black;
          color: white;
          text-align: left;
          padding: 8px;
        }

        td {
          border: 1px solid black;
          text-align: left;
          padding: 8px;
        }

        tr:nth-child(odd) {
          background-color: #dddddd;
        }
        tr:nth-child(even) {
          background-color: white;
          color:black;
        }
    </style>
    <body>
        <h1 align="center"> LISTADO DE PRODUCTOS </h1>
        <a href="Controller?op=nuevo" > NUEVO </a>
        <br><br>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>PRODUCTO</th>
                <th>PRECIO</th>
                <th>CANTIDAD</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.stock.getLista()}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.producto}</td>
                    <td>${item.precio}</td>
                    <td>${item.cantidad}</td>
                    <td><a style="color:blue;" href="Controller?op=modificar&id=${item.id}">MODIFICAR</a></td>
                    <td><a style="color:red;" href="Controller?op=eliminar&id=${item.id}">ELIMINAR</a></td>
                </tr>
            </c:forEach>
        </table>
    <footer>
        <p><br><br>
            <h3 id="heading" align="center">DEVELOPED &#x1F497; by <a style="color:yellow;" ><strong>VLADIMIR HUANCA</strong></a></h3>
        </p>
    </footer>
    </body>
</html>
