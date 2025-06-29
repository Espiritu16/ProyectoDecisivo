package Modelo.Registro.DAO;

import Modelo.Registro.Prototype.PrototypeResiduo;
import Modelo.PatronSingleton.ConexionSingleton;
import Modelo.ISP.DAO.CRUD;

import java.sql.*;
import javax.swing.JOptionPane;

public class ResiduosDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeResiduo residuo) {

            String sql = "{CALL sp_crud_residuos(?, ?, ?, ?, ?, ?, ?, ?)}";
            int resultado = -1;

            try (Connection connection = ConexionSingleton.getConexion();
                 CallableStatement stmt = connection.prepareCall(sql)) {

                stmt.setString(1, "CREATE");                    // @accion
                stmt.setNull(2, Types.INTEGER);                // @idResiduos (para creación)
                stmt.setString(3, residuo.getNombre());        // @nombre
                stmt.setInt(4, residuo.getIdClasificacion());  // @idClasificacion
                stmt.setString(5, residuo.getDescripcion());   // @descripcion
                stmt.setDouble(6, residuo.getPeso());          // ✅ @peso como double
                stmt.setString(7, residuo.getPeligrosidad());  // @peligrosidad
                stmt.registerOutParameter(8, Types.INTEGER);   // @idGenerado (salida)

                stmt.execute();
                resultado = stmt.getInt(8);

                JOptionPane.showMessageDialog(null,
                        "✅ Residuo registrado correctamente. ID generado: " + resultado);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "❌ Error al registrar residuo:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            return resultado;

        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Objeto no es del tipo PrototypeResiduo",
                    "Error de tipo",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}