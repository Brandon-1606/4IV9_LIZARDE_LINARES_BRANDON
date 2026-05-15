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

public class Estudiante extends Persona implements Serializable {
    private String boleta;
    private double promedio;

    public Estudiante() {}

    public Estudiante(int id, String nombre, int edad, String boleta, double promedio) {
        super(id, nombre, edad);
        this.boleta = boleta;
        this.promedio = promedio;
    }

    public String getBoleta() { return boleta; }
    public void setBoleta(String boleta) { this.boleta = boleta; }
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
}