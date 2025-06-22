package tester;
import Controlador.PatronFactory.CrearDAOFactory;
import Controlador.PatronFactory.CrearEntidadFactoryImpl;
import Modelo.RegistroPrototype.*;

public class Main2 {
    public static void main(String[] args) {
        CrearDAOFactory factory = new CrearEntidadFactoryImpl();

        // 1. Crear nueva clasificación de residuos
        PrototypeClasificacionResiduo clasificacion = new PrototypeClasificacionResiduo();
        clasificacion.setNombre("Plásticos");
        clasificacion.setDescripcion("Residuos plásticos comunes");
        clasificacion.setColor_codigo("Verde");

        int idClasificacion = factory.crearClasificacionResiduo(clasificacion);
        System.out.println("ID Clasificación: " + idClasificacion);

        // 2. Crear nuevo residuo asociado a esa clasificación
        PrototypeResiduo residuo = new PrototypeResiduo();
        residuo.setNombre("Botellas PET");
        residuo.setIdClasificacion(idClasificacion);
        residuo.setDescripcion("Botellas de plástico tipo PET");
        residuo.setPeso(1.25);
        residuo.setPeligrosidad("Baja");

        int idResiduo = factory.crearResiduo(residuo);
        System.out.println("ID Residuo: " + idResiduo);

        // 3. Registrar ingreso de residuo por el usuario con ID 33
        PrototypeIngresoResiduo ingreso = new PrototypeIngresoResiduo();
        ingreso.setIdUsuario(33);  // Usuario previamente registrado
        ingreso.setIdResiduos(idResiduo);
        ingreso.setPeso(1.25);
        ingreso.setDescripcion("Reciclaje post-evento");

        int idIngreso = factory.crearPrototypeIngresoResiduo(ingreso);
        System.out.println("ID Ingreso: " + idIngreso);
    }
}