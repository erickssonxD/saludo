/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Mensaje;
import modelo.Registro;

/**
 *
 * @author Erick
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet", "/a/b/c.php"})
public class RegistroServlet extends HttpServlet {

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

        String name;

        name = request.getParameter("nombre");

        if (name.isEmpty()) {
            name = "";
        }

        name = name.toUpperCase();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/mensaje.jsp");

        request.setAttribute("mensaje", name);

        dispatcher.forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");

        String respuesta;

        String texto = request.getParameter("mensaje");

        if (texto.isEmpty()) {
            respuesta = "Favor, Ingrese un mensaje";
        } else {
            Mensaje msg = new Mensaje();
            msg.setTexto(texto);
            msg.setFecha(new Date());

            HttpSession session = request.getSession();
            Registro registro = (Registro) session.getAttribute("registro");
            if (registro == null) {
                registro = new Registro();
                session.setAttribute("registro", registro);
            }
            registro.agregarMensaje(msg);

            ServletContext application = request.getServletContext();
            Registro registroApp = (Registro) application.getAttribute("registro");
            if (registroApp == null) {
                registroApp = new Registro();
                application.setAttribute("registro", registroApp);
            }
            registroApp.agregarMensaje(msg);

            respuesta = "Tu mensaje se ingreso correctamente";
        }

        request.setAttribute("respuesta", respuesta);
        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
        despachador.forward(request, response);
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
