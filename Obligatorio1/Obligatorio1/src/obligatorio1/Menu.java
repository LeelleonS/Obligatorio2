//Alumno: Leonardo Santos, Número de Estudiante: 390545

package obligatorio1;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

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
                System.out.println("0) Terminar");
                System.out.println("1) Informacion de los autores");
                System.out.println("2) Registrar Diseñador");
                System.out.println("3) Registrar Ficha");
                System.out.println("4) Registrar Mural");    
                System.out.println("5) Modificar Mural");
                System.out.println("6) Ver Mural");
                System.out.println("7) Ver Diseñadores");
                System.out.println("8) Comparar Murales");
                System.out.println("9) Ver todas las Fichas");

                opcion = pedirYValidarEntero(scanner, "Elige una opción: ",0,9);

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
                        modificarMural(sistema, scanner);
                        break;
                    case 6:
                        visualizarMural(sistema, scanner);
                        break;
                    case 7:
                        visualizarDisenadores(sistema, scanner);
                        break;
                    case 8:
                        compararMurales(sistema, scanner);
                        break;
                    case 9:
                        visualizarFichas(sistema);
                        break;
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
    
    private static void mostrarFichas(ArrayList<Ficha> lista){
        int numero = 1;
        for (Ficha f: lista){
            System.out.println(numero+") "+f.getNombre());
            numero++;
        }
    }
    
    private static void mostrarDisenadores(ArrayList<Disenador> disenadores){
        int numero = 1;
        for (Disenador d: disenadores){
            System.out.println(numero+") "+ d.getNombre());
            numero++;
        }
    }
    
    private static void mostrarMurales(ArrayList<Mural> murales){
        int numero = 1;
        for (Mural m: murales){
            System.out.println(numero+") "+m.getNombre());
            numero ++;
        }
    }
    
    private static void mostrarMuralesYDisenadores(ArrayList<Mural> murales){
        int numero = 1;
        for (Mural m: murales){
            System.out.println(numero+") "+m.getNombre() + " - " +m.getDisenador().getNombre());
            numero ++;
        }
    }
    
    private static void mostrarMuralesAmbosFormatos(Mural m){
        System.out.println("Mural con ficha \"" + m.getFicha1().getNombre() + "\" y \"" + m.getFicha2().getNombre() + "\" en formato "+ m.getNombreFormato() + " en tamaño Grande y Chico");
        System.out.println(m.dibujarMural(5));
        System.out.println("=================================================================");
        System.out.println(m.dibujarMural(3));
    }
    
    //CASE 2
    private static void registrarDisenador(Sistema sistema, Scanner scanner){
        String nombre;
        String direccion;
        String email;
        System.out.println("Registro de Diseñador, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        scanner.nextLine();
        do{
            System.out.print("Ingrese el nombre del diseñador: ");
            nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("0")){
                return;
            }
            if (sistema.existeDisenador(nombre)){
                System.out.println("El usuario ya existe, intente nuevamente");
            }
            if (nombre.isEmpty()){
                System.out.println("El nombre no puede estar vacío");
            }
        }
        while(sistema.existeDisenador(nombre) || nombre.isEmpty());
        
        System.out.print("Ingrese la dirección: ");
        direccion = scanner.nextLine();
        if (direccion.equalsIgnoreCase("0")){
            return;
        }
        
        System.out.print("Ingrese el correo: ");
        email = scanner.next();
        if (email.equalsIgnoreCase("0")){
            return;
        }
        
        Disenador d = new Disenador(nombre,direccion,email);
        sistema.agregarDisenador(d);
        
    }
    
    //CASE 3
    private static void registrarFicha(Sistema sistema, Scanner scanner){
        String nombreFicha;
        String colorFicha;
        String diseno33;
        String diseno55;
                        
        System.out.println("Registro de Ficha, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        scanner.nextLine();
        
        do{
            System.out.println("Ingrese el nombre de la ficha");
            nombreFicha = scanner.nextLine().trim().toUpperCase();
            if(nombreFicha.equalsIgnoreCase("0")){
                return;
            }
            if(nombreFicha.isEmpty()){
                System.out.println("El nombre no puede estar vacío");
            }else if(sistema.existeFicha(nombreFicha)){
                System.out.println("Ya existe una ficha con ese nombre, intenté otro");
            }
        }while(nombreFicha.isEmpty() || sistema.existeFicha(nombreFicha));
        
        do{
            System.out.println("Ingrese el color de la ficha seleccionando la letra correspondiente al color desado:\n R:Rojo, A:Azul, B:Blanco, N:Negro, M:Amarillo, V:Verde, G:Magena, C:Celeste");
            colorFicha = scanner.next().toUpperCase();
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
            if (diseno33.length() != 9){
                System.out.println("El tamaño debe ser de 9 caracteres");
            }
        }while (diseno33.length() != 9);
                         
        do{
            System.out.println("Ingrese el diseño grande de la ficha, este deberá tener un largo de 25 y los espacios en blanco se representan con un punto (.)");
            diseno55 = scanner.next();
            if (diseno55.equalsIgnoreCase("0")){
                return;
            }
            if (diseno55.length() != 25){
                System.out.println("El tamaño debe ser de 25 caracteres");
            }
        }while (diseno55.length() != 25);
                        
        Ficha f = new Ficha(nombreFicha, colorFicha, diseno33, diseno55);
        sistema.agregarFichas(f);
    }
    
    //CASE 4
    private static void registrarMural(Sistema sistema, Scanner scanner){
        String nombreMural;
        String formatoMural;
        int ficha;
        int disenador;
        Disenador d = null;
        Ficha f1 = null;
        Ficha f2 = null;
        ArrayList<Ficha> disponibles = new ArrayList<>(sistema.getFichas());

                        
        if(sistema.getDisenadores().isEmpty()){
            System.out.println("Necesitas ingresar un Diseñador antes de agregar Murales");
            return;
        }
        
        System.out.println("Registro de Mural, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        
        mostrarDisenadores(sistema.getDisenadores());
        disenador = pedirYValidarEntero(scanner,"Ingrese el diseñador de este Mural indicando el numero del menú:",0,sistema.getDisenadores().size());
        if (disenador == 0){
            return;
        }
        d = sistema.getDisenadores().get(disenador - 1);
        scanner.nextLine();
                        
        do{
            System.out.println("Ingrese el nombre del Mural");
            nombreMural = scanner.nextLine().trim();
            if (nombreMural.equalsIgnoreCase("0")){
                return;
            }
            if (nombreMural.isEmpty()){
                System.out.println("El nombre no puede estar vacío");
            }else if (sistema.existeMural(nombreMural)){
                System.out.println("El nombre ya esta en uso, utilice uno diferente");
            }
        }while (nombreMural.isEmpty() || sistema.existeMural(nombreMural));
                        
        do{
            System.out.println("Ingrese el formato del Mural indicando una letra:\n D: Damero, R: Aleatorio, F: Por Filas, B: Borde, M: Manual");
            formatoMural = scanner.next();
            if (formatoMural.equalsIgnoreCase("0")){
                return;
            }
            if(!formatoMural.matches("[DRFBM]")){
                System.out.println("Elija una de las letras de la lista");
            }
        }while (!formatoMural.matches("[DRFBM]"));        
        
        mostrarFichas(sistema.getFichas());
        ficha = pedirYValidarEntero(scanner, "Elija una ficha para ser la primera seleccion del Mural",0,sistema.getFichas().size());
        if (ficha == 0){
            return;
        }
        f1 = sistema.getFichas().get(ficha - 1);
        
        disponibles.remove(f1);
        mostrarFichas(disponibles);
        ficha = pedirYValidarEntero(scanner, "Elija una ficha para ser la segunda seleccion del Mural",0,disponibles.size());
        if (ficha == 0){
            return;
        }
        f2 = disponibles.get(ficha - 1);
        
        Mural m = new Mural(nombreMural,d,formatoMural,f1,f2,sistema.getFichaVacia());
        
        if (formatoMural.equalsIgnoreCase("M")){
            pedirFichasManuales(scanner, m, f1, f2);
            m.respaldarOriginal();
        }
        
        sistema.agregarMural(m);
        mostrarMuralesAmbosFormatos(m);
    }
    
    private static void pedirFichasManuales(Scanner scanner, Mural m, Ficha ficha1, Ficha ficha2){
        System.out.println("Como el formato seleecionado fue M (Manual) debe elegir que posiciones llevan cada ficha");
        int fila;
        int columna;
        int fichaElegida;
        do{
            fila = pedirYValidarEntero(scanner, "Elija la fila entre 1 y 10: Para terminar la colocación seleccione 0",0,10);
            if (fila == 0){
            //No hago nada, espero a que el while corte
            } else {
                columna = pedirYValidarEntero(scanner, "Elija la columna entre 1 y 12: Para cambiar la fila seleccione 0",0,12);
                if (columna == 0){
                    // No hago nada, dejo que repita el while para elegir la fila de nuevo
                }else{
                    fichaElegida = pedirYValidarEntero(scanner, "Que ficha desea colocar en la posición ("+fila+","+columna+")?\n 1)"+ficha1.getNombre()+"\n2)"+ficha2.getNombre()+"",0,2);
                    if(fichaElegida == 1){
                        m.colocarFicha(fila-1, columna-1, ficha1);
                    }else if (fichaElegida == 2){
                        m.colocarFicha(fila-1, columna-1, ficha2);
                    }
                }
            }
        }while (fila != 0);
    }
            

    private static int pedirYValidarEntero(Scanner scanner, String mensaje, int min, int max){
        int numero;
        boolean valido;
        do {
            System.out.println(mensaje);
            while (!scanner.hasNextInt()) {          // si escribió letras
                System.out.println("Debe ingresar un número");
                scanner.next();                       // descarta lo que escribió
            }
            numero = scanner.nextInt();
            valido = numero >= min && numero <= max;
            if (!valido) {
                System.out.println("Debe elegir un número entre " + min + " y " + max);
            }
        } while (!valido);
        return numero;
    }
    
    //CASE 5
    private static void modificarMural(Sistema sistema, Scanner scanner){
        System.out.println("Modificador de murales, puede ingresar 0 (cero) en cualquier opcion para volver al menu");

        boolean salir = false;
        int mural;
        int opcion;
        Mural m;
        
        if(sistema.getMurales().isEmpty()){
            System.out.println("Necesitas ingresar un Mural antes de modificar alguno");
            return;
        }
        
        mostrarMuralesYDisenadores(sistema.getMurales()); 
        mural = pedirYValidarEntero(scanner,"Que mural desea modificar?",0,sistema.getMurales().size());
        if (mural == 0){
            return;
        }
        m = sistema.getMurales().get(mural -1);
        while(!salir){
            
            System.out.println("Que modificación desea hacer sobre el mural "+ m.getNombre());
            System.out.println("0) Volver");
            System.out.println("1) Modificar posición");
            System.out.println("2) Modificar ficha");
            System.out.println("3) Restaurar");
            
            opcion = pedirYValidarEntero(scanner,"",0,3);
                        
            switch(opcion){
            case 0:
                System.out.println("Volviendo al menu principal");
                salir = true;
                break;
            case 1:
                modificarPosicion(sistema, scanner, m);
                break;
            case 2:
                intercambiarFicha(sistema, scanner, m);
                break;
            case 3:
                m.restaurar();
                mostrarMuralesAmbosFormatos(m);
                break;
            }    
        }
    }    
       
    private static void modificarPosicion(Sistema sistema,Scanner scanner, Mural m){
        int fila;
        int columna;
        int nuevaFicha;
        String confirma;
        
        fila = pedirYValidarEntero(scanner,"Indique la fila de la ficha a modificar:",0,10);
        if (fila == 0){
            return;
        }
        columna = pedirYValidarEntero(scanner,"Indique la columna de la ficha a modificar:",0,12);
        if (columna == 0){
            return;
        }
        
        System.out.println("La ficha a modificar es :" + m.getFicha(fila-1,columna-1).getNombre());
        System.out.println(m.getFicha(fila-1,columna-1).dibujar(3));
        
        mostrarFichas(sistema.getFichas());
        nuevaFicha = pedirYValidarEntero(scanner,"Por cual nueva ficha quieres sustituirla?",0,sistema.getFichas().size());
        if (nuevaFicha == 0){
            return;
        }
        
        scanner.nextLine();
        System.out.println("La nueva ficha que ocupará la posición ("+fila+","+columna+") será:"+sistema.getFichas().get(nuevaFicha-1).getNombre());
        System.out.println(sistema.getFichas().get(nuevaFicha-1).dibujar(3));
        System.out.println("Desea confirmar? S/n");
        confirma = scanner.nextLine();
        if ((confirma).isEmpty() || confirma.equalsIgnoreCase("S")){
            m.colocarFicha(fila-1, columna-1, sistema.getFichas().get(nuevaFicha-1));
            mostrarMuralesAmbosFormatos(m);
        }
    }
    
    private static void intercambiarFicha(Sistema sistema, Scanner scanner, Mural m){
        int fichaACambiar;
        int nuevaFicha;
        Ficha reemplazar;
        Ficha nueva;
        String confirma;
        ArrayList<Ficha> usadas = m.fichasUsadas();
        
        System.out.println("El mural usa las siguientes fichas: ");
        mostrarFichas(usadas);
        fichaACambiar = pedirYValidarEntero(scanner,"Que ficha desea intercambiar por otra?",0,usadas.size());
        if(fichaACambiar == 0){
            return;
        }
        reemplazar = (usadas.get(fichaACambiar - 1));
        
        mostrarFichas(sistema.getFichas());
        nuevaFicha = pedirYValidarEntero(scanner,"Que ficha reemplazará a "+ reemplazar.getNombre(),0,sistema.getFichas().size());
        if(nuevaFicha == 0){
            return;
        }
        nueva = sistema.getFichas().get(nuevaFicha-1);
        
        System.out.println("La ficha " + nueva.getNombre());
        System.out.println(nueva.dibujar(3));
        System.out.println("reemplazará a la ficha " + reemplazar.getNombre() + " en el Mural");
        System.out.println(reemplazar.dibujar(3));
        System.out.println("Desea confirmar? S/n");
        
        scanner.nextLine();
        confirma = scanner.nextLine();
        if ((confirma).isEmpty() || confirma.equalsIgnoreCase("S")){
            m.reemplazarFicha(reemplazar,nueva);
            mostrarMuralesAmbosFormatos(m);
        }
    }
    
    //CASE 6
    private static void visualizarMural(Sistema sistema, Scanner scanner){
        System.out.println("Visualizador de murales, puede ingresar 0 (cero) en cualquier opcion para volver al menu");
        
        Disenador d = null;
        int disenador;
        int mural;
        int tamano;
        String siguiente;
        ArrayList<Disenador> disenadoresConMurales = sistema.disenadoresConMurales();
        
        if(sistema.getMurales().isEmpty()){
            System.out.println("Necesitas ingresar un Mural antes de visualizarlos");
            return;
        }
                
        mostrarDisenadores(disenadoresConMurales);      
        disenador = pedirYValidarEntero(scanner,"Indique el diseñador para ver sus murales",0,disenadoresConMurales.size());
        if (disenador == 0){
            return;
        }
        d = disenadoresConMurales.get(disenador - 1);
        
        mostrarMurales(d.getMurales());
        mural = pedirYValidarEntero(scanner,"Que mural desea ver?",0,d.getMurales().size());
        if (mural == 0){
            return;
        }
        
        tamano = pedirYValidarEntero(scanner,"Elija el formato a mostrar: \n1) Chico\n2) Grande",0,2);
        if (tamano == 0){
            return;
        }
        
        scanner.nextLine();
        do{
            System.out.println(d.getMurales().get(mural -1).dibujarMural((tamano == 1 ? 3:5)));
            System.out.println("Presione ENTER para ver el tamano " + (tamano == 1 ? "Grande":"Chico") + " ó presione 'S' para Salir");
            siguiente = scanner.nextLine();
            if(siguiente.isEmpty()){
                tamano = (tamano == 1) ? 2 : 1;
            }
        }while(!siguiente.equalsIgnoreCase("S"));
        
    }
    
    //CASE 7
    private static void visualizarDisenadores(Sistema sistema, Scanner scanner){
        if (sistema.getDisenadores().isEmpty()) {
            System.out.println("No hay diseñadores registrados");
            return;
        }
        for (Disenador d : sistema.ordenarAlf()){
            System.out.println("===========================================================");
            System.out.println(d.toString());
            System.out.println("Cantidad de Murales: " + d.cantidadMurales());
            System.out.println("Fichas diferentes usadas: " +d.cantidadFichasDiferentes());
            System.out.println("Colores diferentes usados: " +d.cantidadColoresDiferentes());
            System.out.println("===========================================================");
        }        
    }
    
    //CASE 8
    private static void compararMurales(Sistema sistema, Scanner scanner){
        if (sistema.getMurales().isEmpty()){
            System.out.println("No hay murales registrados");
            return;
        }
        
        boolean existeEnOtroMural = false;
        int primerMural;
        Mural m1;
        int filaInicio;
        int columnaInicio;
        int alto;
        int ancho;
        
        mostrarMurales(sistema.getMurales());
        primerMural = pedirYValidarEntero(scanner,"Elija el mural a comparar ",0,sistema.getMurales().size());
        if (primerMural == 0){
            return;
        }
        m1 = sistema.getMurales().get(primerMural -1);
        
        filaInicio = pedirYValidarEntero(scanner,"Indique la fila donde inicia la comparación ",0,10);
        if (filaInicio == 0){
            return;
        }
        
        columnaInicio = pedirYValidarEntero(scanner,"Indique la columna donde inicia la comparación ",0,12);
        if (columnaInicio == 0){
            return;
        }
       
        alto = pedirYValidarEntero(scanner,"Indique la cantidad de filas ",0,10 - filaInicio + 1);
        if (alto == 0){
            return;
        }
        
        ancho = pedirYValidarEntero(scanner,"Indique la cantidad de columnas ",0,12 - columnaInicio + 1);
        if (ancho == 0){
            return;
        }
        
        Ficha[][] recorte = m1.recorteDeMatriz(filaInicio - 1, columnaInicio - 1, alto, ancho);
        for (Mural otrosMurales : sistema.getMurales()){
            if(!otrosMurales.equals(m1)){
                int[] pos = otrosMurales.buscarRecorte(recorte);
                if(pos != null){
                    System.out.println(otrosMurales.getNombre()+ ": fila " + (pos[0]+1) + ", columna " + (pos[1] + 1));
                    existeEnOtroMural = true;
                }
            }
        }
        if (!existeEnOtroMural){
            System.out.println("No hay otros murales con este patrón");
        }       
    }
    
    //CASE 9
    private static void visualizarFichas(Sistema sistema){
        for (Ficha ficha : sistema.getFichas()){
            System.out.println("Ficha: " + ficha.getNombre());
            System.out.println("Color: " + ficha.getColor());
            System.out.println("Tamaño chico: ");
            System.out.print(ficha.dibujar(3));
            System.out.println("Tamaño grande: ");
            System.out.print(ficha.dibujar(5));
        }
    }
}