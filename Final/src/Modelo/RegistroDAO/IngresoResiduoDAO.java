package Modelo.RegistroDAO;

import Modelo.RegistroPrototype.PrototypeIngresoResiduo;
import Modelo.ConexionSingleton.ConexionSingleton;
import Modelo.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IngresoResiduoDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeIngresoResiduo) {
            PrototypeIngresoResiduo ingreso = (PrototypeIngresoResiduo) objeto;

            String sql = "{CALL sp_crud_ingreso_residuo(?, ?, ?, ?, ?, ?, ?)}";
            int resultado = -1;

            try (Connection connection = ConexionSingleton.getConexion();
                 CallableStatement stmt = connection.prepareCall(sql)) {

                stmt.setString(1, "CREATE");
                stmt.setNull(2, Types.INTEGER); // idIngreso no se envía
                stmt.setInt(3, ingreso.getIdUsuario());
                stmt.setInt(4, ingreso.getIdResiduos());
                stmt.setDouble(5, ingreso.getPeso());
                stmt.setString(6, ingreso.getDescripcion());
                stmt.registerOutParameter(7, Types.INTEGER); // Salida id generado

                stmt.execute();
                resultado = stmt.getInt(7);
                ingreso.setIdIngreso(resultado); // opcional

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al registrar ingreso de residuo.");
            }

            return resultado;
        } else {
            System.out.println("El objeto no es del tipo esperado (PrototypeIngresoResiduo)");
            return -1;
        }
    }

   public List<PrototypeIngresoResiduo> listarPorUsuario(int idUsuario) {
    List<PrototypeIngresoResiduo> lista = new ArrayList<>();

    String sql = "SELECT idIngreso, idUsuario, idResiduos, peso, fecha_ingreso, descripcion " +
                 "FROM Ingreso_Residuos WHERE idUsuario = ? ORDER BY fecha_ingreso DESC";

    try (Connection connection = ConexionSingleton.getConexion();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            PrototypeIngresoResiduo ingreso = new PrototypeIngresoResiduo();

            ingreso.setIdIngreso(rs.getInt("idIngreso"));
            ingreso.setIdUsuario(rs.getInt("idUsuario"));
            ingreso.setIdResiduos(rs.getInt("idResiduos"));
            ingreso.setPeso(rs.getDouble("peso"));
            ingreso.setFecha_ingreso(rs.getDate("fecha_ingreso"));
            ingreso.setDescripcion(rs.getString("descripcion"));

            lista.add(ingreso);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al listar ingresos por usuario.");
    }

        return lista;
    }
}
