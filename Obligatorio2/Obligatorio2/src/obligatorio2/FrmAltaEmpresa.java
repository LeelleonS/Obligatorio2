// Leonardo Santos - 390545

package obligatorio2;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public class FrmAltaEmpresa extends javax.swing.JFrame implements DocumentListener, FocusListener{
    
    private String nombreValido = "[A-Za-z0-9]+";
    private String rutValido = "[0-9]+";
    private String direccionValido = "[A-Za-z0-9]+";
    
    private final Sistema sistema;

    public FrmAltaEmpresa(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        txtNombre.getDocument().addDocumentListener(this);
        txtRUT.getDocument().addDocumentListener(this);
        txtDireccion.getDocument().addDocumentListener(this);
        txtNombre.addFocusListener(this);
        txtRUT.addFocusListener(this);
        txtDireccion.addFocusListener(this);
        actualizarBoton();
    }
    
    @Override
    public void insertUpdate(DocumentEvent e){
        actualizarBoton();
    }
   
    @Override
    public void removeUpdate(DocumentEvent e){
       actualizarBoton();
    }
   
    @Override
    public void changedUpdate(DocumentEvent e){
       actualizarBoton();
    }
   
    private void actualizarBoton(){
       boolean nombreOk = esValido(txtNombre, nombreValido);
       boolean rutOk = esValido(txtRUT, rutValido);
       boolean direccionOk = esValido(txtDireccion, direccionValido);
       btnAceptar.setEnabled(nombreOk && rutOk && direccionOk);   
    }
   
    private boolean esValido(JTextComponent campo, String regex){
        boolean ok = campo.getText().trim().matches(regex);
        if (ok) {
           campo.setForeground(Color.BLACK);
        }
        return ok;
    }
   
    @Override
    public void focusGained(FocusEvent e){
    }
   
    @Override
    public void focusLost(FocusEvent e){
        if (e.isTemporary() || e.getOppositeComponent() == btnCancelar){
            return;
        }
        if (e.getSource() == txtNombre){
            avisarSiEstaMal(txtNombre, nombreValido, "Nombre incorrecto");
        } else if (e.getSource() == txtRUT){
            avisarSiEstaMal(txtRUT, rutValido, "El RUT solo puede tener numeros");
        } else if (e.getSource() == txtDireccion){
            avisarSiEstaMal(txtDireccion, direccionValido, "Direccion incorrecta");
        }
    }
   
    private void avisarSiEstaMal(JTextComponent campo, String regex, String mensaje){
        String texto = campo.getText().trim();
        if(!texto.isEmpty() && !texto.matches(regex)){
            campo.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, mensaje, "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblRUT = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtRUT = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Empresa");

        lblNombre.setText("Nombre");

        lblRUT.setText("RUT");

        lblDireccion.setText("Dirección");

        txtDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDireccion.setName(""); // NOI18N

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(lblRUT)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtRUT)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRUT)
                    .addComponent(txtRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            Empresa empresa = new Empresa(txtNombre.getText(), txtRUT.getText(), txtDireccion.getText());
            sistema.agregarEmpresa(empresa);
            JOptionPane.showMessageDialog(this, "Empresa " + empresa + " registrada");
            limpiar();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void limpiar(){
        txtNombre.setText("");
        txtRUT.setText("");
        txtDireccion.setText("");
        txtNombre.requestFocus();
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRUT;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRUT;
    // End of variables declaration//GEN-END:variables
}
