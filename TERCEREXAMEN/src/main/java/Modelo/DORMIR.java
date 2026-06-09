/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lizar
 */
public class DORMIR {
    private int idDormir;
    private int idPersona;
    private String nombrePersona;
    private String dia;
    private String horaDormir;
    private String horaDespertar;
    private double horasDormidas;
    private String calidad;
    private String comentario;
    
    public DORMIR(){
        this.idDormir = 0;
        this.idPersona = 0;
        this.nombrePersona = "";
        this.dia = "";
        this.horaDormir = "";
        this.horaDespertar = "";
        this.horasDormidas = 0.0;
        this.calidad = "";
        this.comentario = "";
    }

    public int getIdDormir() {
        return idDormir;
    }

    public void setIdDormir(int idDormir) {
        this.idDormir = idDormir;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraDormir() {
        return horaDormir;
    }

    public void setHoraDormir(String horaDormir) {
        this.horaDormir = horaDormir;
    }

    public String getHoraDespertar() {
        return horaDespertar;
    }

    public void setHoraDespertar(String horaDespertar) {
        this.horaDespertar = horaDespertar;
    }

    public double getHorasDormidas() {
        return horasDormidas;
    }

    public void setHorasDormidas(double horasDormidas) {
        this.horasDormidas = horasDormidas;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
