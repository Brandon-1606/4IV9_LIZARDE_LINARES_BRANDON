import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op;

        do { 
            System.out.println("1. Registrar");
            System.out.println("2. Buscar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("5. Mostrar todo");
            System.out.println("6. Salir");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Boleta: ");
                    String boleta = sc.nextLine();
                    System.out.println("Nombre completo: ");
                    String nombre = sc.nextLine();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    System.out.println("Promedio: ");
                    double promedio = sc.nextDouble();
                    Estudiante est = new Estudiante(boleta, nombre, edad, promedio);
                    lista.add(est);
                    System.out.println("Registro exitoso");
                    break;

                case 2:
                    System.out.println("Boleta: ");
                    String boletaBuscar = sc.nextLine();
                    for (Estudiante x : lista) {
                        if (x.getBoleta().equals(boletaBuscar)) {
                            x.mostrarEstudiante();
                            break;
                        }
                    }
                    break; 
                    
                case 3:
                    System.out.println("Boltea: ");
                    String boletaEditar = sc.nextLine();
                    for (Estudiante x : lista) {
                        if (x.getBoleta().equals(boletaEditar)) {
                            System.out.println("Nuevo nombre: ");
                            x.setNombre(sc.nextLine());
                            System.out.println("Nueva edad: ");
                            x.setEdad(sc.nextInt());
                            System.out.println("Nuevo promedio: ");
                            x.setPromedio(sc.nextDouble());
                        }
                    }
                    System.out.println("Los cambios se realizaron con exito");
                    break;

                case 4:
                    System.out.println("Boleta: ");
                    String boletaEliminar = sc.nextLine();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getBoleta().equals(boletaEliminar)) {
                            lista.remove(i);
                        }
                    }
                    System.out.println("Se ha eliminado al estudiante con exito");
                    break;
                    
                case 5:
                    if (lista.isEmpty()) {
                        System.out.println("No hay ningun estudiante registrado");

                    } else {
                        for (Estudiante x : lista) {
                            x.mostrarEstudiante();
                        }
                    }
                    break;
            }            
        } while (op != 6);
    }
}
