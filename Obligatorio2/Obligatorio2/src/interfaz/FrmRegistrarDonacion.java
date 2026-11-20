// Leonardo Santos - 390545

package interfaz;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import dominio.Empresa;
import modelo.Sistema;
import dominio.TipoAlimento;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

public class FrmRegistrarDonacion extends javax.swing.JFrame implements ListSelectionListener, DocumentListener, Observer{

    private final Sistema sistema;
    private final static String PESO_VALIDO = "[0-9]+([.,][0-9]+)?";
    
    public FrmRegistrarDonacion(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        getRootPane().setDefaultButton(btnAceptar);
        
        cargarListaEmpresas();
        
        lstEmpresas.addListSelectionListener(this);
        txtPeso.getDocument().addDocumentListener(this);
        
        rbtnGrandes.setSelected(true);
        btnAceptar.setEnabled(false);
    }

    @Override
    public void update(Observable ob, Object o){
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
    
    private void actualizarBoton(){
        boolean pesoOk = esValido(txtPeso, PESO_VALIDO);
        boolean empresaOk = !lstEmpresas.isSelectionEmpty();
        btnAceptar.setEnabled(pesoOk && empresaOk);
        
        avisarSiEstaMal(txtPeso, PESO_VALIDO, lblPesoError, "El peso debe ser un número, por ejemplo 12 o 12,5");
    }
    
    private boolean esValido(JTextComponent campo, String regex){
        boolean ok = campo.getText().trim().matches(regex);
        if (ok){
            campo.setForeground(Color.BLACK);
        }
        return ok;
    }
    
    private void avisarSiEstaMal(JTextComponent campo, String regex, JLabel etiqueta, String mensaje){
        String texto = campo.getText().trim();
        if(!texto.isEmpty() && !texto.matches(regex)){
            campo.setForeground(Color.RED);
            etiqueta.setText(mensaje);
            etiqueta.setForeground(Color.RED);
        }else{
            campo.setForeground(Color.BLACK);
            etiqueta.setText("");
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
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        lstEmpresas = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        rbtnChicos = new javax.swing.JRadioButton();
        rbtnGrandes = new javax.swing.JRadioButton();
        rbtnOtros = new javax.swing.JRadioButton();
        rbtnAdultos = new javax.swing.JRadioButton();
        txtPeso = new javax.swing.JTextField();
        lblPeso = new javax.swing.JLabel();
        lblPesoError = new javax.swing.JLabel();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresas donantes"));

        jScrollPane.setViewportView(lstEmpresas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de alimento"));

        buttonGroup1.add(rbtnChicos);
        rbtnChicos.setText("Para perros chicos");

        buttonGroup1.add(rbtnGrandes);
        rbtnGrandes.setText("Para perros grandes");

        buttonGroup1.add(rbtnOtros);
        rbtnOtros.setText("Otros");

        buttonGroup1.add(rbtnAdultos);
        rbtnAdultos.setText("Para perros adultos");

        lblPeso.setText("Kilos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnGrandes)
                            .addComponent(rbtnChicos)
                            .addComponent(rbtnOtros)
                            .addComponent(rbtnAdultos)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblPeso)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnGrandes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnChicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnAdultos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnOtros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblPeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPesoError, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPesoError, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Empresa empresa = lstEmpresas.getSelectedValue();
        double peso = Double.parseDouble(txtPeso.getText().trim().replace(',', '.'));
        if (rbtnGrandes.isSelected()){
            sistema.agregarDonacion(empresa, TipoAlimento.PERROS_GRANDES, peso);
        } else if (rbtnChicos.isSelected()){
            sistema.agregarDonacion(empresa, TipoAlimento.PERROS_CHICOS, peso);
        } else if (rbtnAdultos.isSelected()){
            sistema.agregarDonacion(empresa, TipoAlimento.PERROS_ADULTOS, peso);
        } else {
            sistema.agregarDonacion(empresa, TipoAlimento.OTRO, peso);
        }
        JOptionPane.showMessageDialog(this, "Donación registrada","Gracias!",JOptionPane.INFORMATION_MESSAGE);
        limpiar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    private void limpiar(){
        txtPeso.setText("");
        btnAceptar.setEnabled(false);
        rbtnGrandes.setSelected(true);
    }
    
    @Override
    public void dispose(){
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPesoError;
    private javax.swing.JList<Empresa> lstEmpresas;
    private javax.swing.JRadioButton rbtnAdultos;
    private javax.swing.JRadioButton rbtnChicos;
    private javax.swing.JRadioButton rbtnGrandes;
    private javax.swing.JRadioButton rbtnOtros;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

}
