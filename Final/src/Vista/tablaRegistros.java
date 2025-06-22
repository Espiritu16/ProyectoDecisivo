package Vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import Modelo.ConexionSingleton.ConexionSingleton;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sankef
 */
public class tablaRegistros extends javax.swing.JPanel {
    //ahora
    private enviarNotificacion ventanaNotificacion;  // La ventana de notificación

    /**
     * Creates new form tablaRegistros
     */
    public tablaRegistros() {
        initComponents();
        cargarTablaVistaIngresosResiduos(tablaTab1); // Este es el primer JTable
        cargarTablaCantidadResiduosPorUsuario(tablaTab2); // Este es el segundo JTable
        tablaTab1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Para seleccionar solo una fila a la vez
        tablaTab2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Para seleccionar solo una fila a la vez
        
        
        //ahora 
        // Detectar la selección de filas en la primera tabla
        tablaTab1.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Obtener la fila seleccionada donde se hizo clic
        int selectedRow = tablaTab1.rowAtPoint(evt.getPoint()); // Esto obtiene la fila en el punto donde hiciste clic

        if (selectedRow != -1) {
            // Obtener el DNI de la fila seleccionada (en la columna 0, asumiendo que el DNI está en la primera columna)
            String dniSeleccionado = tablaTab1.getValueAt(selectedRow, 0).toString();  // Obtener el DNI de la columna 0

            // Si el DNI está en otra columna, puedes cambiar el índice (por ejemplo: columna 1 -> `getValueAt(selectedRow, 1)`)

            // Pasar el DNI a la ventana de notificación
            if (ventanaNotificacion != null) {
                ventanaNotificacion.setDniEnVentanaNotificacion(dniSeleccionado);  // Pasar el DNI a la ventana de notificación
            }
        }
    }
        });

        tablaTab2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Obtener la fila seleccionada en la que hiciste clic
        int selectedRow = tablaTab2.rowAtPoint(evt.getPoint()); // Obtiene la fila donde hiciste clic

        if (selectedRow != -1) {
            // Obtener el DNI de la fila seleccionada (en la columna 0, donde está el DNI)
            String dniSeleccionado = tablaTab2.getValueAt(selectedRow, 0).toString();  // DNI en la columna 0

            // Si tienes la ventana de notificación abierta, pasar el DNI a esa ventana
            if (ventanaNotificacion != null) {
                ventanaNotificacion.setDniEnVentanaNotificacion(dniSeleccionado);  // Pasar el DNI a la ventana de notificación
            }
        }
        }
        });
    }

    
    //ahora
    // Método para establecer la referencia de la ventana de notificación
    public void setVentanaNotificacion(enviarNotificacion ventana) {
        this.ventanaNotificacion = ventana;  // Establecer la referencia de la ventana de notificación
    }
        
    
    public void cargarTablaVistaIngresosResiduos(JTable tabla) {
        // Crear el modelo de la tabla con las columnas adecuadas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Telefono");
        model.addColumn("Residuo");
        model.addColumn("Peso");
        model.addColumn("Fecha Ingreso");

        // Conectar a la base de datos y obtener los datos de la vista `Vista_IngresosResiduos`
        try (Connection conn = ConexionSingleton.getConexion()) {
            String sql = "SELECT * FROM Vista_IngresosResiduos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterar a través de los resultados y llenar el modelo con las filas
            while (rs.next()) {
                model.addRow(new Object[]{   
                    rs.getString("dni"),                // Correo del usuario
                    rs.getString("telefono"),              // Teléfono del usuario
                    rs.getString("residuo"),               // Nombre del residuo
                    rs.getDouble("peso"),                  // Peso del residuo
                    rs.getDate("fecha_ingreso")            // Fecha de ingreso
                });
            }

            // Establecer el modelo de la tabla
            tabla.setModel(model);
            tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición para todas las celdas
            
        } catch (SQLException ex) {
            ex.printStackTrace();  // Manejo de errores si ocurre un problema con la consulta
        }
    }
    
    
    public void cargarTablaCantidadResiduosPorUsuario(JTable tabla) {
        // Crear el modelo de la tabla con las columnas adecuadas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Correo");
        model.addColumn("Telefono");
        model.addColumn("Cantidad Residuos");
        model.addColumn("Suma Pesos Residuos"); // Columna para la suma de los pesos de los residuos

        // Conectar a la base de datos y obtener los datos de la vista `Vista_CantidadResiduosPorUsuario`
        try (Connection conn = ConexionSingleton.getConexion()) {
            String sql = "SELECT * FROM Vista_CantidadResiduosPorUsuario";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterar a través de los resultados y llenar el modelo con las filas
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("dni"),                        // DNI del usuario
                    rs.getString("nombre"),                     // Nombre del usuario
                    rs.getString("correo"),                     // Correo del usuario
                    rs.getString("telefono"),                   // Teléfono del usuario
                    rs.getInt("cantidad_residuos_recolectados"), // Cantidad de residuos recolectados
                    rs.getDouble("suma_pesos_residuos")         // Suma de los pesos de los residuos recolectados
                });
            }

            // Establecer el modelo de la tabla
            tabla.setModel(model);
            tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición para todas las celdas

            // Hacer la tabla ordenable por las columnas
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
            tabla.setRowSorter(sorter);
        } catch (SQLException ex) {
            ex.printStackTrace();  // Manejo de errores si ocurre un problema con la consulta
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTab1 = new javax.swing.JTable();
        tab2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTab2 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTab1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaTab1);

        tab1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 430));

        jTabbedPane1.addTab("Usuarios y sus Residuos ", tab1);

        tab2.setSize(new java.awt.Dimension(700, 400));
        tab2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTab2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaTab2);

        tab2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 430));

        jTabbedPane1.addTab("Cantidad de Residuos por Usuario", tab2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 460));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JTable tablaTab1;
    private javax.swing.JTable tablaTab2;
    // End of variables declaration//GEN-END:variables
}
