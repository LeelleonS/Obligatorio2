package obligatorio1;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Prueba {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        Sistema sistema = new Sistema();
        menuPrincipal(sistema);
    }
    
    private static void menuPrincipal(Sistema sistema){
          
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

            while (!salir) {
                System.out.println("\n--- MENÚ DE OPCIONES ---");
                System.out.println("0. Salir");
                System.out.println("1. Opción 1: Informacion de los autores");
                System.out.println("2. Opción 2: Registrar un nuevo Disenador");
                System.out.println("3. Opción 3: Registrar una nueva ficha");
                System.out.println("4. Opcion 4: Creacion de un nuevo mural");    
                System.out.println("5. Opcion 5: Modificar un mural existente");
                System.out.println("6. Opcion 6: Ver un mural");
                System.out.println("7. Opcion 7: Ver disenadores");
                System.out.println("8. Opcion 8: Comparar murales");
                System.out.println("9. Opcion 9: Ver todos los murales");
                System.out.print("Elige una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    case 1:
                        System.out.println("Alumno: Leonardo Santos, 390545");
                        break;
                    case 2:
                        String nombre;
                        String direccion;
                        String email;
                        System.out.println("Registro de Disenador");
                        System.out.print("Ingrese el nombre del disenador: ");
                        if (sistema.existeDisenador(nombre = scanner.next())){
                            System.out.println("El usuario ya existe, intente nuevamente");
                            break;
                        }else{
                            System.out.println("Ingrese la dirección: ");
                            direccion = scanner.next();
                            System.out.println("Ingrese el correo: ");
                            email = scanner.next();
                            Disenador d = new Disenador(nombre,direccion,email);
                            sistema.agregarDisenador(d);
                            break;
                        }
                        
                    case 3:
                        String nombreFicha;
                        String colorFicha;
                        String diseno33;
                        String diseno55;
                        
                        System.out.println("Registro de Ficha");
                        System.out.println("Ingrese el nombre de la ficha");
                        nombreFicha = scanner.next().toUpperCase();
                        System.out.println("Ingrese el color de la ficha");
                        colorFicha = scanner.next();
                        System.out.println("Ingrese el diseño pequeño de la ficha");
                        diseno33 = scanner.next();
                        System.out.println("Ingrese el diseño grande de la ficha");
                        diseno55 = scanner.next();
                        
                        Ficha f = new Ficha(nombreFicha, colorFicha, diseno33, diseno55);
                        sistema.agregarFicha(f);
                        
                        break;
                    case 4:
                        String nombreMural;
                        String formatoMural;
                        Ficha f1 = new Ficha();
                        Ficha f2 = new Ficha();
                        
                        System.out.println("Creacion de Mural");
                        System.out.println("Ingrese el nombre del mural");
                        nombreMural = scanner.next();
                        System.out.println("Ingrese el formato del Mural");
                        formatoMural = scanner.next();
                        System.out.println("Elija una ficha para ser la primera seleccion del Mural");
                        System.out.println(sistema.getFichas().toString());
                        System.out.println("Elija una ficha para ser la segunda seleccion del Mural");
                        System.out.println(sistema.getFichas());
                        
                        break;
                    case 5:
                        System.out.println("Modificacion de Mural");
                        break;
                    case 6:
                        System.out.println("Ver mural");
                        break;
                    case 7:
                        System.out.println("Ver disenadores");
                        System.out.println(sistema.disenadores.toString());
                        break;
                    case 8:
                        System.out.println("Comparacion de murales");
                        break;
                    case 9:
                        System.out.println("Ver todos los murales");
                        break;
                    default:
                        System.out.println("Por favor, selecciona un número entre 1 y 4.");
                    }
            }
            scanner.close();
    }
}
