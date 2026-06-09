/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DORMIR;
import Modelo.DormirDAO;
import Vistaa.DormirVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lizar
 */
public class DormirControlador {
    
    private DormirDAO dao;
    private DormirVista vista;

    public DormirControlador(DormirDAO dao, DormirVista vista) {
        this.dao = dao;
        this.vista = vista;

        this.vista.getBtnAgregar().addActionListener(e -> agregar());
        this.vista.getBtnActualizar().addActionListener(e -> actualizar());
        this.vista.getBtnEliminar().addActionListener(e -> eliminar());
        this.vista.getBtnBuscar().addActionListener(e -> buscar());
        this.vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());

        this.vista.getTablaDormir().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarFila();
            }
        });

        mostrar();
    }

    private void agregar() {
        try {
            DORMIR dormir = new DORMIR();

            dormir.setIdPersona(Integer.parseInt(vista.getTxtIdPersona().getText()));
            dormir.setDia(vista.getTxtDia().getText());
            dormir.setHoraDormir(vista.getTxtHoraDormir().getText());
            dormir.setHoraDespertar(vista.getTxtHoraDespertar().getText());
            dormir.setHorasDormidas(Double.parseDouble(vista.getTxtHorasDormidas().getText()));
            dormir.setCalidad(vista.getTxtCalidad().getText());
            dormir.setComentario(vista.getTxtComentario().getText());

            dao.agregar(dormir);

            vista.mostrarMensaje("Registro agregado correctamente");
            mostrar();
            vista.limpiarFormulario();

        } catch (Exception e) {
            vista.mostrarError("Error al agregar: " + e.getMessage());
        }
    }

    private void mostrar() {
        try {
            vista.getModeloTabla().setRowCount(0);

            ArrayList<DORMIR> lista = dao.mostrar();

            for (DORMIR dormir : lista) {
                Object[] fila = new Object[9];

                fila[0] = dormir.getIdDormir();
                fila[1] = dormir.getIdPersona();
                fila[2] = dormir.getNombrePersona();
                fila[3] = dormir.getDia();
                fila[4] = dormir.getHoraDormir();
                fila[5] = dormir.getHoraDespertar();
                fila[6] = dormir.getHorasDormidas();
                fila[7] = dormir.getCalidad();
                fila[8] = dormir.getComentario();

                vista.getModeloTabla().addRow(fila);
            }

        } catch (Exception e) {
            vista.mostrarError("Error al mostrar: " + e.getMessage());
        }
    }

    private void actualizar() {
        try {
            if (vista.getTxtId().getText().isEmpty()) {
                vista.mostrarError("Selecciona un registro primero");
                return;
            }

            DORMIR dormir = new DORMIR();

            dormir.setIdDormir(Integer.parseInt(vista.getTxtId().getText()));
            dormir.setIdPersona(Integer.parseInt(vista.getTxtIdPersona().getText()));
            dormir.setDia(vista.getTxtDia().getText());
            dormir.setHoraDormir(vista.getTxtHoraDormir().getText());
            dormir.setHoraDespertar(vista.getTxtHoraDespertar().getText());
            dormir.setHorasDormidas(Double.parseDouble(vista.getTxtHorasDormidas().getText()));
            dormir.setCalidad(vista.getTxtCalidad().getText());
            dormir.setComentario(vista.getTxtComentario().getText());

            dao.actualizar(dormir);

            vista.mostrarMensaje("Registro actualizado correctamente");
            mostrar();
            vista.limpiarFormulario();

        } catch (Exception e) {
            vista.mostrarError("Error al actualizar: " + e.getMessage());
        }
    }

    private void eliminar() {
        try {
            if (vista.getTxtId().getText().isEmpty()) {
                vista.mostrarError("Selecciona un registro primero");
                return;
            }

            if (vista.confirmar("¿Seguro que quieres eliminar este registro?")) {
                int idDormir = Integer.parseInt(vista.getTxtId().getText());

                dao.eliminar(idDormir);

                vista.mostrarMensaje("Registro eliminado correctamente");
                mostrar();
                vista.limpiarFormulario();
            }

        } catch (Exception e) {
            vista.mostrarError("Error al eliminar: " + e.getMessage());
        }
    }

    private void buscar() {
        try {
            if (vista.getTxtId().getText().isEmpty()) {
                vista.mostrarError("Escribe el ID que quieres buscar");
                return;
            }

            int idBuscado = Integer.parseInt(vista.getTxtId().getText());
            ArrayList<DORMIR> lista = dao.mostrar();

            vista.getModeloTabla().setRowCount(0);

            boolean encontrado = false;

            for (DORMIR dormir : lista) {
                if (dormir.getIdDormir() == idBuscado) {
                    Object[] fila = new Object[9];

                    fila[0] = dormir.getIdDormir();
                    fila[1] = dormir.getIdPersona();
                    fila[2] = dormir.getNombrePersona();
                    fila[3] = dormir.getDia();
                    fila[4] = dormir.getHoraDormir();
                    fila[5] = dormir.getHoraDespertar();
                    fila[6] = dormir.getHorasDormidas();
                    fila[7] = dormir.getCalidad();
                    fila[8] = dormir.getComentario();

                    vista.getModeloTabla().addRow(fila);

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                vista.mostrarError("No se encontró el registro");
                mostrar();
            }

        } catch (Exception e) {
            vista.mostrarError("Error al buscar: " + e.getMessage());
        }
    }

    private void seleccionarFila() {
        int fila = vista.getTablaDormir().getSelectedRow();

        if (fila >= 0) {
            vista.getTxtId().setText(vista.getTablaDormir().getValueAt(fila, 0).toString());
            vista.getTxtIdPersona().setText(vista.getTablaDormir().getValueAt(fila, 1).toString());
            vista.getTxtNombrePersona().setText(vista.getTablaDormir().getValueAt(fila, 2).toString());
            vista.getTxtDia().setText(vista.getTablaDormir().getValueAt(fila, 3).toString());
            vista.getTxtHoraDormir().setText(vista.getTablaDormir().getValueAt(fila, 4).toString());
            vista.getTxtHoraDespertar().setText(vista.getTablaDormir().getValueAt(fila, 5).toString());
            vista.getTxtHorasDormidas().setText(vista.getTablaDormir().getValueAt(fila, 6).toString());
            vista.getTxtCalidad().setText(vista.getTablaDormir().getValueAt(fila, 7).toString());
            vista.getTxtComentario().setText(vista.getTablaDormir().getValueAt(fila, 8).toString());
        }
    }
}
