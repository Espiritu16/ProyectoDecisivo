package Modelo.ServiciosDAO;

import Controlador.CRUD;
import Modelo.ConexionSingleton.ConexionSingleton;
import Modelo.ServiciosPrototype.PrototypeAlerta;
import java.sql.*;
import javax.swing.JOptionPane;


public class AlertaDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeAlerta alerta) {
            // SQL para llamar al procedimiento almacenado que envía alertas a todos los usuarios
            String sql = "{CALL sp_insertar_alerta_todos(?, ?, ?, ?)}";  // Añadimos el parámetro de salida

            int idGenerado = -1;  // Variable para almacenar el ID generado

            try (Connection conn = ConexionSingleton.getConexion();
                 CallableStatement stmt = conn.prepareCall(sql)) {

                // Pasamos los parámetros al procedimiento almacenado
                stmt.setString(1, alerta.getMensaje());         // @mensaje
                stmt.setString(2, alerta.getEstadoAlerta());    // @estadoAlerta
                stmt.setTimestamp(3, new Timestamp(alerta.getFechaAlerta().getTime()));  // @fechaAlerta
                stmt.registerOutParameter(4, Types.INTEGER);   // Registrar el parámetro de salida @idGenerado

                // Ejecutamos el procedimiento almacenado
                stmt.execute();

                // Obtener el ID generado
                idGenerado = stmt.getInt(4);  // Obtener el valor del parámetro de salida

                System.out.println("Alerta enviada a todos los usuarios con éxito. ID Generado: " + idGenerado);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "❌ Error al registrar la alerta para todos los usuarios:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Retornamos el ID generado
            return idGenerado;
        }

        // Si el objeto no es una instancia de PrototypeAlerta, retorna -1
        return -1;
    }
}