// Leonardo Santos - 390545

package obligatorio2;

public enum TipoAlimento {
    PERROS_GRANDES(1, "Para perros grandes"),
    PERROS_CHICOS(2, "Para perros chicos"),
    PERROS_ADULTOS(3, "Para perros adultos"),
    OTRO(4, "Otro");

    private final int codigo;
    private final String descripcion;

    private TipoAlimento(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Traduce el código numérico usado en la letra y en los archivos de importación
    public static TipoAlimento desdeCodigo(int codigo) {
        for (TipoAlimento tipo : values()) {
            if (tipo.codigo == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de alimento inválido: " + codigo);
    }

    @Override
    public String toString() {
        return codigo + " - " + descripcion;
    }
}
