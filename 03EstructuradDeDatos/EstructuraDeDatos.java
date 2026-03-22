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
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
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
                        while(numerobinario > 0){
                            if (numerobinario % 2 ==0){
                                guardarbinario = "0" + guardarbinario;
                            }else{
                            guardarbinario = "1" + guardarbinario;
                        }
                        numerobinario = numerobinario / 2;
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

                    int opcionTemp = 0;
                    opcionTemp = entrada.nextInt();
                    System.out.println("Ingrese la temperatura");
                    float temperatura=0;
                    temperatura=entrada.nextFloat();
                    float resultado = 0;
                    if(opcionTemp == 1){
                        resultado = (temperatura * 9/5) +32;
                        System.out.println("La temperatura en F es: " + resultado);
                    }else if(opcionTemp == 2){
                        resultado = temperatura +273.15f;
                        System.out.println("La temperatura en K es: " + resultado);
                    }else{
                        System.out.println("Opción inválida");
                    }
                break;
                case 4:
                    System.out.println("Cuantos numero desea ingresar");
                    int cantidadnumeros = 0;
                    cantidadnumeros = entrada.nextInt();
                    int positivos = 0;
                    int negativos = 0;
                    if(cantidadnumeros>0){
                        for(int i = 1; i <= cantidadnumeros; i++){
                            System.out.println("Ingrese un numero");
                            int numero = 0;
                            numero = entrada.nextInt();
                            if(numero >0){
                                positivos = positivos + 1;
                            }else if(numero <0){
                                negativos = negativos + 1;
                            }
                        }
                        System.out.println("Numeros positivos: " + positivos);
                        System.out.println("Numeros negativos: " + negativos);
                    }else{
                        System.out.println("Ingrese solo cantidades positivas");
                    }
                break;
                case 5:
                    System.out.println("Bienvenido a esta hermosa tiendita linda y kawai");
                    System.out.println("Por favor ingrese cuantos elementos va a comprar");
                    int elementosproducto = 0;
                    elementosproducto = entrada.nextInt();
                    if(elementosproducto > 0){
                        float compra = 0;
                        for (int i = 1; i <= elementosproducto; i++){
                            System.out.println("Ingresa el nombre del producto");
                            String nombreproducto = "";
                            nombreproducto = entrada.next();
                            System.out.println("Ingrese el precio");
                            float precio = 0;
                            precio = entrada.nextFloat();
                            float resultadoTienda;
                            System.out.println("Ingrese la cantidada de producto");
                            int cantidad = 0;
                            cantidad = entrada.nextInt();
                            resultadoTienda = precio * cantidad;
                            
                            compra = resultadoTienda + compra;

                        }                        System.out.println("El total de la compra es: " + compra);
                    }else{
                        System.out.println("Ingrese solo cantidades positivas");
                    }
                break;
                case 6:
                    System.out.println("Seleccione la figura");
                    System.out.println("1. Cuadrado");
                    System.out.println("2. Rectangulo");
                    System.out.println("3. Triangulo");
                    System.out.println("4. Circulo");
                    System.out.println("5. Pentagono");

                    int figura = 0;
                    figura = entrada.nextInt();
                    float area = 0;
                    float perimetro = 0;
                    if (figura== 1){
                        System.out.println("Ingrese el lado");
                        float lado = 0;
                        lado = entrada.nextFloat();
                        area = lado * lado;
                        perimetro = lado * 4;
                    }else if(figura == 2){
                        System.out.println("Ingresa loa base");
                        float base = 0;
                        base = entrada.nextFloat();

                        System.out.println("Ingrese la altura");
                        float altura = 0;
                        altura = entrada.nextFloat();

                        area = base * altura;
                        perimetro = 2 * (base + altura);

                    }else if(figura == 3){
                        System.out.println("Ingrese la base ");
                        float base = 0;
                        base = entrada.nextFloat();

                        System.out.println("Ingrese la altura ");
                        float altura = 0;
                        altura = entrada.nextFloat();

                        System.out.println("Ingrese el lado 2");
                        float lado2 = 0;
                        lado2 = entrada.nextFloat();

                        System.out.println("Ingrese el lado 3 ");
                        float lado3 = 0;
                        lado3 = entrada.nextFloat();

                        area= (base * altura) / 2;
                        perimetro = base + lado2 + lado3;
                    }else if(figura == 4){
                        System.out.println("Ingrese el radio ");
                        float radio = 0;
                        radio = entrada.nextFloat();

                        area = 3.1416f * radio * radio;
                        perimetro = 2 * 3.1416f * radio;

                    }else if (figura == 5){
                        System.out.println("Ingrese el apotema ");
                        float apotema = 0;
                        apotema = entrada.nextFloat();

                        System.out.println("Ingrese el lado ");
                        float lado = 0;
                        lado = entrada.nextFloat();

                        perimetro = lado * 5;
                        area = (perimetro * apotema) / 2;

                    }
                    System.out.println("el area es: " + area);
                    System.out.println("el perimetro es: " + perimetro);
                break;
                case 7:
                    //Quiero dejarles una tabla de multiplicar
                    //Deberan de darle formatos y titulos a cada columna
                    System.out.println("-------------------------------------"); 
                    System.out.println("|   1   |   10  |   100 |   1000    |");
                    System.out.println("-------------------------------------");
                    for(int n = 1; n <= 10; n++){
                        System.out.println(
                            "|  " + n + "   |  " + (n*10 + "    |  " + (n * 100) + "    |  "  + (n * 1000 + "   | ")));
                    }
                break;
                case 8:
                    System.out.println("Ingrese un numero para calcular su factorial");
                    int numfactorial = entrada.nextInt();

                    if(numfactorial >= 0 ){
                        int resultadofactorial = factorial(numfactorial);
                        System.out.println("El factorial de " + numfactorial + " es: " + resultadofactorial);

                    }else{
                        System.out.println("Ingrse solo numero positivos");
                    }
                break;
                case 9:
                    //Vamos a realizar un cuadeado magico
                    System.out.println("Vamos a realizar de dibujo de un cuadrado magico");
                    System.out.println("Ingrese el tamaño del cuadrado");
                    int n1 = entrada.nextInt();

                    if(n1 >= 1 && n1 <= 20 ){
                        //Se imprime
                        for(int i = 1; i <= n1; i++){
                            //Recorro las columnas
                            for(int j = 1; j <= n1; j++){
                                System.out.print(" * ");
                            }
                            System.out.println("");
                        }
                    }else{
                        System.out.println("Porfavor solo ingrese valores entre el 1 y 20");
                    }
                break;
                case 10:
                    System.out.println("Ingrese el tamaño de la figura sin relleno");
                    int tam = entrada.nextInt();
                    if(tam >= 1 && tam <= 20 ){
                        for(int i = 1; i <= tam; i++){
                            for(int j = 1; j <= tam; j++){
                                if(i == 1 || i == tam || j == 1|| j == tam){
                                    System.out.print("* ");
                                }else{
                                    System.out.print("  ");
                                }
                            }
                            System.out.println("");
                        }
                    }else{
                        System.out.println("Ingrese unicamente valores entre el 1 y 20");
                    }
                break;
                case 11:
                    System.out.println("Ingrese el tamaño del patron");
                    int patron = entrada.nextInt();

                    if(patron >= 1 && patron <= 20){
                        for(int i = 1; i <= patron; i++){
                            for(int j = 1; j <= i; j++){
                                System.out.print(" * ");
                            }
                            System.out.println("");
                        }
                    }else{
                        System.out.println("Ingrese solo numeros entre el 1 y 20");
                    }
                break;
                case 12:
                    System.out.println("Ingrese el tamaño del diamante");
                    int diamante = entrada.nextInt();

                    if(diamante >= 1 && diamante <= 20){
                        for(int i = 1; i <= diamante; i++){
                            for(int j = diamante; j > i; j--){
                                System.out.print(" ");
                            }
                            for(int k = 1; k <= (2*i -1); k++){
                                System.out.print("*");
                            }
                            System.out.println("");
                        }
                        for(int i = diamante-1; i >= 1; i--){
                            for(int j = diamante; j > i; j--){
                                System.out.print(" ");
                            }
                            for(int k = 1; k <= (2*i -1); k++){
                                System.out.print("*");
                            }
                            System.out.println("");
                        }
                    }else{
                        System.out.println("Ingrese valores entre 1 y 20");
                    }
                break;
                case 13:
                    System.out.println("Ingrese el primer numero");
                    float num1 = entrada.nextFloat();

                    System.out.println("Ingrese el segundo numero");
                    float num2 = entrada.nextFloat();

                    System.out.println("Seleccione la operacion: ");
                    System.out.println("1. Suma");
                    System.out.println("2. Resta");
                    System.out.println("3. Multiplicacion");
                    System.out.println("4. División");

                    int operacion = entrada.nextInt();
                    float resultadofinal = 0;

                    if(operacion == 1){
                        resultadofinal = num1 + num2;
                    }else if(operacion == 2){
                        resultadofinal = num1 - num2;
                    }else if(operacion == 3){
                        resultadofinal = num1 * num2;
                    }else if(operacion == 4){
                        if (num2 != 0){
                        resultadofinal = num1 / num2;
                        }else{
                            System.out.println("No se puede dividir entre 0");

                        }
                    }else{
                        System.out.println("Opcion invalida");
                    }
                    System.out.println("El resultado final es: " + resultadofinal);
                break;
                case 14:
                    System.out.println("Hasta pronto...");
                    return;
                default:
                                       break;

        }
        System.out.println("Deseas repetir el programa, escribe s o S para si");
        letrapararepetir = entrada.next().charAt(0);
    }while(letrapararepetir == 's' || letrapararepetir == 'S');
}
}