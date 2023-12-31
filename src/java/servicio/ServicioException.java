package servicio;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServicioException extends Exception {
    public ServicioException(String s) {
        super(s);
    }
}
