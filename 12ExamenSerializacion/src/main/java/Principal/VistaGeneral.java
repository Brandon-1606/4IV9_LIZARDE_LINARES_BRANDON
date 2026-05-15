/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author lizar
 */
import java.util.Scanner;

public class VistaGeneral {
    
    Scanner entrada = new Scanner(System.in);
    Controlador crud = new Controlador();
    
    public void Principal() {
        crud.cargarDatos();
        int opcion = 0;
        do {
            try {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1.- CRUD de Estudiantes");
                System.out.println("2.- CRUD de Profesores");
                System.out.println("3.- Salir");
                opcion = Integer.parseInt(entrada.nextLine());
                
                switch (opcion) {
                    case 1: menuEstudiantes(); break;
                    case 2: menuProfesores(); break;
                    case 3: crud.guardarDatos(); break;
                    default: System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa solo numeros");
            }
        } while(opcion != 3);
    }
    
    private void menuEstudiantes() {
        try {
            System.out.println("\n1.- Mostrar\n2.- Registrar\n3.- Eliminar");
            int op = Integer.parseInt(entrada.nextLine());
            if (op == 1) {
                for(Estudiante e : crud.mostrarEstudiantes()) 
                    System.out.println(e.getId() + " - " + e.getNombre());
            } else if (op == 2) {
                System.out.println("ID:"); int id = Integer.parseInt(entrada.nextLine());
                System.out.println("Nombre:"); String nom = entrada.nextLine();
                System.out.println("Edad:"); int ed = Integer.parseInt(entrada.nextLine());
                System.out.println("Boleta:"); String bol = entrada.nextLine();
                System.out.println("Promedio:"); double pr = Double.parseDouble(entrada.nextLine());
                crud.registrarEstudiante(new Estudiante(id, nom, ed, bol, pr));
            } else if (op == 3) {
                System.out.println("ID a eliminar:");
                int id = Integer.parseInt(entrada.nextLine());
                crud.eliminarEstudiante(crud.buscarEstudiante(id));
            }
        } catch (Exception e) { System.out.println("Dato no valido"); }
    }

    private void menuProfesores() {
        try {
            System.out.println("\n1.- Mostrar\n2.- Registrar\n3.- Eliminar");
            int op = Integer.parseInt(entrada.nextLine());
            if (op == 1) {
                for(Profesor p : crud.mostrarProfesores()) 
                    System.out.println(p.getId() + " - " + p.getNombre());
            } else if (op == 2) {
                System.out.println("ID:"); int id = Integer.parseInt(entrada.nextLine());
                System.out.println("Nombre:"); String nom = entrada.nextLine();
                System.out.println("Edad:"); int ed = Integer.parseInt(entrada.nextLine());
                System.out.println("Num Empleado:"); String num = entrada.nextLine();
                crud.registrarProfesor(new Profesor(id, nom, ed, num));
            } else if (op == 3) {
                System.out.println("ID a eliminar:");
                int id = Integer.parseInt(entrada.nextLine());
                crud.eliminarProfesor(crud.buscarProfesor(id));
            }
        } catch (Exception e) { System.out.println("Dato no valido"); }
    }
}