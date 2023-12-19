
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

    private ArrayList<Birth> births;

    public Registro() {
        births = new ArrayList<>();
    }

    public boolean addBirth(Birth n) {
        return births.add(n);
    }

    public boolean removeBirthByID(int id) {
        for (int i = 0; i < births.size(); i++) {
            if (births.get(i).getId() == id) {
                births.remove(i);
                return true; // Removed the Birth with the specified ID
            }
        }
        return false; // Birth with the specified ID was not found
    }

    public ArrayList<Birth> getBirths() {
        return births;
    }
}
