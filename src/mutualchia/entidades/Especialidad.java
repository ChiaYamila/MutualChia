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
public class Especialidad {
    private int idEspecialidad;
    private String especialidad;
    private boolean activo;

    public Especialidad() {
    }

    public Especialidad(String especialidad, boolean activo) {
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public Especialidad(int idEspecialidad, String especialidad, boolean activo) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
   

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}
