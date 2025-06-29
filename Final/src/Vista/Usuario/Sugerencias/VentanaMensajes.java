package Vista.Usuario.Sugerencias;


import Modelo.PatronSingleton.ConexionSingleton;
import Modelo.PatronSingleton.MantenerSession;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sankef
 */
public class VentanaMensajes extends javax.swing.JPanel {
    
 
    

    /**
     * Creates new form VentanaRegistro
     */
    public VentanaMensajes() {
        
        initComponents();
        //guardar el usuario logeado
        
        leerCorreo();
        leerWhatsApp();
        leerSMS();
    }
    
    
    public void cargarMensajesCorreo(JTable tabla) {
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("DNI");
       model.addColumn("Mensaje");
       model.addColumn("Fecha Envío");

       MantenerSession sessionManager = MantenerSession.getInstance();
       String correoUsuario = sessionManager.getCorreo();  // Obtener el correo del usuario desde la sesión activa

       try (Connection conn = ConexionSingleton.getConexion()) {
           // Consulta para obtener los mensajes de correo filtrados por correo y estado "Pendiente"
           String sql = "SELECT u.dni, n.mensaje, n.fechaEnvio " +
                        "FROM Notificaciones n " +
                        "JOIN Usuario u ON n.dni = u.dni " +
                        "WHERE u.correo = ? AND n.estado = 'Pendiente' AND n.canal = 'Correo'";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, correoUsuario);  // Usar el correo obtenido de la sesión

           ResultSet rs = stmt.executeQuery();

           // Iterar sobre los resultados y agregar las filas a la tabla
           while (rs.next()) {
               model.addRow(new Object[]{
                   rs.getString("dni"),        // Obtener el DNI como String
                   rs.getString("mensaje"),
                   rs.getTimestamp("fechaEnvio")
               });
           }

           tabla.setModel(model);
           tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición

       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }

   public void cargarMensajesWhatsApp(JTable tabla) {
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("DNI");
       model.addColumn("Mensaje");
       model.addColumn("Fecha Envío");

       MantenerSession sessionManager = MantenerSession.getInstance();
       String correoUsuario = sessionManager.getCorreo();  // Obtener el correo del usuario desde la sesión activa

       try (Connection conn = ConexionSingleton.getConexion()) {
           // Consulta para obtener los mensajes de WhatsApp filtrados por correo y estado "Pendiente"
           String sql = "SELECT u.dni, n.mensaje, n.fechaEnvio " +
                        "FROM Notificaciones n " +
                        "JOIN Usuario u ON n.dni = u.dni " +
                        "WHERE u.correo = ? AND n.estado = 'Pendiente' AND n.canal = 'WhatsApp'";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, correoUsuario);  // Usar el correo obtenido de la sesión

           ResultSet rs = stmt.executeQuery();

           // Iterar sobre los resultados y agregar las filas a la tabla
           while (rs.next()) {
               model.addRow(new Object[]{
                   rs.getString("dni"),        // Obtener el DNI como String
                   rs.getString("mensaje"),
                   rs.getTimestamp("fechaEnvio")
               });
           }

           tabla.setModel(model);
           tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición

       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }

   public void cargarMensajesSMS(JTable tabla) {
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("DNI");
       model.addColumn("Mensaje");
       model.addColumn("Fecha Envío");

       MantenerSession sessionManager = MantenerSession.getInstance();
       String correoUsuario = sessionManager.getCorreo();  // Obtener el correo del usuario desde la sesión activa

       try (Connection conn = ConexionSingleton.getConexion()) {
           // Consulta para obtener los mensajes de SMS filtrados por correo y estado "Pendiente"
           String sql = "SELECT u.dni, n.mensaje, n.fechaEnvio " +
                        "FROM Notificaciones n " +
                        "JOIN Usuario u ON n.dni = u.dni " +
                        "WHERE u.correo = ? AND n.estado = 'Pendiente' AND n.canal = 'SMS'";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, correoUsuario);  // Usar el correo obtenido de la sesión

           ResultSet rs = stmt.executeQuery();

           // Iterar sobre los resultados y agregar las filas a la tabla
           while (rs.next()) {
               model.addRow(new Object[]{
                   rs.getString("dni"),        // Obtener el DNI como String
                   rs.getString("mensaje"),
                   rs.getTimestamp("fechaEnvio")
               });
           }

           tabla.setModel(model);
           tabla.setDefaultEditor(Object.class, null);  // Deshabilitar la edición

       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }



   
    public void leerCorreo(){
        // Cuando se selecciona la pestaña de Correo
        tabGeneral.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                if (tabGeneral.getSelectedIndex() == 0) { // Correo
                    cargarMensajesCorreo(tablaCorreo);
                }
            }
        });
    }

    public void leerWhatsApp(){
        // Cuando se selecciona la pestaña de WhatsApp
        tabGeneral.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                if (tabGeneral.getSelectedIndex() == 1) { // WhatsApp
                    cargarMensajesWhatsApp(tablaWhatsaap);
                }
            }
        });
    }

    public void leerSMS(){
        // Cuando se selecciona la pestaña de SMS
        tabGeneral.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                if (tabGeneral.getSelectedIndex() == 2) { // SMS
                    cargarMensajesSMS(tablaSMS);
                }
            }
        });
    }
   
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        tabCorreo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCorreo = new javax.swing.JTable();
        tabWhatsaap = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaWhatsaap = new javax.swing.JTable();
        tabSMS = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaSMS = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabGeneral.setBackground(new java.awt.Color(153, 255, 153));
        tabGeneral.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tabGeneral.setMaximumSize(new java.awt.Dimension(700, 400));
        tabGeneral.setMinimumSize(new java.awt.Dimension(700, 400));

        tabCorreo.setBackground(new java.awt.Color(255, 204, 204));
        tabCorreo.setMaximumSize(new java.awt.Dimension(700, 400));
        tabCorreo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCorreo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaCorreo);

        tabCorreo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 420));

        tabGeneral.addTab("Correo", tabCorreo);

        tabWhatsaap.setBackground(new java.awt.Color(255, 204, 204));
        tabWhatsaap.setMaximumSize(new java.awt.Dimension(700, 400));
        tabWhatsaap.setMinimumSize(new java.awt.Dimension(700, 400));
        tabWhatsaap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaWhatsaap.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaWhatsaap);

        tabWhatsaap.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 440));

        tabGeneral.addTab("Whatsaap", tabWhatsaap);

        tabSMS.setBackground(new java.awt.Color(255, 204, 204));
        tabSMS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSMS.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaSMS);

        tabSMS.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 440));

        tabGeneral.addTab("Mensaje(SMS) ", tabSMS);

        add(tabGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 450));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel tabCorreo;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JPanel tabSMS;
    private javax.swing.JPanel tabWhatsaap;
    private javax.swing.JTable tablaCorreo;
    private javax.swing.JTable tablaSMS;
    private javax.swing.JTable tablaWhatsaap;
    // End of variables declaration//GEN-END:variables

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JPanel getTabCorreo() {
        return tabCorreo;
    }

    public void setTabCorreo(JPanel tabCorreo) {
        this.tabCorreo = tabCorreo;
    }

    public JTabbedPane getTabGeneral() {
        return tabGeneral;
    }

    public void setTabGeneral(JTabbedPane tabGeneral) {
        this.tabGeneral = tabGeneral;
    }

    public JPanel getTabSMS() {
        return tabSMS;
    }

    public void setTabSMS(JPanel tabSMS) {
        this.tabSMS = tabSMS;
    }

    public JPanel getTabWhatsaap() {
        return tabWhatsaap;
    }

    public void setTabWhatsaap(JPanel tabWhatsaap) {
        this.tabWhatsaap = tabWhatsaap;
    }

    public JTable getTablaCorreo() {
        return tablaCorreo;
    }

    public void setTablaCorreo(JTable tablaCorreo) {
        this.tablaCorreo = tablaCorreo;
    }

    public JTable getTablaSMS() {
        return tablaSMS;
    }

    public void setTablaSMS(JTable tablaSMS) {
        this.tablaSMS = tablaSMS;
    }

    public JTable getTablaWhatsaap() {
        return tablaWhatsaap;
    }

    public void setTablaWhatsaap(JTable tablaWhatsaap) {
        this.tablaWhatsaap = tablaWhatsaap;
    }

 
    
   
}
