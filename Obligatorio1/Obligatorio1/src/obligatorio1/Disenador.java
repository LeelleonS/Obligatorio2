//Alumno: Leonardo Santos, Número de Estudiante: 390545

package obligatorio1;

import java.util.ArrayList;

public class Disenador implements Comparable<Disenador>{
    private String nombre;
    private String direccion;
    private String mail;
    private ArrayList<Mural> murales;
    
    public Disenador(String nombre, String direccion, String mail) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.murales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMail() {
        return mail;
    }

    public void agregarMural(Mural m){
        murales.add(m);
    }
    
    public ArrayList<Mural> getMurales(){
        return murales;
    }
    
    public int cantidadMurales(){
        return murales.size();
    }

    @Override
    public String toString(){
        return "Nombre: " + this.getNombre() + "\nDireccion: " + this.getDireccion() + "\nMail: " + this.getMail();
    }
            
    @Override
    public boolean equals(Object obj) {
        Disenador d = (Disenador)obj;
        return this.getNombre().equalsIgnoreCase(d.getNombre());
    }
    
    @Override
    public int compareTo(Disenador d){
        return this.getNombre().compareToIgnoreCase(d.getNombre());
    }
    
    public int cantidadFichasDiferentes(){
        ArrayList<Ficha> todas = new ArrayList<>();
        for (Mural m : murales){
            for (Ficha f : m.fichasUsadas()){
                if(!todas.contains(f)){
                    todas.add(f);
                }
            }
        }
        return todas.size();
    }
    
    public int cantidadColoresDiferentes(){
        ArrayList<String> colores = new ArrayList<>();
        for (Mural m: murales){
            for (Ficha f : m.fichasUsadas()){
                if(!colores.contains(f.getColor())){
                    colores.add(f.getColor());
                }
            }
        }
        return colores.size();
    }
}
