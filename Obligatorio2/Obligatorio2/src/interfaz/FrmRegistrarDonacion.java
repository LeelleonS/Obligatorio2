// Leonardo Santos - 390545
package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dominio.Donacion;
import dominio.Empresa;
import modelo.Sistema;
import dominio.TipoAlimento;
import java.util.Observable;
import java.util.Observer;

public class FrmRegistrarDonacion extends javax.swing.JFrame implements ListSelectionListener, DocumentListener, Observer {

    private final Sistema sistema;

    public FrmRegistrarDonacion(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        getRootPane().setDefaultButton(btnAceptar);

        cargarListaEmpresas();

        lstEmpresas.addListSelectionListener(this);
        txtKilos.getDocument().addDocumentListener(this);

        rbtnGrandes.setSelected(true);
        btnAceptar.setEnabled(false);
    }

    @Override
    public void update(Observable ob, Object o) {
        cargarListaEmpresas();
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

    private void actualizarBoton() {
        boolean kilosOk = Validaciones.esNumeroPositivo(txtKilos);
        boolean empresaOk = !lstEmpresas.isSelectionEmpty();
        btnAceptar.setEnabled(kilosOk && empresaOk);

        Validaciones.avisarSiEstaMal(txtKilos, kilosOk, lblKilosError, "Los kilos deben ser un número mayor a 0, por ejemplo 12 o 12,5");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            actualizarBoton();
        }
    }

    private void cargarListaEmpresas() {
        DefaultListModel<Empresa> modelo = new DefaultListModel<>();
        for (Empresa e : sistema.getEmpresas()) {
            modelo.addElement(e);
        }
        lstEmpresas.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipoAlimento = new javax.swing.ButtonGroup();
        btnAceptar = new javax.swing.JButton();
        pnlEmpresas = new javax.swing.JPanel();
        scrEmpresas = new javax.swing.JScrollPane();
        lstEmpresas = new javax.swing.JList<>();
        pnlTipoAlimento = new javax.swing.JPanel();
        rbtnChicos = new javax.swing.JRadioButton();
        rbtnGrandes = new javax.swing.JRadioButton();
        rbtnOtro = new javax.swing.JRadioButton();
        rbtnAdultos = new javax.swing.JRadioButton();
        txtKilos = new javax.swing.JTextField();
        lblKilos = new javax.swing.JLabel();
        lblKilosError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar donación");
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

        pnlEmpresas.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresas donantes"));

        scrEmpresas.setViewportView(lstEmpresas);

        javax.swing.GroupLayout pnlEmpresasLayout = new javax.swing.GroupLayout(pnlEmpresas);
        pnlEmpresas.setLayout(pnlEmpresasLayout);
        pnlEmpresasLayout.setHorizontalGroup(
            pnlEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlEmpresasLayout.setVerticalGroup(
            pnlEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresasLayout.createSequentialGroup()
                .addComponent(scrEmpresas)
                .addContainerGap())
        );

        pnlTipoAlimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de alimento"));

        grpTipoAlimento.add(rbtnChicos);
        rbtnChicos.setText("Para perros chicos");

        grpTipoAlimento.add(rbtnGrandes);
        rbtnGrandes.setText("Para perros grandes");

        grpTipoAlimento.add(rbtnOtro);
        rbtnOtro.setText("Otro");

        grpTipoAlimento.add(rbtnAdultos);
        rbtnAdultos.setText("Para perros adultos");

        lblKilos.setText("Kilos");

        javax.swing.GroupLayout pnlTipoAlimentoLayout = new javax.swing.GroupLayout(pnlTipoAlimento);
        pnlTipoAlimento.setLayout(pnlTipoAlimentoLayout);
        pnlTipoAlimentoLayout.setHorizontalGroup(
            pnlTipoAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoAlimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTipoAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTipoAlimentoLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(pnlTipoAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnGrandes)
                            .addComponent(rbtnChicos)
                            .addComponent(rbtnOtro)
                            .addComponent(rbtnAdultos)))
                    .addGroup(pnlTipoAlimentoLayout.createSequentialGroup()
                        .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlTipoAlimentoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblKilos)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlTipoAlimentoLayout.setVerticalGroup(
            pnlTipoAlimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTipoAlimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnGrandes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnChicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnAdultos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnOtro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblKilos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblKilosError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTipoAlimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKilosError, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Empresa empresa = lstEmpresas.getSelectedValue();
        double kilos = Validaciones.aNumero(txtKilos);
        TipoAlimento tipo;
        if (rbtnGrandes.isSelected()) {
            tipo = TipoAlimento.PERROS_GRANDES;
        } else if (rbtnChicos.isSelected()) {
            tipo = TipoAlimento.PERROS_CHICOS;
        } else if (rbtnAdultos.isSelected()) {
            tipo = TipoAlimento.PERROS_ADULTOS;
        } else {
            tipo = TipoAlimento.OTRO;
        }
        Donacion donacion = sistema.agregarDonacion(empresa, tipo, kilos);
        JOptionPane.showMessageDialog(this, "Donación número " + donacion.getNumero() + " registrada: "
                + donacion.getKilos() + " kg de " + empresa.getNombre(), "¡Gracias!", JOptionPane.INFORMATION_MESSAGE);
        limpiar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void limpiar() {
        txtKilos.setText("");
        btnAceptar.setEnabled(false);
        rbtnGrandes.setSelected(true);
    }

    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup grpTipoAlimento;
    private javax.swing.JPanel pnlEmpresas;
    private javax.swing.JPanel pnlTipoAlimento;
    private javax.swing.JScrollPane scrEmpresas;
    private javax.swing.JLabel lblKilos;
    private javax.swing.JLabel lblKilosError;
    private javax.swing.JList<Empresa> lstEmpresas;
    private javax.swing.JRadioButton rbtnAdultos;
    private javax.swing.JRadioButton rbtnChicos;
    private javax.swing.JRadioButton rbtnGrandes;
    private javax.swing.JRadioButton rbtnOtro;
    private javax.swing.JTextField txtKilos;
    // End of variables declaration//GEN-END:variables

}
