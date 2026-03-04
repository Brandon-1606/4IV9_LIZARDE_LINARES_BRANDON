/*
Vamos a crear una instancia de un objeto para la entrada de datos estandar y la salida de datos
*/
//libreria

import java.util.Scanner;

class EntradaTexto{
    //metodo principal
    public static void main(String[] args){

        //instanceamos el objeto

        Scanner entrada = new Scanner(System.in);
        //las variables locales
        String nombre;
        int edad;
        //entrada 
        System.out.println("Escribe un nombre: ");
        nombre= System.console().readLine();
        
        System.out.println("Hola " + " bienvenido a programar muy feo");

        System.out.println("Escribe un nombre: ");
        edad = entrada.nextInt();
    }
}