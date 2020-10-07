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

/**
 *
 * @author Cacho
 */
public class EspecialidadData {
    private Connection con;
    
    public EspecialidadData (Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR AL OBTENER LA CONEXION");
        }
    }
    
    public void agregarEspecialidad (Especialidad especialidad) {
       
        try {
            
            String sql = "INSERT INTO especialidad (especialidad) VALUES ( ?, ? );";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, especialidad.getEspecialidad());
             ps.setBoolean(2, especialidad.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                especialidad.setIdEspecialidad(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un especialidad");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una especialiad: " + ex.getMessage());
        }
    }

    public List<Especialidad> obtenerEspecialidades(){
        List<Especialidad> especialidades = new ArrayList<Especialidad>();
            
        try {
            String sql = "SELECT * FROM especialidad;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Especialidad esp;
            while(resultSet.next()){
                //Creo una especialidad vacia
                esp = new Especialidad();
                //seteo los datos
                esp.setIdEspecialidad(resultSet.getInt("idEspecialidad"));
                esp.setEspecialidad(resultSet.getString("especialidad"));
                esp.setActivo(resultSet.getBoolean("activo"));
                //Agrego la nueva especialidad al arraylist
                especialidades.add(esp);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener especialidades: " + ex.getMessage());
        }
        
        
        return especialidades;
    }
    public Especialidad buscarEspecialidad(int id){
    Especialidad especialidad=null;
    
    try {           
            String sql = "SELECT * FROM especialidad WHERE idEspecialidad =?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                especialidad = new Especialidad();
                
                especialidad.setIdEspecialidad(resultSet.getInt("idEspecialidad"));
                especialidad.setEspecialidad(resultSet.getString("especialidad"));
                especialidad.setActivo(resultSet.getBoolean("activo"));
                
                
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar una especialidad: " + ex.getMessage());
        }
        
        return especialidad;
    }
    public void borrarEspecialidad(int id){
    try {
            
            String sql = "UPDATE especialidad SET activo = 0 WHERE idEspecialidad =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una Especialidad: " + ex.getMessage());
        }



    }
    public void actualizarEspecialidad(Especialidad especialidad){
    
        try {
            
            String sql = "UPDATE especialidad SET especialidad = ?, "
                    + "activo = ?  WHERE idEspecialidad = ?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, especialidad.getEspecialidad());
            ps.setBoolean(2, especialidad.isActivo());
            ps.setInt(3, especialidad.getIdEspecialidad());
            ps.executeUpdate();
            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una especialidad: " + ex.getMessage());
        }
     }
}
