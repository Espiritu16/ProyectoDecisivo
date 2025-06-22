package tester;
import java.sql.*;

public class TestSPClasificacion {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=GestionResiduoOriginal;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String password = "YourStrongPassword123"; // Reemplázalo si lo cambiaste

        String sql = "{CALL sp_crud_clasificacion(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = conn.prepareCall(sql)) {

            // Parámetros de entrada
            stmt.setString(1, "CREATE");                    // @opcion
            stmt.setNull(2, Types.INTEGER);                // @idClasificacion
            stmt.setString(3, "Papel");                    // @nombre
            stmt.setString(4, "Residuos reciclables");     // @descripcion
            stmt.setString(5, "Blue");                     // @color_codigo
            stmt.setString(6, "icono.png");                // @icono

            // Parámetro de salida
            stmt.registerOutParameter(7, Types.INTEGER);   // @resultado

            // Ejecutar
            stmt.execute();

            // Recuperar ID generado
            int idGenerado = stmt.getInt(7);
            System.out.println("✅ Clasificación creada con ID: " + idGenerado);

        } catch (SQLException e) {
            System.err.println("❌ Error SQL: " + e.getMessage());
        }
    }
}