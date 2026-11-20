// Leonardo Santos - 390545

package dominio;

import java.io.Serializable;

public class Adopcion implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int numero;
    private final Mascota mascota;
    private final Familia familia;
    private final String comentarios;

    public Adopcion(int numero, Mascota mascota, Familia familia, String comentarios) {
        this.numero = numero;
        this.mascota = mascota;
        this.familia = familia;
        this.comentarios = comentarios == null ? "" : comentarios.trim();
    }

    public int getNumero() {
        return numero;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Familia getFamilia() {
        return familia;
    }
    
    public String getComentario(){
        return comentarios;
    }
}
