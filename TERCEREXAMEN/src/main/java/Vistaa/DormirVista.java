/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistaa;

/**
 *
 * @author lizar
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/*
 * ============================================================================
 * CAPA: VISTA — DormirVista
 * ============================================================================
 *
 * PATRÓN MVC — ¿QUÉ ES LA VISTA?
 * La Vista es responsable ÚNICAMENTE de la interfaz gráfica:
 *   - Crear y organizar los componentes visuales (campos, botones, tabla)
 *   - Mostrar datos al usuario
 *   - Recoger datos del usuario
 *
 * La Vista NO DEBE:
 *   - Conectarse a la base de datos
 *   - Ejecutar lógica de negocio
 *   - Decidir qué hacer cuando el usuario hace clic en un botón
 *
 * CAMBIO RESPECTO A PRÁCTICA 2:
 * En Práctica 2, VentanaPrincipal HACÍA TODO:
 *   - Creaba los componentes (VISTA) ✓
 *   - Manejaba eventos de botones (CONTROLADOR) ✗ → ahora en DormirControlador
 *   - Llamaba al servicio de datos (MODELO) ✗ → ahora el controlador lo hace
 *
 * Ahora VentanaPrincipal se divide en:
 *   - DormirVista: solo componentes gráficos (esta clase)
 *   - DormirControlador: maneja eventos y lógica
 *
 * CLAVE: Los botones son PÚBLICOS (o tienen getters) para que el Controlador
 * pueda agregarles ActionListeners. La Vista no sabe qué pasará al hacer clic.
 * ============================================================================
 */
public class DormirVista extends JFrame {

    // --- Tabla ---
    private JTable tablaDormir;
    private DefaultTableModel modeloTabla;

    // --- Campos comunes ---
    private JTextField txtId, txtIdPersona, txtNombrePersona, txtDia, txtHoraDormir, txtHoraDespertar;
    private JTextField txtHorasDormidas, txtCalidad, txtComentario;

    // --- Botones CRUD ---
    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar, btnLimpiar;

    /*
     * CONSTRUCTOR:
     * SOLO crea y organiza componentes. NO agrega lógica a los botones.
     * Eso lo hará el Controlador después.
     */
    public DormirVista() {
        setTitle("Práctica 3: CRUD de Dormir — Patrón MVC");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));

        // --- NORTH: Título ---
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(39, 174, 96));
        JLabel lblTitulo = new JLabel("Sistema de Gestión de Dormir — Práctica 3 (MVC)");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // --- CENTER: Tabla ---
        modeloTabla = new DefaultTableModel(
            new String[]{"ID", "ID Persona", "Nombre", "Día", "Hora Dormir", "Hora Despertar", "Horas Dormidas", "Calidad", "Comentario"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaDormir = new JTable(modeloTabla);
        tablaDormir.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaDormir.setRowHeight(25);

        JScrollPane scrollTabla = new JScrollPane(tablaDormir);
        scrollTabla.setPreferredSize(new Dimension(900, 250));
        add(scrollTabla, BorderLayout.CENTER);

        // --- SOUTH: Formulario + Botones ---
        JPanel panelInferior = new JPanel(new BorderLayout(5, 5));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelInferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotones(), BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Datos de Dormir"));

        // Campos comunes
        JPanel panelComun = new JPanel(new GridLayout(3, 6, 5, 5));

        panelComun.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelComun.add(txtId);

        panelComun.add(new JLabel("ID Persona:"));
        txtIdPersona = new JTextField();
        panelComun.add(txtIdPersona);

        panelComun.add(new JLabel("Nombre:"));
        txtNombrePersona = new JTextField();
        txtNombrePersona.setEditable(false);
        panelComun.add(txtNombrePersona);

        panelComun.add(new JLabel("Día:"));
        txtDia = new JTextField();
        panelComun.add(txtDia);

        panelComun.add(new JLabel("Hora Dormir:"));
        txtHoraDormir = new JTextField();
        panelComun.add(txtHoraDormir);

        panelComun.add(new JLabel("Hora Despertar:"));
        txtHoraDespertar = new JTextField();
        panelComun.add(txtHoraDespertar);

        panelComun.add(new JLabel("Horas Dormidas:"));
        txtHorasDormidas = new JTextField();
        panelComun.add(txtHorasDormidas);

        panelComun.add(new JLabel("Calidad:"));
        txtCalidad = new JTextField();
        panelComun.add(txtCalidad);

        panelComun.add(new JLabel("Comentario:"));
        txtComentario = new JTextField();
        panelComun.add(txtComentario);

        panel.add(panelComun, BorderLayout.NORTH);

        return panel;
    }

    /*
     * PUNTO CLAVE MVC:
     * Los botones se CREAN aquí (Vista), pero NO tienen ActionListener.
     * El Controlador obtendrá referencias a estos botones mediante getters
     * y les asignará la acción correspondiente.
     *
     * La Vista dice: "Aquí hay un botón que dice Agregar."
     * El Controlador dice: "Cuando lo presionen, yo haré esto."
     */
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar por ID");
        btnLimpiar = new JButton("Limpiar");

        // Estilo — colores oscuros para visibilidad en Windows LAF
        Color colorBtn = new Color(0, 100, 60);
        Color colorBtnEliminar = new Color(140, 20, 20);
        for (JButton btn : new JButton[]{btnAgregar, btnActualizar, btnBuscar, btnLimpiar}) {
            btn.setBackground(colorBtn);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
        }
        btnEliminar.setBackground(colorBtnEliminar);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);

        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);
        panel.add(btnLimpiar);

        return panel;
    }

    // ========================================================================
    // GETTERS — El Controlador los usa para acceder a los componentes
    // ========================================================================
    /*
     * PATRÓN MVC — COMUNICACIÓN VISTA ↔ CONTROLADOR:
     * La Vista expone sus componentes mediante getters.
     * El Controlador usa estos getters para:
     *   1. Leer datos del formulario (getText())
     *   2. Escribir datos en el formulario (setText())
     *   3. Agregar listeners a botones (addActionListener())
     *   4. Actualizar la tabla (modeloTabla)
     */

    public JTable getTablaDormir() { return tablaDormir; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    // Campos comunes
    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtIdPersona() { return txtIdPersona; }
    public JTextField getTxtNombrePersona() { return txtNombrePersona; }
    public JTextField getTxtDia() { return txtDia; }
    public JTextField getTxtHoraDormir() { return txtHoraDormir; }
    public JTextField getTxtHoraDespertar() { return txtHoraDespertar; }
    public JTextField getTxtHorasDormidas() { return txtHorasDormidas; }
    public JTextField getTxtCalidad() { return txtCalidad; }
    public JTextField getTxtComentario() { return txtComentario; }

    // Botones
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }

    // ========================================================================
    // MÉTODOS DE LA VISTA — Acciones visuales que el Controlador puede invocar
    // ========================================================================

    // Muestra un mensaje informativo
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Muestra un mensaje de error
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Muestra diálogo de confirmación, retorna true si el usuario acepta
    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje,
            "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    // Limpia todos los campos del formulario
    public void limpiarFormulario() {
        txtId.setText("");
        txtIdPersona.setText("");
        txtNombrePersona.setText("");
        txtDia.setText("");
        txtHoraDormir.setText("");
        txtHoraDespertar.setText("");
        txtHorasDormidas.setText("");
        txtCalidad.setText("");
        txtComentario.setText("");
        tablaDormir.clearSelection();
    }
}
