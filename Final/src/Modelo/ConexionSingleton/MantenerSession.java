package Modelo.ConexionSingleton;
import Modelo.ConexionSingleton.ConexionSingleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class MantenerSession {

    private static MantenerSession instance;
    private int idUsuario = -1;  // -1 significa que no hay usuario logueado
    private String nombre;
    private String correo;
    private String rol;

    private MantenerSession() {}

    public static MantenerSession getInstance() {
        if (instance == null) {
            instance = new MantenerSession();
        }
        return instance;
    }

    // Establecer los datos del usuario (se llama cuando el usuario se loguea)
    public void setUsuarioData(int idUsuario, String nombre, String correo, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    
    public boolean autenticarUsuario(String correo, String contrasenaHash) {
        boolean autenticado = false;

        // SQL para verificar el usuario y la contraseña en la base de datos
        String sql = "SELECT idUsuario, nombre, correo, rol FROM Usuario WHERE correo = ? AND contrasena_hash = ?";
        // SQL para actualizar el último acceso
        String updateQuery = "UPDATE Usuario SET ultimo_acceso = GETDATE() WHERE correo = ?";

        try (Connection conn = ConexionSingleton.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            stmt.setString(1, correo);           // Establecer el correo del usuario
            stmt.setString(2, contrasenaHash);   // Establecer la contraseña

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si el usuario es encontrado, establecer la información en la sesión
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String rol = rs.getString("rol");

                // Establecer los datos del usuario en la sesión
                setUsuarioData(idUsuario, nombre, correo, rol);
         // Actualizar la fecha de último acceso
                updateStmt.setString(1, correo); // Establecer el correo para actualizar
                updateStmt.executeUpdate(); // Ejecutar la actualización

                autenticado = true;  // El usuario está autenticado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autenticado;
    }


    
    
    // Obtener el idUsuario de la sesión
    public int getIdUsuario() {
        return idUsuario;
    }

    // Verificar si el usuario está logueado
    public boolean isUserLoggedIn() {
        return idUsuario != -1;
    }

    // Cerrar sesión (limpiar la sesión)
    public void logout() {
        idUsuario = -1;
        nombre = null;
        correo = null;
        rol = null;
    }

    // Obtener datos del usuario
    public String getUserData() {
        return "ID: " + idUsuario + ", Nombre: " + nombre + ", Correo: " + correo + ", Rol: " + rol;
    }

    // Obtener el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Obtener el correo del usuario
    public String getCorreo() {
        return correo;
    }

    // Obtener el rol del usuario
    public String getRol() {
        return rol;
    }

    // Verificar si el usuario tiene un rol específico
    public boolean hasRole(String role) {
        return rol != null && rol.equals(role);
    }

    // Verificar si la sesión está activa
    public boolean isSessionActive() {
        return idUsuario != -1;
    }
}