package Controlador.PatronFactory;
import Modelo.Registro.Prototype.PrototypeClasificacionResiduo;
import Modelo.Registro.Prototype.PrototypeDireccion;
import Modelo.Registro.Prototype.PrototypeIngresoResiduo;
import Modelo.Registro.Prototype.PrototypeResiduo;
import Modelo.Registro.Prototype.PrototypeUsuario;
import Modelo.Servicios.Prototype.PrototypeAlerta;
import Modelo.Servicios.Prototype.PrototypeCentroReciclaje;
import Modelo.Sugerencias.Prototype.PrototypeNotificacion;

public interface CrearDAOFactory {
    int crearUsuario(PrototypeUsuario usuario);
    int crearResiduo(PrototypeResiduo residuo);
    int crearDireccion(PrototypeDireccion direccion);
    int crearClasificacionResiduo(PrototypeClasificacionResiduo clasificacion); 
    int crearPrototypeIngresoResiduo(PrototypeIngresoResiduo ingreso);
    int crearPrototypeNotificacion(PrototypeNotificacion notificacion);
    int crearCentroReciclaje(PrototypeCentroReciclaje centroReciclaje);  // Nuevo método
    int crearAlerta(PrototypeAlerta alerta);  // Nuevo método para crear alertas
}
