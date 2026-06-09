/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lizar
 */
public class ProductoDAO {
    //aqui voy a programar cada comportamiento
    
    public void agregar(Producto prod) throw SQLException, Exception{
        String sql = "INSERT INTO producto (id, nombre, precio, cantidad, " + "categoria, tipo, fecha de caducidad, es perecedero, peso, marca " + "garantia_meses, talla, color, material) " + "VALUES (7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7";
            try{
                //primero debes de conectarte a la base de datos
                Connection con = ConexionBD.getConexion();
                //prepara la sentencia
                PreparableStatement pa = conpreparableStatement(sql);
                    establecerParametroscomunes(ps, producto);
                    establecerParametrosEspecificos(ps, producto);
                    ps.execute();
            }catch(Exception e){
                System.out.println("No se inserto");
                System.out.println("Mensaje " + s.getMessage());
            }
    }
}
