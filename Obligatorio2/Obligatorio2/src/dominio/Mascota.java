// Leonardo Santos - 390545

package dominio;

import java.io.Serializable;

public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String codigo;
    private String nombre;
    private String temperamento;
    private double peso;
    private EstadoMascota estado;

    
    public Mascota(String codigo, String nombre, String temperamento, double peso, EstadoMascota estado) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0");
        }
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
        this.temperamento = temperamento == null ? "" : temperamento.trim();
        this.peso = peso;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public double getPeso() {
        return peso;
    }

    public EstadoMascota getEstado() {
        return estado;
    }

    public void setEstado(EstadoMascota estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
