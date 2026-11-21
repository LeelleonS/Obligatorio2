// Leonardo Santos - 390545
package interfaz;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Sistema;

public class FrmGenerarHTML extends javax.swing.JFrame implements DocumentListener {

    private final Sistema sistema;
    private File ultimoGenerado;
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

    private void actualizarBoton() {
        boolean nombreOk = Validaciones.esValido(txtNombre, NOMBRE_VALIDO);
        btnGenerar.setEnabled(nombreOk);
        if (nombreOk || txtNombre.getText().trim().isEmpty()) {
            lblNombreError.setText("");
        } else {
            lblNombreError.setText("El nombre no puede contener los caracteres \\ / : * ? \" < > |");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtRutaGuardado.setText("");
        btnGenerar.setEnabled(false);
    }

    private void abrirEnNavegador(File archivo) {
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(this, "No existe un archivo " + archivo.getName(),
                    "Archivo inexistente", JOptionPane.ERROR_MESSAGE);
        } else if (!Desktop.isDesktopSupported()) {
            JOptionPane.showMessageDialog(this, "Este equipo no puede abrir el navegador desde el programa\nPor favor, busque el archivo en el sistema para abrirlo",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Desktop.getDesktop().browse(archivo.toURI());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador", 
                        "Error abriendo el archivo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscarRuta = new javax.swing.JButton();
        txtRutaGuardado = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblRuta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnAbrirArchivo = new javax.swing.JButton();
        lblNombreError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generación de página HTML de adopciones");
        setResizable(false);

        btnBuscarRuta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnBuscarRuta.setText("Buscar");
        btnBuscarRuta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarRuta.setContentAreaFilled(false);
        btnBuscarRuta.setOpaque(true);
        btnBuscarRuta.addActionListener(this::btnBuscarRutaActionPerformed);

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
        btnAbrirArchivo.setText("Abrir archivo");
        btnAbrirArchivo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAbrirArchivo.setContentAreaFilled(false);
        btnAbrirArchivo.setOpaque(true);
        btnAbrirArchivo.addActionListener(this::btnAbrirArchivoActionPerformed);

        lblNombreError.setForeground(new java.awt.Color(255, 0, 0));

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
                            .addComponent(btnBuscarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblNombreError, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAbrirArchivo, btnGenerar, btnBuscarRuta});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreError, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (sistema.getAdopciones().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay adopciones registradas, no se ha creado el archivo", "Sin adopciones", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String nombreArchivo = txtNombre.getText();
            String carpeta = txtRutaGuardado.getText();
            boolean generar = true;
            if (carpeta.isEmpty()) {
                generar = JOptionPane.showConfirmDialog(this, "No se seleccionó ninguna carpeta, el archivo se guardará en la carpeta del programa",
                        "Guardado de archivo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
            }
            File destino = new File(sistema.rutaPagina(carpeta, nombreArchivo));
            if (generar && destino.exists()) {
                generar = JOptionPane.showConfirmDialog(this, "Ya existe el archivo " + destino.getName() + ". ¿Desea reemplazarlo?",
                        "Archivo existente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }
            if (generar) {
                ultimoGenerado = new File(sistema.generarPaginaAdopciones(carpeta, nombreArchivo)).getAbsoluteFile();
                JOptionPane.showMessageDialog(this, "¡Archivo generado con éxito!\n" + ultimoGenerado.getPath(),
                        "¡Archivo generado!", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnBuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRutaActionPerformed
        JFileChooser seleccionarRuta = new JFileChooser();
        seleccionarRuta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (seleccionarRuta.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (Files.isWritable(seleccionarRuta.getSelectedFile().toPath())) {
                txtRutaGuardado.setText(seleccionarRuta.getSelectedFile().getAbsolutePath());
            }else{
                JOptionPane.showMessageDialog(this, "No tiene permisos para guardar en esa carpeta", "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }//GEN-LAST:event_btnBuscarRutaActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        JFileChooser archivoSeleccionado = new JFileChooser(new File(System.getProperty("user.dir")));
        archivoSeleccionado.setFileFilter(new FileNameExtensionFilter("Páginas web (*.html)", "html"));
        archivoSeleccionado.setAcceptAllFileFilterUsed(false);
        if (ultimoGenerado != null) {
            archivoSeleccionado.setSelectedFile(ultimoGenerado);
        }
        if (archivoSeleccionado.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            abrirEnNavegador(archivoSeleccionado.getSelectedFile());
        }
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnBuscarRuta;
    private javax.swing.JLabel lblNombreError;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRutaGuardado;
    // End of variables declaration//GEN-END:variables

}
