// Leonardo Santos - 390545

package interfaz;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class Validaciones {

    public static final String NUMERO = "[0-9]+([.,][0-9]+)?";

    public static boolean esValido(JTextComponent campo, String regex) {
        return campo.getText().trim().matches(regex);
    }

    public static boolean esNumeroPositivo(JTextComponent campo) {
        return esValido(campo, NUMERO) && aNumero(campo) > 0;
    }

    public static double aNumero(JTextComponent campo) {
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }

    public static void avisarSiEstaMal(JTextComponent campo, boolean ok, JLabel etiqueta, String mensaje) {
        if (!ok && !campo.getText().trim().isEmpty()) {
            campo.setForeground(Color.RED);
            etiqueta.setText(mensaje);
            etiqueta.setForeground(Color.RED);
        } else {
            campo.setForeground(Color.BLACK);
            etiqueta.setText("");
        }
    }
}
