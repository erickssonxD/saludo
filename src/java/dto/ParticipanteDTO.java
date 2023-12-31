/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Erick
 */
public class ParticipanteDTO {
    private int id, distancia;
    private String nombre, sexo, categoria;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(int id, String nombre, String sexo, int distancia, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.distancia = distancia;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ParticipanteDTO{" + "id=" + id + ", distancia=" + distancia + ", nombre=" + nombre + ", sexo=" + sexo + ", categoria=" + categoria + "}";
    }
}
