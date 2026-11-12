// Leonardo Santos - 390545

package obligatorio2;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FrmAltaMascotas extends javax.swing.JFrame implements DocumentListener, FocusListener {

    private String codigoValido = "[A-Za-z0-9]+";
    private String nombreValido = "[A-Za-zÁÉÍÓÚáéíóúÑñ ]+";
    private String pesoValido   = "[0-9]+([.,][0-9]+)?";
    private String temperamentoValido = "[A-Za-zÁÉÍÓÚáéíóúÑñÜü\\s,.;-]+";

    private final Sistema sistema;

    public FrmAltaMascotas(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        txtCodigo.getDocument().addDocumentListener(this);
        txtNombre.getDocument().addDocumentListener(this);
        txtPeso.getDocument().addDocumentListener(this);
        txtATemperamento.getDocument().addDocumentListener(this);
        txtCodigo.addFocusListener(this);
        txtNombre.addFocusListener(this);
        txtPeso.addFocusListener(this);
        txtATemperamento.addFocusListener(this);
        actualizarBoton();
    }

    // Se revalida con cada cambio de texto, no al entrar o salir de un campo
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

    private void actualizarBoton() {
        boolean codigoOk = esValido(txtCodigo, codigoValido);
        boolean nombreOk = esValido(txtNombre, nombreValido);
        boolean pesoOk = esValido(txtPeso, pesoValido);
        boolean temperamentoOk = esValido(txtATemperamento, temperamentoValido);
        btnAceptar.setEnabled(codigoOk && nombreOk && pesoOk && temperamentoOk);
    }

    // Si el campo ya quedó bien, vuelve a letra negra
    private boolean esValido(JTextComponent campo, String regex) {
        boolean ok = campo.getText().trim().matches(regex);
        if (ok) {
            campo.setForeground(Color.BLACK);
        }
        return ok;
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Temporal = el foco fue a otra ventana (por ej. el propio mensaje); Cancelar cierra sin avisar
        if (e.isTemporary() || e.getOppositeComponent() == btnCancelar) {
            return;
        }
        if (e.getSource() == txtCodigo) {
            avisarSiEstaMal(txtCodigo, codigoValido, "El código solo puede tener letras y números");
        } else if (e.getSource() == txtNombre) {
            avisarSiEstaMal(txtNombre, nombreValido, "El nombre solo puede tener letras y espacios");
        } else if (e.getSource() == txtPeso) {
            avisarSiEstaMal(txtPeso, pesoValido, "El peso debe ser un número, por ejemplo 12 o 12,5");
        } else if (e.getSource() == txtATemperamento) {
            avisarSiEstaMal(txtATemperamento, temperamentoValido,
                    "El temperamento solo puede tener letras y signos de puntuación");
        }
    }

    // Un campo vacío no se marca: el botón deshabilitado ya indica que falta
    private void avisarSiEstaMal(JTextComponent campo, String regex, String mensaje) {
        String texto = campo.getText().trim();
        if (!texto.isEmpty() && !texto.matches(regex)) {
            campo.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, mensaje, "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpEstado = new javax.swing.ButtonGroup();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtATemperamento = new javax.swing.JTextArea();
        lblCodigo = new javax.swing.JLabel();
        lblTemperamento = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        rbtnDisponible = new javax.swing.JRadioButton();
        rbtnNoDisponible = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Mascotas");



        txtPeso.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtATemperamento.setColumns(20);
        txtATemperamento.setRows(5);
        jScrollPane1.setViewportView(txtATemperamento);

        lblCodigo.setText("Código");

        lblTemperamento.setText("Temperamento");

        lblNombre.setText("Nombre");

        lblPeso.setText("Peso (Kg)");

        lblEstado.setText("Estado");

        btngrpEstado.add(rbtnDisponible);
        rbtnDisponible.setText("Disponible");
        rbtnDisponible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btngrpEstado.add(rbtnNoDisponible);
        rbtnNoDisponible.setSelected(true);
        rbtnNoDisponible.setText("No Disponible");
        rbtnNoDisponible.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblCodigo)
                    .addComponent(lblPeso)
                    .addComponent(lblEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(22, 22, 22)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(39, Short.MAX_VALUE)
                        .addComponent(lblTemperamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnNoDisponible)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(rbtnDisponible))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(rbtnDisponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnNoDisponible)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTemperamento)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            double peso = Double.parseDouble(txtPeso.getText().trim().replace(',', '.'));
            EstadoMascota estado = rbtnDisponible.isSelected()
                    ? EstadoMascota.DISPONIBLE
                    : EstadoMascota.NO_DISPONIBLE;
            Mascota mascota = new Mascota(txtCodigo.getText(), txtNombre.getText(),
                    txtATemperamento.getText(), peso, estado);
            sistema.agregarMascota(mascota);
            JOptionPane.showMessageDialog(this, "Mascota " + mascota + " registrada");
            limpiar();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPeso.setText("");
        txtATemperamento.setText("");
        rbtnNoDisponible.setSelected(true);
        txtCodigo.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btngrpEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemperamento;
    private javax.swing.JRadioButton rbtnDisponible;
    private javax.swing.JRadioButton rbtnNoDisponible;
    private javax.swing.JTextArea txtATemperamento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
