// Leonardo Santos - 390545

package interfaz;

import dominio.Adopcion;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dominio.EstadoMascota;
import dominio.Familia;
import dominio.Mascota;
import java.util.Observable;
import java.util.Observer;
import modelo.Sistema;

public class FrmIniciarAdopcion extends javax.swing.JFrame implements ListSelectionListener, Observer {

    private final Sistema sistema;
     
    public FrmIniciarAdopcion(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        getRootPane().setDefaultButton(btnAceptar);
        cargarListaMascotas();
        cargarListaFamilias();

        lstFamilias.addListSelectionListener(this);
        lstMascotas.addListSelectionListener(this);

        btnAceptar.setEnabled(false);
        txtPeso.setEditable(false);
        txtATemperamento.setEditable(false);
        mostrarProximoNumero();
       
    }

    @Override
    public void update(Observable ob, Object o){
        cargarListaMascotas();
        cargarListaFamilias();
        mostrarProximoNumero();
    }

    private void mostrarProximoNumero() {
        setTitle("Realizar adopción - Nº " + sistema.getProximoNumeroAdopcion());
    }
    
    private void actualizarBoton(){
        boolean mascotaOk = !this.lstMascotas.isSelectionEmpty();
        boolean familiaOk = !this.lstFamilias.isSelectionEmpty();
        btnAceptar.setEnabled(familiaOk && mascotaOk);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e){
        if (!e.getValueIsAdjusting()){
            if (e.getSource() == lstMascotas){
                mostrarDatosMascota();
            }
            actualizarBoton();
        }
    }
    
    private void mostrarDatosMascota(){
        Mascota m = lstMascotas.getSelectedValue();
        if (m == null) {
            txtPeso.setText("");
            txtATemperamento.setText("");
        } else {
            txtPeso.setText(String.valueOf(m.getPeso()) + " kg");
            txtATemperamento.setText(m.getTemperamento());
        }
    }
    
    private void cargarListaMascotas(){
        DefaultListModel<Mascota> modelo = new DefaultListModel<>();
        for (Mascota m : sistema.getMascotasPorEstado(EstadoMascota.DISPONIBLE)){
            modelo.addElement(m);
        }
        lstMascotas.setModel(modelo);
    }
    
    private void cargarListaFamilias(){
        DefaultListModel<Familia> modelo = new DefaultListModel<>();
        for (Familia f : sistema.getFamilias()){
            modelo.addElement(f);
        }
        lstFamilias.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        pnlMascotas = new javax.swing.JPanel();
        scrMascotas = new javax.swing.JScrollPane();
        lstMascotas = new javax.swing.JList<>();
        pnlDatos = new javax.swing.JPanel();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        lblTemperamento = new javax.swing.JLabel();
        scrTemperamento = new javax.swing.JScrollPane();
        txtATemperamento = new javax.swing.JTextArea();
        pnlFamilias = new javax.swing.JPanel();
        scrFamilias = new javax.swing.JScrollPane();
        lstFamilias = new javax.swing.JList<>();
        pnlComentarios = new javax.swing.JPanel();
        scrComentarios = new javax.swing.JScrollPane();
        txtAComentarios = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar adopción");
        setResizable(false);

        btnAceptar.setBackground(new java.awt.Color(200, 240, 200));
        btnAceptar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setOpaque(true);
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        pnlMascotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Mascotas disponibles"));

        scrMascotas.setViewportView(lstMascotas);

        javax.swing.GroupLayout pnlMascotasLayout = new javax.swing.GroupLayout(pnlMascotas);
        pnlMascotas.setLayout(pnlMascotasLayout);
        pnlMascotasLayout.setHorizontalGroup(
            pnlMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMascotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMascotasLayout.setVerticalGroup(
            pnlMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMascotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrMascotas)
                .addContainerGap())
        );

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la mascota"));

        lblPeso.setText("Peso");

        lblTemperamento.setText("Temperamento");

        txtATemperamento.setColumns(20);
        txtATemperamento.setRows(5);
        scrTemperamento.setViewportView(txtATemperamento);

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPeso))
                    .addComponent(scrTemperamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblTemperamento)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(lblTemperamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrTemperamento, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlFamilias.setBorder(javax.swing.BorderFactory.createTitledBorder("Familias"));

        scrFamilias.setViewportView(lstFamilias);

        javax.swing.GroupLayout pnlFamiliasLayout = new javax.swing.GroupLayout(pnlFamilias);
        pnlFamilias.setLayout(pnlFamiliasLayout);
        pnlFamiliasLayout.setHorizontalGroup(
            pnlFamiliasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFamiliasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFamiliasLayout.setVerticalGroup(
            pnlFamiliasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFamiliasLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(scrFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlComentarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentarios"));

        txtAComentarios.setColumns(20);
        txtAComentarios.setRows(5);
        scrComentarios.setViewportView(txtAComentarios);

        javax.swing.GroupLayout pnlComentariosLayout = new javax.swing.GroupLayout(pnlComentarios);
        pnlComentarios.setLayout(pnlComentariosLayout);
        pnlComentariosLayout.setHorizontalGroup(
            pnlComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComentariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlComentariosLayout.setVerticalGroup(
            pnlComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComentariosLayout.createSequentialGroup()
                .addComponent(scrComentarios)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlFamilias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFamilias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void dispose(){
        sistema.deleteObserver(this);
        super.dispose();
    }
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try{
            if (txtAComentarios.getText().trim().isEmpty()){
                txtAComentarios.setText("Sin observaciones");
            }
            Adopcion a = sistema.realizarAdopcion(this.lstMascotas.getSelectedValue(), 
                    this.lstFamilias.getSelectedValue(), this.txtAComentarios.getText());
            JOptionPane.showMessageDialog(this, 
                    "Se registró la adopción número " + a.getNumero() + ".\n" + a.getMascota().getNombre()
                    + " ahora pertenece a la familia " + a.getFamilia().getApellido() + ".",
                    "¡Adopción registrada!",JOptionPane.INFORMATION_MESSAGE);
            cargarListaMascotas();
            lstFamilias.clearSelection();
            txtAComentarios.setText("");
            mostrarDatosMascota();
            actualizarBoton();

        }catch (IllegalStateException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JScrollPane scrMascotas;
    private javax.swing.JScrollPane scrTemperamento;
    private javax.swing.JScrollPane scrFamilias;
    private javax.swing.JScrollPane scrComentarios;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemperamento;
    private javax.swing.JList<Familia> lstFamilias;
    private javax.swing.JList<Mascota> lstMascotas;
    private javax.swing.JPanel pnlComentarios;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlFamilias;
    private javax.swing.JPanel pnlMascotas;
    private javax.swing.JTextArea txtAComentarios;
    private javax.swing.JTextArea txtATemperamento;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

}
