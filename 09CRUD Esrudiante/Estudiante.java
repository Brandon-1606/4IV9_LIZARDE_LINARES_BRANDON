public class Estudiante {
    private String boleta;
    private String nombre;
    private int edad;
    private double promedio;
    
    public Estudiante(){

    }

    public Estudiante(String boleta, String nombre, int edad, double promedio){
        this.boleta = boleta;
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void mostrarEstudiante() {
        System.out.println("El nombre del estudiante es " + getNombre() + "\n" + "su boleta es: " + getBoleta() + "\n" + "su edad es: " + getEdad() + "\n" + "y su promedio es: " + getPromedio() + "\n");
    }
}
