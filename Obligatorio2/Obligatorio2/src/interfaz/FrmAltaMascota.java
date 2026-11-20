// Leonardo Santos - 390545

package interfaz;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import dominio.EstadoMascota;
import dominio.Mascota;
import javax.swing.JLabel;
import modelo.Sistema;

public class FrmAltaMascota extends javax.swing.JFrame implements DocumentListener {

    private static final String CODIGO_VALIDO = "[A-Za-z0-9]+";
    private static final String NOMBRE_VALIDO = "[A-Za-zÁÉÍÓÚáéíóúÑñ ]+";
    private static final String PESO_VALIDO   = "[0-9]+([.,][0-9]+)?";
    private static final String TEMPERAMENTO_VALIDO = "[A-Za-zÁÉÍÓÚáéíóúÑñÜü\\s,.;-]+";

    private final Sistema sistema;

    public FrmAltaMascota(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        getRootPane().setDefaultButton(btnAceptar);
        txtCodigo.getDocument().addDocumentListener(this);
        txtNombre.getDocument().addDocumentListener(this);
        txtPeso.getDocument().addDocumentListener(this);
        txtATemperamento.getDocument().addDocumentListener(this);
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
        boolean codigoOk = esValido(txtCodigo, CODIGO_VALIDO);
        boolean nombreOk = esValido(txtNombre, NOMBRE_VALIDO);
        boolean pesoOk = esValido(txtPeso, PESO_VALIDO);
        boolean temperamentoOk = esValido(txtATemperamento, TEMPERAMENTO_VALIDO);
        btnAceptar.setEnabled(codigoOk && nombreOk && pesoOk && temperamentoOk);

        avisarSiEstaMal(txtCodigo, CODIGO_VALIDO, lblCodigoError, "El código solo puede tener letras y números");
        avisarSiEstaMal(txtNombre, NOMBRE_VALIDO, lblNombreError, "El nombre solo puede tener letras y espacios");
        avisarSiEstaMal(txtPeso, PESO_VALIDO, lblPesoError, "El peso debe ser un número, por ejemplo 12 o 12,5");
        avisarSiEstaMal(txtATemperamento, TEMPERAMENTO_VALIDO, lblTemperamentoError, "El temperamento solo puede tener letras y signos de puntuación");
    }

    // Si el campo ya quedó bien, vuelve a letra negra
    private boolean esValido(JTextComponent campo, String regex) {
        boolean ok = campo.getText().trim().matches(regex);
        if (ok) {
            campo.setForeground(Color.BLACK);
        }
        return ok;
    }

    // Un campo vacío no se marca: el botón deshabilitado ya indica que falta
    private void avisarSiEstaMal(JTextComponent campo, String regex, JLabel etiqueta ,String mensaje) {
        String texto = campo.getText().trim();
        if (!texto.isEmpty() && !texto.matches(regex)) {
            campo.setForeground(Color.RED);
            etiqueta.setText(mensaje);
            etiqueta.setForeground(Color.RED);
        }else{
            campo.setForeground(Color.BLACK);
            etiqueta.setText("");
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
        lblCodigoError = new javax.swing.JLabel();
        lblPesoError = new javax.swing.JLabel();
        lblNombreError = new javax.swing.JLabel();
        lblTemperamentoError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Mascota");
        setResizable(false);

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

        btnAceptar.setBackground(new java.awt.Color(200, 240, 200));
        btnAceptar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setOpaque(true);
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setBackground(new java.awt.Color(255, 75, 55));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setMaximumSize(new java.awt.Dimension(54, 26));
        btnCancelar.setMinimumSize(new java.awt.Dimension(54, 26));
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPesoError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigoError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnDisponible)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPeso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCodigo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTemperamento)
                        .addGap(151, 151, 151))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnNoDisponible)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 51, Short.MAX_VALUE)
                                        .addComponent(lblTemperamentoError, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1))))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigoError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPesoError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTemperamento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnDisponible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnNoDisponible))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTemperamentoError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
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
            JOptionPane.showMessageDialog(this, mascota.getNombre() + " registrada con éxito!","Mascota registrada!",JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JLabel lblCodigoError;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreError;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPesoError;
    private javax.swing.JLabel lblTemperamento;
    private javax.swing.JLabel lblTemperamentoError;
    private javax.swing.JRadioButton rbtnDisponible;
    private javax.swing.JRadioButton rbtnNoDisponible;
    private javax.swing.JTextArea txtATemperamento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
