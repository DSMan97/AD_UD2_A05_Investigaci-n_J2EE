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
        <form action="Servlet" method="POST">Presiona el botón para obtener los datos.
            <input type="submit" name="enviar" value="Listado"/>
        </form>
        </br>
        <form action="InsertServlet" method="POST">
            <input type="submit" name="agregar" value="Insertar"/><br><br>
            Titulo<br>
            <input type="text" name="titulo"/><br>
            </br>Fecha de lanzamiento:<br>
            <input type="text" name="fecha"/><br>
            </br>Presupuesto:<br>
            <input type="text" name="presupuesto"/><br><br>
        </form>Presiona el botón para añadir una Pelicula.
        <br><br>
         <form action="DeleteServlet" method="POST">
            <input type="submit" name="agregar" value="Eliminar"/><br><br>
            
        </form>Presiona el botón para eliminar una Pelicula.

        <form action="SearchServlet" method="POST">Presiona el botón para buscar una pelicula segun su Nombre.
            <input type="submit" name="buscar" value="Buscar"/><br><br>
            Nombre:<br>
            <input type="text" name="nombre"/><br>
            <br>
        </form>
         <form action="UpdateServlet" method="POST">Presiona el botón para actualizar una pelicula segun su Nombre.
            <input type="submit" name="buscar" value="Ir"/><br><br>
            Nombre de la pelicula a Actualizar:<br>
            <input type="text" name="nombre"/><br>
            <br>
        </form>
     
        </br>
    </body>
</html>