/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.Date;
import modelo.Nacimiento;
import modelo.Registro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erick
 */
public class PruebaText {
    private Registro registro = new Registro();
    private Nacimiento mensaje = new Nacimiento();
    public PruebaText() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mensaje.setTexto("mensaje 1");
        mensaje.setFecha(new Date());
        registro.agregarMensaje(mensaje);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void validarNulo() {
        assertNotNull("Valor nulo", mensaje.getTexto());
    }

    @Test
    public void validarBoolean() {
        mensaje.setTexto("mensaje 2");
        boolean valida = registro.agregarMensaje(mensaje);
        assertTrue(valida);
    }
}
