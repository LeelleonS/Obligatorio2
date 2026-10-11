package obligatorio1;

public class Disenador {
    private String Nombre;
    private String Direccion;
    private String Mail;

    public Disenador(String nom, String dir, String mail) {
        this.setNombre("");
        this.setDireccion("");
        this.setMail("");
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    @Override
    public boolean equals(Object obj) {
        Disenador d = (Disenador)obj;
        return this.getNombre().equalsIgnoreCase(d.getNombre());
    }
    
   
    public void registarDisenador(){
        
    }
}
