//La herencia es la capacidad de ppoder tener acceso a los atributos y comportamientos de una clase padre a una clase hijo. Podemos reutilizar codigo.

//Encapsulamiento es la capacidad de poder restringir el acceso a los tipos de datos, comportamientos u atributos de una clase frente a otra. Con ello vamos a poder agrupar en una clase el acceso a los metodos, atributos y objetos para que no puedan ser modificadios.

//Sobrecarga es la capacidad de los diferentes metodos de una clase para nombrarse de la misma forma, pero establecer diferentes comportamientos.

public class Animal{

    private String nombre, raza, tipo_alimento;
    private int edad;

    //Toda clase debe de tener un constructor
    //Sirven para poder declarar la existencia de una clase, para poder inicializar sus variables y poder crear instancias de la misma.
    public Animal(){
        //Primero su acceso es publico
        //El nombre del constructor es el mismo que de la clase pero sin parametros
        //Es un metodo

    }
    public Animal(String nombre, String raza, String tipo_alimento, int edad){
        //Constructor sobrecargado
        //Para poder obtener el paso de cada parametro esto es necesario porque debemos de obtener el acceso a los atributos
        //Vamis a ocupar la palabra reservada this
        this.nombre = nombre;
        this.raza = raza;
        this.tipo_alimento = tipo_alimento;
        this.edad = edad;
    }

    //Para poder obtener o enviar los datos correspondientes de la clase, necesitamos hacer uso de los metodos
    //Get para obtener o recibir
    //Set para asignar o enviar

    public String getNombre(){
        return nombre;

    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getRaza(){
        return raza;
    }

    public void setRaza(String raza){
        this.raza = raza;
    }

    public String getTipo_alimento(){
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento){
        this.tipo_alimento = tipo_alimento;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
}