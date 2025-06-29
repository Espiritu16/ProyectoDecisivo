package Modelo.ISP.Facade;

import Modelo.Registro.Prototype.PrototypeClasificacionResiduo;
import Modelo.Registro.Prototype.PrototypeDireccion;
import Modelo.Registro.Prototype.PrototypeResiduo;
import Modelo.Registro.Prototype.PrototypeUsuario;

public interface SistemaGestionResiduosFacade {
    boolean registrarFlujoCompleto(
        PrototypeUsuario usuario,
        PrototypeDireccion direccion,
        PrototypeClasificacionResiduo clasificacion,
        PrototypeResiduo residuo
    );
}