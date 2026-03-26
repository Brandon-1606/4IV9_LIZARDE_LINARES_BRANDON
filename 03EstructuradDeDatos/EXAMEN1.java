import java.util.Scanner;

class EXAMEN1 { 
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        char repetir;

        String nombre = "";
        String apellidopaterno = "";
        String apellidomaterno = "";
        String fechanacimiento = "";
        String direccion = "";

        do{
            System.out.println("Bienvenido a la tienda de pisos");
            System.out.println("1. Ingresa datos del cliente");
            System.out.println("2. Ver tipos de pisos");
            System.out.println("3. Calcular monto estimado");
            System.out.println("4. Salir");
            
            opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch(opcion) {
                case 1:
                do {
                    System.out.print("Ingrese su nombre: ");
                    nombre = entrada.nextLine();
                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                    System.out.println("Ingrese solo caracteres validos");
                }
                } while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                do{
                    System.out.print("Ingrese su apellido paterno: ");
                    apellidopaterno = entrada.nextLine();
                    if (!apellidopaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                        System.out.println("Ingrese solo caracteres validos");
                    }
                } while (!apellidopaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                do{
                    System.out.print("Ingrese su apellido materno: ");
                    apellidomaterno = entrada.nextLine();
                    if (!apellidomaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                        System.out.println("Ingrese solo caracteres validos");
                    }
                } while (!apellidomaterno.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                do{
                    System.out.print("Ingrese su fecha de nacimiento: ");
                    fechanacimiento = entrada.nextLine();
                    if (!fechanacimiento.matches("[0-9/]+")){
                        System.out.println("Ingrese una fecha valida");
                    }
                } while (!fechanacimiento.matches("[0-9/]+"));
                    System.out.print("Ingrese su direccion: ");
                    direccion = entrada.nextLine();
                    break;

                case 2:
                    System.out.println("Tipos de pisos disponibles: ");
                    System.out.println("1. Porcelanato = 22.35 por m2");
                    System.out.println("2. Marmoleado = 34.27 por m2");
                    System.out.println("3. Acrilico = 22.94 por m2");
                    break;

                case 3:
                    int numhabitaciones = 0;
                    do { 
                        System.out.println("Ingrese el numero de habitaciones (maximo 5)");
                        numhabitaciones = entrada.nextInt();
                    } while (numhabitaciones <= 1 || numhabitaciones >= 5);
                    
                    float subtotal = 0;

                    System.out.println("Datos del cliente: ");    
                    System.out.println(nombre + " " + apellidopaterno + " " + apellidomaterno);
                        System.out.println(fechanacimiento);
                        System.out.println(direccion);
                    
                    for (int i = 1; i <=numhabitaciones; i++){
                        System.out.println("Cuarto " + i);
                        System.out.println("Ingrese el largo de la habitacion");
                        float largo = entrada.nextFloat();
                        System.out.println("Ingrese el ancho de la habitacion");
                        float ancho = entrada.nextFloat();
                        float area = largo * ancho;
                        System.out.println("Ingrese el tipo de piso (1, 2 o 3)");

                        int tipoPiso = entrada.nextInt();
                        float preciopiso = 0;
                        String nombrepiso = "";

                        if (tipoPiso == 1) {
                            preciopiso = 22.35f;
                            nombrepiso = "Porcelanato";
                        } else if (tipoPiso == 2) {
                            preciopiso = 34.27f;
                            nombrepiso = "Marmoleado";
                        } else if (tipoPiso == 3) {
                            preciopiso = 22.94f;
                            nombrepiso = "Acrilico";
                        } else {
                            System.out.println("Opcion invalida");
                        }

                        float preciohabitacion = area * preciopiso;
                        subtotal = subtotal + preciohabitacion;
                        System.out.println("El costo de la habitacion " + i + "con " + nombrepiso + " es: " + preciohabitacion);

                    }
                    float IVA = subtotal * 0.16f;
                        float total = subtotal + IVA;

                        System.out.println("Subtotal: " + subtotal);
                        System.out.println("IVA (16%): " + IVA);
                        System.out.println("Total: " + total);

                        System.out.println("Desea continuar con la compra, s/n");
                        char comprar = entrada.next().charAt(0);

                        if (comprar == 's' || comprar == 'S'){
                            float descuento = total * 0.0795f;
                            float totaldescuento = total - descuento;
                            System.out.println("Descuento del: " + descuento);
                            System.out.println("El total a pagar es: " + totaldescuento);
                        } else {
                            System.out.println("Compra cancelada");
                        }
                    break;

                case 4:
                    System.out.println("Gracias por su visita");
                    return;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            System.out.println("Desea regresar al menu principal s/n");
            repetir = entrada.next().charAt(0);
        } while (repetir == 's' || repetir == 'S');

    }   
}