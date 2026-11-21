// Leonardo Santos - 390545
package interfaz;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import dominio.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Sistema;

public class FrmMenu extends javax.swing.JFrame implements TableCellRenderer, Observer {

    private final Sistema sistema;
    private final JLabel celda = new JLabel();

    public FrmMenu(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();

        celda.setOpaque(true);
        tblMascotas.setDefaultRenderer(Object.class, this);
        tblMascotas.setDefaultEditor(Object.class, null);

        actualizarInicio();
    }

    @Override
    public void update(Observable ob, Object o) {
        actualizarInicio();
    }

    private void actualizarInicio() {
        lblMascota.setText("Total de mascotas: " + sistema.getMascotas().size());
        lblDisponibles.setText("Disponibles para adoptar: " + sistema.getMascotasPorEstado(EstadoMascota.DISPONIBLE).size());
        lblNoDisponibles.setText("No disponibles para adoptar: " + sistema.getMascotasPorEstado(EstadoMascota.NO_DISPONIBLE).size());
        lblEntregadas.setText("Entregadas a familias: " + sistema.getMascotasPorEstado(EstadoMascota.ENTREGADA).size());
        lblAdopciones.setText("Adopciones registradas: " + sistema.getAdopciones().size());
        lblEmpresas.setText("Empresas registradas: " + sistema.getEmpresas().size());
        actualizarAlimento();
        actualizarEstadosMascotas();
    }

    private void actualizarAlimento() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (TipoAlimento t : TipoAlimento.values()) {
            modelo.addElement(t.getDescripcion() + ": " + sistema.getStockPorTipo(t) + " kg");
        }
        lstAlimento.setModel(modelo);
    }

    private void actualizarEstadosMascotas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");

        for (Mascota m : sistema.getMascotas()) {
            Object[] fila = {m.getNombre(), m.getEstado()};
            modelo.addRow(fila);
        }
        tblMascotas.setModel(modelo);
    }

    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionada, boolean tieneFoco, int fila, int columna) {
        celda.setBackground(tabla.getBackground());

        if (columna == 1) {
            EstadoMascota estado = (EstadoMascota) valor;
            celda.setText("\u25CF");
            celda.setHorizontalAlignment(JLabel.CENTER);
            celda.setFont(tabla.getFont().deriveFont(18f));

            if (estado == EstadoMascota.DISPONIBLE) {
                celda.setForeground(new Color(0, 160, 0));
            } else if (estado == EstadoMascota.NO_DISPONIBLE) {
                celda.setForeground(Color.RED);
            } else {
                celda.setForeground(Color.BLUE);
            }
        } else {
            celda.setText(valor.toString());
            celda.setHorizontalAlignment(JLabel.LEFT);
            celda.setFont(tabla.getFont());
            celda.setForeground(tabla.getForeground());
        }
        return celda;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JPanel();
        pnlResumen = new javax.swing.JPanel();
        lblMascota = new javax.swing.JLabel();
        lblDisponibles = new javax.swing.JLabel();
        lblNoDisponibles = new javax.swing.JLabel();
        lblEntregadas = new javax.swing.JLabel();
        lblAdopciones = new javax.swing.JLabel();
        lblEmpresas = new javax.swing.JLabel();
        pnlStock = new javax.swing.JPanel();
        scrAlimento = new javax.swing.JScrollPane();
        lstAlimento = new javax.swing.JList<>();
        pnlMascotas = new javax.swing.JPanel();
        scrMascotas = new javax.swing.JScrollPane();
        tblMascotas = new javax.swing.JTable();
        lblLeyenda = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        menAltas = new javax.swing.JMenu();
        itmMascotas = new javax.swing.JMenuItem();
        itmFamilias = new javax.swing.JMenuItem();
        itmEmpresas = new javax.swing.JMenuItem();
        menMovimientos = new javax.swing.JMenu();
        itmRealizarAdopcion = new javax.swing.JMenuItem();
        itmAnularAdopcion = new javax.swing.JMenuItem();
        itmCambiarEstadoMascota = new javax.swing.JMenuItem();
        itmRegistrarDonacion = new javax.swing.JMenuItem();
        itmImportarDonaciones = new javax.swing.JMenuItem();
        menVarios = new javax.swing.JMenu();
        itmConsultarFamilias = new javax.swing.JMenuItem();
        itmConsultarDonaciones = new javax.swing.JMenuItem();
        itmHTML = new javax.swing.JMenuItem();
        itmRecuperarDatos = new javax.swing.JMenuItem();
        itmAutores = new javax.swing.JMenuItem();
        itmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de un refugio de perros");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlInicio.setLayout(null);

        pnlResumen.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen del refugio"));
        pnlResumen.setLayout(null);

        lblMascota.setText("Total de mascotas: ");
        pnlResumen.add(lblMascota);
        lblMascota.setBounds(15, 25, 300, 20);

        lblDisponibles.setText("Disponibles:");
        pnlResumen.add(lblDisponibles);
        lblDisponibles.setBounds(15, 55, 300, 20);

        lblNoDisponibles.setText("No disponibles:");
        pnlResumen.add(lblNoDisponibles);
        lblNoDisponibles.setBounds(15, 85, 300, 20);

        lblEntregadas.setText("Entregados:");
        pnlResumen.add(lblEntregadas);
        lblEntregadas.setBounds(15, 115, 300, 20);

        lblAdopciones.setText("Adopciones registradas: ");
        pnlResumen.add(lblAdopciones);
        lblAdopciones.setBounds(15, 145, 300, 20);

        lblEmpresas.setText("Empresas registradas:");
        pnlResumen.add(lblEmpresas);
        lblEmpresas.setBounds(15, 175, 300, 20);

        pnlInicio.add(pnlResumen);
        pnlResumen.setBounds(43, 18, 330, 215);

        pnlStock.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock de alimento"));
        pnlStock.setLayout(null);

        lstAlimento.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrAlimento.setViewportView(lstAlimento);

        pnlStock.add(scrAlimento);
        scrAlimento.setBounds(15, 25, 280, 170);

        pnlInicio.add(pnlStock);
        pnlStock.setBounds(383, 18, 310, 215);

        pnlMascotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Mascotas"));
        pnlMascotas.setLayout(null);

        tblMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrMascotas.setViewportView(tblMascotas);

        pnlMascotas.add(scrMascotas);
        scrMascotas.setBounds(15, 25, 620, 235);

        lblLeyenda.setText("<html><font color='#00a000'>●</font> Disponible &nbsp;&nbsp; <font color='red'>●</font> No disponible &nbsp;&nbsp; <font color='blue'>●</font> Adoptado</html>");
        pnlMascotas.add(lblLeyenda);
        lblLeyenda.setBounds(15, 265, 620, 20);

        pnlInicio.add(pnlMascotas);
        pnlMascotas.setBounds(43, 243, 650, 300);

        getContentPane().add(pnlInicio);
        pnlInicio.setBounds(0, 0, 736, 561);

        menAltas.setMnemonic('a');
        menAltas.setText("Altas");

        itmMascotas.setMnemonic('m');
        itmMascotas.setText("Mascotas");
        itmMascotas.addActionListener(this::itmMascotasActionPerformed);
        menAltas.add(itmMascotas);

        itmFamilias.setMnemonic('f');
        itmFamilias.setText("Familias");
        itmFamilias.addActionListener(this::itmFamiliasActionPerformed);
        menAltas.add(itmFamilias);

        itmEmpresas.setMnemonic('e');
        itmEmpresas.setText("Empresas");
        itmEmpresas.addActionListener(this::itmEmpresasActionPerformed);
        menAltas.add(itmEmpresas);

        barMenu.add(menAltas);

        menMovimientos.setMnemonic('m');
        menMovimientos.setText("Movimientos");

        itmRealizarAdopcion.setMnemonic('r');
        itmRealizarAdopcion.setText("Realizar adopción");
        itmRealizarAdopcion.addActionListener(this::itmRealizarAdopcionActionPerformed);
        menMovimientos.add(itmRealizarAdopcion);

        itmAnularAdopcion.setMnemonic('a');
        itmAnularAdopcion.setText("Anular adopción");
        itmAnularAdopcion.addActionListener(this::itmAnularAdopcionActionPerformed);
        menMovimientos.add(itmAnularAdopcion);

        itmCambiarEstadoMascota.setMnemonic('c');
        itmCambiarEstadoMascota.setText("Cambiar estado de mascota");
        itmCambiarEstadoMascota.addActionListener(this::itmCambiarEstadoMascotaActionPerformed);
        menMovimientos.add(itmCambiarEstadoMascota);

        itmRegistrarDonacion.setMnemonic('d');
        itmRegistrarDonacion.setText("Registrar donación");
        itmRegistrarDonacion.addActionListener(this::itmRegistrarDonacionActionPerformed);
        menMovimientos.add(itmRegistrarDonacion);

        itmImportarDonaciones.setMnemonic('i');
        itmImportarDonaciones.setText("Importar donaciones");
        itmImportarDonaciones.addActionListener(this::itmImportarDonacionesActionPerformed);
        menMovimientos.add(itmImportarDonaciones);

        barMenu.add(menMovimientos);

        menVarios.setMnemonic('v');
        menVarios.setText("Varios");

        itmConsultarFamilias.setMnemonic('f');
        itmConsultarFamilias.setText("Consultar familias");
        itmConsultarFamilias.addActionListener(this::itmConsultarFamiliasActionPerformed);
        menVarios.add(itmConsultarFamilias);

        itmConsultarDonaciones.setMnemonic('d');
        itmConsultarDonaciones.setText("Consultar donaciones");
        itmConsultarDonaciones.addActionListener(this::itmConsultarDonacionesActionPerformed);
        menVarios.add(itmConsultarDonaciones);

        itmHTML.setMnemonic('g');
        itmHTML.setText("Generar página HTML");
        itmHTML.addActionListener(this::itmHTMLActionPerformed);
        menVarios.add(itmHTML);

        itmRecuperarDatos.setMnemonic('r');
        itmRecuperarDatos.setText("Recuperar datos");
        itmRecuperarDatos.addActionListener(this::itmRecuperarDatosActionPerformed);
        menVarios.add(itmRecuperarDatos);

        itmAutores.setMnemonic('a');
        itmAutores.setText("Autores");
        itmAutores.addActionListener(this::itmAutoresActionPerformed);
        menVarios.add(itmAutores);

        itmSalir.setMnemonic('s');
        itmSalir.setText("Salir");
        itmSalir.addActionListener(this::itmSalirActionPerformed);
        menVarios.add(itmSalir);

        barMenu.add(menVarios);

        setJMenuBar(barMenu);

        setSize(new java.awt.Dimension(752, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itmMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMascotasActionPerformed
        new FrmAltaMascota(sistema).setVisible(true);
    }//GEN-LAST:event_itmMascotasActionPerformed

    private void itmAnularAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAnularAdopcionActionPerformed
        new FrmAnularAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_itmAnularAdopcionActionPerformed

    private void itmRecuperarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRecuperarDatosActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this,
                "Se reemplazarán todos los datos actuales por los guardados. ¿Continuar?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            if (!sistema.existenDatosGuardados()) {
                JOptionPane.showMessageDialog(this, "Todavía no hay datos guardados de una ejecución anterior.",
                        "Sin datos guardados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    sistema.recuperar();
                } catch (ClassNotFoundException | IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "No se pudieron cargar los datos",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_itmRecuperarDatosActionPerformed

    private void itmFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmFamiliasActionPerformed
        new FrmAltaFamilia(sistema).setVisible(true);
    }//GEN-LAST:event_itmFamiliasActionPerformed

    private void itmEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEmpresasActionPerformed
        new FrmAltaEmpresa(sistema).setVisible(true);
    }//GEN-LAST:event_itmEmpresasActionPerformed

    private void itmRealizarAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRealizarAdopcionActionPerformed
        new FrmIniciarAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_itmRealizarAdopcionActionPerformed

    private void itmCambiarEstadoMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCambiarEstadoMascotaActionPerformed
        new FrmCambiarEstado(sistema).setVisible(true);
    }//GEN-LAST:event_itmCambiarEstadoMascotaActionPerformed

    private void itmRegistrarDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistrarDonacionActionPerformed
        new FrmRegistrarDonacion(sistema).setVisible(true);
    }//GEN-LAST:event_itmRegistrarDonacionActionPerformed

    private void itmImportarDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmImportarDonacionesActionPerformed
        JFileChooser archivoSeleccionado = new JFileChooser();
        archivoSeleccionado.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

        if (archivoSeleccionado.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (archivoSeleccionado.getSelectedFile().exists()) {
                String rutaArchivo = archivoSeleccionado.getSelectedFile().getAbsolutePath();
                if (sistema.leerArchivoDonaciones(rutaArchivo)) {
                    JOptionPane.showMessageDialog(this,
                            "La importación finalizó con errores.\nVer el detalle en " + sistema.rutaArchivoErrores(rutaArchivo),
                            "Importación con errores", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Importación finalizada sin errores");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_itmImportarDonacionesActionPerformed

    private void itmConsultarFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultarFamiliasActionPerformed
        new FrmConsultarFamilias(sistema).setVisible(true);
    }//GEN-LAST:event_itmConsultarFamiliasActionPerformed

    private void itmConsultarDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultarDonacionesActionPerformed
        new FrmConsultarDonaciones(sistema).setVisible(true);
    }//GEN-LAST:event_itmConsultarDonacionesActionPerformed

    private void itmHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmHTMLActionPerformed
        new FrmGenerarHTML(sistema).setVisible(true);
    }//GEN-LAST:event_itmHTMLActionPerformed

    private void itmAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAutoresActionPerformed
        new FrmAutores().setVisible(true);
    }//GEN-LAST:event_itmAutoresActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void itmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSalirActionPerformed
        salir();
    }//GEN-LAST:event_itmSalirActionPerformed

    private void salir() {
        try {
            sistema.guardar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron guardar los datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAutores;
    private javax.swing.JMenuItem itmAnularAdopcion;
    private javax.swing.JMenuItem itmCambiarEstadoMascota;
    private javax.swing.JMenuItem itmConsultarDonaciones;
    private javax.swing.JMenuItem itmConsultarFamilias;
    private javax.swing.JMenuItem itmEmpresas;
    private javax.swing.JMenuItem itmFamilias;
    private javax.swing.JMenuItem itmHTML;
    private javax.swing.JMenuItem itmImportarDonaciones;
    private javax.swing.JMenuItem itmRealizarAdopcion;
    private javax.swing.JMenuItem itmMascotas;
    private javax.swing.JMenuItem itmRecuperarDatos;
    private javax.swing.JMenuItem itmRegistrarDonacion;
    private javax.swing.JMenuItem itmSalir;
    private javax.swing.JScrollPane scrMascotas;
    private javax.swing.JScrollPane scrAlimento;
    private javax.swing.JLabel lblAdopciones;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblEmpresas;
    private javax.swing.JLabel lblEntregadas;
    private javax.swing.JLabel lblLeyenda;
    private javax.swing.JLabel lblMascota;
    private javax.swing.JLabel lblNoDisponibles;
    private javax.swing.JList<String> lstAlimento;
    private javax.swing.JMenu menAltas;
    private javax.swing.JMenu menMovimientos;
    private javax.swing.JMenu menVarios;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMascotas;
    private javax.swing.JPanel pnlResumen;
    private javax.swing.JPanel pnlStock;
    private javax.swing.JTable tblMascotas;
    // End of variables declaration//GEN-END:variables

}
