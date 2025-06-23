package Modelo.RegistroDAO;

import Modelo.RegistroPrototype.PrototypeDireccion;
import Modelo.ConexionSingleton.ConexionSingleton;
import Modelo.CRUD;

import java.sql.*;
import javax.swing.JOptionPane;

public class DireccionDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeDireccion direccion) {

            String sql = "{CALL sp_crud_direccion(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            int idGenerado = -1;

            try (Connection conn = ConexionSingleton.getConexion();
                 CallableStatement stmt = conn.prepareCall(sql)) {

                stmt.setString(1, "CREATE");                          // @accion
                stmt.setNull(2, Types.INTEGER);                       // @idDireccion (nulo para crear)
                stmt.setString(3, direccion.getDireccion());          // @direccion
                stmt.setString(4, direccion.getCiudad());             // @ciudad
                stmt.setString(5, direccion.getDistrito());           // @distrito
                stmt.setString(6, direccion.getCodigo_postal());      // @codigo_postal
                stmt.setString(7, direccion.getPais());               // @pais
                stmt.setString(8, direccion.getReferencia());         // @referencia

                stmt.registerOutParameter(9, Types.INTEGER);          // @idGenerado (salida)

                stmt.execute();
                idGenerado = stmt.getInt(9);

                JOptionPane.showMessageDialog(null,
                        "✅ Dirección registrada correctamente. ID generado: " + idGenerado);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "❌ Error al registrar dirección:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            return idGenerado;
        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Objeto no es del tipo PrototypeDireccion",
                    "Error de tipo",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}