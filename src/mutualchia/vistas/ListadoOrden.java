/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.vistas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mutualchia.Conexion;
import mutualchia.entidades.Orden;
import mutualchia.modelo.OrdenData;

/**
 *
 * @author Cacho
 */
public class ListadoOrden extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private Orden ord;
    private OrdenData od;
    private List<Orden> listaOrdenes;
    
   


    /**
     * Creates new form ListadoOrden
     */
    public ListadoOrden() {
        initComponents();
     try {
        modelo= new DefaultTableModel ();
        armarCabecera();
        
        od = new OrdenData (new Conexion());
       // dcFecha.setSelectableDateRange();
//       cargarDatosOrden();
       
    } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error de Conexion");
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrdenes = new javax.swing.JTable();
        btSalir = new javax.swing.JButton();
        dcFecha = new com.toedter.calendar.JDateChooser();

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("LISTADO ORDENES ");

        jLabel2.setText("FECHA DE EMISION");

        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tbOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrdenesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbOrdenes);

        btSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btBuscar))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void tbOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrdenesMouseClicked
        // TODO add your handling code here:
        int fila = tbOrdenes.getSelectedRow();
        
       dcFecha.setSelectedItem(()tbOrdenes.getValueAt(fila, 0));
       
        
        
        ord = new Orden ();
        ord.setIdOrden((int)tbOrdenes.getValueAt(fila, 0));
        ord.setFechaTurno((Date)tbOrdenes.getValueAt(fila, 1));
        ord.setPrestador((String)tbOrdenes.getValueAt(fila, 2));
        ord.setAfiliado ((String)tbOrdenes.getValueAt(fila,3));
        ord.setIdOrden(idOrden);
    }//GEN-LAST:event_tbOrdenesMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        try {
        Date fechaBuscar =Date.parseDate(dcFecha);
        Orden ord = od.buscarOrdenXFecha(fechaBuscar);
       
        if (ord!=null) {
        dcFecha.setMaxSelectableDate(fechaBuscar);
        
        } else {
        JOptionPane.showMessageDialog(this, "Fecha no encontrada");
        dcFecha.requestFocus();
        }
    }//GEN-LAST:event_btBuscarActionPerformed
//private void cargarDatosOrden () {
        // try {
            // borrarFilas ();
//             Orden orden =(Orden) dcFecha.getSelectedItem();
               // OrdenData od = new OrdenData(new Conexion());
//             List <Orden> listaOrdenes=od.buscarOrdenXFecha(fecha);
//             for(Orden o:listaOrdenes) {
  //               if(o.isActivo()) {
                 
                 
                 
                // modelo.addRow(new Object[]{o.getIdOrden(),o.getAfiliado(), o.getFechaTurno(),o.getFechaTurno(),o.getPrestador()});
                // }
                 
             //}
        // } catch (ClassNotFoundException ex) {
             //JOptionPane.showMessageDialog(this, "Error al recuperar las ordenes");
        // }
                //}
    
    
    
    private void armarCabecera () {
            ArrayList<Object> titulos=new ArrayList<Object>();
            titulos.add("ID");
            titulos.add("FechaTurno");
            titulos.add("Prestador");
            titulos.add("Afiliado");
          
            for(Object it:titulos) {
                modelo.addColumn(it);
            }
            tbOrdenes.setModel(modelo);
}

 private void borrarFilas (){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){

                modelo.removeRow(i );
                

        }
        }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btSalir;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbOrdenes;
    // End of variables declaration//GEN-END:variables
}
