// Leonardo Santos - 390545

package obligatorio2;

public class Obligatorio2 {

    public static void main(String[] args) {
        // Única instancia del sistema, compartida por todas las ventanas
        Sistema sistema = new Sistema();
        FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal(sistema);
        menuPrincipal.setVisible(true);
    }
}
