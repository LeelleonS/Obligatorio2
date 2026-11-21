// Leonardo Santos - 390545
package interfaz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import dominio.EstadoMascota;
import dominio.Mascota;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import modelo.Sistema;

public class FrmCambiarEstado extends javax.swing.JFrame implements ListSelectionListener, Observer, TableCellRenderer {

    private final Sistema sistema;
    private ArrayList<Mascota> mascotasEnTabla;
    private final JLabel celda = new JLabel();

    public FrmCambiarEstado(Sistema sistema) {
        this.sistema = sistema;
        sistema.addObserver(this);
        initComponents();

        celda.setOpaque(true);
        tblMascotas.setDefaultRenderer(Object.class, this);

        btnCambiar.setEnabled(false);
        tblMascotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMascotas.setDefaultEditor(Object.class, null);
        tblMascotas.getSelectionModel().addListSelectionListener(this);
        actualizarEstadosMascotas();

    }

    @Override
    public void update(Observable ob, Object o) {
        actualizarEstadosMascotas();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            btnCambiar.setEnabled(tblMascotas.getSelectedRow() != -1);
            if (tblMascotas.getSelectedRow() != -1) {
                if (mascotasEnTabla.get(tblMascotas.getSelectedRow()).getEstado() == EstadoMascota.DISPONIBLE) {
                    btnCambiar.setText("Cambiar a no disponible");
                    btnCambiar.setBackground(new Color(255, 75, 55));
                } else {
                    btnCambiar.setText("Cambiar a disponible");
                    btnCambiar.setBackground(new Color(200, 240, 200));
                }
            } else {
                btnCambiar.setText("Cambiar estado");
            }
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object valor,
            boolean seleccionada, boolean tieneFoco, int fila, int columna) {
        celda.setText(valor.toString());

        if (seleccionada) {
            celda.setBackground(tabla.getSelectionBackground());
            celda.setForeground(tabla.getSelectionForeground());
        } else {
            Mascota m = mascotasEnTabla.get(fila);
            if (m.getEstado() == EstadoMascota.DISPONIBLE) {
                celda.setBackground(new Color(200, 240, 200));
            } else {
                celda.setBackground(new Color(255, 75, 55)); 
            }
            celda.setForeground(tabla.getForeground());
        }
        return celda;
    }

    private void actualizarEstadosMascotas() {
        mascotasEnTabla = new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");

        for (Mascota m : sistema.getMascotas()) {
            if (m.getEstado() != EstadoMascota.ENTREGADA) {
                mascotasEnTabla.add(m);
            }
        }

        for (Mascota m : mascotasEnTabla) {
            Object[] fila = {m.getCodigo(), m.getNombre(), m.getEstado()};
            modelo.addRow(fila);
        }
        tblMascotas.setModel(modelo);
    }

    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMascotas = new javax.swing.JPanel();
        scrMascotas = new javax.swing.JScrollPane();
        tblMascotas = new javax.swing.JTable();
        btnCambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar estado de mascota");

        pnlMascotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de mascotas no adoptadas"));

        tblMascotas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrMascotas.setViewportView(tblMascotas);

        javax.swing.GroupLayout pnlMascotasLayout = new javax.swing.GroupLayout(pnlMascotas);
        pnlMascotas.setLayout(pnlMascotasLayout);
        pnlMascotasLayout.setHorizontalGroup(
            pnlMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMascotasLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(scrMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMascotasLayout.setVerticalGroup(
            pnlMascotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMascotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCambiar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnCambiar.setText("Cambiar estado");
        btnCambiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCambiar.setContentAreaFilled(false);
        btnCambiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiar.setOpaque(true);
        btnCambiar.addActionListener(this::btnCambiarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pnlMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        int fila = tblMascotas.getSelectedRow();

        if (fila != -1) {
            Mascota mascota = mascotasEnTabla.get(fila);
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea cambiar el estado?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    sistema.cambiarEstado(mascota);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnCambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JScrollPane scrMascotas;
    private javax.swing.JPanel pnlMascotas;
    private javax.swing.JTable tblMascotas;
    // End of variables declaration//GEN-END:variables

}
