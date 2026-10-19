//Alumno: Leonardo Santos, Número de Estudiante: 390545

package obligatorio1;

public class Ficha {
    private String nombre;
    private String color;
    private String diseno33;
    private String diseno55;

    public Ficha(String nombre, String color, String diseno33, String diseno55) {
        this.nombre = nombre;
        this.color = color;
        this.diseno33 = diseno33;
        this.diseno55 = diseno55;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public boolean equals(Object obj) {
        Ficha f = (Ficha)obj;
        return this.getNombre().equalsIgnoreCase(f.getNombre());
    }
    
    public String dibujar(int tamano){
        String dibujo = "";
        for (int i = 0; i < tamano; i++) {
            dibujo += this.getCodigoColor() + this.obtenerLinea(i, tamano) + "\u001B[0m\n";
        }
        return dibujo;
    }
    
    public String obtenerLinea(int linea,int tamano){
        String imprimir = "";
        int inicio = linea * tamano;
        if (tamano == 3){
            imprimir = this.diseno33.substring(inicio,(inicio+tamano));
        }
        
        if (tamano == 5){
            imprimir = this.diseno55.substring(inicio,(inicio+tamano));
        }
        return imprimir.replace('.', ' ');
    }
    
    public String getCodigoColor(){
        switch (this.color) {
            case "R": return "\u001B[31m";   // rojo
            case "V": return "\u001B[32m";   // verde
            case "M": return "\u001B[33m";   // amarillo
            case "A": return "\u001B[34m";   // azul
            case "G": return "\u001B[35m";   // magenta
            case "C": return "\u001B[36m";   // celeste
            case "B": return "\u001B[37m";   // blanco
            case "N": return "\u001B[30m";   // negro
            default:  return "";
        }
    }
    
}
