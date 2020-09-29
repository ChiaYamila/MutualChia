/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mutualchia.Conexion;
import mutualchia.entidades.Especialidad;
import mutualchia.entidades.Prestador;

/**
 *
 * @author Cacho
 */
public class PrestadorData {
    private Connection con;
    private Conexion conexion;
    
    public PrestadorData (Conexion conexion) {
        try {
            con = conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR AL OBTENER LA CONEXION");
        }
    }
    
    public void agregarPrestador (Prestador prestador) {
       
        try {
            String sql = "INSERT INTO prestador (nombre,apellido,dni,activo,idEspecialidad) VALUES ( ?, ?, ?, ?, ? );";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, prestador.getNombre());
            ps.setString(2, prestador.getApellido());
            ps.setLong(3, prestador.getDni());
            ps.setBoolean(4, prestador.isActivo());
            ps.setInt(5, prestador.getEspecialidad().getIdEspecialidad()); 
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                prestador.setIdPrestador(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un prestador");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un prestador: " + ex.getMessage());
        }
    }
      public List<Prestador> obtenerPrestadores(){
        List<Prestador> prestadores = new ArrayList<Prestador>();
            
        try {
            String sql = "SELECT * FROM prestador;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Prestador pre;
            while(resultSet.next()){
                //Creo una especialidad vacia
                pre = new Prestador();
                //seteo los datos
                pre.setIdPrestador(resultSet.getInt("idPrestador"));
                pre.setNombre(resultSet.getString("nombre"));
                pre.setApellido(resultSet.getString("apellido"));
                pre.setDni(resultSet.getLong("dni"));
                pre.setActivo(resultSet.getBoolean("activo"));
                int idEspecialidad=resultSet.getInt("idEspecialidad");
                EspecialidadData ed = new EspecialidadData (conexion);
                Especialidad esp = ed.buscarEspecialidad(idEspecialidad);
                pre.setEspecialidad(esp);
                
                //Agrego la nueva especialidad al arraylist
                prestadores.add(pre);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener prestadores: " + ex.getMessage());
        }
        
        
        return prestadores;
    }
      public Prestador buscarPrestador(int id){
    Prestador prestador=null;
    
    try {           
            String sql = "SELECT * FROM prestador WHERE idPrestador =?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                prestador = new Prestador();
                
                prestador.setIdPrestador(resultSet.getInt("idPrestador"));
                prestador.setNombre(resultSet.getString("nombre"));
                prestador.setApellido(resultSet.getString("apellido"));
                prestador.setDni(resultSet.getLong("dni"));
                prestador.setActivo(resultSet.getBoolean("activo"));
                //Buscar Especialidad
                int idEspecialidad=resultSet.getInt("idEspecialidad");
                EspecialidadData ed = new EspecialidadData (conexion);
                Especialidad esp = ed.buscarEspecialidad(idEspecialidad);
                prestador.setEspecialidad(esp);
                
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un prestador: " + ex.getMessage());
        }
        
        return prestador;
    }
     public void borrarPrestador(int id){
    try {
            
            String sql = "UPDATE prestador SET activo = 0 WHERE idPrestador =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un Prestador: " + ex.getMessage());
        }
        
    
    }
}

    
