package tester;

import Controlador.PatronFactory.CrearDAOFactory;
import Controlador.PatronFactory.CrearEntidadFactoryImpl;
import Modelo.ServiciosDAO.CentroReciclajeDAO;
import Modelo.ServiciosPrototype.PrototypeCentroReciclaje;

public class direccion {
    public static void main(String[] args) {
        // Crear la instancia del Factory
        CrearDAOFactory factory = new CrearEntidadFactoryImpl();

        // 1. Crear y configurar un nuevo centro de reciclaje
        PrototypeCentroReciclaje centroReciclaje = new PrototypeCentroReciclaje();
        centroReciclaje.setNombre("Centro Reciclaje San Isidro");
        centroReciclaje.setDireccion("Av. Siempre Viva 123");
        centroReciclaje.setCiudad("Lima");
        centroReciclaje.setDistrito("San Isidro");
        centroReciclaje.setCodigoPostal("15073");
        centroReciclaje.setPais("Perú");
        centroReciclaje.setTelefono("987654321");
        centroReciclaje.setHorarioAtencion(""
                + "");

        // 2. Usar el Factory para crear el centro de reciclaje en la base de datos
        int idGenerado = factory.crearCentroReciclaje(centroReciclaje);

        // 3. Mostrar el ID generado del nuevo centro de reciclaje
        System.out.println("ID del nuevo centro de reciclaje: " + idGenerado);
    }
}