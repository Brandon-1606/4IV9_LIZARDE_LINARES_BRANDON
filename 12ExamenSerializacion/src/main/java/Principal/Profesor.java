/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author lizar
 */
import java.io.Serializable;

public class Profesor extends Persona implements Serializable {
    private String numeroEmpleado;

    public Profesor() {}

    public Profesor(int id, String nombre, int edad, String numeroEmpleado) {
        super(id, nombre, edad);
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() { return numeroEmpleado; }
    public void setNumeroEmpleado(String numeroEmpleado) { this.numeroEmpleado = numeroEmpleado; }
}
