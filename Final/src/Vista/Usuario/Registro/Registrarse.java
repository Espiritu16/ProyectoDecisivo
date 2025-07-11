/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Usuario.Registro;


import Controlador.PatronFactory.CrearDAOFactory;
import Controlador.PatronFactory.CrearEntidadFactoryImpl;
import Modelo.PatronObserver.BotonObservador;
import Modelo.PatronObserver.Formulario;
import Modelo.Registro.Prototype.PrototypeDireccion;
import Modelo.Registro.Prototype.PrototypeUsuario;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

/**
 *
 * @author sankef
 */
public class Registrarse extends javax.swing.JFrame {
    
         private Formulario formulario;
        
    /**
     * Creates new form enviarNotificacion
     */
    
    public Registrarse() {
        initComponents();
        setLocationRelativeTo(null);  // Centra la ventana

        // Inicializamos el formulario
        formulario = new Formulario();

        // Crear el observador para el botón de enviar
        BotonObservador botonObservador = new BotonObservador(btnRegistrarse);
        formulario.agregarObservador(botonObservador);  // Registrar el botón como observador

        // Validar los campos al agregar CaretListener
        camposNotificacion();
        txtPais.setText("Peru");
        txtPais.setEnabled(false);
        
    }
    
   

    
    //metodo Observer
    public void camposNotificacion() {
        txtDni.addCaretListener(e -> actualizarEstadoFormulario());
        txtNombre.addCaretListener(e -> actualizarEstadoFormulario());
        txtApellido.addCaretListener(e -> actualizarEstadoFormulario());
        txtCorreo.addCaretListener(e -> actualizarEstadoFormulario());
        txtContrasena.addCaretListener(e -> actualizarEstadoFormulario());
        txtTelefono.addCaretListener(e -> actualizarEstadoFormulario());
        txtPais.addCaretListener(e -> actualizarEstadoFormulario());
        txtCiudad.addCaretListener(e -> actualizarEstadoFormulario());
        txtDistrito.addCaretListener(e -> actualizarEstadoFormulario());
        txtDireccion.addCaretListener(e -> actualizarEstadoFormulario());
        txtReferencia.addCaretListener(e -> actualizarEstadoFormulario());
        txtCodPostal.addCaretListener(e -> actualizarEstadoFormulario());
    }

    public void actualizarEstadoFormulario() {
    // Verifica que todos los campos estén llenos y sean válidos
    boolean formularioCompleto = 
        esDniValido(txtDni.getText()) &&                // Verifica que el DNI tenga 8 caracteres numéricos
        esTextoValido(txtNombre.getText()) &&           // Verifica que el nombre tenga solo letras
        esTextoValido(txtApellido.getText()) &&         // Verifica que el apellido tenga solo letras
        esCorreoValido(txtCorreo.getText()) &&          // Verifica que el correo sea válido
        esTelefonoValido(txtTelefono.getText()) &&      // Verifica que el teléfono tenga 9 dígitos
        txtPais.getText().equalsIgnoreCase("Peru") &&  // Verifica que el país sea "Peru"
        esTextoValido(txtCiudad.getText()) &&           // Verifica que la ciudad tenga solo letras
        esTextoValido(txtDistrito.getText()) &&         // Verifica que el distrito tenga solo letras
        esDireccionValida(txtDireccion.getText()) &&   // Verifica que la dirección tenga letras y números
        esDireccionValida(txtReferencia.getText()) &&       // Verifica que la referencia tenga letras y números
        esNumeroValido(txtCodPostal.getText());         // Verifica que el código postal sea numérico

    // Notificar el estado actualizado del formulario a los observadores (botones)
    formulario.setFormularioCompleto(formularioCompleto);  // Cambia el estado del formulario y notifica a los observadores
}

    // Verifica que el DNI tenga 8 caracteres numéricos
    private boolean esDniValido(String texto) {
        return texto.length() == 8 && texto.matches("[0-9]+");
    }

    // Verifica que el texto tenga solo letras y espacios
    private boolean esTextoValido(String texto) {
        return texto.matches("^[a-zA-Z\\s]+$");
    }

    // Verifica que el correo tenga formato válido
    private boolean esCorreoValido(String correo) {
        return correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Verifica que el teléfono tenga 9 dígitos
    private boolean esTelefonoValido(String telefono) {
        return telefono.matches("[0-9]{9}");
    }

    // Verifica que la dirección tenga letras, números y espacios
    private boolean esDireccionValida(String direccion) {
        return direccion.matches("^[a-zA-Z0-9\\s]+$");
    }
    // Verifica que el código postal sea numérico
    private boolean esNumeroValido(String texto) {
        return texto.matches("[0-9]+");
    }

  
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelarRegistro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Pais = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtReferencia = new javax.swing.JTextField();
        txtCodPostal = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnRegistrarse = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Registro Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        btnCancelarRegistro.setBackground(new java.awt.Color(255, 51, 0));
        btnCancelarRegistro.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        btnCancelarRegistro.setText("Cancelar Registro");
        btnCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 160, 40));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Apellido");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Correo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Telefono");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Referencia");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 100, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cod. Postal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 100, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 100, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Distrito");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 100, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Ciudad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 100, -1));

        Pais.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        Pais.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Pais.setText("Pais");
        jPanel1.add(Pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 100, 20));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 160, -1));

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 160, -1));

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 160, -1));

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 160, -1));

        txtPais.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        txtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisActionPerformed(evt);
            }
        });
        jPanel1.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 190, -1));

        txtCiudad.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 190, -1));

        txtDistrito.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 190, -1));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 190, -1));

        txtReferencia.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 190, -1));

        txtCodPostal.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtCodPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 190, -1));

        txtContrasena.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 160, -1));

        btnRegistrarse.setBackground(new java.awt.Color(153, 255, 153));
        btnRegistrarse.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 160, 40));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Dni");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txtDni.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
       

    
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    private void txtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisActionPerformed
      
    }//GEN-LAST:event_txtPaisActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
      // Paso 1: Verificar que el formulario esté completo y correcto
    if (!formulario.isFormularioCompleto()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Si el formulario no está completo, no se ejecuta el registro
    }

    // Paso 2: Crear objetos PrototypeUsuario y PrototypeDireccion con los datos del formulario
    PrototypeUsuario nuevoUsuario = new PrototypeUsuario();
    nuevoUsuario.setDni(txtDni.getText());
    nuevoUsuario.setNombre(txtNombre.getText());
    nuevoUsuario.setApellido(txtApellido.getText());
    nuevoUsuario.setCorreo(txtCorreo.getText());
    nuevoUsuario.setTelefono(txtTelefono.getText());
    nuevoUsuario.setContrasena_hash(new String(txtContrasena.getPassword()));  // Convierte la contraseña a String
    
    // Crear el objeto PrototypeDireccion
    PrototypeDireccion direccion = new PrototypeDireccion();
    direccion.setDireccion(txtDireccion.getText());
    direccion.setCiudad(txtCiudad.getText());
    direccion.setDistrito(txtDistrito.getText());
    direccion.setPais(txtPais.getText());  // Este debería ser "Peru" según las validaciones
    direccion.setCodigo_postal(txtCodPostal.getText());
    direccion.setReferencia(txtReferencia.getText());
    
    // Paso 3: Usar el Factory para registrar al usuario y su dirección
    CrearDAOFactory factory = new CrearEntidadFactoryImpl();
    
    // Registrar la dirección
    int idDireccion = factory.crearDireccion(direccion);
    if (idDireccion != -1) {  // Si la dirección se registró correctamente
        nuevoUsuario.setIdDireccion(idDireccion);  // Asignar el ID de la dirección al usuario
        
        // Registrar el usuario
        int idUsuario = factory.crearUsuario(nuevoUsuario);
        
        if (idUsuario != -1) {  // Si el usuario se registró correctamente
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            this.dispose();  // Cierra la ventana de registro
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Error al registrar la dirección.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pais;
    private javax.swing.JButton btnCancelarRegistro;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables


    

}
