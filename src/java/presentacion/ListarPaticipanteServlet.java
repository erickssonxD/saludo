package presentacion;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import servicio.MaratonService;

public class ListarPaticipanteServlet extends HttpServlet {

    @EJB
    private MaratonService service;
}
