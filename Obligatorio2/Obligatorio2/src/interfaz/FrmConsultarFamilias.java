// Leonardo Santos - 390545
package interfaz;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import dominio.Familia;
import java.util.Observable;
import java.util.Observer;
import modelo.Sistema;

public class FrmConsultarFamilias extends javax.swing.JFrame implements Observer{
    
    private final Sistema sistema;
    private ArrayList<Familia> familiasEnTabla;
    public FrmConsultarFamilias(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        tblFamilias.setDefaultEditor(Object.class, null);
        cargarTabla();
    }

    @Override
    public void update(Observable ob, Object o){
        cargarTabla();
    }
    
    private void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
        modelo.addColumn("Celular");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cantidad de adopciones");
        
        familiasEnTabla = sistema.getFamiliasOrdenadas(rbtnApellido.isSelected());
        
        for(Familia f : familiasEnTabla){
            Object[] fila = {f.getCedula(),f.getCelular(),f.getApellido(),sistema.adopcionesPorFamilia(f)};
            modelo.addRow(fila);
        }
        tblFamilias.setModel(modelo);
    }
    
    @Override
    public void dispose(){
        sistema.deleteObserver(this);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpOrden = new javax.swing.ButtonGroup();
        lblOrden = new javax.swing.JLabel();
        rbtnApellido = new javax.swing.JRadioButton();
        rbtnAdopciones = new javax.swing.JRadioButton();
        scrFamilias = new javax.swing.JScrollPane();
        tblFamilias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de familias");

        lblOrden.setText("Ordenar por:");

        grpOrden.add(rbtnApellido);
        rbtnApellido.setSelected(true);
        rbtnApellido.setText("Apellido");
        rbtnApellido.addActionListener(this::rbtnApellidoActionPerformed);

        grpOrden.add(rbtnAdopciones);
        rbtnAdopciones.setText("Cantidad de adopciones");
        rbtnAdopciones.addActionListener(this::rbtnAdopcionesActionPerformed);

        tblFamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrFamilias.setViewportView(tblFamilias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(rbtnApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnAdopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrFamilias, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnAdopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(scrFamilias, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );


        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnApellidoActionPerformed
        cargarTabla();
    }//GEN-LAST:event_rbtnApellidoActionPerformed

    private void rbtnAdopcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAdopcionesActionPerformed
        cargarTabla();
    }//GEN-LAST:event_rbtnAdopcionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grpOrden;
    private javax.swing.JScrollPane scrFamilias;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JRadioButton rbtnAdopciones;
    private javax.swing.JRadioButton rbtnApellido;
    private javax.swing.JTable tblFamilias;
    // End of variables declaration//GEN-END:variables
}
