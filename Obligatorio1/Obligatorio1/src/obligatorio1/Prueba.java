package obligatorio1;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        Sistema sistema = new Sistema();
        precargarFichas(sistema);
        menuPrincipal(sistema);
    }
    
    private static void menuPrincipal(Sistema sistema){
          
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

            while (!salir) {
                System.out.println("\n--- MENÚ DE OPCIONES ---");
                System.out.println("0. Salir");
                System.out.println("1) Informacion de los autores");
                System.out.println("2) Registrar Diseñador");
                System.out.println("3) Registrar Ficha");
                System.out.println("4) Registrar Mural");    
                System.out.println("5) Modificar Mural");
                System.out.println("6) Ver Mural");
                System.out.println("7) Ver Diseñadores");
                System.out.println("8) Comparar Murales");
                System.out.println("9) Ver todas las Fichas");
                System.out.print("Elige una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del programa");
                        break;
                    case 1:
                        System.out.println("Alumno: Leonardo Santos, Número de Estudiante: 390545");
                        break;
                    case 2:
                        registrarDisenador(sistema, scanner);
                        break;
                    case 3:
                        registrarFicha(sistema, scanner);
                        break;
                    case 4:
                        registrarMural(sistema, scanner);
                        break;
                    case 5:
                        System.out.println("Modificacion de Mural");
                        break;
                    case 6:
                        visualizarMural(sistema, scanner);
                        break;
                    case 7:
                        System.out.println("Ver disenadores");
                        System.out.println(sistema.disenadores.toString());
                        break;
                    case 8:
                        System.out.println("Comparacion de murales");
                        break;
                    case 9:
                        visualizarFichas(sistema);
                        break;
                    default:
                        System.out.println("Por favor, selecciona un número entre 1 y 4.");
                    }
            }
            scanner.close();
    }
    
    private static void precargarFichas(Sistema sistema){
        Ficha sol = new Ficha("SOL","M","\\|/-*-/|\\","..|...\\|/.--*--./|\\...|..");
        Ficha cuadrado = new Ficha("CUADRADO","N","+-+|.|+-+","+---+|...||...||...|+---+");
        Ficha corazon = new Ficha("CORAZON","R","*.****.*.","**.************.***...*..");
        Ficha copa = new Ficha("COPA","C","\\./.|./_\\","\\.../.\\./...|....|.../_\\.");
        Ficha arbol = new Ficha("ARBOL","V",".^.^^^.|.","..^...^^^.^^^^^..|.../.\\.");
        Ficha gato = new Ficha("GATO","A","^.^o.o=^=","/\\_/\\(o.o).>^<../|\\../.\\.");
        Ficha diamante = new Ficha("DIAMANTE","G",".*.*.*.*.","..*...*.*.*...*.*.*...*..");
        Ficha vacia = new Ficha("VACIA","B",".........",".........................");
        sistema.agregarFichas(sol,cuadrado,corazon,copa,arbol,gato,diamante,vacia);
    }
    
    private static void mostrarFichas(Sistema sistema){
        int numero = 1;
        for (Ficha f: sistema.getFichas()){
            System.out.println(numero+") "+f.getNombre());
            numero++;
        }
    }
    
    private static void mostrarDisenadores(Sistema sistema){
        int numero = 1;
        for (Disenador d: sistema.getDisenadores()){
            System.out.println(numero+") "+ d.getNombre());
            numero++;
        }
    }
    
    private static void registrarDisenador(Sistema sistema, Scanner scanner){
        String nombre;
        String direccion;
        String email;
        System.out.println("Registro de Diseñador, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        
        do{
            System.out.print("Ingrese el nombre del diseñador: ");
            nombre = scanner.next();
            if (nombre.equalsIgnoreCase("0")){
                return;
            }
            if (sistema.existeDisenador(nombre)){
                System.out.println("El usuario ya existe, intente nuevamente");
            }
        }
        while(sistema.existeDisenador(nombre));
        
        System.out.println("Ingrese la dirección: ");
        direccion = scanner.next();
        if (direccion.equalsIgnoreCase("0")){
            return;
        }
        
        System.out.println("Ingrese el correo: ");
        email = scanner.next();
        if (email.equalsIgnoreCase("0")){
            return;
        }
        
        Disenador d = new Disenador(nombre,direccion,email);
        sistema.agregarDisenador(d);
        
    }
    
    private static void registrarFicha(Sistema sistema, Scanner scanner){
        String nombreFicha;
        String colorFicha;
        String diseno33;
        String diseno55;
                        
        System.out.println("Registro de Ficha, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        
        do{
            System.out.println("Ingrese el nombre de la ficha");
            nombreFicha = scanner.next().toUpperCase();
            if(nombreFicha.equalsIgnoreCase("0")){
                return;
            }
            if(sistema.existeFicha(nombreFicha)){
                System.out.println("Ya existe una ficha con ese nombre, intenté otro");
            }
        }while(sistema.existeFicha(nombreFicha));
        
        do{
            System.out.println("Ingrese el color de la ficha seleccionando la letra correspondiente al color desado:\n R:Rojo, A:Azul, B:Blanco, N:Negro, M:Amarillo, V:Verde, G:Magena, C:Celeste");
            colorFicha = scanner.next();
            if (colorFicha.equalsIgnoreCase("0")){
                return;
            }
            if (!colorFicha.matches("[RABNMVGC]")){
                System.out.println("Ingrese un color válido");
            }
        }while (!colorFicha.matches("[RABNMVGC]"));
                        
        do{
            System.out.println("Ingrese el diseño pequeño de la ficha, este deberá tener un largo de 9 y los espacios en blanco se representan con un punto (.)");
            diseno33 = scanner.next();
            if (diseno33.equalsIgnoreCase("0")){
                return;
            }
            System.out.println(diseno33.length());
            if (diseno33.length() != 9){
                System.out.println("El tamaño debe ser de 9 caracteres");
            }
        }while (diseno33.length() != 9);
                         
        do{
            System.out.println("Ingrese el diseño pequeño de la ficha, este deberá tener un largo de 25 y los espacios en blanco se representan con un punto (.)");
            diseno55 = scanner.next();
            if (diseno55.equalsIgnoreCase("0")){
                return;
            }
            if (diseno55.length() != 25){
                System.out.println("El tamaño debe ser de 25 caracteres");
            }
        }while (diseno55.length() != 25);
                        
        Ficha f = new Ficha(nombreFicha, colorFicha, diseno33, diseno55);
        sistema.agregarFicha(f);
    }
    
    private static void registrarMural(Sistema sistema, Scanner scanner){
        String nombreMural;
        String formatoMural;
        int ficha;
        int disenador;
        Disenador d = new Disenador();
        Ficha f1 = new Ficha();
        Ficha f2 = new Ficha();
                        
        System.out.println("Registro de Mural, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        do{
            System.out.println("Ingrese el diseñador de este Mural");
            mostrarDisenadores(sistema);
            disenador = scanner.nextInt();
            if (disenador == 0){
                return;
            }
            if (disenador > sistema.getDisenadores().size()){
                System.out.println("No existe ese disenador, elija uno los disponibles");
            }else{
                d = sistema.disenadores.get(disenador - 1);
            }
                            
        }while (disenador > sistema.getDisenadores().size());
                        
        do{
            System.out.println("Ingrese el nombre del Mural");
            nombreMural = scanner.next();
            if (nombreMural.equalsIgnoreCase("0")){
                return;
            }
            if (sistema.existeMural(nombreMural)){
                System.out.println("El nombre ya esta en uso, utilice uno diferente");
            }
        }while (sistema.existeMural(nombreMural));
                        
        do{
            System.out.println("Ingrese el formato del Mural indicando una letra:\n D:Damero, R:Random, F:Por Filas, B:Borde, M:Manual");
            formatoMural = scanner.next();
            if (formatoMural.equalsIgnoreCase("0")){
                return;
            }
            if(!formatoMural.matches("[DRFBM]")){
                System.out.println("Elija una de las letras de la lista");
            }
        }while (!formatoMural.matches("[DRFBM]"));
                        
        do{
            System.out.println("Elija una ficha para ser la primera seleccion del Mural");
            mostrarFichas(sistema);
            ficha = scanner.nextInt();
            if (ficha == 0){
                return;
            }
            if(ficha > sistema.fichas.size()){
                System.out.println("Ingrese una ficha de las disponibles");
            }else{
                f1 = sistema.fichas.get(ficha - 1);
            }
        }while(ficha > sistema.fichas.size());
        
        do{
            System.out.println("Elija una ficha para ser la segunda seleccion del Mural");
            ficha = scanner.nextInt();
            if (ficha == 0){
                return;
            }
            if(ficha > sistema.fichas.size()){
                System.out.println("Ingrese una ficha de las disponibles");
            }else{
                f2 = sistema.fichas.get(ficha - 1);
            }
        }while(ficha > sistema.fichas.size());
        
        Mural m = new Mural(nombreMural,d,formatoMural,f1,f2);
        sistema.agregarMural(m);
    }
    
    private static void visualizarFichas(Sistema sistema){
        for (Ficha ficha : sistema.fichas){
            System.out.println("Ficha: " + ficha.getNombre());
            System.out.println("Color: " + ficha.getColor());
            imprimirFichaPequena(ficha.getDiseno33());
            imprimirFichaGrande(ficha.getDiseno55());
        }
    }
    
    private static void imprimirFichaPequena(String diseno){
        System.out.println("Tamaño chico: ");
        for (int i = 0; i < diseno.length(); i++){
            if(diseno.charAt(i) == '.'){
                System.out.print(" ");
            }else{
                System.out.print(diseno.charAt(i));
            }
            if((i+1) % 3 == 0){
                System.out.println("");
            }
        }
    }
    
    private static void imprimirFichaGrande(String diseno){
        System.out.println("Tamaño grande: ");
        for (int i = 0; i < diseno.length(); i++){
            if(diseno.charAt(i) == '.'){
                System.out.print(" ");
            }else{
                System.out.print(diseno.charAt(i));
            }
            if((i+1) % 5 == 0){
                System.out.println("");
            }
        }
    }
    
    private static void visualizarMural(Sistema sistema, Scanner scanner){
        System.out.println("Visualizador de murales, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        
        Disenador d = new Disenador();
        int disenador;
        int mural;
        int numero = 1;
        
        do{
            System.out.println("Indique el diseñador para ver sus murales");
            mostrarDisenadores(sistema);
            disenador = scanner.nextInt();
            if (disenador == 0){
                return;
            }
            if (disenador > sistema.disenadores.size()){
                System.out.println("Elija un diseñador de la lista");
            }else{
                d = sistema.disenadores.get(disenador - 1);
            }
        }while(disenador > sistema.disenadores.size());
        numero = 1;
        
        do{
            System.out.println("Que mural desea ver?");
            for (Mural m : d.getMurales()){
                System.out.println(numero+")"+m.getNombre());
                numero ++;
            }
            mural = scanner.nextInt();
            if (mural == 0){
                return;
            }
            if (mural > sistema.murales.size()){
                System.out.println("Elije un mural de la lista");
            }
        }while(mural > sistema.murales.size());
        
        System.out.println(sistema.getMurales().get(mural -1).toString());
        
    }
}