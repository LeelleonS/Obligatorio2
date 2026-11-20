// Leonardo Santos - 390545

package dominio;

import java.io.Serializable;

public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String cedula;
    private String apellido;
    private String celular;

    public Familia(String cedula, String apellido, String celular) {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalArgumentException("La cédula es obligatoria");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        this.cedula = cedula.trim();
        this.apellido = apellido.trim();
        this.celular = celular == null ? "" : celular.trim();
    }

    public String getCedula() {
        return cedula;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getCelular(){
        return celular;
    }

    @Override
    public String toString() {
        return apellido + " (" + cedula + ")";
    }
}
