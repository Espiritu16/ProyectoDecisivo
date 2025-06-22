package Controlador.PatronFactory;

import Controlador.CRUD;
import Modelo.RegistroDAO.ClasificacionResiduosDAO;
import Modelo.RegistroDAO.DireccionDAO;
import Modelo.RegistroDAO.IngresoResiduoDAO;
import Modelo.RegistroDAO.ResiduosDAO;
import Modelo.RegistroDAO.UsuarioDAO;
import Modelo.RegistroPrototype.PrototypeClasificacionResiduo;
import Modelo.RegistroPrototype.PrototypeDireccion;
import Modelo.RegistroPrototype.PrototypeIngresoResiduo;
import Modelo.RegistroPrototype.PrototypeResiduo;
import Modelo.RegistroPrototype.PrototypeUsuario;
import Modelo.ServiciosDAO.AlertaDAO;
import Modelo.ServiciosDAO.CentroReciclajeDAO;
import Modelo.ServiciosPrototype.PrototypeAlerta;
import Modelo.ServiciosPrototype.PrototypeCentroReciclaje;
import Modelo.SugerenciasDAO.NotificacionesDAO;
import Modelo.SugerenciasPrototype.PrototypeNotificacion;


public class CrearEntidadFactoryImpl implements CrearDAOFactory {

    @Override
    public int crearUsuario(PrototypeUsuario usuario) {
        return new UsuarioDAO().crear(usuario);
    }

    @Override
    public int crearResiduo(PrototypeResiduo residuo) {
        return new ResiduosDAO().crear(residuo);
    }

    @Override
    public int crearDireccion(PrototypeDireccion direccion) {
        return new DireccionDAO().crear(direccion);
    }

    @Override
    public int crearClasificacionResiduo(PrototypeClasificacionResiduo clasificacion) {
         return new ClasificacionResiduosDAO().crear(clasificacion);
    }
    @Override
    public int crearPrototypeIngresoResiduo(PrototypeIngresoResiduo ingreso) {
        return new IngresoResiduoDAO().crear(ingreso);
    }

    @Override
    public int crearPrototypeNotificacion(PrototypeNotificacion notificacion) {
        return new NotificacionesDAO().crear(notificacion);
    }
    
    @Override
    public int crearCentroReciclaje(PrototypeCentroReciclaje centroReciclaje) {
        return new CentroReciclajeDAO().crear(centroReciclaje);  // Nuevo DAO para CentroReciclaje
    }
    
    @Override
    public int crearAlerta(PrototypeAlerta alerta) {
        return new AlertaDAO().crear(alerta);  // Crear alerta utilizando el DAO
    }
}