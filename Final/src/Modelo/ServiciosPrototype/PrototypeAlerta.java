package Modelo.ServiciosPrototype;


import java.util.Date;

public class PrototypeAlerta implements Cloneable {
    private int idAlerta;
    private String mensaje;
    private Date fechaAlerta;
    private String estadoAlerta;

    // Constructor por defecto
    public PrototypeAlerta() {
    }

    // Constructor
    public PrototypeAlerta(String mensaje) {
        this.mensaje = mensaje;
        this.fechaAlerta = new Date(System.currentTimeMillis());  // Fecha actual
        this.estadoAlerta = "No leída";  // El estado por defecto
    }

    // Getters y Setters
    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(Date fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    public String getEstadoAlerta() {
        return estadoAlerta;
    }

    public void setEstadoAlerta(String estadoAlerta) {
        this.estadoAlerta = estadoAlerta;
    }

    // Sobrescribimos el método clone() para permitir la clonación del objeto
    @Override
    public PrototypeAlerta clone() {
        try {
            return (PrototypeAlerta) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;  // Si no se puede clonar, devolvemos null
        }
    }
}