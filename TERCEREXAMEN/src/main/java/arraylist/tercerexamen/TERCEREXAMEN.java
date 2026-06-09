/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package arraylist.tercerexamen;

/**
 *
 * @author lizar
 */
import Controlador.DormirControlador;
import Modelo.ConexionBD;
import Modelo.DormirDAO;
import Vistaa.DormirVista;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TERCEREXAMEN {

    public static void main(String[] args) {
        if(!ConexionBD.probarConexion()){
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la BD");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            try{
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            }catch(Exception e){
                System.out.println("Error "+ e.getMessage());
            }

            DormirDAO modelo = new DormirDAO();

            DormirVista vista = new DormirVista();

            new DormirControlador(modelo, vista);

            vista.setVisible(true);
        });
    }
}