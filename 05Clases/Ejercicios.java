import java.util.Scanner;

public class Ejercicios {
    
    //Vamos a hacer una calculadora rapida
    Scanner entrada = new Scanner(System.in);
    //La calculadora debe de tener un menu
    public void menu() {
        //Las instrucciones
        System.out.println("Bienvenido a la calculadora");
        System.out.println("Elige la opcion deseada");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Salir");
        int opcion=0;
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                suma();
                break;
            default:
                break;
        }

    }

    public void suma(){
        double num1 = 0.0, num2 = 0.0, resultado=0.0;

        System.out.println("Ingrese numero que desea sumar");
        num1 = entrada.nextDouble();
        System.out.println("Ingrese numero que desea sumar");
        num2 = entrada.nextDouble();
        resultado = num1 + num2;
        System.out.println("El resultado de la suma es: " + resultado);
    }
}
