package Modelo.Registro.DAO;

import Modelo.Registro.Prototype.PrototypeClasificacionResiduo;
import Modelo.PatronSingleton.ConexionSingleton;
import Modelo.ISP.DAO.CRUD;

import java.sql.*;
import javax.swing.JOptionPane;

public class ClasificacionResiduosDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeClasificacionResiduo clasificacion) {

            String sql = "{CALL sp_crud_clasificacion(?, ?, ?, ?, ?, ?)}";
            int idGenerado = -1;

            try {
                Connection connection = ConexionSingleton.getConexion();
                CallableStatement stmt = connection.prepareCall(sql);

                stmt.setString(1, "CREATE");                         // @opcion
                stmt.setNull(2, Types.INTEGER);                      // @idClasificacion
                stmt.setString(3, clasificacion.getNombre());        // @nombre
                stmt.setString(4, clasificacion.getDescripcion());   // @descripcion
                stmt.setString(5, clasificacion.getColor_codigo());  // @color_codigo
                stmt.registerOutParameter(6, Types.INTEGER);         // @resultado (salida)

                stmt.execute();

                idGenerado = stmt.getInt(6); // Obtenemos el ID generado

                JOptionPane.showMessageDialog(null,
                        "✅ Clasificación registrada correctamente. ID generado: " + idGenerado);

            } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,
                        "❌ Error al registrar clasificación:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            return idGenerado;

        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Objeto no es una instancia de PrototypeClasificacionResiduo",
                    "Error de tipo",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}