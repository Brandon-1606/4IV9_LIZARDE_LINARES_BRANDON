/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author lizar
 */
import java.util.ArrayList;
import java.io.*;

public class Controlador {
    
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static ArrayList<Profesor> listaProfesores = new ArrayList<>();
    
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.dat"))) {
            oos.writeObject(listaEstudiantes);
            oos.writeObject(listaProfesores);
            System.out.println("Datos guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        File archivo = new File("datos.dat");
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                listaEstudiantes = (ArrayList<Estudiante>) ois.readObject();
                listaProfesores = (ArrayList<Profesor>) ois.readObject();
            } catch (Exception e) {
                System.out.println("Error al cargar datos.");
            }
        }
    }

    public ArrayList<Estudiante> mostrarEstudiantes() { return listaEstudiantes; }
    public void registrarEstudiante(Estudiante e) { listaEstudiantes.add(e); }
    public Estudiante buscarEstudiante(int id) {
        for(Estudiante e : listaEstudiantes) if(id == e.getId()) return e;
        return null;
    }
    public void eliminarEstudiante(Estudiante e) { listaEstudiantes.remove(e); }

    public ArrayList<Profesor> mostrarProfesores() { return listaProfesores; }
    public void registrarProfesor(Profesor p) { listaProfesores.add(p); }
    public Profesor buscarProfesor(int id) {
        for(Profesor p : listaProfesores) if(id == p.getId()) return p;
        return null;
    }
    public void eliminarProfesor(Profesor p) { listaProfesores.remove(p); }
}