// Leonardo Santos - 390545

package interfaz;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;
import modelo.Sistema;

public class FrmGenerarHTML extends javax.swing.JFrame implements DocumentListener {
    
    private final Sistema sistema;
    private static final String NOMBRE_VALIDO = "[^\\\\/:*?\"<>|]+";
    
    public FrmGenerarHTML(Sistema sistema) {
        initComponents();
        getRootPane().setDefaultButton(btnGenerar);
        this.sistema = sistema;
        
        txtNombre.getDocument().addDocumentListener(this);
        btnGenerar.setEnabled(false);
        txtRutaGuardado.setEditable(false);
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
        boolean nombreOk = esValido(txtNombre,NOMBRE_VALIDO);
        btnGenerar.setEnabled(nombreOk);
        if (nombreOk || txtNombre.getText().trim().isEmpty()){
            lblErrorNombre.setText("");
        }else{
            lblErrorNombre.setText("El nombre no puede contener los caracteres \\ / : * ? \" < > |");
        }
    }
    
    private boolean esValido(JTextComponent campo, String regex){
        boolean ok = campo.getText().trim().matches(regex);
        if (ok){
            campo.setForeground(Color.BLACK);
        }
        return ok;
    }
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtRutaGuardado.setText("");
        btnGenerar.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRutaGuardado = new javax.swing.JButton();
        txtRutaGuardado = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblRuta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnAbrirArchivo = new javax.swing.JButton();
        lblErrorNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generación de página HTML de adopciones");
        setResizable(false);

        btnRutaGuardado.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnRutaGuardado.setText("Buscar");
        btnRutaGuardado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRutaGuardado.setContentAreaFilled(false);
        btnRutaGuardado.setOpaque(true);
        btnRutaGuardado.addActionListener(this::btnRutaGuardadoActionPerformed);

        txtRutaGuardado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGenerar.setBackground(new java.awt.Color(200, 240, 200));
        btnGenerar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerar.setText("Generar");
        btnGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setOpaque(true);
        btnGenerar.addActionListener(this::btnGenerarActionPerformed);

        lblRuta.setText("Guardar en...");

        lblNombre.setText("Nombre del archivo");

        btnAbrirArchivo.setBackground(new java.awt.Color(200, 240, 200));
        btnAbrirArchivo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAbrirArchivo.setForeground(new java.awt.Color(0, 0, 0));
        btnAbrirArchivo.setText("Abrir Archivo");
        btnAbrirArchivo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAbrirArchivo.setContentAreaFilled(false);
        btnAbrirArchivo.setOpaque(true);
        btnAbrirArchivo.addActionListener(this::btnAbrirArchivoActionPerformed);

        lblErrorNombre.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRuta)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAbrirArchivo, btnGenerar, btnRutaGuardado});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if(sistema.getAdopciones().isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay adopciones registradas, no se ha creado el archivo","Sin adopciones",JOptionPane.INFORMATION_MESSAGE);
        }else{
            String nombreArchivo = txtNombre.getText();
            String rutaArchivo = txtRutaGuardado.getText();
            if(rutaArchivo.isEmpty()){
                if(JOptionPane.showConfirmDialog(this, "No se seleccionó ninguna ruta, el archivo se guardara en la carpeta del programa", 
                    "Guardado de archivo",JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
                    sistema.generarPaginaAdopciones("",nombreArchivo);
                    limpiarCampos();
                }
            }else{
                sistema.generarPaginaAdopciones(rutaArchivo,nombreArchivo);
                limpiarCampos();
            }
            JOptionPane.showMessageDialog(this, "Archivo generado con éxito!", "Archivo generado!", JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnRutaGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaGuardadoActionPerformed
        JFileChooser seleccionarRuta = new JFileChooser();
        seleccionarRuta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(seleccionarRuta.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            txtRutaGuardado.setText(seleccionarRuta.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btnRutaGuardadoActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        JFileChooser archivoSeleccionado = new JFileChooser();
        archivoSeleccionado.setFileFilter(new FileNameExtensionFilter("(*.html)","html"));
        if(archivoSeleccionado.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try{
                File archivo = archivoSeleccionado.getSelectedFile();
                Desktop.getDesktop().browse(archivo.toURI());
            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador", "Error abriendo el archivo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRutaGuardado;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRutaGuardado;
    // End of variables declaration//GEN-END:variables

}
