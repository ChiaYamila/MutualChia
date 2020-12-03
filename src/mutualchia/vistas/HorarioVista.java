/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mutualchia.Conexion;
import mutualchia.entidades.Especialidad;
import mutualchia.entidades.Horario;
import mutualchia.entidades.Prestador;
import mutualchia.modelo.EspecialidadData;
import mutualchia.modelo.PrestadorData;
import mutualchia.modelo.HorarioData;

/**
 *
 * @author Cacho
 */
public class HorarioVista extends javax.swing.JInternalFrame {
     private DefaultTableModel modelo;
     private DefaultTableModel modeloHorarios;
    private PrestadorData pd;
    private List<Prestador> listaPrestadores;
    private Prestador pre;
    private Especialidad esp;
    private EspecialidadData ed;
    private Horario hor;
    private HorarioData hd;
    private List<Horario> listaHorarios;

    /**
     * Creates new form HorarioVista
     */
    public HorarioVista() {
        try {
        initComponents();
        modelo= new DefaultTableModel ();
        modeloHorarios= new DefaultTableModel ();
            armarCabecera();
            armarCabeceraHorarios();
            pd = new PrestadorData (new Conexion());
            ed = new EspecialidadData (new Conexion());
            hd = new HorarioData (new Conexion());
            traerEspecialidades();
            traerPrestadores ();
           cbEspecialidad.setSelectedIndex(1);
            cargarDatos();
            //cargarDatosHorarios();
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPrestadores = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        cbHorario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        chbActivo = new javax.swing.JCheckBox();
        btGuardar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHorarios = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("CARGA DE HORARIOS");

        jLabel2.setText("Especialidad");

        cbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadActionPerformed(evt);
            }
        });

        jLabel3.setText("Prestadores");

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

        jLabel4.setText("Dia");

        jLabel5.setText("Horario de Atencion");

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" }));

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 9,10,11,12,14,15,16,17 }));

        jLabel6.setText("Activo");

        btGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBorrar.setText("Borrar");
        btBorrar.setEnabled(false);
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        btSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        tbHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHorariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHorarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btGuardar)
                        .addGap(44, 44, 44)
                        .addComponent(btBorrar)
                        .addGap(59, 59, 59)
                        .addComponent(btSalir)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(83, 83, 83)
                                        .addComponent(chbActivo)
                                        .addGap(7, 7, 7)))
                                .addGap(61, 61, 61))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60)
                        .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(chbActivo))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btGuardar)
                            .addComponent(btBorrar)
                            .addComponent(btSalir))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        // TODO add your handling code here:
        int fila = tbHorarios.getSelectedRow();
        int idHorario = (Integer) tbHorarios.getValueAt(fila, 0);
        hd.borrarHorario(idHorario);
        cargarDatosHorarios(hor.getPrestador().getIdPrestador());
    }//GEN-LAST:event_btBorrarActionPerformed

    private void cbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_cbEspecialidadActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        if (hor==null){
            hor = new Horario();
            hor.setDia((String)cbDia.getSelectedItem());
            hor.setHorarioAtencion((Integer)cbHorario.getSelectedItem());
            hor.setActivo(chbActivo.isSelected());
            
            int fila = tbPrestadores.getSelectedRow();
            int idPrestador=(Integer)tbPrestadores.getValueAt(fila, 0);
            Prestador p = new Prestador();
            p.setIdPrestador(idPrestador);
            hor.setPrestador(p);
           if (hd.existeHorario(idPrestador, (String)cbDia.getSelectedItem(), (Integer)cbHorario.getSelectedItem()) ==null) {
            hd.agregarHorario(hor);
             cargarDatosHorarios((Integer)tbPrestadores.getValueAt(fila, 0));
            } else {
        JOptionPane.showMessageDialog(this, "Horario ya asignado");
        }
        }
        else {
                
            hor.setDia((String)cbDia.getSelectedItem());
            hor.setHorarioAtencion((Integer)cbHorario.getSelectedItem());
            hor.setActivo(chbActivo.isSelected());
            
            int fila = tbPrestadores.getSelectedRow();
            int idPrestador=(Integer)tbPrestadores.getValueAt(fila, 0);
            Prestador p = new Prestador();
            p.setIdPrestador(idPrestador);
            hor.setPrestador(p);
                if (hd.existeHorario(idPrestador, (String)cbDia.getSelectedItem(), (Integer)cbHorario.getSelectedItem()) ==null){
            hd.actualizarHorario(hor);
             cargarDatosHorarios((Integer)tbPrestadores.getValueAt(fila, 0));
            } else {
        JOptionPane.showMessageDialog(this, "Horario ya asignado");
        } 
    }
                
                
         System.out.println(hor);
        hor=null;
       
    }//GEN-LAST:event_btGuardarActionPerformed

    private void tbPrestadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPrestadoresMouseClicked
        // TODO add your handling code here:
        int fila = tbPrestadores.getSelectedRow();
        if(fila!=-1);
       

        //pre = new Prestador ();
       //pre.setIdPrestador((int) tbPrestadores.getValueAt(fila, 0));
        //pre.setNombre((String)tbPrestadores.getValueAt(fila, 1)) ;
        //pre.setApellido((String) tbPrestadores.getValueAt(fila, 2));
        //pre.setEspecialidad((Especialidad) tbPrestadores.getValueAt(fila, 3));
        //pre.setActivo((boolean) tbPrestadores.getValueAt(fila, 4));
        
        cargarDatosHorarios((int) tbPrestadores.getValueAt(fila, 0));
        
    }//GEN-LAST:event_tbPrestadoresMouseClicked

    private void tbHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHorariosMouseClicked
        // TODO add your handling code here:
        hor = new Horario();
            hor.setDia((String)cbDia.getSelectedItem());
            hor.setHorarioAtencion((Integer)cbHorario.getSelectedItem());
            hor.setActivo(chbActivo.isSelected());
            
            int filap = tbPrestadores.getSelectedRow();
            int idPrestador=(Integer)tbPrestadores.getValueAt(filap, 0);
            Prestador p = new Prestador();
            p.setIdPrestador(idPrestador);
            hor.setPrestador(p);
            
        btBorrar.setEnabled(true);
        
        
        int fila=tbHorarios.getSelectedRow();
        String dia = (String) tbHorarios.getValueAt(fila, 1);
        Integer horario = (Integer) tbHorarios.getValueAt(fila, 2);
        Boolean activo = (Boolean) tbHorarios.getValueAt(fila, 3);
        Integer idHorario = (Integer) tbHorarios.getValueAt(fila, 0);
        hor.setIdHorario(idHorario);
        
        cbDia.setSelectedItem(dia);
        cbHorario.setSelectedItem(horario);
        chbActivo.setSelected(activo);

    }//GEN-LAST:event_tbHorariosMouseClicked

public void traerEspecialidades () {
    List <Especialidad> lista = ed.obtenerEspecialidades();
    for (Especialidad e:lista) {
    cbEspecialidad.addItem(e);
 
    }
    }
public void traerPrestadores () {
    List <Prestador> lista = pd.obtenerPrestadores();
    for (Prestador p:lista) {
        tbPrestadores.setModel(modelo);
    }
}

  
            
    private void armarCabecera () {
            ArrayList<Object> titulos=new ArrayList<Object>();
            titulos.add("ID");
            titulos.add("Nombre");
            titulos.add("Apellido");
          
            for(Object it:titulos) {
                modelo.addColumn(it);
            }
            tbPrestadores.setModel(modelo);
            
        }
    private void armarCabeceraHorarios () {
            ArrayList<Object> titulos=new ArrayList<Object>();
            titulos.add("ID");
            titulos.add("Dia");
            titulos.add("HorarioAtencion");
            titulos.add("Activo");
          
            for(Object it:titulos) {
                modeloHorarios.addColumn(it);
            }
            tbHorarios.setModel(modeloHorarios);
            
        }
        
        private void cargarDatos () {
            borrarFilas ();
            Especialidad e = (Especialidad)cbEspecialidad.getSelectedItem();
           listaPrestadores = pd.obtenerPrestadores();
           listaHorarios = hd.obtenerHorarios();
           for(Prestador p:listaPrestadores) {
               if(p.getEspecialidad().getIdEspecialidad() == e.getIdEspecialidad()) {
            modelo.addRow(new Object[]{p.getIdPrestador(),p.getNombre(),p.getApellido(),p.isActivo()});
               }
                }
        }
        
         private void cargarDatosHorarios (int idPrestador) {
         try {
             borrarFilasHorarios ();
             HorarioData hd = new HorarioData(new Conexion());
             List <Horario> listaHorarios=hd.obtenerHorariosxPrestador(idPrestador);
             for(Horario h:listaHorarios) {
                 
                 modeloHorarios.addRow(new Object[]{h.getIdHorario(),h.getDia(),h.getHorarioAtencion(),h.isActivo()});
             }
         } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Error al recuperar horarios");
         }
                }
        
         
        private void borrarFilas (){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){

                modelo.removeRow(i );
                

        }
        }
         private void borrarFilasHorarios (){
            int a =modeloHorarios.getRowCount()-1;
            for(int i=a;i>=0;i--){

                modeloHorarios.removeRow(i );
                

        }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<Especialidad> cbEspecialidad;
    private javax.swing.JComboBox<Integer> cbHorario;
    private javax.swing.JCheckBox chbActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbHorarios;
    private javax.swing.JTable tbPrestadores;
    // End of variables declaration//GEN-END:variables
}
