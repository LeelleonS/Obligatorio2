//Leonardo Santos - 390545
package obligatorio2;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmConsultaDonaciones extends javax.swing.JFrame {
    
    private final Sistema sistema;
    private ArrayList<Donacion> donacionesEnTabla;
    
    public FrmConsultaDonaciones(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        
        cargarTabla();
    }

    private void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();    
        modelo.addColumn("Id");
        modelo.addColumn("Empresa");
        modelo.addColumn("Tipo de Alimento");
        modelo.addColumn("Cantidad");
    
        donacionesEnTabla = sistema.getDonaciones();
    
        for(Donacion d : donacionesEnTabla){
            Object[] fila = {d.getNumero(),d.getEmpresa().getNombre(),d.getTipoAlimento().toString(),d.getKilos() + "Kg"};
            modelo.addRow(fila);
        }
        tblDonaciones.setModel(modelo);
    
        TableRowSorter<DefaultTableModel> orden = new TableRowSorter<>(modelo);
        orden.setSortable(1,false);
        orden.setSortable(2,false);
        orden.setSortable(3,false);
        orden.setComparator(0,Comparator.naturalOrder());
        tblDonaciones.setRowSorter(orden);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDonaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDonaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDonaciones;
    // End of variables declaration//GEN-END:variables
}
