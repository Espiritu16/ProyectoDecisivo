package Modelo.ServiciosDAO;

import Controlador.PatronFactory.CrearDAOFactory;
import Controlador.PatronFactory.CrearEntidadFactoryImpl;
import Modelo.ServiciosPrototype.PrototypeAlerta;

public class AlertaTest {
    public static void main(String[] args) {
        // 1. Crear la instancia del Factory
        CrearDAOFactory factory = new CrearEntidadFactoryImpl();

        // 2. Crear y configurar una nueva alerta
        String mensajeAlerta = "Recordatorio: La recolección de residuos será mañana a las 10:00 AM.";
        
        // No es necesario poner idUsuario porque la alerta se enviará a todos los usuarios
        PrototypeAlerta alerta = new PrototypeAlerta();
        alerta.setMensaje(mensajeAlerta);
        
        // 3. Usar el Factory para crear la alerta en la base de datos
        int idGenerado = factory.crearAlerta(alerta);  // Llamamos al método DAO para crear la alerta

        // 4. Verificar si la alerta fue enviada correctamente
        if (idGenerado != -1) {
            System.out.println("Alerta enviada con éxito. ID Generado: " + idGenerado);
        } else {
            System.out.println("Hubo un error al enviar la alerta.");
        }
    }
}