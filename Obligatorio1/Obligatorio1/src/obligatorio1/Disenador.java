package obligatorio1;

import java.util.ArrayList;

public class Disenador {
    private String nombre;
    private String direccion;
    private String mail;
    private ArrayList<Mural> murales;

    public Disenador(){
        
    }
    
    public Disenador(String nombre, String direccion, String mail) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.murales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
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
    
    /*public int cantidadFichasDiferentes(){
        ArrayList<Ficha> diferentes = new ArrayList<>();
        for (Mural m : murales){
            for (Ficha f : m.fichasUsadas())
        }
    }
    */

    @Override
    public boolean equals(Object obj) {
        Disenador d = (Disenador)obj;
        return this.getNombre().equalsIgnoreCase(d.getNombre());
    }
    
   
    public void registarDisenador(){
        
    }
}
