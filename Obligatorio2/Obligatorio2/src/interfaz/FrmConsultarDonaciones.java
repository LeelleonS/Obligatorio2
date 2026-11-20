//Leonardo Santos - 390545
package interfaz;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import dominio.Donacion;
import java.util.Observable;
import java.util.Observer;
import modelo.Sistema;

public class FrmConsultarDonaciones extends javax.swing.JFrame implements Observer{
    
    private final Sistema sistema;
    private ArrayList<Donacion> donacionesEnTabla;
    
    public FrmConsultarDonaciones(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();
        
        cargarTabla();
    }

    @Override
    public void update(Observable ob, Object o){
        cargarTabla();
    }
    
    private void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();    
        modelo.addColumn("Número");
        modelo.addColumn("Empresa");
        modelo.addColumn("Tipo de alimento");
        modelo.addColumn("Kilos");
    
        donacionesEnTabla = sistema.getDonaciones();
    
        for(Donacion d : donacionesEnTabla){
            Object[] fila = {d.getNumero(),d.getEmpresa().getNombre(),d.getTipoAlimento().toString(),d.getKilos() + " kg"};
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
    
    @Override
    public void dispose(){
        sistema.deleteObserver(this);
        super.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDonaciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de donaciones");

        pnlDonaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Donaciones realizadas"));

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

        javax.swing.GroupLayout pnlDonacionesLayout = new javax.swing.GroupLayout(pnlDonaciones);
        pnlDonaciones.setLayout(pnlDonacionesLayout);
        pnlDonacionesLayout.setHorizontalGroup(
            pnlDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDonacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDonacionesLayout.setVerticalGroup(
            pnlDonacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDonacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(pnlDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDonaciones;
    private javax.swing.JTable tblDonaciones;
    // End of variables declaration//GEN-END:variables
}
