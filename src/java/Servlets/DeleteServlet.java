/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Session.Session;
import Modelo.Peliculas;

/**
 *
 * @author Guillermo Crespo, Javier Borreguero y Miguel Martinez
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

    @EJB
    Session aEJB;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        try (PrintWriter out = response.getWriter()) {

            if (request.getParameter("nombre") == null) {

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet DeleteServlet</title>");
                out.println("<body>");
                out.println("<form action='DeleteServlet' method='POST'>Escoga una pelicula y presiona el botón para eliminar un actor.");
                out.println("<input type='submit' name='eliminar' value='Eliminar'/><br><br>");
                List<Peliculas> l = aEJB.allPeliculas();
                /* bucle para recorrer la lista que corresponda */
                for (int i = 0; i < l.size(); i++) {
                    out.println("<input type='radio' name= 'titulo' value=" + l.get(i).getCodigo() + ">" + l.get(i).getTitulo() + "<br>");

                }

                out.println("</form>");
                out.println("</body>");
                out.println("</head>");
                out.println("</html>");
            } else {
                String valueRadio = request.getParameter("titulo");
                int parse_codigo = Integer.parseInt(valueRadio);
                aEJB.borrarPelicula(parse_codigo);
                
                out.println("<script>window.location='index.jsp'</script>");
            }
        }
    }
 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

