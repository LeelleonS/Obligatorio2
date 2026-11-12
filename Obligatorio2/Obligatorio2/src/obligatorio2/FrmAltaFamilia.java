// Leonardo Santos - 390545

package obligatorio2;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public class FrmAltaFamilia extends javax.swing.JFrame implements DocumentListener, FocusListener {

    private String apellidoValido = "[A-Za-zÁÉÍÓÚáéíóúÑñ ]+";
    private String cedulaValido = "[0-9]+";
    private String celularValido = "[0-9]+";
    
    private final Sistema sistema;

    public FrmAltaFamilia(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        txtCedula.getDocument().addDocumentListener(this);
        txtApellido.getDocument().addDocumentListener(this);
        txtCelular.getDocument().addDocumentListener(this);
        txtCedula.addFocusListener(this);
        txtApellido.addFocusListener(this);
        txtCelular.addFocusListener(this);
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
        boolean apellidoOk = esValido(txtApellido, apellidoValido);
        boolean cedulaOk = esValido(txtCedula, cedulaValido);
        boolean celularOk = esValido(txtCelular, celularValido);
        btnAceptar.setEnabled(apellidoOk && cedulaOk && celularOk);
    }
    
    private boolean esValido(JTextComponent campo, String regex){
        boolean ok = campo.getText().trim().matches(regex);
        if (ok){
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
        if (e.getSource() == txtApellido){
            avisarSiEstaMal(txtApellido, apellidoValido, "El apellido solo puede tener letras");
        } else if (e.getSource() == txtCedula){
            avisarSiEstaMal(txtCedula, cedulaValido, "La cedula solo puede tener numeros");
        } else if (e.getSource() == txtCelular){
            avisarSiEstaMal(txtCelular, celularValido, "El celular solo puede contener numeros");
        }
    }
    
    private void avisarSiEstaMal(JTextComponent campo, String regex, String mensaje){
        String texto = campo.getText().trim();
        if (!texto.isEmpty() && !texto.matches(regex)){
            campo.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, mensaje, "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Familia");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblCedula.setText("Cédula");

        lblApellido.setText("Apellido");

        lblCelular.setText("Celular");

        txtCelular.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCelular.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(43, 43, 43)
                .addComponent(btnCancelar)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCelular)
                    .addComponent(lblApellido)
                    .addComponent(lblCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addComponent(txtCelular)))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            Familia familia = new Familia(txtCedula.getText(), txtApellido.getText(), txtCelular.getText());
            sistema.agregarFamilia(familia);
            JOptionPane.showMessageDialog(this, "Familia " + familia + " registrada");
            limpiar();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    private void limpiar(){
        txtApellido.setText("");
        txtCedula.setText("");
        txtCelular.setText("");
        txtApellido.requestFocus();
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    // End of variables declaration//GEN-END:variables
}
