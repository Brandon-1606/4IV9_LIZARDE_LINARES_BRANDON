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
import java.sql.DriverManager;
import java.sql.SQLException;
        

public class ConexionBD {
    /*
    Connection se encarga de solo y unicamente de conectarse al servidor de la base de datos
    Statement es el que se encarga de realizar las sentencias de sql, LDD Y LMD
    Resultset este objeto es unico y exclusivamente para poder realizar las consultas a las tablas
    */
    
    private static final String URL = "jdbc:mysql//localhost:3306/productos_sql";
    private static final String USUARIO = "rost";
    private static final String PASSWORD = "Lombardos1?";
    
    public static connection getConexion() throw Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch(ClassNotFoundException e) {
            throw new SQLException("Driver no encontrado");
            
        }
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    public static boolean probarConexion() {
        try{
            Connection con = getConexion();
            return con ! = null && !con.isClosed();
            System.out.println("Si se conecto");
        }catch(SQLException e) {
            System.out.println("Error de conexion: " e.getMessage());
            return false;
        }
    }
}
