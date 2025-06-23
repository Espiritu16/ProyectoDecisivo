package Modelo.RegistroDAO;

import Modelo.RegistroPrototype.PrototypeUsuario;
import Modelo.ConexionSingleton.ConexionSingleton;
import Modelo.CRUD;

import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO implements CRUD {

    @Override
    public int crear(Object objeto) {
        if (objeto instanceof PrototypeUsuario usuario) {

            String sql = "{CALL sp_insertar_usuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            int idGenerado = -1;

            try (Connection connection = ConexionSingleton.getConexion();
                 CallableStatement stmt = connection.prepareCall(sql)) {

                // Parámetros para sp_insertar_usuario
                stmt.setString(1, "CREATE");                    // @accion
                stmt.setNull(2, Types.INTEGER);                 // @idUsuario (nulo para crear)
                stmt.setString(3, usuario.getDni());            // @dni
                stmt.setString(4, usuario.getNombre());         // @nombre
                stmt.setString(5, usuario.getApellido());       // @apellido
                stmt.setString(6, usuario.getCorreo());         // @correo
                stmt.setString(7, usuario.getTelefono());       // @telefono
                stmt.setString(8, usuario.getContrasena_hash()); // @contrasena_hash
                stmt.setInt(9, usuario.getIdDireccion());       // @idDireccion

                // @idGenerado (salida)
                stmt.registerOutParameter(10, Types.INTEGER);

                stmt.execute();

                idGenerado = stmt.getInt(10); // Obtenemos el ID generado

                JOptionPane.showMessageDialog(null,
                        "✅ Usuario registrado correctamente. ID generado: " + idGenerado);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "❌ Error al insertar usuario:\n" + e.getMessage(),
                        "Error SQL",
                        JOptionPane.ERROR_MESSAGE);
            }

            return idGenerado;
        } else {
            JOptionPane.showMessageDialog(null,
                    "❌ Objeto no es una instancia de PrototypeUsuario",
                    "Error de tipo",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    public int autenticarUsuario(String correo, String contrasenaHash) {
    int idUsuario = -1;

    String sql = "SELECT idUsuario FROM Usuario WHERE correo = ? AND contrasena_hash = ?";

    try (Connection conn = ConexionSingleton.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, correo);
        stmt.setString(2, contrasenaHash);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            idUsuario = rs.getInt("idUsuario");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return idUsuario;
    }
}