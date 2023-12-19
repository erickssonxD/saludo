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
import modelo.Birth;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
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

        String responseText = "";
        
        String responseID = "", responseName = "", responseWeight = "", responsePremature = "", responseSex = "", responseCenter = "";

        String idString = request.getParameter("id");
        int id = 0;
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String prematureString = request.getParameter("premature");
        boolean premature = false;
        String sexString = request.getParameter("sex");
        char sex = ' ';
        String centerString = request.getParameter("center");
        int center = 0;

        boolean allInputSanitized = true;

        if (idString.isEmpty() || !isNumeric(idString)) {
            responseID = "Debe ingresar id";
            allInputSanitized = false;
        } else {
            id = Integer.parseInt(idString);
            request.setAttribute("id", idString);
        }
        if (name.isEmpty()) {
            responseName = "Debe ingresar nombre";
            allInputSanitized = false;
        } else {
            request.setAttribute("name", name);
        }
        if (weight.isEmpty()) {
            responseWeight = "Debe ingresar peso";
            allInputSanitized = false;
        } else {
            request.setAttribute("weight", weight);
        }
        if (!isBoolean(prematureString)) {
            responsePremature = "Debe ingresar prematuro";
            allInputSanitized = false;
        } else {
            premature = prematureString.equals("true");
            request.setAttribute("premature", prematureString);
        }
        if (!isChar(sexString)) {
            responseSex = "Debe ingresar sexo";
            allInputSanitized = false;
        } else {
            sex = sexString.charAt(0);
            request.setAttribute("sex", sexString);
        }
        if (!isNumeric(centerString)) {
            responseCenter = "Debe ingresar centro";
            allInputSanitized = false;
        } else {
            center = Integer.parseInt(centerString);
            System.out.println("center" + center);
            request.setAttribute("center", centerString);
        }

        if (!allInputSanitized) {
            request.setAttribute("responseID", responseID);
            request.setAttribute("responseName", responseName);
            request.setAttribute("responseWeight", responseWeight);
            request.setAttribute("responsePremature", responsePremature);
            request.setAttribute("responseSex", responseSex);
            request.setAttribute("responseCenter", responseCenter);

            responseText = "Hay errores en el input";
            request.setAttribute("responseText", responseText);
            RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
            despachador.forward(request, response);

            return;
        }

        Birth birth = new Birth(
                id,
                name,
                weight,
                new Date(),
                premature,
                sex,
                center
        );

        ServletContext application = request.getServletContext();
        Registro registroApp = (Registro) application.getAttribute("registro");
        if (registroApp == null) {
            registroApp = new Registro();
            application.setAttribute("registro", registroApp);
        }
        registroApp.addBirth(birth);

        responseText = "Se ha registrado el nacimiento correctamente";
        request.setAttribute("responseText", responseText);
        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
        despachador.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isNumeric(String str) {
        System.out.println("numeric" + str);
        return str != null && str.matches("[0-9.]+");
    }
    
    private boolean isBoolean(String str) {
        return str != null && str.matches("[true|false]+");
    }

    private boolean isChar(String str) {
        return str != null && str.matches("[M|F]+");
    }

}
