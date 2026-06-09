/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lizar
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DormirDAO {
    //aqui voy a programar cada comportamiento
    
    public void agregar(DORMIR dormir) throws SQLException, Exception{
        String sql = "INSERT INTO dormir (id_persona, dia, hora_dormir, hora_despertar, horas_dormidas, calidad, comentario) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try{
                //primero debes de conectarte a la base de datos
                Connection con = ConexionBD.getConexion();
                //prepara la sentencia
                PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, dormir.getIdPersona());
                    ps.setString(2, dormir.getDia());
                    ps.setString(3, dormir.getHoraDormir());
                    ps.setString(4, dormir.getHoraDespertar());
                    ps.setDouble(5, dormir.getHorasDormidas());
                    ps.setString(6, dormir.getCalidad());
                    ps.setString(7, dormir.getComentario());
                    ps.execute();
                    ps.close();
                    con.close();
            }catch(Exception e){
                System.out.println("No se inserto");
                System.out.println("Mensaje " + e.getMessage());
            }
    }

    public ArrayList<DORMIR> mostrar() throws SQLException, Exception{
        ArrayList<DORMIR> lista = new ArrayList<>();
        String sql = "SELECT d.id_dormir, d.id_persona, p.nombre, d.dia, d.hora_dormir, d.hora_despertar, d.horas_dormidas, d.calidad, d.comentario FROM dormir d INNER JOIN persona p ON d.id_persona = p.id_persona";
            try{
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    DORMIR dormir = new DORMIR();
                    dormir.setIdDormir(rs.getInt("id_dormir"));
                    dormir.setIdPersona(rs.getInt("id_persona"));
                    dormir.setNombrePersona(rs.getString("nombre"));
                    dormir.setDia(rs.getString("dia"));
                    dormir.setHoraDormir(rs.getString("hora_dormir"));
                    dormir.setHoraDespertar(rs.getString("hora_despertar"));
                    dormir.setHorasDormidas(rs.getDouble("horas_dormidas"));
                    dormir.setCalidad(rs.getString("calidad"));
                    dormir.setComentario(rs.getString("comentario"));
                    lista.add(dormir);
                }

                rs.close();
                ps.close();
                con.close();
            }catch(Exception e){
                System.out.println("No se mostro");
                System.out.println("Mensaje " + e.getMessage());
            }
        return lista;
    }

    public void actualizar(DORMIR dormir) throws SQLException, Exception{
        String sql = "UPDATE dormir SET id_persona = ?, dia = ?, hora_dormir = ?, hora_despertar = ?, horas_dormidas = ?, calidad = ?, comentario = ? WHERE id_dormir = ?";
            try{
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, dormir.getIdPersona());
                    ps.setString(2, dormir.getDia());
                    ps.setString(3, dormir.getHoraDormir());
                    ps.setString(4, dormir.getHoraDespertar());
                    ps.setDouble(5, dormir.getHorasDormidas());
                    ps.setString(6, dormir.getCalidad());
                    ps.setString(7, dormir.getComentario());
                    ps.setInt(8, dormir.getIdDormir());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
            }catch(Exception e){
                System.out.println("No se actualizo");
                System.out.println("Mensaje " + e.getMessage());
            }
    }

    public void eliminar(int idDormir) throws SQLException, Exception{
        String sql = "DELETE FROM dormir WHERE id_dormir = ?";
            try{
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, idDormir);
                    ps.executeUpdate();
                    ps.close();
                    con.close();
            }catch(Exception e){
                System.out.println("No se elimino");
                System.out.println("Mensaje " + e.getMessage());
            }
    }
}