package Modelo.RegistroPrototype;

import java.sql.Date;

public class PrototypeIngresoResiduo implements Cloneable {

    private int idIngreso;
    private int idUsuario;
    private int idResiduos;
    private double peso;
    private Date fecha_ingreso;
    private String descripcion;

    public PrototypeIngresoResiduo() {}

    public PrototypeIngresoResiduo(int idIngreso, int idUsuario, int idResiduos, double peso,
                                   Date fecha_ingreso, String descripcion) {
        this.idIngreso = idIngreso;
        this.idUsuario = idUsuario;
        this.idResiduos = idResiduos;
        this.peso = peso;
        this.fecha_ingreso = fecha_ingreso;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdResiduos() {
        return idResiduos;
    }

    public void setIdResiduos(int idResiduos) {
        this.idResiduos = idResiduos;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public PrototypeIngresoResiduo clone() throws CloneNotSupportedException {
        return (PrototypeIngresoResiduo) super.clone();
    }

    @Override
    public String toString() {
        return "PrototypeIngresoResiduo [idIngreso=" + idIngreso + ", idUsuario=" + idUsuario +
               ", idResiduos=" + idResiduos + ", peso=" + peso +
               ", fecha_ingreso=" + fecha_ingreso + ", descripcion=" + descripcion + "]";
    }
} 