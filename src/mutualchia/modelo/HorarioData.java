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
import mutualchia.entidades.Horario;

/**
 *
 * @author Cacho
 */
public class HorarioData {
    private Connection con;
    
    public HorarioData (Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR AL OBTENER LA CONEXION");
        }
    }
    
    public void agregarHorario (Horario horario) {
       
        try {
            String sql = "INSERT INTO horario (dia,horarioAtencion,idPrestador) VALUES ( ?, ?, ?,?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, horario.getDia());
            ps.setInt(2, horario.getHorarioAtencion());
            ps.setInt(3, horario.getPrestador().getIdPrestador());
            ps.setBoolean(4,horario.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                horario.setIdHorario(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un horario");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un horario: " + ex.getMessage());
        }
    }
   public List<Horario> obtenerHorarios(){
        List<Horario> Horarios = new ArrayList<Horario>();
            
        try {
            String sql = "SELECT * FROM horario;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Horario hor;
            while(resultSet.next()){
                //Creo una especialidad vacia
                hor = new Horario();
                //seteo los datos
                hor.setIdHorario(resultSet.getInt("idHorario"));
                hor.setDia(resultSet.getString("dia"));
                hor.setHorarioAtencion(resultSet.getInt("horarioAtencion"));
                hor.setActivo(resultSet.getBoolean("activo"));
                //hor.setIdPrestador(resultSet.getInt("idPrestador"));
                
                //Agrego la nueva especialidad al arraylist
                //horarios.add(hor);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener horarios: " + ex.getMessage());
        }
        
        
        return Horarios;
    }
  public Horario buscarHorario(int id){
    Horario horario=null;
    
    try {           
            String sql = "SELECT * FROM horario WHERE idHorario =?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                horario = new Horario();
                
                horario.setIdHorario(resultSet.getInt("idHorario"));
                horario.setDia(resultSet.getString("dia"));
                horario.setHorarioAtencion(resultSet.getInt("horarioAtencion"));
                //horario.setIdPrestador(resultSet.getInt("idPrestador"));
                horario.setActivo(resultSet.getBoolean("activo"));
                
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un horario: " + ex.getMessage());
        }
        
        return horario;
    }
     public void borrarHorario(int id){
    try {
            
            String sql = "UPDATE horario SET activo = 0 WHERE idHorario =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un Horario: " + ex.getMessage());
        }
        
    
    }
    
}
