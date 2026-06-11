/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author lizar
 */
package Controlador;

import Modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void agregar(Producto producto) throws SQLException {
        String sql = "INSERT INTO producto (id, nombre, precio, cantidad, categoria, tipo, " +
                     "fecha_caducidad, es_perecedero, peso, " +
                     "marca, garantia_meses, voltaje, " +
                     "talla, color, material) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            establecerParametrosComunes(ps, producto);
            establecerParametrosEspecificos(ps, producto);
            ps.executeUpdate();
        }
    }

    public Producto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM producto WHERE id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirProductoDesdeResultSet(rs);
                }
            }
        }

        return null;
    }

    public List<Producto> listarTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(construirProductoDesdeResultSet(rs));
            }
        }

        return productos;
    }

    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, cantidad = ?, " +
                     "categoria = ?, tipo = ?, fecha_caducidad = ?, es_perecedero = ?, " +
                     "peso = ?, marca = ?, garantia_meses = ?, voltaje = ?, " +
                     "talla = ?, color = ?, material = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());
            ps.setString(4, producto.getCategoria());

            if (producto instanceof Alimento) {
                Alimento a = (Alimento) producto;

                ps.setString(5, "ALIMENTO");
                ps.setString(6, a.getFechaCaducidad());
                ps.setBoolean(7, a.isEsPerecedero());
                ps.setDouble(8, a.getPeso());
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.INTEGER);
                ps.setNull(11, Types.DOUBLE);
                ps.setNull(12, Types.VARCHAR);
                ps.setNull(13, Types.VARCHAR);
                ps.setNull(14, Types.VARCHAR);

            } else if (producto instanceof Electronico) {
                Electronico e = (Electronico) producto;

                ps.setString(5, "ELECTRONICO");
                ps.setNull(6, Types.VARCHAR);
                ps.setNull(7, Types.BOOLEAN);
                ps.setNull(8, Types.DOUBLE);
                ps.setString(9, e.getMarca());
                ps.setInt(10, e.getGarantiaMeses());
                ps.setDouble(11, e.getVoltaje());
                ps.setNull(12, Types.VARCHAR);
                ps.setNull(13, Types.VARCHAR);
                ps.setNull(14, Types.VARCHAR);

            } else if (producto instanceof Ropa) {
                Ropa r = (Ropa) producto;

                ps.setString(5, "ROPA");
                ps.setNull(6, Types.VARCHAR);
                ps.setNull(7, Types.BOOLEAN);
                ps.setNull(8, Types.DOUBLE);
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.INTEGER);
                ps.setNull(11, Types.DOUBLE);
                ps.setString(12, r.getTalla());
                ps.setString(13, r.getColor());
                ps.setString(14, r.getMaterial());

            } else {
                ps.setString(5, "GENERAL");
                ps.setNull(6, Types.VARCHAR);
                ps.setNull(7, Types.BOOLEAN);
                ps.setNull(8, Types.DOUBLE);
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.INTEGER);
                ps.setNull(11, Types.DOUBLE);
                ps.setNull(12, Types.VARCHAR);
                ps.setNull(13, Types.VARCHAR);
                ps.setNull(14, Types.VARCHAR);
            }

            ps.setInt(15, producto.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void establecerParametrosComunes(PreparedStatement ps, Producto producto)
            throws SQLException {

        ps.setInt(1, producto.getId());
        ps.setString(2, producto.getNombre());
        ps.setDouble(3, producto.getPrecio());
        ps.setInt(4, producto.getCantidad());
        ps.setString(5, producto.getCategoria());
    }

    private void establecerParametrosEspecificos(PreparedStatement ps, Producto producto)
            throws SQLException {

        if (producto instanceof Alimento) {
            Alimento a = (Alimento) producto;

            ps.setString(6, "ALIMENTO");
            ps.setString(7, a.getFechaCaducidad());
            ps.setBoolean(8, a.isEsPerecedero());
            ps.setDouble(9, a.getPeso());
            ps.setNull(10, Types.VARCHAR);
            ps.setNull(11, Types.INTEGER);
            ps.setNull(12, Types.DOUBLE);
            ps.setNull(13, Types.VARCHAR);
            ps.setNull(14, Types.VARCHAR);
            ps.setNull(15, Types.VARCHAR);

        } else if (producto instanceof Electronico) {
            Electronico e = (Electronico) producto;

            ps.setString(6, "ELECTRONICO");
            ps.setNull(7, Types.VARCHAR);
            ps.setNull(8, Types.BOOLEAN);
            ps.setNull(9, Types.DOUBLE);
            ps.setString(10, e.getMarca());
            ps.setInt(11, e.getGarantiaMeses());
            ps.setDouble(12, e.getVoltaje());
            ps.setNull(13, Types.VARCHAR);
            ps.setNull(14, Types.VARCHAR);
            ps.setNull(15, Types.VARCHAR);

        } else if (producto instanceof Ropa) {
            Ropa r = (Ropa) producto;

            ps.setString(6, "ROPA");
            ps.setNull(7, Types.VARCHAR);
            ps.setNull(8, Types.BOOLEAN);
            ps.setNull(9, Types.DOUBLE);
            ps.setNull(10, Types.VARCHAR);
            ps.setNull(11, Types.INTEGER);
            ps.setNull(12, Types.DOUBLE);
            ps.setString(13, r.getTalla());
            ps.setString(14, r.getColor());
            ps.setString(15, r.getMaterial());

        } else {
            ps.setString(6, "GENERAL");
            ps.setNull(7, Types.VARCHAR);
            ps.setNull(8, Types.BOOLEAN);
            ps.setNull(9, Types.DOUBLE);
            ps.setNull(10, Types.VARCHAR);
            ps.setNull(11, Types.INTEGER);
            ps.setNull(12, Types.DOUBLE);
            ps.setNull(13, Types.VARCHAR);
            ps.setNull(14, Types.VARCHAR);
            ps.setNull(15, Types.VARCHAR);
        }
    }

    private Producto construirProductoDesdeResultSet(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo");
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        double precio = rs.getDouble("precio");
        int cantidad = rs.getInt("cantidad");
        String categoria = rs.getString("categoria");

        switch (tipo) {
            case "ALIMENTO":
                return new Alimento(
                        id,
                        nombre,
                        precio,
                        cantidad,
                        categoria,
                        rs.getString("fecha_caducidad"),
                        rs.getBoolean("es_perecedero"),
                        rs.getDouble("peso")
                );

            case "ELECTRONICO":
                return new Electronico(
                        id,
                        nombre,
                        precio,
                        cantidad,
                        categoria,
                        rs.getString("marca"),
                        rs.getInt("garantia_meses"),
                        rs.getDouble("voltaje")
                );

            case "ROPA":
                return new Ropa(
                        id,
                        nombre,
                        precio,
                        cantidad,
                        categoria,
                        rs.getString("talla"),
                        rs.getString("color"),
                        rs.getString("material")
                );

            default:
                return new Producto(id, nombre, precio, cantidad, categoria);
        }
    }
}
