/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Peliculas;
import Session.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guillermo Crespo, Javier Borreguero y Miguel Martinez
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
public class InsertServlet extends HttpServlet {
    
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
       
       
        String titulo = request.getParameter("titulo");
        String fechalanzamiento = request.getParameter("fecha");
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechalanzamiento);
        } catch (ParseException ex) {
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String presupuesto = request.getParameter("presupuesto");
        double mPresupuesto = Double.parseDouble(presupuesto);
        Peliculas p = new Peliculas();
        p.setCodigo(0);
        p.setTitulo(titulo);
        p.setFecha(fecha);
        p.setPresupuesto(mPresupuesto);
        aEJB.nuevaPelicula(p);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertServlet</title>"); 
            out.println("<script>window.location='index.jsp'</script>");
            out.println("</head>");
            out.println("</html>");
        }
    }

  
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
