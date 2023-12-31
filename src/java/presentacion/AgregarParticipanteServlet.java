package presentacion;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

import dto.ParticipanteDTO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.MaratonService;
import servicio.ServicioException;

public class AgregarParticipanteServlet extends HttpServlet {

    @EJB
    private MaratonService service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ParticipanteDTO participante = new ParticipanteDTO();

        request.setAttribute("participante", participante);
        request.getRequestDispatcher("/participante_agregar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ParticipanteDTO participante = new ParticipanteDTO();
        Map<String, String> mapMensajes = new HashMap<>();
        String mensaje;

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id <= 0) {
                mapMensajes.put("id", "Favor, Ingrese un ID Positivo");
            } else {
                participante.setId(id);
            }
        } catch (NumberFormatException ex) {
            mapMensajes.put("id", "ID no válido: " + request.getParameter("id"));
        }

        String nombre = request.getParameter("nombre");
        if (nombre == null || nombre.trim().isEmpty()) {
            mapMensajes.put("nombre", "Favor, Ingrese Nombre");
        } else {
            participante.setNombre(nombre);
        }

        String sexo = request.getParameter("sexo");
        if (sexo == null || sexo.trim().isEmpty()) {
            mapMensajes.put("sexo", "Favor, Seleccione Sexo");
        } else {
            participante.setSexo(sexo);
        }

        try {
            int distancia = Integer.parseInt(request.getParameter("distancia"));
            if (distancia <= 0) {
                mapMensajes.put("distancia", "Favor, Ingrese Distancia Positiva");
            } else {
                participante.setDistancia(distancia);
            }
        } catch (NumberFormatException ex) {
            mapMensajes.put("distancia", "Distancia no es válida: " + request.getParameter("distancia"));
        }

        String categoria = request.getParameter("categoria");
        if (categoria == null || categoria.trim().isEmpty()) {
            mapMensajes.put("categoria", "Favor, Seleccione Categoría");
        } else {
            participante.setCategoria(categoria);
        }

        if (mapMensajes.isEmpty()) {
            try {
                service.agregarParticipante(participante);
                mensaje = "Participante agregado exitosamente";
            } catch (ServicioException ex) {
                mensaje = ex.getMessage();
            }
        } else {
            mensaje = "Favor, revise el formulario";
        }

        request.setAttribute("mapMensajes", mapMensajes);
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("participante", participante);
        request.getRequestDispatcher("/participante_agregar.jsp").forward(request, response);
    }
}
