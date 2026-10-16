package obligatorio1;

import java.util.Objects;

public class Ficha {
    private String nombre;
    private String color;
    private String diseno33;
    private String diseno55;
    private String coloresValidos = "[RABNMVGC]";

    public Ficha(){
        
    }
    public Ficha(String nombre, String color, String diseno33, String diseno55) {
        this.nombre = nombre;
        this.color = color;
        this.diseno33 = diseno33;
        this.diseno55 = diseno55;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiseno33() {
        return diseno33;
    }

    public void setDiseno33(String diseno33) {
        this.diseno33 = diseno33;
    }

    public String getDiseno55() {
        return diseno55;
    }

    public void setDiseno55(String diseno55) {
        this.diseno55 = diseno55;
    }

    public String getColoresValidos() {
        return coloresValidos;
    }

    public void setColoresValidos(String coloresValidos) {
        this.coloresValidos = coloresValidos;
    }

    @Override
    public String toString() {
        return "Ficha{" + "nombre=" + nombre + ", color=" + color + ", diseno33=" + diseno33 + ", diseno55=" + diseno55 + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Ficha f = (Ficha)obj;
        if (this.getNombre().equalsIgnoreCase(f.getNombre()) &&
            this.getColor().equalsIgnoreCase(f.getColor()) && 
            this.getDiseno33().equalsIgnoreCase(f.getDiseno33()) && 
            this.getDiseno55().equalsIgnoreCase(f.getDiseno55())){
            
            return true;
        }else{
            return false;
        }
    }
    
}
