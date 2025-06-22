package Controlador.PatronFactory;
import Modelo.RegistroPrototype.PrototypeClasificacionResiduo;
import Modelo.RegistroPrototype.PrototypeDireccion;
import Modelo.RegistroPrototype.PrototypeIngresoResiduo;
import Modelo.RegistroPrototype.PrototypeResiduo;
import Modelo.RegistroPrototype.PrototypeUsuario;
import Modelo.ServiciosPrototype.PrototypeAlerta;
import Modelo.ServiciosPrototype.PrototypeCentroReciclaje;
import Modelo.SugerenciasPrototype.PrototypeNotificacion;

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
