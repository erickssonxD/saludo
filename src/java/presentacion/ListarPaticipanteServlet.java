package presentacion;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.MaratonService;

public class ListarPaticipanteServlet extends HttpServlet {

    @EJB
    private MaratonService service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        if (nombre == null || nombre.trim().isEmpty()) {
           request.setAttribute("lstParticipantes", service.buscarParticipanteTodos());
        } else {
              request.setAttribute("lstParticipantes", service.buscarParticipanteNombre(nombre));
        }

        request.setAttribute("nombre", nombre);
        request.getRequestDispatcher("/participante_listar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        service.eliminarParticipante(id);
        request.setAttribute("mensaje", "Participante eliminado");

        String nombre = request.getParameter("nombre");
        if (nombre == null || nombre.trim().isEmpty()) {
           request.setAttribute("lstParticipantes", service.buscarParticipanteTodos());
        } else {
              request.setAttribute("lstParticipantes", service.buscarParticipanteNombre(nombre));
        }
        request.setAttribute("nombre", nombre);
        request.getRequestDispatcher("/participante_listar.jsp").forward(request, response);
    }
}
