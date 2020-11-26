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
import mutualchia.entidades.Prestador;

/**
 *
 * @author Cacho
 */
public class HorarioData {
    private Connection con;
    private Conexion conexion;
    
    public HorarioData (Conexion conexion) {
        try {
            con = conexion.getConexion();
            this.conexion=conexion;
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR AL OBTENER LA CONEXION");
        }
    }
    
    public void agregarHorario (Horario horario) {
       
        try {
            String sql = "INSERT INTO horario (dia, horarioAtencion, idPrestador, activo) VALUES ( ?, ?, ?, ?);";
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
        List<Horario> horarios = new ArrayList<Horario>();
            
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
                //Buscar Horario
                int IdPrestador = resultSet.getInt("idPrestador");
                PrestadorData pd = new PrestadorData (conexion);
                Prestador pre = pd.buscarPrestador(IdPrestador);
                hor.setPrestador(pre);
                
                //Agrego la nueva especialidad al arraylist
                horarios.add(hor);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener horarios: " + ex.getMessage());
        }
        
        
        return horarios;
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
                int IdPrestador = resultSet.getInt("idPrestador");
                PrestadorData pd = new PrestadorData (conexion);
                Prestador pre = pd.buscarPrestador(IdPrestador);
                horario.setPrestador(pre);
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
      public void actualizarHorario(Horario horario){
    
        try {
            
            String sql = "UPDATE horario SET dia = ?, horarioAtencion = ? , "
                    + "activo = ?, idPrestador = ?  WHERE idHorario = ?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, horario.getDia());
            ps.setInt(2, horario.getHorarioAtencion());
            ps.setBoolean(3, horario.isActivo());
            ps.setInt(4, horario.getPrestador().getIdPrestador());
            ps.setInt(5, horario.getIdHorario());
            ps.executeUpdate();
            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un horario: " + ex.getMessage());
        }
     }
      
      public List<Horario> obtenerHorariosxPrestador( int idPrestador){
        List<Horario> horarios = new ArrayList<Horario>();
            
        try {
            String sql = "SELECT * FROM horario where idPrestador = ?;";
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
                //Buscar Horario
                int IdPrestador = resultSet.getInt("idPrestador");
                PrestadorData pd = new PrestadorData (conexion);
                Prestador pre = pd.buscarPrestador(IdPrestador);
                hor.setPrestador(pre);
                
                //Agrego la nueva especialidad al arraylist
                horarios.add(hor);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener horarios: " + ex.getMessage());
        }
        
        
        return horarios;
    }
    
}
