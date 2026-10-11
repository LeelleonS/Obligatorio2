package obligatorio1;
import java.util.ArrayList;

public class Sistema {
    ArrayList<Disenador> disenadores;
    ArrayList<Ficha> fichas;
    ArrayList<Mural> murales;

    public Sistema(){
        disenadores = new ArrayList();
        fichas = new ArrayList();
        murales = new ArrayList();
    }
    
    public ArrayList<Disenador> getDisenadores() {
        return disenadores;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }
    
    public ArrayList<Ficha> getFichas(Ficha f){
        return fichas;
    }
    
    public ArrayList<Mural> getMurales() {
        return murales;
    }
   
    @Override
    public String toString() {
        return "Sistema{" + "disenadores=" + disenadores + ", fichas=" + fichas + ", murales=" + murales + '}';
    }
    
    public void agregarDisenador(Disenador d){
        disenadores.add(d);
    }
    
    public void agregarMural(Mural m){
        murales.add(m);
    }
    
    public void agregarFicha (Ficha f){
        fichas.add(f);
    }
    
    public boolean existeDisenador(String disenador){
        Disenador dAux = new Disenador(disenador,"","");
        return disenadores.contains(dAux);
    }
}
