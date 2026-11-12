// Leonardo Santos - 390545

package obligatorio2;

public enum EstadoMascota {
    NO_DISPONIBLE("No disponible para adoptar"),
    DISPONIBLE("Disponible para adoptar"),
    ENTREGADA("Entregada a familia");

    private final String descripcion;

    private EstadoMascota(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
