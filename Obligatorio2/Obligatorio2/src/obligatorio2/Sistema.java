// Leonardo Santos - 390545

package obligatorio2;

import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Mascota> mascotas;
    private ArrayList<Familia> familias;
    private ArrayList<Empresa> empresas;
    private ArrayList<Adopcion> adopciones;
    private ArrayList<Donacion> donaciones;
    private int proxNumAdopcion;
    private int proxNumDonacion;

    public Sistema() {
        mascotas = new ArrayList<>();
        familias = new ArrayList<>();
        empresas = new ArrayList<>();
        adopciones = new ArrayList<>();
        donaciones = new ArrayList<>();
        proxNumAdopcion = 1;
        proxNumDonacion = 1;
    }

    // ---------- Altas ----------

    public void agregarMascota(Mascota m) {
        if (buscarMascota(m.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe una mascota con código " + m.getCodigo());
        }
        mascotas.add(m);
    }

    public void agregarFamilia(Familia f) {
        if (buscarFamilia(f.getCedula()) != null) {
            throw new IllegalArgumentException("Ya existe una familia con cédula " + f.getCedula());
        }
        familias.add(f);
    }

    public void agregarEmpresa(Empresa e) {
        if (buscarEmpresa(e.getRut()) != null) {
            throw new IllegalArgumentException("Ya existe una empresa con RUT " + e.getRut());
        }
        empresas.add(e);
    }

    public Mascota buscarMascota(String codigo) {
        for (Mascota m : mascotas) {
            if (m.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return m;
            }
        }
        return null;
    }

    public Familia buscarFamilia(String cedula) {
        for (Familia f : familias) {
            if (f.getCedula().equals(cedula.trim())) {
                return f;
            }
        }
        return null;
    }

    public Empresa buscarEmpresa(String rut) {
        for (Empresa e : empresas) {
            if (e.getRut().equals(rut.trim())) {
                return e;
            }
        }
        return null;
    }

    // ---------- Movimientos ----------

    public Adopcion realizarAdopcion(Mascota mascota, Familia familia, String comentarios) {
        if (mascota == null || familia == null) {
            throw new IllegalArgumentException("Debe elegir una mascota y una familia");
        }
        if (mascota.getEstado() != EstadoMascota.DISPONIBLE) {
            throw new IllegalStateException("La mascota no está disponible para adoptar");
        }
        Adopcion adopcion = new Adopcion(proxNumAdopcion, mascota, familia, comentarios);
        proxNumAdopcion++;
        adopciones.add(adopcion);
        mascota.setEstado(EstadoMascota.ENTREGADA);
        return adopcion;
    }

    // El número de la adopción anulada no se reutiliza
    public void anularAdopcion(Adopcion adopcion) {
        if (!adopciones.remove(adopcion)) {
            throw new IllegalArgumentException("La adopción no está registrada");
        }
        adopcion.getMascota().setEstado(EstadoMascota.NO_DISPONIBLE);
    }
    
    public Donacion realizarDonacion(Empresa empresa, TipoAlimento tipoAlimento, double kilos){
        Donacion donacion = new Donacion(proxNumDonacion, empresa, tipoAlimento, kilos);
        proxNumDonacion++;
        donaciones.add(donacion);
        return donacion;
    }

    // ---------- Consultas ----------

    public ArrayList<Mascota> getMascotasDisponibles() {
        ArrayList<Mascota> resultado = new ArrayList<>();
        for (Mascota m : mascotas) {
            if (m.getEstado() == EstadoMascota.DISPONIBLE) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public ArrayList<Mascota> getMascotasNoEntregadas() {
        ArrayList<Mascota> resultado = new ArrayList<>();
        for (Mascota m : mascotas) {
            if (m.getEstado() != EstadoMascota.ENTREGADA) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public ArrayList<Familia> getFamilias() {
        ArrayList<Familia> familia = new ArrayList<>();
        for (Familia f : familias){
            familia.add(f);
        }
        return familia;
    }
    
    public ArrayList<Empresa> getEmpresas(){
        ArrayList<Empresa> empresa = new ArrayList<>();
        for(Empresa e : empresas){
            empresa.add(e);
        }
        return empresa;
    }
    
    public int adopcionesPorFamilia(Familia f){
        int cantidadAdopciones = 0;
        for (Adopcion a : adopciones){
            if (a.getFamilia() == f){
                cantidadAdopciones ++;
            }
        }
        return cantidadAdopciones;
    }

    // Se agregan con número creciente, por lo que ya quedan ordenadas por número
    public ArrayList<Adopcion> getAdopciones() {
        ArrayList<Adopcion> adopcion = new ArrayList<>();
        for(Adopcion a : adopciones){
            adopcion.add(a);
        }
        return adopcion;
    }
    
    public ArrayList<Donacion> getDonaciones(){
        ArrayList<Donacion> donacion = new ArrayList<>();
        for(Donacion d : donaciones){
            donacion.add(d);
        }
        return donacion;
    }
    
}
