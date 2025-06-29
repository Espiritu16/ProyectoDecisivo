package Modelo.Servicios.Prototype;

import java.util.Date;

public class PrototypeCentroReciclaje implements Cloneable {
    private int idCentro;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String distrito;
    private String codigoPostal;
    private String pais;
    private String telefono;
    private String horarioAtencion;
    private Date fechaCreacion;

    // Constructor por defecto
    public PrototypeCentroReciclaje() {
    }

    // Constructor con parámetros
    public PrototypeCentroReciclaje(String nombre, String direccion, String ciudad, String distrito, 
                                     String codigoPostal, String pais, String telefono, String horarioAtencion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.distrito = distrito;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.fechaCreacion = new Date(System.currentTimeMillis());
    }

    // Getters y Setters
    public int getIdCentro() { return idCentro; }
    public void setIdCentro(int idCentro) { this.idCentro = idCentro; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getHorarioAtencion() { return horarioAtencion; }
    public void setHorarioAtencion(String horarioAtencion) { this.horarioAtencion = horarioAtencion; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    // Sobrescribimos el método clone() para permitir la clonación del objeto
    @Override
    public PrototypeCentroReciclaje clone() {
        try {
            // Usamos el método clone() de la clase Object para hacer una copia del objeto
            return (PrototypeCentroReciclaje) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;  // Si no se puede clonar, devolvemos null
        }
    }
}