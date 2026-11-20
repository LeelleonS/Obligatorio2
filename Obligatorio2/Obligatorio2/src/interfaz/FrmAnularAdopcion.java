// Leonardo Santos - 390545
package interfaz;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import dominio.Adopcion;
import java.util.Observable;
import java.util.Observer;
import modelo.Sistema;

public class FrmAnularAdopcion extends javax.swing.JFrame implements ListSelectionListener, Observer{
    
    private final Sistema sistema;
    private ArrayList<Adopcion> adopcionesEnTabla;
    
    public FrmAnularAdopcion(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        
        btnAnular.setEnabled(false);
        tblAdopciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblAdopciones.setDefaultEditor(Object.class,null);
        tblAdopciones.getSelectionModel().addListSelectionListener(this);
        
        cargarTabla();
    }

    @Override
    public void update(Observable ob, Object o){
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
        //btnAnular.setEnabled(false);
    }

    @Override
    public void valueChanged(ListSelectionEvent e){
        if (!e.getValueIsAdjusting()){
            btnAnular.setEnabled(tblAdopciones.getSelectedRow() != -1);
        }
    }
    
    @Override
    public void dispose(){
        sistema.deleteObserver(this);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAdiopciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdopciones = new javax.swing.JTable();
        btnAnular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anular adopción");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlAdiopciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Adopciones realizadas"));

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

        javax.swing.GroupLayout pnlAdiopcionesLayout = new javax.swing.GroupLayout(pnlAdiopciones);
        pnlAdiopciones.setLayout(pnlAdiopcionesLayout);
        pnlAdiopcionesLayout.setHorizontalGroup(
            pnlAdiopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdiopcionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAdiopcionesLayout.setVerticalGroup(
            pnlAdiopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdiopcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnAnular.setBackground(new java.awt.Color(200, 240, 200));
        btnAnular.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAnular.setForeground(new java.awt.Color(0, 0, 0));
        btnAnular.setText("Anular");
        btnAnular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAnular.setContentAreaFilled(false);
        btnAnular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnular.setMaximumSize(new java.awt.Dimension(47, 22));
        btnAnular.setMinimumSize(new java.awt.Dimension(47, 22));
        btnAnular.setPreferredSize(new java.awt.Dimension(47, 22));
        btnAnular.addActionListener(this::btnAnularActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdiopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlAdiopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
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
    private javax.swing.JPanel pnlAdiopciones;
    private javax.swing.JTable tblAdopciones;
    // End of variables declaration//GEN-END:variables

}
