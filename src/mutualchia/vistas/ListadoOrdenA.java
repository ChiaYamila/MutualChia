/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.vistas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mutualchia.Conexion;
import mutualchia.entidades.Afiliado;
import mutualchia.entidades.Orden;
import mutualchia.modelo.AfiliadoData;
import mutualchia.modelo.OrdenData;
import mutualchia.modelo.PrestadorData;

/**
 *
 * @author Cacho
 */
public class ListadoOrdenA extends javax.swing.JInternalFrame {
 private DefaultTableModel modelo;
    private Orden ord;
    private OrdenData od;
    private AfiliadoData ad;
    private PrestadorData pd;
    /**
     * Creates new form ListadoOrdenA
     */
    public ListadoOrdenA() {
         try {
             initComponents();
        modelo= new DefaultTableModel ();
        armarCabecera();
        ad = new AfiliadoData (new Conexion());
        pd =new PrestadorData (new Conexion());
        
        od = new OrdenData (new Conexion());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrdenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDni = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tbOrdenes);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("LISTADO DE ORDENES POR AFILIADOS");

        jLabel2.setText("DNI AFILIADO");

        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose ();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        try {
        long dniBuscar =Long.parseLong(tfDni.getText());
        Afiliado afi = ad.buscarAfiliadoXDni(dniBuscar);
        if (afi!=null) {
            cargarDatosOrden(afi.getIdAfiliado());
        
        } else {
        JOptionPane.showMessageDialog(this, "Afiliado no encontrado");
        tfDni.requestFocus();
        }
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(this, "Usted debe introducir un numero");
        tfDni.requestFocus();
        
        }
    
    }//GEN-LAST:event_btBuscarActionPerformed
private void armarCabecera () {
            ArrayList<Object> titulos=new ArrayList<Object>();
            titulos.add("ID");
            titulos.add("FechaTurno");
            titulos.add("Prestador");
            
          
            for(Object it:titulos) {
                modelo.addColumn(it);
            }
            tbOrdenes.setModel(modelo);
}
private void cargarDatosOrden (int idAfiliado) {
         try {
             borrarFilasOrdenes ();
             
             OrdenData od = new OrdenData(new Conexion());
             List <Orden> listaOrdenes=od.buscarOrdenXAfiliado(idAfiliado);
             for(Orden o:listaOrdenes) {
                  
                 
                 
                 
                 modelo.addRow(new Object[]{o.getIdOrden(),o.getFechaTurno(),o.getHorario().getPrestador()});
                 
                 
             }
         } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Error al recuperar ordenes");
         }
}
 private void borrarFilasOrdenes (){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){

                modelo.removeRow(i );
                

        }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbOrdenes;
    private javax.swing.JTextField tfDni;
    // End of variables declaration//GEN-END:variables
}
