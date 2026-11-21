// Leonardo Santos - 390545

package dominio;

import java.io.Serializable;

public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private final String rut;
    private String direccion;

    public Empresa(String nombre, String rut, String direccion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (rut == null || rut.isBlank()) {
            throw new IllegalArgumentException("El RUT es obligatorio");
        }
        this.nombre = nombre.trim();
        this.rut = rut.trim();
        this.direccion = direccion == null ? "" : direccion.trim();
    }

    public String getRut() {
        return rut;
    }

    public String getNombre(){
        return nombre;
    }
}
