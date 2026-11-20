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

public class FrmMenu extends javax.swing.JFrame implements TableCellRenderer, Observer{
    
    private final Sistema sistema;
    private JLabel celda = new JLabel();
    
    public FrmMenu(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        
        celda.setOpaque(true);
        tblMascotas.setDefaultRenderer(Object.class,this);
        tblMascotas.setDefaultEditor(Object.class, null);
        
        actualizarInicio();
    }

    @Override
    public void update(Observable ob, Object o){
        actualizarInicio();
    }
    
   
    private void actualizarInicio(){
        lblMascota.setText("Total de mascotas: " + sistema.getMascotas().size());
        lblDisponibles.setText("Disponibles para adoptar: " + sistema.getMascotasPorEstado(EstadoMascota.DISPONIBLE).size());
        lblNoDisponibles.setText("No disponibles para adoptar: " + sistema.getMascotasPorEstado(EstadoMascota.NO_DISPONIBLE).size());
        lblEntregadas.setText("Entregadas a familias: " + sistema.getMascotasPorEstado(EstadoMascota.ENTREGADA).size());
        lblAdopciones.setText("Adopciones registradas: " + sistema.getAdopciones().size());
        lblEmpresas.setText("Empresas registradas: " + sistema.getEmpresas().size());
        actualizarAlimento();
        actualizarEstadosMascotas();
    }
    
    private void actualizarAlimento(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (TipoAlimento t : TipoAlimento.values()){
            modelo.addElement(t.getDescripcion() + ": " + sistema.getStockPorTipo(t) + " Kg");
        }
        lstAlimento.setModel(modelo);
    }
    
    private void actualizarEstadosMascotas(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");
                
        for(Mascota m : sistema.getMascotas()){
            Object[] fila = { m.getNombre(), m.getEstado()};
            modelo.addRow(fila);
        }
        tblMascotas.setModel(modelo);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionada, boolean tieneFoco, int fila, int columna){
        celda.setBackground(tabla.getBackground());
        
        if (columna == 1){
            EstadoMascota estado = (EstadoMascota) valor;
            celda.setText("\u25CF");
            celda.setHorizontalAlignment(JLabel.CENTER);
            celda.setFont(tabla.getFont().deriveFont(18f));
            
            if (estado == EstadoMascota.DISPONIBLE){
                celda.setForeground(new Color(0,160,0));
            } else if (estado == EstadoMascota.NO_DISPONIBLE){
                celda.setForeground(Color.RED);
            } else {
                celda.setForeground(Color.BLUE);
            }
        }else{
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
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAlimento = new javax.swing.JList<>();
        pnlMascotas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMascotas = new javax.swing.JTable();
        lblLeyenda = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menMascotas = new javax.swing.JMenu();
        itmMascotas = new javax.swing.JMenuItem();
        itmFamilias = new javax.swing.JMenuItem();
        itmEmpresas = new javax.swing.JMenuItem();
        menMovimientos = new javax.swing.JMenu();
        itmIniciarAdopcion = new javax.swing.JMenuItem();
        itmAnularAdopcion = new javax.swing.JMenuItem();
        itmCambiarEstadoMascota = new javax.swing.JMenuItem();
        itmRegistrarDonacion = new javax.swing.JMenuItem();
        itmImportarDonaciones = new javax.swing.JMenuItem();
        menReportes = new javax.swing.JMenu();
        itmConsultarFamilias = new javax.swing.JMenuItem();
        itmConsultarDonaciones = new javax.swing.JMenuItem();
        itmHTML = new javax.swing.JMenuItem();
        itmRecuperarDatos = new javax.swing.JMenuItem();
        itmAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de un Refugio de Perros");
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

        lblNoDisponibles.setText("No Disponibles:");
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
        jScrollPane2.setViewportView(lstAlimento);

        pnlStock.add(jScrollPane2);
        jScrollPane2.setBounds(15, 25, 280, 170);

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
        jScrollPane1.setViewportView(tblMascotas);

        pnlMascotas.add(jScrollPane1);
        jScrollPane1.setBounds(15, 25, 620, 235);

        lblLeyenda.setText("<html><font color='#00a000'>●</font> Disponible &nbsp;&nbsp; <font color='red'>●</font> No disponible &nbsp;&nbsp; <font color='blue'>●</font> Adoptado</html>");
        pnlMascotas.add(lblLeyenda);
        lblLeyenda.setBounds(15, 265, 620, 20);

        pnlInicio.add(pnlMascotas);
        pnlMascotas.setBounds(43, 243, 650, 300);

        getContentPane().add(pnlInicio);
        pnlInicio.setBounds(0, 0, 736, 561);

        menMascotas.setMnemonic('f');
        menMascotas.setText("Altas");

        itmMascotas.setMnemonic('o');
        itmMascotas.setText("Mascotas");
        itmMascotas.addActionListener(this::itmMascotasActionPerformed);
        menMascotas.add(itmMascotas);

        itmFamilias.setMnemonic('s');
        itmFamilias.setText("Familias");
        itmFamilias.addActionListener(this::itmFamiliasActionPerformed);
        menMascotas.add(itmFamilias);

        itmEmpresas.setMnemonic('a');
        itmEmpresas.setText("Empresas");
        itmEmpresas.addActionListener(this::itmEmpresasActionPerformed);
        menMascotas.add(itmEmpresas);

        menuBar.add(menMascotas);

        menMovimientos.setMnemonic('e');
        menMovimientos.setText("Movimientos");

        itmIniciarAdopcion.setMnemonic('t');
        itmIniciarAdopcion.setText("Iniciar Adopción");
        itmIniciarAdopcion.addActionListener(this::itmIniciarAdopcionActionPerformed);
        menMovimientos.add(itmIniciarAdopcion);

        itmAnularAdopcion.setMnemonic('y');
        itmAnularAdopcion.setText("Anular Adopción");
        itmAnularAdopcion.addActionListener(this::itmAnularAdopcionActionPerformed);
        menMovimientos.add(itmAnularAdopcion);

        itmCambiarEstadoMascota.setMnemonic('p');
        itmCambiarEstadoMascota.setText("Cambiar Estado Mascota");
        itmCambiarEstadoMascota.addActionListener(this::itmCambiarEstadoMascotaActionPerformed);
        menMovimientos.add(itmCambiarEstadoMascota);

        itmRegistrarDonacion.setMnemonic('d');
        itmRegistrarDonacion.setText("Registrar Donación");
        itmRegistrarDonacion.addActionListener(this::itmRegistrarDonacionActionPerformed);
        menMovimientos.add(itmRegistrarDonacion);

        itmImportarDonaciones.setText("Importar Donaciones");
        itmImportarDonaciones.addActionListener(this::itmImportarDonacionesActionPerformed);
        menMovimientos.add(itmImportarDonaciones);

        menuBar.add(menMovimientos);

        menReportes.setMnemonic('h');
        menReportes.setText("Reportes");

        itmConsultarFamilias.setMnemonic('c');
        itmConsultarFamilias.setText("Consultar Familias");
        itmConsultarFamilias.addActionListener(this::itmConsultarFamiliasActionPerformed);
        menReportes.add(itmConsultarFamilias);

        itmConsultarDonaciones.setMnemonic('a');
        itmConsultarDonaciones.setText("Consultar Donaciones");
        itmConsultarDonaciones.addActionListener(this::itmConsultarDonacionesActionPerformed);
        menReportes.add(itmConsultarDonaciones);

        itmHTML.setText("Generación de Página HTML");
        itmHTML.addActionListener(this::itmHTMLActionPerformed);
        menReportes.add(itmHTML);

        itmRecuperarDatos.setText("Recuperar Datos");
        itmRecuperarDatos.addActionListener(this::itmRecuperarDatosActionPerformed);
        menReportes.add(itmRecuperarDatos);

        itmAcercaDe.setText("Acerca de...");
        itmAcercaDe.addActionListener(this::itmAcercaDeActionPerformed);
        menReportes.add(itmAcercaDe);

        menuBar.add(menReportes);

        setJMenuBar(menuBar);

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
            "Confirmar",JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
            try{
                sistema.recuperar();
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this,ex.getMessage(),"No se pudieron cargar los datos"
                        ,JOptionPane.ERROR_MESSAGE);
            }catch(IOException ex){
                JOptionPane.showMessageDialog(this,ex.getMessage(),"No se pudieron cargar los datos"
                        ,JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_itmRecuperarDatosActionPerformed

    private void itmFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmFamiliasActionPerformed
        new FrmAltaFamilia(sistema).setVisible(true);
    }//GEN-LAST:event_itmFamiliasActionPerformed

    private void itmEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEmpresasActionPerformed
        new FrmAltaEmpresa(sistema).setVisible(true);
    }//GEN-LAST:event_itmEmpresasActionPerformed

    private void itmIniciarAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmIniciarAdopcionActionPerformed
        new FrmIniciarAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_itmIniciarAdopcionActionPerformed

    private void itmCambiarEstadoMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCambiarEstadoMascotaActionPerformed
        new FrmCambiarEstado(sistema).setVisible(true);
    }//GEN-LAST:event_itmCambiarEstadoMascotaActionPerformed

    private void itmRegistrarDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistrarDonacionActionPerformed
        new FrmRegistrarDonacion(sistema).setVisible(true);
    }//GEN-LAST:event_itmRegistrarDonacionActionPerformed

    private void itmImportarDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmImportarDonacionesActionPerformed
        JFileChooser archivoSeleccionado = new JFileChooser();
        archivoSeleccionado.setFileFilter(new FileNameExtensionFilter("(*.txt)","txt"));
        
        if (archivoSeleccionado.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            String rutaArchivo = archivoSeleccionado.getSelectedFile().getAbsolutePath();
            if(sistema.leerArchivoDonaciones(rutaArchivo)){
                JOptionPane.showMessageDialog(this,
                "La importación finalizó con errores. Ver detalle en el archivo de errores.",
                "Importación con errores", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Importación finalizada sin errores");
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

    private void itmAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAcercaDeActionPerformed
        new FrmAutores().setVisible(true);
    }//GEN-LAST:event_itmAcercaDeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try{
            sistema.guardar();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this, "No se pudieron guardar los datos: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
         System.exit(0);  
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAcercaDe;
    private javax.swing.JMenuItem itmAnularAdopcion;
    private javax.swing.JMenuItem itmCambiarEstadoMascota;
    private javax.swing.JMenuItem itmConsultarDonaciones;
    private javax.swing.JMenuItem itmConsultarFamilias;
    private javax.swing.JMenuItem itmEmpresas;
    private javax.swing.JMenuItem itmFamilias;
    private javax.swing.JMenuItem itmHTML;
    private javax.swing.JMenuItem itmImportarDonaciones;
    private javax.swing.JMenuItem itmIniciarAdopcion;
    private javax.swing.JMenuItem itmMascotas;
    private javax.swing.JMenuItem itmRecuperarDatos;
    private javax.swing.JMenuItem itmRegistrarDonacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdopciones;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblEmpresas;
    private javax.swing.JLabel lblEntregadas;
    private javax.swing.JLabel lblLeyenda;
    private javax.swing.JLabel lblMascota;
    private javax.swing.JLabel lblNoDisponibles;
    private javax.swing.JList<String> lstAlimento;
    private javax.swing.JMenu menMascotas;
    private javax.swing.JMenu menMovimientos;
    private javax.swing.JMenu menReportes;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMascotas;
    private javax.swing.JPanel pnlResumen;
    private javax.swing.JPanel pnlStock;
    private javax.swing.JTable tblMascotas;
    // End of variables declaration//GEN-END:variables

}
