package tester;

import Controlador.PatronFactory.CrearDAOFactory;
import Controlador.PatronFactory.CrearEntidadFactoryImpl;
import Modelo.RegistroPrototype.*;

public class Main {
    public static void main(String[] args) {
        CrearDAOFactory factory = new CrearEntidadFactoryImpl();

        // 1. Dirección
        PrototypeDireccion direccion = new PrototypeDireccion();
        direccion.setDireccion("Av. Siempre Viva 123");
        direccion.setCiudad("Lima");
        direccion.setDistrito("San Borja");
        direccion.setCodigo_postal("15036");
        direccion.setPais("Perú");
        direccion.setReferencia("Cerca al parque");
        int idDireccion = factory.crearDireccion(direccion);
        System.out.println("ID Dirección: " + idDireccion);

        // 2. Usuario
        PrototypeUsuario usuario = new PrototypeUsuario();
        usuario.setDni("12345678");
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setCorreo("juan.perez@example.com");
        usuario.setTelefono("987654321");
        usuario.setContrasena_hash("hashedpassword123");
        usuario.setIdDireccion(idDireccion);
        int idUsuario = factory.crearUsuario(usuario);
        System.out.println("ID Usuario: " + idUsuario);

        // 3. Clasificación de residuo
        PrototypeClasificacionResiduo clasificacion = new PrototypeClasificacionResiduo();
        clasificacion.setNombre("Plástico");
        clasificacion.setDescripcion("Residuos plásticos reciclables");
        clasificacion.setColor_codigo("Verde");
        int idClasificacion = factory.crearClasificacionResiduo(clasificacion);
        System.out.println("ID Clasificación: " + idClasificacion);

        // 4. Residuo
        PrototypeResiduo residuo = new PrototypeResiduo();
        residuo.setNombre("Botella PET");
        residuo.setIdClasificacion(idClasificacion);
        residuo.setDescripcion("Botellas plásticas de bebidas");
        residuo.setPeso(0.5);
        residuo.setPeligrosidad("Baja");
        int idResiduo = factory.crearResiduo(residuo);
        System.out.println("ID Residuo: " + idResiduo);
        System.out.println(idUsuario);
        
        // 5. Ingreso de residuo
        PrototypeIngresoResiduo ingreso = new PrototypeIngresoResiduo();
        ingreso.setIdUsuario(idUsuario);
        ingreso.setIdResiduos(idResiduo);
        ingreso.setPeso(0.5);
        ingreso.setDescripcion("Botellas recolectadas de evento");
        int idIngreso = factory.crearPrototypeIngresoResiduo(ingreso);
        System.out.println("ID Ingreso: " + idIngreso);
    }
}