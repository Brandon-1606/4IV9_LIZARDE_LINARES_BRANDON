import java.util.Scanner;
    
class figura {
    float radio;
    float diametro;
    float lado;
    float altura;
    int opcion;
    float base;
    float apotema;

    Scanner entrada = new Scanner(System.in);

    public void menu() {
        char repetir = 0;
        do{
            System.out.println("Calculadora de areas");
            System.out.println("1. Circulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triangulo");
            System.out.println("4. Rectangulo");
            System.out.println("5. Pentagono");
            System.out.println("6. Salir");
            System.out.println("Seleccione la figura que desea calcular el area");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: calcularCirculo();
                break;
                case 2: calcularCuadrado();
                break;
                case 3: calcularTriangulo();
                break;
                case 4: calcularRectangulo();
                break;
                case 5: calcularPentagono();
                break;
                case 6: System.out.println("Hasta pronto");
                break;
                default:
                    System.out.println("Introduzca una opcion valida");
                    break;
            }
            System.out.println("\nDeseas realizar otro calculo? s/n");
            repetir = entrada.next().charAt(0);
        } while(repetir == 's' || repetir == 'S');
        System.out.println("Hasta luego");
    }

    public void calcularCirculo() {
        System.out.println("Ingrese el radio");
        radio = entrada.nextFloat();
        double resultado = 3.1416 * (radio * radio);
        System.out.println("El area del circulo es: " + resultado);
    }

    public void calcularCuadrado(){
        System.out.println("Ingrese el lado");
        lado = entrada.nextFloat();
        float resultado = lado * lado;
        System.out.println("El area del cuadrado es: " + resultado);
    }

    public void calcularTriangulo(){
        System.out.println("Ingrese la base");
        base = entrada.nextFloat();
        System.out.println("Ingrese la altura");
        altura = entrada.nextFloat();
        float resultado = (base * altura) / 2;
        System.out.println("El area del triangulo es: " + resultado);
    }

    public void calcularRectangulo(){
        System.out.println("Ingresa la base");
        base = entrada.nextFloat();
        System.out.println("Ingresa la altura");
        altura = entrada.nextFloat();
        float resultado = base * altura;
        System.out.println("El area del rectangulo es: " + resultado);
    }

    public void calcularPentagono() {
        System.out.println("Ingreese el lado");
        lado = entrada.nextFloat();
        System.out.println("Ingrese el apotema");
        apotema = entrada.nextFloat();
        float perimetro = lado * 5;
        float resultado = (perimetro * apotema) / 2;
        System.out.println("El area del pentagono es: " + resultado);
    }
}
