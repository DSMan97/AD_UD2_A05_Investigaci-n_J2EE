<%-- 
    Document   : index
    Created on : 06-nov-2018, 11:55:58
    Author     : DSMan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h1>Peliculas. Obtiene todas las Peliculas con EJB </h1>
        <form action="SelectServlet" method="POST">Presiona el botón para obtener los datos.
            <input type="submit" name="enviar" value="Listado"/>
        </form>
        </br>
        <form action="InsertServlet" method="POST">Presiona el botón para añadir un actor.
            <input type="submit" name="agregar" value="Insertar"/><br><br>
            Titulo<br>
            <input type="text" name="nombre"/><br>
            </br>Fecha de lanzamiento:<br>
            <input type="text" name="fnacimiento"/><br>
            </br>Presupuesto:<br>
            <input type="text" name="nacionalidad"/><br><br>
        </form>
        <a href="http://localhost:8080/EJBAcceso/DeleteServlet">Eliminar</a><br>
        <form action="SearchServlet" method="POST">Presiona el botón para buscar un actor segun su Codigo.
            <input type="submit" name="buscar" value="Buscar"/><br><br>
            Codigo:<br>
            <input type="text" name="codigo"/><br>
            <br>
        </form>
        <a href="http://localhost:8080/EJBAcceso/UpdateServlet">Modificar</a><br>
        </br>
    </body>
</html>