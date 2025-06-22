package Modelo.SugerenciasPrototype;

import java.util.Date;

public class PrototypeNotificacion implements Cloneable {
    private int idNotificacion;
    private String dni;
    private String mensaje;
    private String canal;
    private Date fechaEnvio;
    private String estado;

    public PrototypeNotificacion() {
    }
    // Constructor
    public PrototypeNotificacion(String idUsuario, String mensaje, String canal) {
        this.dni = idUsuario;
        this.mensaje = mensaje;
        this.canal = canal;
        this.fechaEnvio = new Date(System.currentTimeMillis());
        this.estado = "Pendiente"; // Estado inicial
    }

    // Getters y Setters
    public int getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(int idNotificacion) { this.idNotificacion = idNotificacion; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }
    public Date getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(Date fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Sobrescribimos el método clone()
    @Override
    public PrototypeNotificacion clone() {
        try {
            // Usamos el método clone() de la clase Object para hacer una copia
            return (PrototypeNotificacion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;  // Si no se puede clonar, devolvemos null
        }
    }
}