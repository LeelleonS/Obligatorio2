// Leonardo Santos - 390545

package obligatorio2;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    private final Sistema sistema;

    public FrmMenuPrincipal(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel1 = new java.awt.Panel();
        btnAltaMascotas = new javax.swing.JButton();
        btnAltaFamilias = new javax.swing.JButton();
        btnAltaEmpresas = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        btnAdopcion = new javax.swing.JButton();
        btnAnularAdopcion = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        btnIniciarDonacion = new javax.swing.JButton();
        btnImportarDonacion = new javax.swing.JButton();
        panel3 = new java.awt.Panel();
        btnConsultaFamilia = new javax.swing.JButton();
        btnConsultarDonaciones = new javax.swing.JButton();
        btnGenerarPagina = new javax.swing.JButton();
        btnRecuperarDatos = new javax.swing.JButton();
        btnAutores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAltaMascotas.setText("Mascotas");
        btnAltaMascotas.setToolTipText("");
        btnAltaMascotas.addActionListener(this::btnAltaMascotasActionPerformed);

        btnAltaFamilias.setText("Familias");
        btnAltaFamilias.addActionListener(this::btnAltaFamiliasActionPerformed);

        btnAltaEmpresas.setText("Empresas");
        btnAltaEmpresas.addActionListener(this::btnAltaEmpresasActionPerformed);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAltaFamilias)
                        .addComponent(btnAltaMascotas))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnAltaEmpresas)
                        .addGap(7, 7, 7)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnAltaMascotas)
                .addGap(105, 105, 105)
                .addComponent(btnAltaFamilias)
                .addGap(95, 95, 95)
                .addComponent(btnAltaEmpresas)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Altas", panel1);

        btnAdopcion.setText("Iniciar Adopción");
        btnAdopcion.addActionListener(this::btnAdopcionActionPerformed);

        btnAnularAdopcion.setText("Anular Adopción");
        btnAnularAdopcion.addActionListener(this::btnAnularAdopcionActionPerformed);

        btnCambiarEstado.setText("Cambiar Estado");
        btnCambiarEstado.addActionListener(this::btnCambiarEstadoActionPerformed);

        btnIniciarDonacion.setText("Registrar Donación");
        btnIniciarDonacion.addActionListener(this::btnIniciarDonacionActionPerformed);

        btnImportarDonacion.setText("Importar Donaciones");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImportarDonacion)
                    .addComponent(btnIniciarDonacion)
                    .addComponent(btnCambiarEstado)
                    .addComponent(btnAnularAdopcion)
                    .addComponent(btnAdopcion))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnAdopcion)
                .addGap(54, 54, 54)
                .addComponent(btnAnularAdopcion)
                .addGap(48, 48, 48)
                .addComponent(btnCambiarEstado)
                .addGap(62, 62, 62)
                .addComponent(btnIniciarDonacion)
                .addGap(59, 59, 59)
                .addComponent(btnImportarDonacion)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Movimientos", panel2);

        btnConsultaFamilia.setText("Consultar Familias");
        btnConsultaFamilia.addActionListener(this::btnConsultaFamiliaActionPerformed);

        btnConsultarDonaciones.setText("Consultar Donaciones");
        btnConsultarDonaciones.addActionListener(this::btnConsultarDonacionesActionPerformed);

        btnGenerarPagina.setText("Generación de Página");

        btnRecuperarDatos.setText("Recuperar Datos");

        btnAutores.setText("Autores");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnConsultarDonaciones)
                .addGap(85, 85, 85))
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnConsultaFamilia))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRecuperarDatos)
                            .addComponent(btnGenerarPagina)))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnAutores)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnConsultaFamilia)
                .addGap(50, 50, 50)
                .addComponent(btnConsultarDonaciones)
                .addGap(35, 35, 35)
                .addComponent(btnGenerarPagina)
                .addGap(51, 51, 51)
                .addComponent(btnRecuperarDatos)
                .addGap(73, 73, 73)
                .addComponent(btnAutores)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", panel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaMascotasActionPerformed
        new FrmAltaMascotas(sistema).setVisible(true);
    }//GEN-LAST:event_btnAltaMascotasActionPerformed

    private void btnAltaFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaFamiliasActionPerformed
        new FrmAltaFamilia(sistema).setVisible(true);
    }//GEN-LAST:event_btnAltaFamiliasActionPerformed

    private void btnAltaEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaEmpresasActionPerformed
        new FrmAltaEmpresa(sistema).setVisible(true);
    }//GEN-LAST:event_btnAltaEmpresasActionPerformed

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        new FrmCambiarEstado(sistema).setVisible(true);
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    private void btnAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdopcionActionPerformed
        new FrmRealizarAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_btnAdopcionActionPerformed

    private void btnAnularAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularAdopcionActionPerformed
        new FrmAnularAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_btnAnularAdopcionActionPerformed

    private void btnIniciarDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarDonacionActionPerformed
        new FrmRealizarDonacion(sistema).setVisible(true);
    }//GEN-LAST:event_btnIniciarDonacionActionPerformed

    private void btnConsultaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaFamiliaActionPerformed
        new FrmConsultaFamilias(sistema).setVisible(true);
    }//GEN-LAST:event_btnConsultaFamiliaActionPerformed

    private void btnConsultarDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDonacionesActionPerformed
        new FrmConsultaDonaciones(sistema).setVisible(true);
    }//GEN-LAST:event_btnConsultarDonacionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdopcion;
    private javax.swing.JButton btnAltaEmpresas;
    private javax.swing.JButton btnAltaFamilias;
    private javax.swing.JButton btnAltaMascotas;
    private javax.swing.JButton btnAnularAdopcion;
    private javax.swing.JButton btnAutores;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnConsultaFamilia;
    private javax.swing.JButton btnConsultarDonaciones;
    private javax.swing.JButton btnGenerarPagina;
    private javax.swing.JButton btnImportarDonacion;
    private javax.swing.JButton btnIniciarDonacion;
    private javax.swing.JButton btnRecuperarDatos;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    // End of variables declaration//GEN-END:variables
}
