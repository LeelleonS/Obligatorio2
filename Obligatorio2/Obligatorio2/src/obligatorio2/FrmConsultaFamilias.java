// Leonardo Santos - 390545
package obligatorio2;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmConsultaFamilias extends javax.swing.JFrame {
    
    private final Sistema sistema;
    private ArrayList<Familia> familiasEnTabla;
    public FrmConsultaFamilias(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        
        cargarTabla();
    }

    private void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cantidad de adopciones");
        
        familiasEnTabla = sistema.getFamilias();
        
        for(Familia f : familiasEnTabla){
            Object[] fila = {f.getCedula(),f.getCelular(),f.getApellido(),sistema.adopcionesPorFamilia(f)};
            modelo.addRow(fila);
        }
        tblFamilias.setModel(modelo);
        
        TableRowSorter<DefaultTableModel> orden = new TableRowSorter<>(modelo);
        orden.setSortable(0,false);
        orden.setSortable(1,false);
        orden.setComparator(3,Comparator.naturalOrder());
        tblFamilias.setRowSorter(orden);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFamilias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane1.setViewportView(tblFamilias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFamilias;
    // End of variables declaration//GEN-END:variables
}
