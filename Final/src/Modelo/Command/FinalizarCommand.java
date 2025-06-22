package Modelo.Command;

import Controlador.PatronFactory.CrearDAOFactory;
import Controlador.PatronFactory.CrearEntidadFactoryImpl;
import Modelo.ConexionSingleton.MantenerSession;
import Modelo.RegistroPrototype.PrototypeClasificacionResiduo;
import Modelo.RegistroPrototype.PrototypeIngresoResiduo;
import Modelo.RegistroPrototype.PrototypeResiduo;
import Vista.Usuario.VentanaRegistro;
import javax.swing.JOptionPane;

public class FinalizarCommand implements Command {
    private VentanaRegistro ventanaRegistro;

    public FinalizarCommand(VentanaRegistro ventanaRegistro) {
        this.ventanaRegistro = ventanaRegistro;
    }

    @Override
    public void execute() {
         // Guardar la Clasificación del Residuo y obtener su id
        CrearDAOFactory factory = new CrearEntidadFactoryImpl();
        // Obtener los datos del formulario 1 (Clasificación de Residuo)
        PrototypeClasificacionResiduo clasificacion = new PrototypeClasificacionResiduo();
        clasificacion.setNombre(ventanaRegistro.getTxtNombreClaResiduo().getText());
        clasificacion.setDescripcion(ventanaRegistro.getTxtDescripcionClaResiduo().getText());
        clasificacion.setColor_codigo(ventanaRegistro.getBoxColor().getSelectedItem().toString());

      
        int idClasificacion = factory.crearClasificacionResiduo(clasificacion);
        System.out.println("Clasificación ID: " + idClasificacion);  // Imprimir ID para referencia

        // Obtener los datos del formulario 2 (Residuo)
        PrototypeResiduo residuo = new PrototypeResiduo();
        residuo.setNombre(ventanaRegistro.getTxtNombreResiduo().getText());
        residuo.setIdClasificacion(idClasificacion);
        residuo.setDescripcion(ventanaRegistro.getTxtDescripcionResiduo().getText());
        residuo.setPeso(Double.parseDouble(ventanaRegistro.getTxtPesoResiduo().getText()));
        residuo.setPeligrosidad(ventanaRegistro.getComboPeligrosidad().getSelectedItem().toString());

        // Guardar el Residuo y obtener su id
        int idResiduo = factory.crearResiduo(residuo);
        System.out.println("Residuo ID: " + idResiduo);  // Imprimir ID para referencia

        // Obtener el idUsuario desde la sesión
        MantenerSession sessionManager = MantenerSession.getInstance();
        int idUsuario = sessionManager.getIdUsuario();  // Obtener el idUsuario desde la sesión activa

        
        // Concatenar las descripciones en formato de párrafo
        String descripcionIngreso = "Descripción Clasificación: " 
                + clasificacion.getDescripcion() + "\n" + 
                "Descripción Residuo: " + residuo.getDescripcion();  // Concatenar las descripciones con salto de línea
        
        
        // Crear el IngresoResiduo con los datos correspondientes
        PrototypeIngresoResiduo ingresoResiduo = new PrototypeIngresoResiduo();
        ingresoResiduo.setIdUsuario(idUsuario);  // Asignar el idUsuario desde la sesión
        ingresoResiduo.setIdResiduos(idResiduo);  // Asignar el idResiduo creado
        ingresoResiduo.setPeso(Double.parseDouble(ventanaRegistro.getTxtPesoResiduo().getText()));  // Peso del residuo
        ingresoResiduo.setDescripcion(descripcionIngreso);  // Descripción del ingreso

        // Guardar el IngresoResiduo
        int idIngreso = factory.crearPrototypeIngresoResiduo(ingresoResiduo);
        System.out.println("Ingreso Residuo ID: " + idIngreso);  // Imprimir ID para referencia

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(null, "Registro finalizado con éxito", "Finalización", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar los campos del formulario
        ventanaRegistro.limpiarCampos();
    }
}