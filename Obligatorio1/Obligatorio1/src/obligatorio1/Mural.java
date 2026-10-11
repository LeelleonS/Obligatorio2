
package obligatorio1;

import java.util.Objects;

public class Mural {
    private String nombre;
    private String formato;
    private Ficha ficha1;
    private Ficha ficha2;

    public Mural(String nombre, String formato, Ficha ficha1, Ficha ficha2) {
        this.nombre = nombre;
        this.formato = formato;
        this.ficha1 = ficha1;
        this.ficha2 = ficha2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public void setFicha1(Ficha ficha1) {
        this.ficha1 = ficha1;
    }

    public Ficha getFicha2() {
        return ficha2;
    }

    public void setFicha2(Ficha ficha2) {
        this.ficha2 = ficha2;
    }

    @Override
    public String toString() {
        return "Mural{" + "nombre=" + nombre + ", formato=" + formato + ", ficha1=" + ficha1 + ", ficha2=" + ficha2 + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mural other = (Mural) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.formato, other.formato)) {
            return false;
        }
        if (!Objects.equals(this.ficha1, other.ficha1)) {
            return false;
        }
        return Objects.equals(this.ficha2, other.ficha2);
    }
    
    
    
}
