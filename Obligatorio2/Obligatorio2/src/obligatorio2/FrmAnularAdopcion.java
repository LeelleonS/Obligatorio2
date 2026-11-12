// Leonardo Santos - 390545
package obligatorio2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrmAnularAdopcion extends javax.swing.JFrame implements ListSelectionListener{
    
    private final Sistema sistema;
    private ArrayList<Adopcion> adopcionesEnTabla;
    
    public FrmAnularAdopcion(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        
        btnAnular.setEnabled(false);
        tblAdopciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblAdopciones.setDefaultEditor(Object.class,null);
        tblAdopciones.getSelectionModel().addListSelectionListener(this);
        
        cargarTabla();
    }

    private void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número");
        modelo.addColumn("Mascota");
        modelo.addColumn("Familia");
        
        adopcionesEnTabla = sistema.getAdopciones();
        
        for (Adopcion a : adopcionesEnTabla){
            Object[] fila = {a.getNumero(), a.getMascota().toString(),a.getFamilia().getApellido()};
            modelo.addRow(fila);
        }
        
        tblAdopciones.setModel(modelo);
        btnAnular.setEnabled(false);
    }

    @Override
    public void valueChanged(ListSelectionEvent e){
        if (!e.getValueIsAdjusting()){
            btnAnular.setEnabled(tblAdopciones.getSelectedRow() != -1);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdopciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdopciones = new javax.swing.JTable();
        btnAnular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblAdopciones.setText("Adopciones");

        tblAdopciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAdopciones);

        btnAnular.setText("Anular");
        btnAnular.addActionListener(this::btnAnularActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(lblAdopciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnular)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdopciones)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnular)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        int fila = tblAdopciones.getSelectedRow();
        
        if (fila != -1){
            Adopcion adopcion = adopcionesEnTabla.get(fila);
            
            int respuesta = JOptionPane.showConfirmDialog(this, "Desea anular la adopcion","Confirmar",JOptionPane.YES_NO_OPTION);
            
            if(respuesta == JOptionPane.YES_OPTION){
                try{
                    sistema.anularAdopcion(adopcion);
                    JOptionPane.showMessageDialog(this, "Adopcion numero " + adopcion.getNumero() + " anulada");
                    cargarTabla();
                } catch (IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdopciones;
    private javax.swing.JTable tblAdopciones;
    // End of variables declaration//GEN-END:variables

}
