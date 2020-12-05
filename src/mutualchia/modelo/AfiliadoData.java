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
import mutualchia.entidades.Afiliado;

/**
 *
 * @author Cacho
 */
public class AfiliadoData {
    private Connection con;
    
    public AfiliadoData (Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR AL OBTENER LA CONEXION");
        }
    }
    public void agregarAfiliado (Afiliado afiliado) {
       
        try {
            String sql = "INSERT INTO afiliado (nombre,apellido,dni,activo) VALUES ( ?, ?, ?, ?);";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, afiliado.getNombre());
            ps.setString(2, afiliado.getApellido());
            ps.setLong(3, afiliado.getDni());
            ps.setBoolean(4, afiliado.isActivo()); //Boolean borrar get y colocar el punto asi se coloca automaticamente
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                afiliado.setIdAfiliado(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un afiliado");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un afiliado: " + ex.getMessage());
        }
    }
    public List<Afiliado> obtenerAfiliados(){
        List<Afiliado> afiliados = new ArrayList<Afiliado>();
            
        try {
            String sql = "SELECT * FROM afiliado;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Afiliado afi;
            while(resultSet.next()){
                //Creo una especialidad vacia
                afi = new Afiliado();
                //seteo los datos
                afi.setIdAfiliado(resultSet.getInt("idAfiliado"));
                afi.setNombre(resultSet.getString("nombre"));
                afi.setApellido(resultSet.getString("apellido"));
                afi.setDni(resultSet.getLong("dni"));
                afi.setActivo(resultSet.getBoolean("activo"));
                //Agrego la nueva especialidad al arraylist
                afiliados.add(afi);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener afiliados: " + ex.getMessage());
        }
        
        
        return afiliados;
    }
     public Afiliado buscarAfiliado(int id){
    Afiliado afiliado=null;
    
    try {           
            String sql = "SELECT * FROM afiliado WHERE idAfiliado =?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                afiliado = new Afiliado();
                
                afiliado.setIdAfiliado(resultSet.getInt("idAfiliado"));
                afiliado.setNombre(resultSet.getString("nombre"));
                afiliado.setApellido(resultSet.getString("apellido"));
                afiliado.setDni(resultSet.getLong("dni"));
                afiliado.setActivo(resultSet.getBoolean("activo"));
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un afiliado: " + ex.getMessage());
        }
        
        return afiliado;
    }
     public void borrarAfiliado(int id){
    try {
            
            String sql = "UPDATE afiliado SET activo = 0 WHERE idAfiliado =?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un Afiliado: " + ex.getMessage());
        }
        
    
    }
    public void actualizarAfiliado(Afiliado afiliado){
    
        try {
            
            String sql = "UPDATE afiliado SET nombre = ?, apellido = ? , "
                    + "dni = ?, activo = ?  WHERE idAfiliado = ?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, afiliado.getNombre());
            ps.setString(2, afiliado.getApellido());
            ps.setLong(3, afiliado.getDni());
            ps.setBoolean(4, afiliado.isActivo());
            ps.setInt(5, afiliado.getIdAfiliado());
            ps.executeUpdate();
            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un afiliado: " + ex.getMessage());
        }
     }
     public Afiliado buscarAfiliadoXDni(long dni){
    Afiliado afiliado=null;
    
    try {           
            String sql = "SELECT * FROM afiliado WHERE dni =? and activo = true;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, dni);            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                afiliado = new Afiliado();
                
                afiliado.setIdAfiliado(resultSet.getInt("idAfiliado"));
                afiliado.setNombre(resultSet.getString("nombre"));
                afiliado.setApellido(resultSet.getString("apellido"));
                afiliado.setDni(resultSet.getLong("dni"));
                afiliado.setActivo(resultSet.getBoolean("activo"));
            }      
            ps.close();                      
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un afiliado: " + ex.getMessage());
        }
        
        return afiliado;
     }
        }
    
