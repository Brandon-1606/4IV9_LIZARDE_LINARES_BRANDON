/*
Vamos a crear 14 programas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia
1.-Desarrollar un programa para calcular el bono de un descuento por edad
2.-Convertir numeros de decimales a binarios
3.-Convertir temperaturas entre los tres principales grados C -> F y K
4.-Realizar un programa parea contar numero de positivos y negativos de una serie de numeros
5.-Desarrollar una tiendita ara agregar productos y precios
6.-Dearrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.-Desarrollar una tabla
8.-Desarrollar un programa para calcular el factorial con recursividad
9.-Vamos a hace dibujitos
10.-Desarrollar una figura hueca
11.-Realizar algunos patrones
12.-Realizar un diamante
13.-Desarrollar una calculadora basica suma, resta, multiplicacion, division
*/

import java.util.Scanner;

class EstructuraDeDatos{
    public static void main(String[] args) {
        //Aqui van las variables
        int opcion;
        char letrapararepetir;

        //Aqui van los objetos
        Scanner entrada = new Scanner(System.in);
        //Aqui va el menu

        do{
        System.out.println("Bienvenido a este programa para ver cuanto saben programar a partir de algoritmos basicos");
        System.out.println( "1.-Desarrollar un programa para calcular el bono de un descuento por edad");
        System.out.println( "2.-Convertir numeros de decimales a binarios");
        System.out.println( "3.-Convertir temperaturas entre los tres principales grados C -> F y K");
        System.out.println( "4.-Realizar un programa parea contar numero de positivos y negativos de una serie de numeros");
        System.out.println( "5.-Desarrollar una tiendita ara agregar productos y precios");
        System.out.println( "6.-Dearrollar un programa para calcular el area y perimetro de 5 diferentes figuras");
        System.out.println( "7.-Desarrollar una tabla");
        System.out.println( "8.-Desarrollar un programa para calcular el factorial con recursividad");
        System.out.println( "9.-Vamos a hace dibujitos");
        System.out.println( "10.-Desarrollar una figura hueca");
        System.out.println( "11.-Realizar algunos patrones");
        System.out.println( "12.-Realizar un diamante");
        System.out.println( "13.-Desarrollar una calculadora basica suma, resta, multiplicacion, division");
        System.out.println( "14.- Salir");

        //Entrada de datos
        opcion = entrada.nextInt();

        //Ahora tengo que evaluar la entrada
        switch (opcion) {
                case 1:
                    System.out.println("Ingrese su edad");
                    int edad = entrada.nextInt();
                    float descuento = 0;

                    if(edad >0){
                        if(edad >= 60){
                            descuento = 0.30f;
                            System.out.println("Tiene un descuento del 30%");
                        }else if (edad>=30){
                            descuento = 0.20f;
                            System.out.println("Tiene un descuento del 20%");
                        }else if (edad>=18){
                            descuento = 0.10f;
                            System.out.println("Tiene un descuento del 10%");
                        }else{
                            descuento=0;
                            System.out.println("No tiene descuento");
                        }
                    }else{
                        System.out.println("Ingrese una edad válida");
                    }

                break;
                case 2:
                    System.out.println("Ingrese un número positivo entero que se desee convertir a binario");
                    int numerobinario;
                    String guardarbinario ="";
                    numerobinario = entrada.nextInt();

                    if(numerobinario > 0){
                        //Realizamos el modulo de dos
                        while(numerobinario%2 > 0){
                            if (numerobinario%2 ==0){
                                guardarbinario = "0" + guardarbinario;
                            }else{
                            guardarbinario = "1" + guardarbinario;
                        }
                    }
                        
                    }else if (numerobinario ==0) {
                        guardarbinario = "0";
                    }
                    else{
                        guardarbinario = "No se puede convertir ese numero solo acepta positivos";
                    }
                    System.out.println("El numero convertido en binario es: " + guardarbinario);
                break;
                case 3:
                    System.out.println("Seleccione el tipo de conversion");
                    System.out.println("1. C => F");
                    System.out.println("2. C => K");

                    int opcion = 0;
                    opcion = entrada.nextInt();
                    System.out.println("Ingrese la temperatura");
                    float temperatura=0;
                    temperatura=entrada.nextFloat();
                    float resultado = 0;
                    if(opcion == 1){
                        
                    }
                break;
                case 4:

                break;
                case 5:
                    System.out.println("Bienvenido a esta hermosa tiendita linda y kawai");
                    System.out.println("Por favor ingrese cuantos elementos va a comprar");
                    int elementosproducto = 0;
                    elementosproducto = entrada.nextInt();
                    if(elementosproducto < 0){
                        float compra = 0;
                        for (int i = 1; i >= elementosproducto; i++){
                            System.out.println("Ingresa el nombre del producto");
                            String nombreproducto = "";
                            nombreproducto = entrada.next();
                            System.out.println("Ingrese el precio");
                            float precio = 0;
                            precio = entrada.nextFloat();
                            float resultado;
                            System.out.println("Ingrese la cantidada de producto");
                            int cantidad = 0;
                            precio = entrada.nextInt();
                            resultado = precio * cantidad;
                            
                            compra = resultado + compra;

                        }                        System.out.println("El total de la compra es: " + compra);
                    }else{
                        System.out.println("Ingrese solo cantidades positivas");
                    }
                break;
                case 6:

                break;
                case 7:
                    //Quiero dejarles una tabla de multiplicar
                    //Deberan de darle formatos y titulos a cada columna
                    for(int n = 1; n <= 10; n++){
                        System.out.println(
                            "|  " + n + "   |  " + (n*10 + "    |  " + (n * 100) + "    |  "  + (n * 1000 + "   | ")));
                    }
                break;
                case 8:

                break;
                case 9:
                    //Vamos a realizar un cuadeado magico
                    System.out.println("Vamos a realizar de dibujo de un cuadrado magico");
                    System.out.println("Ingrese el tamaño del cuadrado");
                    int n1 = entrada.nextInt();

                    if(n1 >= 1 && n1 <= 20 ){
                        //Se imprime
                        for(int i = 1; i >= n1; i++){
                            //Recorro las columnas
                            for(int j = 1; j >= n1; j++){
                                System.out.print(" * ");
                            }
                            System.out.println("");
                        }
                    }else{
                        System.out.println("Porfavor solo ingrese valores entre el 1 y 20");
                    }
                break;
                case 10:

                break;
                case 11:

                break;
                case 12:

                break;
                case 13:

                break;
                default:
                    throw new AssertionError();
        }
        System.out.println("Deseas repetir el programa, escribe s o S para si");
        letrapararepetir = entrada.next().charAt(0);
    }while(letrapararepetir == 's' || letrapararepetir == 'S');
}
}