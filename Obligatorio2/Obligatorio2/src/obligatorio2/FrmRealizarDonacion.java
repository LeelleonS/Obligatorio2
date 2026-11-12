// Leonardo Santos - 390545

package obligatorio2;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

public class FrmRealizarDonacion extends javax.swing.JFrame implements ListSelectionListener, DocumentListener, FocusListener{

    private final Sistema sistema;
    private String pesoValido = "[0-9]+([.,][0-9]+)?";
    
    public FrmRealizarDonacion(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        
        cargarListaEmpresas();
        
        lstEmpresas.addListSelectionListener(this);
        txtPeso.getDocument().addDocumentListener(this);
        txtPeso.addFocusListener(this);
        
        rbtnGrandes.setSelected(true);
        btnAceptar.setEnabled(false);
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
        boolean pesoOk = esValido(txtPeso, pesoValido);
        btnAceptar.setEnabled(pesoOk);
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
        if (e.isTemporary()){
            return;
        }
        if (e.getSource() == txtPeso){
            if(txtPeso.getText().isEmpty() && !txtPeso.getText().trim().matches(pesoValido)){
                txtPeso.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Solo puede tener numeros y un punto", "Dato incorrecto", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e){
        actualizarBoton();
    }
    
    private void cargarListaEmpresas(){
        DefaultListModel<Empresa> modelo = new DefaultListModel<>();
        for (Empresa e : sistema.getEmpresas()){
            modelo.addElement(e);
        }
        lstEmpresas.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblEmpresas = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        lstEmpresas = new javax.swing.JList<>();
        rbtnChicos = new javax.swing.JRadioButton();
        rbtnGrandes = new javax.swing.JRadioButton();
        rbtnOtros = new javax.swing.JRadioButton();
        rbtnAdultos = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEmpresas.setText("Empresas");

        jScrollPane.setViewportView(lstEmpresas);

        buttonGroup1.add(rbtnChicos);
        rbtnChicos.setText("Para perros chicos");

        buttonGroup1.add(rbtnGrandes);
        rbtnGrandes.setText("Para perros grandes");

        buttonGroup1.add(rbtnOtros);
        rbtnOtros.setText("Otros");

        buttonGroup1.add(rbtnAdultos);
        rbtnAdultos.setText("Para perros adultos");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        lblPeso.setText("Peso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpresas)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnGrandes)
                                    .addComponent(rbtnChicos)
                                    .addComponent(rbtnOtros)
                                    .addComponent(rbtnAdultos)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblPeso)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnAceptar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmpresas)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnGrandes)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnChicos)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnAdultos)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnOtros)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPeso)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Empresa empresa = lstEmpresas.getSelectedValue();
        double peso = Double.parseDouble(txtPeso.getText().trim().replace(',', '.'));
        if (rbtnGrandes.isSelected()){
            sistema.realizarDonacion(empresa, TipoAlimento.PERROS_GRANDES, peso);
        } else if (rbtnChicos.isSelected()){
            sistema.realizarDonacion(empresa, TipoAlimento.PERROS_CHICOS, peso);
        } else if (rbtnAdultos.isSelected()){
            sistema.realizarDonacion(empresa, TipoAlimento.PERROS_ADULTOS, peso);
        } else {
            sistema.realizarDonacion(empresa, TipoAlimento.OTRO, peso);
        }
        JOptionPane.showMessageDialog(this, "Donación registrada");
        limpiar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void limpiar(){
        txtPeso.setText("");
        btnAceptar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblEmpresas;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JList<Empresa> lstEmpresas;
    private javax.swing.JRadioButton rbtnAdultos;
    private javax.swing.JRadioButton rbtnChicos;
    private javax.swing.JRadioButton rbtnGrandes;
    private javax.swing.JRadioButton rbtnOtros;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

}
