//Alumno: Leonardo Santos, Número de Estudiante: 390545

package obligatorio1;

import java.util.ArrayList;
import java.util.Random;

public class Mural {
    private String nombre;
    private Disenador disenador;
    private String formato;
    private Ficha ficha1;
    private Ficha ficha2;
    private Ficha vacia;
    private static final int FILAS = 10;
    private static final int COLUMNAS = 12;
    private Ficha[][] matriz;
    private Ficha[][] original;

    public Mural(String nombre){
        this.nombre = nombre;
    }
    
    public Mural(String nombre, Disenador disenador, String formato, Ficha ficha1, Ficha ficha2, Ficha vacia) {
        this.nombre = nombre;
        this.disenador = disenador;
        this.formato = formato;
        this.ficha1 = ficha1;
        this.ficha2 = ficha2;
        this.vacia = vacia;
        this.matriz = new Ficha[FILAS][COLUMNAS];
        this.original = new Ficha[FILAS][COLUMNAS];
        aplicarFormato();
        respaldarOriginal();
    }

    public String getNombre() {
        return nombre;
    }

    public Disenador getDisenador() {
        return disenador;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public Ficha getFicha2() {
        return ficha2;
    }

    public Ficha getFicha(int fila, int col) {
        return matriz[fila][col];
    }

    @Override
    public boolean equals(Object obj) {
        Mural m = (Mural) obj;
        return this.getNombre().equalsIgnoreCase(m.getNombre());
    }
    
    public void colocarFicha(int fila, int col, Ficha f) {
        matriz[fila][col] = f;
    }
         
    private void aplicarFormato() {
    switch (formato) {
        case "D":
            crearDamero();
            break;
        case "F":
            crearAlternado();
            break;
        case "B":
            crearBorde();
            break;
        case "R":
            crearRandom();
            break;
        case "M":
            llenarVacio();
            break;
        }
    }
   
    private void crearDamero(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if ((i + j) % 2 == 0){
                    this.matriz[i][j] = this.ficha1;
                }else{
                    this.matriz[i][j] = this.ficha2;
                }              
            }
        }
    }
    
    private void crearAlternado() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if ((i % 2) == 0){
                    this.matriz[i][j] = this.ficha1;
                }else{
                    this.matriz[i][j] = this.ficha2;
                }              
            }
        }
    }
    
    private void crearBorde(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (i == 0 || i == FILAS - 1 || j == 0 || j == COLUMNAS - 1){
                    this.matriz[i][j] = this.ficha1;
                }else{
                    this.matriz[i][j] = this.ficha2;
                }
            }
        }
    }
    
    private void crearRandom(){
        llenarVacio();
        Random r = new Random();
        int fichaElegida;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                fichaElegida = r.nextInt(3);
                if (fichaElegida == 1){
                    matriz[i][j] = this.ficha1;
                }
                if (fichaElegida == 2){
                    matriz[i][j] = this.ficha2;
                }
            }
        }
    }
    private void llenarVacio(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = vacia;   
            }
        }
    }
    
    public String dibujarMural(int tamano){
        String imprimir = "";
        for (int i = 0; i < FILAS; i++) {
            for (int linea = 0; linea < tamano; linea++) {
                for (int j = 0; j < COLUMNAS; j++) {
                    Ficha ficha = matriz[i][j];
                    imprimir += ficha.getCodigoColor() + ficha.obtenerLinea(linea, tamano) + "\u001B[0m";
                }
                imprimir +="\n";
            }
        }
        return imprimir;
    }
    
    public String getNombreFormato(){
        String nombreFormato = "";
        switch (this.formato){
            case "D":
            nombreFormato = "Damero";
            break;
        case "F":
            nombreFormato = "Por filas";
            break;
        case "B":
            nombreFormato = "Borde exterior";
            break;
        case "R":
            nombreFormato = "Aleatorio";
            break;
        case "M":
            nombreFormato = "Manual";
            break;
        }
        return nombreFormato;
    }
    
    public ArrayList<Ficha> fichasUsadas(){
        ArrayList<Ficha> usadas = new ArrayList<>();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!usadas.contains(matriz[i][j])){
                    usadas.add(matriz[i][j]);
                }
            }
        }
        return usadas;
    }
    
    public void reemplazarFicha(Ficha vieja, Ficha nueva){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(matriz[i][j].equals(vieja)){
                    matriz[i][j] = nueva;
                }   
            }
        }
    }
    
    private void copiar(Ficha[][] desde, Ficha[][] hacia){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                hacia[i][j] = desde[i][j]; 
            }           
        }
    }
    
    public void respaldarOriginal(){
        copiar(matriz, original);
    }
    
    public void restaurar(){
        copiar(original, matriz);
    }
    
    public Ficha[][] recorteDeMatriz(int inicioFila, int inicioColumna, int alto, int ancho){
        Ficha[][] recorte = new Ficha[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                recorte[i][j] = matriz[inicioFila + i][inicioColumna + j];
            }
        }
        return recorte;
    }
    
    public int[] buscarRecorte(Ficha[][] recorte){
        for (int i = 0; i <= FILAS - recorte.length; i++) {
            for (int j = 0; j <= COLUMNAS - recorte[0].length; j++) {
                if (coincideRecorte(recorte, i, j)){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    
    private boolean coincideRecorte(Ficha[][] recorte, int fila, int columna){
        for (int i = 0; i < recorte.length; i++) {
            for (int j = 0; j < recorte[0].length; j++) {
                if (!matriz[fila+i][columna+j].equals(recorte[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}
