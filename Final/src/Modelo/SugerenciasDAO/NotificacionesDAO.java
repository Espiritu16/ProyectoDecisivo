package Modelo.SugerenciasDAO;
import Controlador.CRUD;
import Modelo.ConexionSingleton.ConexionSingleton;
import Modelo.SugerenciasPrototype.PrototypeNotificacion;
import java.sql.*;
import javax.swing.JOptionPane;

public class NotificacionesDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeNotificacion notificacion) {

            String sql = "{CALL sp_insertar_notificacion(?, ?, ?, ?, ?, ?, ?)}";
            int idGenerado = -1;
            
            try {
                // Conexión a la base de datos
                Connection connection = ConexionSingleton.getConexion();
                CallableStatement stmt = connection.prepareCall(sql);

                // Pasar los parámetros del procedimiento almacenado
                stmt.setString(1, "CREATE");                         // @accion
                stmt.setNull(2, Types.INTEGER);                        // @idNotificacion (se utiliza NULL en creación)
                stmt.setString(3, notificacion.getDni());          // @idUsuario
                stmt.setString(4, notificacion.getMensaje());         // @mensaje
                stmt.setString(5, notificacion.getEstado());          // @estado
                stmt.setString(6, notificacion.getCanal());           // @canal
                stmt.registerOutParameter(7, Types.INTEGER);          // @idGenerado (salida)

                // Ejecutar el procedimiento almacenado
                stmt.execute();

                // Obtener el ID generado
                idGenerado = stmt.getInt(7);

                JOptionPane.showMessageDialog(null,
                        "✅ Notificación registrada correctamente. ID generado: " + idGenerado);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "❌ Error al registrar la notificación:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            return idGenerado;

        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Objeto no es una instancia de PrototypeNotificacion",
                    "Error de tipo",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    
}