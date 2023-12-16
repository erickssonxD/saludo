
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
    private ArrayList<Births> births;

    public Registro() {
        births = new ArrayList<Births>();
    }

    public boolean addBirth(Births n) {
        return births.add(n);
    }

    public ArrayList<Births> getBirths() {
        return births;
    }
}
