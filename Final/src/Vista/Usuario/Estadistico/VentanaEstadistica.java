package Vista.Usuario.Estadistico;


import Modelo.PatronSingleton.ConexionSingleton;
import Modelo.PatronSingleton.MantenerSession;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class VentanaEstadistica extends javax.swing.JPanel {
 
    public VentanaEstadistica() {
        
        initComponents();
        cargarResiduosReciclables(tablaReciclable);
        cargarResiduosNoReciclables(tablaNoReciclable);
        cargarResiduosGenerados(tablaCantidadResiduosGenerados);
    }
    
    public void cargarResiduosGenerados(JTable tabla) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Cantidad de Residuos");
        model.addColumn("Peso Total (kg)");

        // Obtener el correo del usuario desde la sesión activa
        MantenerSession sessionManager = MantenerSession.getInstance();
        String correoUsuario = sessionManager.getCorreo();

        try (Connection conn = ConexionSingleton.getConexion()) {
            // Consulta para obtener la cantidad de residuos y el peso total generados por el usuario logueado
            String sql = "SELECT u.dni, COUNT(ir.idIngreso) AS cantidad_residuos, SUM(ir.peso) AS peso_total " +
                         "FROM Ingreso_Residuos ir " +
                         "JOIN Residuos r ON ir.idResiduos = r.idResiduos " +
                         "JOIN Usuario u ON ir.idUsuario = u.idUsuario " +
                         "WHERE u.correo = ? " +
                         "GROUP BY u.dni";  // Filtramos por el correo del usuario logueado y agrupamos por el DNI

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correoUsuario);  // Usar el correo obtenido de la sesión

            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las filas a la tabla
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("dni"),          // Obtener el DNI del usuario
                    rs.getInt("cantidad_residuos"), // Obtener la cantidad de residuos generados
                    rs.getDouble("peso_total")    // Obtener el peso total de los residuos generados
                });
            }

            // Establecer el modelo de la tabla
            tabla.setModel(model);
            tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición de la tabla

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void cargarResiduosReciclables(JTable tabla) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre del Residuo");
        model.addColumn("Peso (kg)");
        model.addColumn("Fecha de Ingreso");

        // Obtener el correo del usuario desde la sesión activa
        MantenerSession sessionManager = MantenerSession.getInstance();
        String correoUsuario = sessionManager.getCorreo();

        try (Connection conn = ConexionSingleton.getConexion()) {
            // Consulta para obtener los residuos reciclables generados por el usuario logueado
            String sql = "SELECT u.dni, r.nombre, ir.peso, ir.fecha_ingreso " +
                         "FROM Ingreso_Residuos ir " +
                         "JOIN Residuos r ON ir.idResiduos = r.idResiduos " +
                         "JOIN Usuario u ON ir.idUsuario = u.idUsuario " +
                         "JOIN Clasificacion_Residuos cr ON r.idClasificacion = cr.idClasificacion " +
                         "WHERE u.correo = ? AND cr.color_codigo IN ('Azul', 'Amarillo', 'Verde')";  // Filtrar residuos reciclables

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correoUsuario);  // Usar el correo obtenido de la sesión

            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las filas a la tabla
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("dni"),          // Obtener el DNI del usuario
                    rs.getString("nombre"),       // Obtener el nombre del residuo
                    rs.getDouble("peso"),         // Obtener el peso del residuo
                    rs.getTimestamp("fecha_ingreso") // Obtener la fecha de ingreso del residuo
                });
            }

            // Establecer el modelo de la tabla
            tabla.setModel(model);
            tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición de la tabla

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   
    
    public void cargarResiduosNoReciclables(JTable tabla) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre del Residuo");
        model.addColumn("Peso (kg)");
        model.addColumn("Fecha de Ingreso");

        // Obtener el correo del usuario desde la sesión activa
        MantenerSession sessionManager = MantenerSession.getInstance();
        String correoUsuario = sessionManager.getCorreo();

        try (Connection conn = ConexionSingleton.getConexion()) {
            // Consulta para obtener los residuos no reciclables generados por el usuario logueado
            String sql = "SELECT u.dni, r.nombre, ir.peso, ir.fecha_ingreso " +
                         "FROM Ingreso_Residuos ir " +
                         "JOIN Residuos r ON ir.idResiduos = r.idResiduos " +
                         "JOIN Usuario u ON ir.idUsuario = u.idUsuario " +
                         "JOIN Clasificacion_Residuos cr ON r.idClasificacion = cr.idClasificacion " +
                         "WHERE u.correo = ? AND cr.color_codigo = 'Rojo'";  // Filtrar residuos no reciclables

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correoUsuario);  // Usar el correo obtenido de la sesión

            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las filas a la tabla
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("dni"),          // Obtener el DNI del usuario
                    rs.getString("nombre"),       // Obtener el nombre del residuo
                    rs.getDouble("peso"),         // Obtener el peso del residuo
                    rs.getTimestamp("fecha_ingreso") // Obtener la fecha de ingreso del residuo
                });
            }

            // Establecer el modelo de la tabla
            tabla.setModel(model);
            tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición de la tabla

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        tabReciclable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReciclable = new javax.swing.JTable();
        tabNoReciclable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNoReciclable = new javax.swing.JTable();
        tabCantidadResiduosGenerados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCantidadResiduosGenerados = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabGeneral.setBackground(new java.awt.Color(153, 255, 153));
        tabGeneral.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tabGeneral.setMaximumSize(new java.awt.Dimension(700, 400));
        tabGeneral.setMinimumSize(new java.awt.Dimension(700, 400));

        tabReciclable.setBackground(new java.awt.Color(255, 204, 204));
        tabReciclable.setMaximumSize(new java.awt.Dimension(700, 400));
        tabReciclable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaReciclable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaReciclable);

        tabReciclable.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 440));

        tabGeneral.addTab("Reciclabes", tabReciclable);

        tabNoReciclable.setBackground(new java.awt.Color(255, 204, 204));
        tabNoReciclable.setMaximumSize(new java.awt.Dimension(700, 400));
        tabNoReciclable.setMinimumSize(new java.awt.Dimension(700, 400));
        tabNoReciclable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaNoReciclable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaNoReciclable);

        tabNoReciclable.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 440));

        tabGeneral.addTab("No Reciclabes", tabNoReciclable);

        tabCantidadResiduosGenerados.setBackground(new java.awt.Color(255, 204, 204));
        tabCantidadResiduosGenerados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCantidadResiduosGenerados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaCantidadResiduosGenerados);

        tabCantidadResiduosGenerados.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 410));

        tabGeneral.addTab("Cantidad de residuos generados", tabCantidadResiduosGenerados);

        add(tabGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 440));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel tabCantidadResiduosGenerados;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JPanel tabNoReciclable;
    private javax.swing.JPanel tabReciclable;
    private javax.swing.JTable tablaCantidadResiduosGenerados;
    private javax.swing.JTable tablaNoReciclable;
    private javax.swing.JTable tablaReciclable;
    // End of variables declaration//GEN-END:variables

   
}
