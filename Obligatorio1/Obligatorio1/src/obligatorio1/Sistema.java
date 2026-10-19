//Alumno: Leonardo Santos, Número de Estudiante: 390545

package obligatorio1;
import java.util.ArrayList;
import java.util.Collections;

public class Sistema {
    private ArrayList<Disenador> disenadores;
    private ArrayList<Ficha> fichas;
    private ArrayList<Mural> murales;

    public Sistema(){
        disenadores = new ArrayList<>();
        fichas = new ArrayList<>();
        murales = new ArrayList<>();
    }
    
    public ArrayList<Disenador> getDisenadores() {
        return disenadores;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }
    
    public ArrayList<Mural> getMurales() {
        return murales;
    }

    public void agregarDisenador(Disenador d){
        disenadores.add(d);
    }
    
    public void agregarMural(Mural m){
        murales.add(m);
        m.getDisenador().agregarMural(m);
    }
    
    public void agregarFichas (Ficha... f){
        for (Ficha ficha : f){
            fichas.add(ficha);
        }
    }
    
    public boolean existeDisenador(String disenador){
        Disenador dAux = new Disenador(disenador,"","");
        return disenadores.contains(dAux);
    }
    
    public boolean existeFicha(String ficha){
        Ficha fAux = new Ficha(ficha,"","","");
        return fichas.contains(fAux);
    }
    
    public boolean existeMural(String mural){
        Mural mAux = new Mural(mural);
        return murales.contains(mAux);  
    }
    
    public ArrayList<Disenador> ordenarAlf(){
        ArrayList<Disenador> ordenada = new ArrayList<>(disenadores);
        Collections.sort(ordenada);
        return ordenada;
    }
    
    public Ficha getFichaPorNombre(String nombre){
        Ficha fAux = new Ficha(nombre,"","","");
        return fichas.get(fichas.indexOf(fAux));
    }
    
    public Ficha getFichaVacia(){
        return getFichaPorNombre("VACIA");
    }
    
    public ArrayList<Disenador> disenadoresConMurales(){
        ArrayList<Disenador> disenadoresConMurales = new ArrayList<>();
        for(Disenador d : disenadores){
            if (!d.getMurales().isEmpty()){
                disenadoresConMurales.add(d);
            }
        }
        return disenadoresConMurales;
    }

}
