package Modelo.Servicios.DAO;

import Modelo.PatronSingleton.ConexionSingleton;
import java.sql.*;
import javax.swing.JOptionPane;

import Modelo.ISP.DAO.CRUD;
import Modelo.Servicios.Prototype.PrototypeCentroReciclaje;

public class CentroReciclajeDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeCentroReciclaje centroReciclaje) {

            String sql = "{CALL sp_insertar_centro_reciclaje(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";
            int idGenerado = -1;

            try {
                // Conexión a la base de datos
                Connection connection = ConexionSingleton.getConexion();
                CallableStatement stmt = connection.prepareCall(sql);

                // Pasar los parámetros del procedimiento almacenado
                stmt.setString(1, "CREATE");                         // @accion
                stmt.setNull(2, Types.INTEGER);                        // @idCentro (se utiliza NULL en creación)
                stmt.setString(3, centroReciclaje.getNombre());          // @nombre
                stmt.setString(4, centroReciclaje.getDireccion());         // @direccion
                stmt.setString(5, centroReciclaje.getCiudad());           // @ciudad
                stmt.setString(6, centroReciclaje.getDistrito());          // @distrito
                stmt.setString(7, centroReciclaje.getCodigoPostal());     // @codigo_postal
                stmt.setString(8, centroReciclaje.getPais());             // @pais
                stmt.setString(9, centroReciclaje.getTelefono());         // @telefono
                stmt.setString(10, centroReciclaje.getHorarioAtencion()); // @horario_atencion

                // Registrar el parámetro de salida en el índice correcto (11)
                stmt.registerOutParameter(11, Types.INTEGER);            // @idGenerado (salida)

                // Ejecutar el procedimiento almacenado
                stmt.execute();

                // Obtener el ID generado
                idGenerado = stmt.getInt(11);  // Correcto: Obtener el valor de @idGenerado

                JOptionPane.showMessageDialog(null,
                        "✅ Centro de Reciclaje registrado correctamente. ID generado: " + idGenerado);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "❌ Error al registrar el centro de reciclaje:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            return idGenerado;

        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Objeto no es una instancia de PrototypeCentroReciclaje",
                    "Error de tipo",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    // Otros métodos como actualizar, eliminar, obtener se pueden agregar aquí
}