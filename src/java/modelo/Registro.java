
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class Registro implements Serializable {
    private ArrayList<Mensaje> lstMensajes;

    public Registro() {
        lstMensajes = new ArrayList<Mensaje>();
    }

    public void agregarMensaje(Mensaje mensaje) {
        lstMensajes.add(mensaje);
    }

    public ArrayList<Mensaje> getLstMensajes() {
        return lstMensajes;
    }
}
