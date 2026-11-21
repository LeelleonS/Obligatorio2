// Leonardo Santos - 390545

package modelo;

import interfaz.FrmMenu;
import javax.swing.UIManager;

public class Obligatorio2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        }
        FrmMenu menu = new FrmMenu(sistema);
        menu.setVisible(true);
    }
}
