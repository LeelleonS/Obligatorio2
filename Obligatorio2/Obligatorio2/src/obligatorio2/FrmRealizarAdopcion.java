// Leonardo Santos - 390545

package obligatorio2;

import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrmRealizarAdopcion extends javax.swing.JFrame implements DocumentListener, ListSelectionListener{
    
    private final Sistema sistema;
     
    public FrmRealizarAdopcion(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        cargarListaMascotas();
        cargarListaFamilias();
        
        txtAComentarios.getDocument().addDocumentListener(this);
        lstFamilias.addListSelectionListener(this);
        lstMascotas.addListSelectionListener(this);

        
        btnAceptar.setEnabled(false);
        txtPeso.setEditable(false);
        txtATemperamento.setEditable(false);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        actualizarBoton();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        actualizarBoton();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        actualizarBoton();
    }
    
    private void actualizarBoton(){
        boolean comentariosOk = !this.txtAComentarios.getText().isEmpty();
        boolean mascotaOk = !this.lstMascotas.isSelectionEmpty();
        boolean familiaOk = !this.lstFamilias.isSelectionEmpty();
        btnAceptar.setEnabled(familiaOk && mascotaOk && comentariosOk);
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
        for (Mascota m : sistema.getMascotasDisponibles()){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstMascotas = new javax.swing.JList<>();
        lblMascotas = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtATemperamento = new javax.swing.JTextArea();
        lblPeso = new javax.swing.JLabel();
        lblTemperamento = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstFamilias = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAComentarios = new javax.swing.JTextArea();
        lblComentarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(lstMascotas);

        lblMascotas.setText("Mascotas Disponibles");

        txtATemperamento.setColumns(20);
        txtATemperamento.setRows(5);
        jScrollPane2.setViewportView(txtATemperamento);

        lblPeso.setText("Peso");

        lblTemperamento.setText("Temperamento");

        jScrollPane3.setViewportView(lstFamilias);

        jLabel4.setText("Familias");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        txtAComentarios.setColumns(20);
        txtAComentarios.setRows(5);
        jScrollPane4.setViewportView(txtAComentarios);

        lblComentarios.setText("Comentarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblMascotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPeso)
                .addGap(199, 199, 199))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(lblComentarios))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(144, 144, 144)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTemperamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPeso))))))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblMascotas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPeso)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblTemperamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblComentarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try{
            sistema.realizarAdopcion(this.lstMascotas.getSelectedValue(), this.lstFamilias.getSelectedValue(), this.lblComentarios.getText());
            JOptionPane.showMessageDialog(this, "Adopción número " + sistema.getAdopciones().getLast().getNumero()+ " registrada");
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblComentarios;
    private javax.swing.JLabel lblMascotas;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemperamento;
    private javax.swing.JList<Familia> lstFamilias;
    private javax.swing.JList<Mascota> lstMascotas;
    private javax.swing.JTextArea txtAComentarios;
    private javax.swing.JTextArea txtATemperamento;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

}
