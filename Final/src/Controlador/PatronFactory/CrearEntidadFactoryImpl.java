package Controlador.PatronFactory;

import Modelo.ISP.DAO.CRUD;
import Modelo.Registro.DAO.ClasificacionResiduosDAO;
import Modelo.Registro.DAO.DireccionDAO;
import Modelo.Registro.DAO.IngresoResiduoDAO;
import Modelo.Registro.DAO.ResiduosDAO;
import Modelo.Registro.DAO.UsuarioDAO;
import Modelo.Registro.Prototype.PrototypeClasificacionResiduo;
import Modelo.Registro.Prototype.PrototypeDireccion;
import Modelo.Registro.Prototype.PrototypeIngresoResiduo;
import Modelo.Registro.Prototype.PrototypeResiduo;
import Modelo.Registro.Prototype.PrototypeUsuario;
import Modelo.Servicios.DAO.AlertaDAO;
import Modelo.Servicios.DAO.CentroReciclajeDAO;
import Modelo.Servicios.Prototype.PrototypeAlerta;
import Modelo.Servicios.Prototype.PrototypeCentroReciclaje;
import Modelo.Sugerencias.DAO.NotificacionesDAO;
import Modelo.Sugerencias.Prototype.PrototypeNotificacion;

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