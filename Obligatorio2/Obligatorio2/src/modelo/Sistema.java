// Leonardo Santos - 390545

package modelo;
import dominio.*;
import lecturaEscrituraArchivos.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;

public class Sistema extends Observable implements Serializable{

    private static final long serialVersionUID = 1L;
    private static final String PERSISTENCIA = "Datos.per";

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

    public void agregarMascota(Mascota m) {
        if (buscarMascota(m.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe una mascota con código " + m.getCodigo());
        }
        mascotas.add(m);
        setChanged();
        notifyObservers();
    }

    public void agregarFamilia(Familia f) {
        if (buscarFamilia(f.getCedula()) != null) {
            throw new IllegalArgumentException("Ya existe una familia con cédula " + f.getCedula());
        }
        familias.add(f);
        setChanged();
        notifyObservers();
    }

    public void agregarEmpresa(Empresa e) {
        if (buscarEmpresa(e.getRut()) != null) {
            throw new IllegalArgumentException("Ya existe una empresa con RUT " + e.getRut());
        }
        empresas.add(e);
        setChanged();
        notifyObservers();
    }
    
    public Donacion agregarDonacion(Empresa empresa, TipoAlimento tipoAlimento, double kilos){
        if (empresa == null || tipoAlimento == null) {
            throw new IllegalArgumentException("Debe elegir una empresa y un tipo de alimento");
        }
        if (kilos <= 0) {
            throw new IllegalArgumentException("La cantidad de kilos debe ser mayor a 0");
        }
        Donacion donacion = new Donacion(proxNumDonacion, empresa, tipoAlimento, kilos);
        proxNumDonacion++;
        donaciones.add(donacion);
        setChanged();
        notifyObservers();
        return donacion;
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

    public int getProximoNumeroAdopcion() {
        return proxNumAdopcion;
    }

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
        setChanged();
        notifyObservers();
        return adopcion;
    }

    public void anularAdopcion(Adopcion adopcion) {
        if (!adopciones.remove(adopcion)) {
            throw new IllegalArgumentException("La adopción no está registrada");
        }
        adopcion.getMascota().setEstado(EstadoMascota.NO_DISPONIBLE);
        setChanged();
        notifyObservers();
    }
    
    public void cambiarEstado(Mascota mascota){
        if(mascota.getEstado() == EstadoMascota.DISPONIBLE){
            mascota.setEstado(EstadoMascota.NO_DISPONIBLE);
        }else{
            mascota.setEstado(EstadoMascota.DISPONIBLE);
        }
        setChanged();
        notifyObservers();
    }

    public boolean existenDatosGuardados(){
        return new File(PERSISTENCIA).exists();
    }

    public void guardar() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PERSISTENCIA));
        out.writeObject(this);
        out.close();
    }
    
    public void recuperar() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(PERSISTENCIA));
        Sistema guardado = (Sistema) in.readObject();
        in.close();
        mascotas = guardado.mascotas;
        familias = guardado.familias;
        empresas = guardado.empresas;
        adopciones = guardado.adopciones;
        donaciones = guardado.donaciones;
        proxNumAdopcion = guardado.proxNumAdopcion;
        proxNumDonacion = guardado.proxNumDonacion;
        setChanged();
        notifyObservers();
    }
    
    public boolean leerArchivoDonaciones(String ruta){
        ArchivoLectura arch = new ArchivoLectura(ruta);
        ArrayList<String> lineasConError = new ArrayList<>();
        int linea = 0;
        
        while (arch.hayMasLineas()){
            linea++;
            String[] datos = arch.linea().split("#");
            String error = buscarErrores(datos);
            if(error.isEmpty()){
                agregarDonacion(buscarEmpresa(datos[0].trim()),
                        TipoAlimento.desdeCodigo(Integer.parseInt(datos[1].trim())),
                        Double.parseDouble(datos[2].trim().replace(',', '.')));
            }else{
                lineasConError.add("Línea " + linea + ": " + error);
            }
        }
        arch.cerrar();
        
        if(!lineasConError.isEmpty()){
            logearErrores(ruta, lineasConError);
        }
        return !lineasConError.isEmpty();
    }
    
    private String buscarErrores(String[] datos){
        if(datos.length != 3){
            return "formato incorrecto (se espera rut#tipo#kilos)";
        }
        String errores = "";
        if (buscarEmpresa(datos[0].trim()) == null){
            errores += ", empresa no registrada";
        }
        if(!datos[1].trim().matches("[1-4]")){
            errores += ", tipo de alimento inexistente";
        }
        String kilos = datos[2].trim();
        if(!kilos.matches("[0-9]+([.,][0-9]+)?") || Double.parseDouble(kilos.replace(',', '.')) <= 0){
            errores += ", cantidad de kilos incorrecta";
        }
        if (errores.isEmpty()) {
            return errores;
        }
        return errores.substring(2);
    }
    
    private void logearErrores(String ruta, ArrayList<String> lineasConError){
        ArchivoGrabacion err = new ArchivoGrabacion(rutaArchivoErrores(ruta));
        for(String l : lineasConError){
            err.grabarLinea(l);
        }
        err.cerrar();
    }

    public String rutaArchivoErrores(String ruta){
        int punto = ruta.lastIndexOf('.');
        int separador = Math.max(ruta.lastIndexOf('\\'), ruta.lastIndexOf('/'));
        if(punto > separador){
            return ruta.substring(0, punto) + "Error" + ruta.substring(punto);
        }
        return ruta + "Error.txt";
    }


    public ArrayList<Mascota> getMascotasPorEstado(EstadoMascota estado) {
        ArrayList<Mascota> resultado = new ArrayList<>();
        for (Mascota m : mascotas) {
            if (m.getEstado() == estado) {
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

    public ArrayList<Familia> getFamiliasOrdenadas(boolean porApellido){
        ArrayList<Familia> ordenadas = getFamilias();
        for (int i = 0; i < ordenadas.size() - 1; i++){
            int elegida = i;
            for (int j = i + 1; j < ordenadas.size(); j++){
                if (vaAntes(ordenadas.get(j), ordenadas.get(elegida), porApellido)){
                    elegida = j;
                }
            }
            Familia aux = ordenadas.get(i);
            ordenadas.set(i, ordenadas.get(elegida));
            ordenadas.set(elegida, aux);
        }
        return ordenadas;
    }

    private boolean vaAntes(Familia a, Familia b, boolean porApellido){
        int comparacionApellido = a.getApellido().compareToIgnoreCase(b.getApellido());
        if (porApellido){
            return comparacionApellido < 0;
        }
        int adopcionesA = adopcionesPorFamilia(a);
        int adopcionesB = adopcionesPorFamilia(b);
        if (adopcionesA != adopcionesB){
            return adopcionesA > adopcionesB;
        }
        return comparacionApellido < 0;
    }

    public ArrayList<Mascota> getMascotas(){
        ArrayList<Mascota> mascota = new ArrayList<>();
        for(Mascota m : mascotas){
            mascota.add(m);
        }
        return mascota;
    }
    
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
    
    public double getStockPorTipo(TipoAlimento tipo){
        double total = 0;
        for (Donacion d : donaciones){
            if (d.getTipoAlimento() == tipo){
                total += d.getKilos();
            }
        }
        return total;
    }
     
    public String rutaPagina(String carpeta, String nombre) {
        String archivo = nombre.trim();
        if (!archivo.toLowerCase().endsWith(".html")) {
            archivo += ".html";
        }
        if (carpeta.isEmpty()) {
            return archivo;
        }
        return new File(carpeta, archivo).getPath();
    }

    public String generarPaginaAdopciones(String ruta, String nombre) {
        String nombreFinal = rutaPagina(ruta, nombre);
        
        ArchivoGrabacion arch = new ArchivoGrabacion(nombreFinal);
        
        arch.grabarLinea("<!DOCTYPE html>");
        arch.grabarLinea("<html><head><meta charset=\"UTF-8\"><title>Adopciones</title>");
        arch.grabarLinea("<style>table{border-collapse:collapse} th,td{border:1px solid #999;padding:6px}</style>");
        arch.grabarLinea("</head><body>");
        arch.grabarLinea("<h1>Adopciones del refugio</h1>");

        if (adopciones.isEmpty()) {
            arch.grabarLinea("<p>No hay adopciones registradas.</p>");
        } else {
            arch.grabarLinea("<p>Total de adopciones: " + adopciones.size() + "</p>");
            arch.grabarLinea("<table>");    
            arch.grabarLinea("<tr><th>Número</th><th>Código</th><th>Animal</th><th>Familia</th><th>Comentarios</th></tr>");
            for (Adopcion a : adopciones) {
                arch.grabarLinea("<tr><td>" + a.getNumero() + "</td><td>" + a.getMascota().getCodigo()
                + "</td><td>" + a.getMascota().getNombre() + "</td><td>" + a.getFamilia().getApellido()
                + "</td><td>" + a.getComentario() + "</td></tr>");
            }
            arch.grabarLinea("</table>");
        }
        arch.grabarLinea("</body></html>");
        arch.cerrar();
        return nombreFinal;
    }
    
}
