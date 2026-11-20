// Leonardo Santos - 390545

package dominio;

import java.io.Serializable;

public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int numero;
    private final Empresa empresa;
    private final TipoAlimento tipoAlimento;
    private final double kilos;

    public Donacion(int numero, Empresa empresa, TipoAlimento tipoAlimento, double kilos) {
        this.numero = numero;
        this.empresa = empresa;
        this.tipoAlimento = tipoAlimento;
        this.kilos = kilos;
    }

    public int getNumero() {
        return numero;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public double getKilos() {
        return kilos;
    }
}
