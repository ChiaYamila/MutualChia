/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualchia.entidades;
import java.time.LocalDate;

/**
 *
 * @author Cacho
 */
public class Orden {
    private int idOrden;
    private LocalDate fecha;
    private String formaPago;
    private float importe;
    private Afiliado afiliado;
    private Horario horario;
    private boolean activo;

    public Orden() {
    }

    public Orden(LocalDate fecha, String formaPago, float importe, Afiliado afiliado, Horario horario, boolean activo) {
        this.fecha = fecha;
        this.formaPago = formaPago;
        this.importe = importe;
        this.afiliado = afiliado;
        this.horario = horario;
        this.activo = activo;
    }

    public Orden(int idOrden, LocalDate fecha, String formaPago, float importe, Afiliado afiliado, Horario horario, boolean activo) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.formaPago = formaPago;
        this.importe = importe;
        this.afiliado = afiliado;
        this.horario = horario;
        this.activo = activo;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

     
}
