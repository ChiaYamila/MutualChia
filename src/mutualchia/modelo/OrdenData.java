/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mutualchia.Conexion;
import mutualchia.entidades.Afiliado;
import mutualchia.entidades.Horario;
import mutualchia.entidades.Orden;

/**
 *
 * @author Cacho
 */
public class OrdenData {
    private Connection con;
    private Conexion conexion;
    
    public OrdenData (Conexion conexion) {
        try {
            con = conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR AL OBTENER LA CONEXION");
        }
    }
    
    public void agregarOrden (Orden orden) {
       
        try {
            String sql = "INSERT INTO orden (fecha,fechaTurno,formaPago,importe,idAfiliado,idHorario,activo) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ps.setDate(1, Date.valueOf(orden.getFecha()));
             ps.setDate(2, Date.valueOf(orden.getFechaTurno()));
            ps.setString(3, orden.getFormaPago());
            ps.setFloat(4, orden.getImporte());
            ps.setInt(5, orden.getAfiliado().getIdAfiliado());
            ps.setInt(6, orden.getHorario().getIdHorario());
            ps.setBoolean(7, orden.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                orden.setIdOrden(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una orden");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una orden: " + ex.getMessage());
        }
    }
    public List<Orden> obtenerOrdenes(){
        List<Orden> ordenes = new ArrayList<Orden>();
            
        try {
            String sql = "SELECT * FROM orden;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Orden ord;
            while(resultSet.next()){
                //Creo una especialidad vacia
                ord = new Orden();
                //seteo los datos
                ord.setIdOrden(resultSet.getInt("idOrden"));
                ord.setFecha(resultSet.getDate("fecha").toLocalDate());
                ord.setFechaTurno(resultSet.getDate("fechaTurno").toLocalDate());
                ord.setFormaPago(resultSet.getString("formaPago"));
                ord.setImporte(resultSet.getFloat("importe"));
                //Buscar Afiliado
                int idAfiliado = resultSet.getInt("idAfiliado");
                AfiliadoData ad = new AfiliadoData (conexion);
                Afiliado afi=ad.buscarAfiliado(idAfiliado);
                ord.setAfiliado(afi);
                //Buscar Horario
                int idHorario =resultSet.getInt("idHorario");
                HorarioData hd = new HorarioData (conexion);
                Horario hor=hd.buscarHorario(idHorario);
                ord.setHorario(hor);
                ord.setActivo(resultSet.getBoolean("activo"));
                
                
                //Agrego la nueva especialidad al arraylist
                ordenes.add(ord);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener ordenes: " + ex.getMessage());
        }
        
        
        return ordenes;
    }
     public Orden buscarOrden(int id){
    Orden orden=null;
    
    try {           
            String sql = "SELECT * FROM orden WHERE idOrden =?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                orden = new Orden();
                
               orden.setIdOrden(resultSet.getInt("idOrden"));
                orden.setFecha(resultSet.getDate("fecha").toLocalDate());
                orden.setFechaTurno(resultSet.getDate("fechaTurno").toLocalDate());
                orden.setFormaPago(resultSet.getString("formaPago"));
                orden.setImporte(resultSet.getFloat("importe"));
               //Buscar Afiliado
                int idAfiliado = resultSet.getInt("idAfiliado");
                AfiliadoData ad = new AfiliadoData (conexion);
                Afiliado afi=ad.buscarAfiliado(idAfiliado);
                orden.setAfiliado(afi);
                //Buscar Horario
                int idHorario =resultSet.getInt("idHorario");
                HorarioData hd = new HorarioData (conexion);
                Horario hor=hd.buscarHorario(idHorario);
                orden.setHorario(hor);
                orden.setActivo(resultSet.getBoolean("activo"));
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar una Orden: " + ex.getMessage());
        }
        
        return orden;
    }
     public void borrarOrden(int id){
    try {
            
            String sql = "UPDATE orden SET activo = 0 WHERE idOrden =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una Orden: " + ex.getMessage());
        }
        
    
    }
     public void actualizarOrden(Orden orden){
    
        try {
            
            String sql = "UPDATE orden SET fecha = ?,fechaTurno = ?, formaPago = ? , "
                    + "importe = ?, idAfiliado = ?,idHorario = ?, activo = ?  WHERE idOrden = ?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(orden.getFecha()));
             ps.setDate(2, Date.valueOf(orden.getFechaTurno()));
            ps.setString(3, orden.getFormaPago());
            ps.setFloat(4, orden.getImporte());
            ps.setInt(5, orden.getAfiliado().getIdAfiliado());
            ps.setInt(6, orden.getHorario().getIdHorario());
            ps.setBoolean(7, orden.isActivo());
            ps.setInt(8, orden.getIdOrden());
            ps.executeUpdate();
            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una orden: " + ex.getMessage());
        }
    
    }
     public List<Orden> BuscarOrdenxFecha(LocalDate fecha){
        List<Orden> ordenes = new ArrayList<Orden>();
    
    try {           
            String sql = "SELECT * FROM orden WHERE fechaTurno =? and activo = true;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                Orden orden = new Orden();
                
               orden.setIdOrden(resultSet.getInt("idOrden"));
                orden.setFecha(resultSet.getDate("fecha").toLocalDate());
                orden.setFechaTurno(resultSet.getDate("fechaTurno").toLocalDate());
                orden.setFormaPago(resultSet.getString("formaPago"));
                orden.setImporte(resultSet.getFloat("importe"));
               //Buscar Afiliado
                int idAfiliado = resultSet.getInt("idAfiliado");
                AfiliadoData ad = new AfiliadoData (conexion);
                Afiliado afi=ad.buscarAfiliado(idAfiliado);
                orden.setAfiliado(afi);
                //Buscar Horario
                int idHorario =resultSet.getInt("idHorario");
                HorarioData hd = new HorarioData (conexion);
                Horario hor=hd.buscarHorario(idHorario);
                orden.setHorario(hor);
                orden.setActivo(resultSet.getBoolean("activo"));
                ordenes.add(orden);
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar una Orden: " + ex.getMessage());
        }
        
        return ordenes;
    }
     public List<Orden> buscarOrdenXAfiliado (int idAfi){
        List<Orden> ordenes = new ArrayList<Orden>();
    
    try {           
            String sql = "SELECT * FROM orden WHERE idAfiliado =?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, idAfi);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                Orden orden = new Orden();
                
               orden.setIdOrden(resultSet.getInt("idOrden"));
                orden.setFecha(resultSet.getDate("fecha").toLocalDate());
                orden.setFechaTurno(resultSet.getDate("fechaTurno").toLocalDate());
                orden.setFormaPago(resultSet.getString("formaPago"));
                orden.setImporte(resultSet.getFloat("importe"));
               //Buscar Afiliado
                int idAfiliado = resultSet.getInt("idAfiliado");
                AfiliadoData ad = new AfiliadoData (conexion);
                Afiliado afi=ad.buscarAfiliado(idAfiliado);
                orden.setAfiliado(afi);
                //Buscar Horario
                int idHorario =resultSet.getInt("idHorario");
                HorarioData hd = new HorarioData (conexion);
                Horario hor=hd.buscarHorario(idHorario);
                orden.setHorario(hor);
                orden.setActivo(resultSet.getBoolean("activo"));
                ordenes.add(orden);
                
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar una Orden: " + ex.getMessage());
        }
        
        return ordenes;
    }
     public List<Orden> BuscarOrdenxFechaEmision(LocalDate fecha){
        List<Orden> ordenes = new ArrayList<Orden>();
    
    try {           
            String sql = "SELECT * FROM orden WHERE fecha =? and activo = true;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                Orden orden = new Orden();
                
               orden.setIdOrden(resultSet.getInt("idOrden"));
                orden.setFecha(resultSet.getDate("fecha").toLocalDate());
                orden.setFechaTurno(resultSet.getDate("fechaTurno").toLocalDate());
                orden.setFormaPago(resultSet.getString("formaPago"));
                orden.setImporte(resultSet.getFloat("importe"));
               //Buscar Afiliado
                int idAfiliado = resultSet.getInt("idAfiliado");
                AfiliadoData ad = new AfiliadoData (conexion);
                Afiliado afi=ad.buscarAfiliado(idAfiliado);
                orden.setAfiliado(afi);
                //Buscar Horario
                int idHorario =resultSet.getInt("idHorario");
                HorarioData hd = new HorarioData (conexion);
                Horario hor=hd.buscarHorario(idHorario);
                orden.setHorario(hor);
                orden.setActivo(resultSet.getBoolean("activo"));
                ordenes.add(orden);
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar una Orden: " + ex.getMessage());
        }
        
        return ordenes;
    }

    
}
