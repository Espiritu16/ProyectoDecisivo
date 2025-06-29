package Modelo.Registro.Prototype;

import java.sql.Date;

public class PrototypeResiduo implements Cloneable {

    private int idResiduos;
    private String nombre;
    private int idClasificacion;
    private String descripcion;
    private double peso; 
    private String peligrosidad;
    private Date fecha_registro;

    public PrototypeResiduo() {}

    public PrototypeResiduo(int idResiduos, String nombre, int idClasificacion, String descripcion,
                            double peso, String peligrosidad, Date fecha_registro) {
        this.idResiduos = idResiduos;
        this.nombre = nombre;
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.peso = peso;
        this.peligrosidad = peligrosidad;
        this.fecha_registro = fecha_registro;
    }

    // Getters y setters
    public int getIdResiduos() {
        return idResiduos;
    }

    public void setIdResiduos(int idResiduos) {
        this.idResiduos = idResiduos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public PrototypeResiduo clone() throws CloneNotSupportedException {
        return (PrototypeResiduo) super.clone();
    }

    @Override
    public String toString() {
        return "PrototypeResiduo [idResiduos=" + idResiduos + ", nombre=" + nombre + ", idClasificacion=" + idClasificacion +
               ", descripcion=" + descripcion + ", peso=" + peso + ", peligrosidad=" + peligrosidad +
               ", fecha_registro=" + fecha_registro + "]";
    }
}