
public class Gato extends Animal {
    int num_vidas;

    public Gato(){

    }
    //Quiero acceder a los attributos de la clase gato
    public Gato(String nombre, String raza, String tipo_alimento, int edad, int num_vidas){
        //Como puedo obtenerlo ocupo la palabra reservada super
        super(nombre, raza, tipo_alimento, edad);
        this.num_vidas = num_vidas;
    }

    public int getNum_vidas(){
        return num_vidas;
    }

    public void setNum_vidas(int num_vidas){
        this.num_vidas = num_vidas;
    }

    //Metodo propio del señor gato
    public void mostrarGato(){
        System.out.println("El nombre del michi " + getNombre() + "\n" + "su raza es: " + getRaza() + "\n" + "su comida es: " + getTipo_alimento() + "\n" + "su edad es: " + getEdad() + "\n" + "El numero de vidas que le restan son: " + getNum_vidas() + "\n");
    }
}
