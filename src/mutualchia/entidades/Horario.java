/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.entidades;

/**
 *
 * @author Cacho
 */
public class Horario {
    private int idHorario;
    private String dia;
    private int horarioAtencion;
    private Prestador prestador;
    private boolean activo;

    public Horario() {
    }

    public Horario(String dia, int horarioAtencion, Prestador prestador, boolean activo) {
        this.dia = dia;
        this.horarioAtencion = horarioAtencion;
        this.prestador = prestador;
        this.activo = activo;
    }

    public Horario(int idHorario, String dia, int horarioAtencion, Prestador prestador, boolean activo) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.horarioAtencion = horarioAtencion;
        this.prestador = prestador;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(int horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", dia=" + dia + ", horarioAtencion=" + horarioAtencion + ", prestador=" + prestador + ", activo=" + activo + '}';
    }
   
}
