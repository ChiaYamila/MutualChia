/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutualchia.entidades.Afiliado;
import mutualchia.entidades.Especialidad;
import mutualchia.entidades.Horario;
import mutualchia.entidades.Orden;
import mutualchia.entidades.Prestador;
import mutualchia.modelo.AfiliadoData;
import mutualchia.modelo.EspecialidadData;
import mutualchia.modelo.HorarioData;
import mutualchia.modelo.OrdenData;
import mutualchia.modelo.PrestadorData;

/**
 *
 * @author Cacho
 */
public class Mutualchia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion miconexion = new Conexion();
            //EspecialidadData ed = new EspecialidadData(miconexion);
            //Especialidad e = new Especialidad("cirujano");
            //ed.agregarEspecialidad(e);
            //AfiliadoData ad = new AfiliadoData(miconexion);
            //Afiliado a = new Afiliado("luis","mercado",111245333,true);
            //ad.agregarAfiliado(a);
            //PrestadorData pd = new PrestadorData(miconexion);
            //Especialidad cardio=new Especialidad (3,"Cardiologia"); //debo emular para que me pueda agregar la especialidad y su id
            //Prestador p = new Prestador("Pedro","Blanco",25741999,true,cardio);
            //pd.agregarPrestador(p);
            //HorarioData hd = new HorarioData(miconexion);
            //Especialidad cardio=new Especialidad (3,"Cardiologia");
            //Prestador p = new Prestador(3,"Pedro","Blanco",25741999,true,cardio);
            //Horario h = new Horario("viernes",10,p);
            //hd.agregarHorario(h);
            //OrdenData od = new OrdenData(miconexion);
            //Especialidad cardio=new Especialidad (3,"Cardiologia");
            //Prestador p = new Prestador(3,"Pedro","Blanco",25741999,true,cardio);
            //Horario h = new Horario(6,"viernes",10,p);
            //Afiliado a = new Afiliado(5,"luis","mercado",111245333,true);
            //Orden o = new Orden (LocalDate.now(), "efectivo", 450,a,h,true);
            //od.agregarOrden(o);
            //EspecialidadData ed = new EspecialidadData(miconexion);
            //ed.obtenerEspecialidades();
            //List<Especialidad> lista= ed.obtenerEspecialidades(); 
            //for(Especialidad it:lista){
            //System.out.println("id: "+it.getIdEspecialidad());
	    //System.out.println("especialidad: "+it.getEspecialidad()); }
            //AfiliadoData ad = new AfiliadoData(miconexion);
            //ad.obtenerAfiliados();
            //List<Afiliado> lista= ad.obtenerAfiliados(); 
            //for(Afiliado it:lista){
            //System.out.println("id: "+it.getIdAfiliado());
	    //System.out.println("nombre: "+it.getNombre()); 
            //System.out.println("apellido: "+it.getApellido());
            //System.out.println("dni: "+it.getDni());
            //System.out.println("activo: "+it.isActivo());}
            //PrestadorData pd = new PrestadorData(miconexion);
            //pd.obtenerPrestadores();
            //List<Prestador> lista= pd.obtenerPrestadores();
            //for(Prestador it:lista) {
            //System.out.println("id: "+it.getIdPrestador());
            //System.out.println("nombre: "+it.getNombre());
            //System.out.println("apellido: "+it.getApellido());
            //System.out.println("dni: "+it.getDni());
            //System.out.println("activo: "+it.isActivo());
            //System.out.println("id: "+it.getEspecialidad());}
            //OrdenData od = new OrdenData(miconexion);
            //od.obtenerOrdenes();
            //List<Orden> lista= od.obtenerOrdenes();
            //for(Orden it:lista) {
            //System.out.println("id: "+it.getIdOrden());
            //System.out.println("fecha"+it.getFecha());
            //System.out.println("formaPago"+it.getFormaPago());
            //System.out.println("importe"+it.getImporte());
            //System.out.println("id: "+it.getAfiliado());
            //System.out.println("id: "+it.getHorario());
            //System.out.println("activo: "+it.isActivo());}
            //HorarioData hd = new HorarioData(miconexion);
            //hd.obtenerHorarios();
            //List<Horario> lista= hd.obtenerHorarios();
            //for(Horario it:lista) {
            //System.out.println("id: "+it.getIdHorario());
            //System.out.println("dia"+it.getDia());
            //System.out.println("horarioAtencion"+it.getHorarioAtencion());
            //System.out.println("id: "+it.getPrestador());}
            //EspecialidadData ed = new EspecialidadData(miconexion);
            //Especialidad x = ed.buscarEspecialidad(5);
            //System.out.println ("id: "+ x.getIdEspecialidad());
            //System.out.println ("Nombre Especialidad "+ x.getEspecialidad());
            //AfiliadoData ad = new AfiliadoData(miconexion);
            //Afiliado x = ad.buscarAfiliado(5);
            //System.out.println ("id: "+ x.getIdAfiliado());
            //System.out.println ("Nombre Afiliado: "+ x.getNombre());
            //System.out.println ("Apellido Afiliado: "+ x.getApellido());
            //AfiliadoData ad = new AfiliadoData(miconexion);
            //ad.borrarAfiliado(5);
            //EspecialidadData ed = new EspecialidadData (miconexion);
            //ed.borrarEspecialidad(3);
            //PrestadorData pd = new PrestadorData(miconexion);
            //Prestador x = pd.buscarPrestador(6);
            //System.out.println ("id: "+ x.getIdPrestador());
            //System.out.println ("Nombre Prestador: "+ x.getNombre());
            //System.out.println ("Apellido Prestador: "+ x.getApellido());
            //PrestadorData pd = new PrestadorData(miconexion);
            //pd.borrarPrestador(6);
            //HorarioData hd = new HorarioData(miconexion);
            //Horario x = hd.buscarHorario(4);
            //System.out.println ("id: "+ x.getIdHorario());
            //System.out.println ("Dia Atencion: "+ x.getDia());
            //System.out.println ("Horario Atencion: "+ x.getHorarioAtencion());
            //HorarioData hd = new HorarioData(miconexion);
            //hd.borrarHorario(4);
            //OrdenData od = new OrdenData(miconexion);
            //Orden x = od.buscarOrden(29);
            //System.out.println ("id: "+ x.getIdOrden());
            //System.out.println("fecha "+ x.getFecha());
            //System.out.println("formaPago "+ x.getFormaPago());
            //System.out.println("importe "+ x.getImporte());
             //OrdenData od = new OrdenData(miconexion);
             //od.borrarOrden(29);
             OrdenData od = new OrdenData(miconexion);
            Orden x = od.buscarOrden(9);
            System.out.println("importe "+ x.getImporte());
            x.setImporte(200);
            od.actualizarOrden(x);
            
            
            
            
            
            

            // TODO code application logic here
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR AL CARGAR DRIVER");
        
        }
    }
    
}
