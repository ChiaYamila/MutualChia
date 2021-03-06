/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mutualchia.Conexion;
import mutualchia.entidades.Especialidad;
import mutualchia.entidades.Prestador;
import mutualchia.modelo.EspecialidadData;
import mutualchia.modelo.PrestadorData;

/**
 *
 * @author Cacho
 */
public class ListadoEspecialidad extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private EspecialidadData ed;
    private List<Especialidad> listaEspecialidades;
    private Especialidad esp;
    private PrestadorData pd;
    private List<Prestador> listaPrestadores;
    private Prestador pre;

    /**
     * Creates new form ListadoEspecialidad
     */
    public ListadoEspecialidad() {
       try {
            initComponents();
            modelo= new DefaultTableModel ();
            armarCabecera();
            pd = new PrestadorData (new Conexion());
            ed = new EspecialidadData (new Conexion());
            traerEspecialidades();
            cbEspecialidad.setSelectedIndex(1);
            cargarDatos();
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
        cbEspecialidad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPrestadores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("LISTADO DE PRESTADORES POR ESPECIALIDAD");

        jLabel2.setText("Especialidad");

        cbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadActionPerformed(evt);
            }
        });

        tbPrestadores.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPrestadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPrestadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPrestadores);

        jLabel3.setText("Prestadores");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose ();
    }//GEN-LAST:event_btSalirActionPerformed

    private void cbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadActionPerformed
        // TODO add your handling code here:
        cargarDatos ();
    }//GEN-LAST:event_cbEspecialidadActionPerformed

    private void tbPrestadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPrestadoresMouseClicked
        // TODO add your handling code here:
        int fila = tbPrestadores.getSelectedRow();
        
       cbEspecialidad.setSelectedItem((Especialidad)tbPrestadores.getValueAt(fila, 0));
       
        
        
        pre = new Prestador ();
        pre.setIdPrestador((int)tbPrestadores.getValueAt(fila, 0));
        pre.setNombre((String)tbPrestadores.getValueAt(fila, 1));
        pre.setApellido((String)tbPrestadores.getValueAt(fila, 2));
        
        
        
    }//GEN-LAST:event_tbPrestadoresMouseClicked
 public void traerEspecialidades () {
    List <Especialidad> lista = ed.obtenerEspecialidades();
    for (Especialidad e:lista) {
    cbEspecialidad.addItem(e);
    }
 }
 
 private void cargarDatos () {
            borrarFilas ();
            Especialidad e = (Especialidad)cbEspecialidad.getSelectedItem();
           listaPrestadores = pd.obtenerPrestadores();
           for(Prestador p:listaPrestadores) {
               if(p.getEspecialidad().getIdEspecialidad() == e.getIdEspecialidad()) {
            modelo.addRow(new Object[]{p.getIdPrestador(),p.getNombre(),p.getApellido(),p.isActivo()});
               }
                }
                       }
    
private void armarCabecera () {
            ArrayList<Object> titulos=new ArrayList<Object>();
            titulos.add("ID");
            titulos.add("Nombre");
            titulos.add("Apellido");
            
            
            titulos.add("Activo");
            for(Object it:titulos) {
                modelo.addColumn(it);
            }
            tbPrestadores.setModel(modelo);
            
        }
  private void borrarFilas (){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){

                modelo.removeRow(i );
                

        }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<Especialidad> cbEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPrestadores;
    // End of variables declaration//GEN-END:variables
}
