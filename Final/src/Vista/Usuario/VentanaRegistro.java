package Vista.Usuario;

import Modelo.Command.AnteriorCommand;
import Modelo.Command.Command;
import Modelo.Command.FinalizarCommand;
import Modelo.Command.SiguienteCommand;
import Modelo.ConexionSingleton.MantenerSession;
import Modelo.Observer.BotonObservador;
import Modelo.Observer.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author sankef
 */
public class VentanaRegistro extends javax.swing.JPanel {
    
    private Formulario formulario; 
    private Formulario formulario2;
    private Formulario formulario3;
    

    /**
     * Creates new form VentanaRegistro
     */
    public VentanaRegistro() {
        
        initComponents();
        txtNombreClaResiduo.requestFocusInWindow();  // Esto hace que el campo obtenga el foco y el usuario pueda empezar a escribir directamente
        txtNombreResiduo.requestFocusInWindow();  // Esto hace que el campo obtenga el foco y el usuario pueda empezar a escribir directamente
        // Inicializamos el sujeto (Formulario)
        formulario = new Formulario();
        formulario2 = new Formulario();
        formulario3 = new Formulario();
        
        //deshabilitar los botones
        btnSiguiente1.setEnabled(false);
        btnSiguiente2.setEnabled(false);
        btnFinalizar.setEnabled(false);
        
        
        // Crear un observador para el botón y lo registramos en el sujeto
        BotonObservador botonObservador = new BotonObservador(this.btnSiguiente1);
        formulario.agregarObservador(botonObservador);  // Registrar el botón como observador
        // Configurar los eventos para los campos de texto del Paso 1
        camposPaso1();
        
        BotonObservador botonObservador2 = new BotonObservador(this.btnSiguiente2);
        formulario2.agregarObservador(botonObservador2);  // Registrar el botón como observador
        camposPaso2();
       
        BotonObservador botonObservador3 = new BotonObservador(this.btnFinalizar);
        formulario3.agregarObservador(botonObservador3);  // Registrar el botón como observador
        camposPaso3();
        
        // Creamos los comandos para los botones
        Command siguienteCommand = new SiguienteCommand(jTabbedPane1);
        Command anteriorCommand = new AnteriorCommand(jTabbedPane1);
        
        //botones anterior y siguientes bloqueados para el ingreso de usuario
        btnAnterior1.setEnabled(false);
        btnAnterior2.setEnabled(false);
        
        // Asignamos los comandos a los botones correspondientes: command
        btnSiguiente1.addActionListener(e -> siguienteCommand.execute());
        btnSiguiente2.addActionListener(e -> siguienteCommand.execute()); // Para el botón de Siguiente en el paso 2
        btnAnterior1.addActionListener(e -> anteriorCommand.execute());
        btnAnterior2.addActionListener(e -> anteriorCommand.execute()); // Para el botón de Anterior en el paso 2
        btnAnterior3.addActionListener(e -> anteriorCommand.execute()); // Para el botón de Anterior en el paso 2
        
        //Asignamos el comando command para finalizar el registro
        FinalizarCommand finalizarCommand = new FinalizarCommand(this);
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCommand.execute();  // Ejecuta el comando cuando se hace clic en el botón Finalizar
            }
        });
    
        // Bloqueamos el Tab 1 y habilitamos solo los Tab 2 y 3
        jTabbedPane1.setEnabledAt(0, false); // Deshabilitar el Tab 1 (Paso 1)
        jTabbedPane1.setEnabledAt(1, true);  // Habilitar el Tab 2 (Clasificación)
        jTabbedPane1.setEnabledAt(2, true);  // Habilitar el Tab 3 (Residuo)
        
        guardar();
    }
    
    public void guardar(){
         // Obtener el idUsuario de la sesión
        MantenerSession sessionManager = MantenerSession.getInstance();
        if (sessionManager.isUserLoggedIn()) {
            // Guardar el idUsuario desde la sesión
            int idUsuario = sessionManager.getIdUsuario();
            System.out.println("ID Usuario: " + idUsuario); // Opcional, para verificar
        }
    }
    
    
    private void habilitarTabs() {
        // Habilitar el Tab 2 (Clasificación) cuando se llega al paso de clasificación
        jTabbedPane1.setEnabledAt(1, true);  // Habilitar el tab 2

        // Habilitar el Tab 3 (Residuo) cuando el usuario complete el paso de clasificación
        jTabbedPane1.setEnabledAt(2, true);  // Habilitar el tab 3
    }

    private void bloquearTabs() {
        // Deshabilitar el Tab 2 y Tab 3 mientras no estén completos
        jTabbedPane1.setEnabledAt(1, false);  // Deshabilitar el tab 2 (Clasificación)
        jTabbedPane1.setEnabledAt(2, false);  // Deshabilitar el tab 3 (Residuo)
    }
     
    
    //limpiar los campos una vez registrado el residuo
    public void limpiarCampos() {
        // Limpiar campos de texto en el formulario 1
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtPais.setText("");
        txtCiudad.setText("");
        txtDistrito.setText("");
        txtDireccion.setText("");
        txtPostal.setText("");
        txtReferencia.setText("");
        txtContraseña.setText("");

        // Limpiar campos de texto en el formulario 2
        txtNombreClaResiduo.setText("");
        txtDescripcionClaResiduo.setText("");
        txtIconoClaResiduo.setText("");
        boxColor.setSelectedIndex(0); // Restablecer el combo de colores

        // Limpiar campos de texto en el formulario 3
        txtNombreResiduo.setText("");
        txtDescripcionResiduo.setText("");
        txtPesoResiduo.setText("");
        comboPeligrosidad.setSelectedIndex(0); // Restablecer el combo de peligrosidad
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPaso1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Pais = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtPostal = new javax.swing.JTextField();
        txtReferencia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnAnterior1 = new javax.swing.JButton();
        btnSiguiente1 = new javax.swing.JButton();
        panelPaso2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Nombre = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreClaResiduo = new javax.swing.JTextField();
        txtDescripcionClaResiduo = new javax.swing.JTextField();
        txtIconoClaResiduo = new javax.swing.JTextField();
        boxColor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        btnAnterior2 = new javax.swing.JButton();
        btnSiguiente2 = new javax.swing.JButton();
        panelPaso3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombreResiduo = new javax.swing.JTextField();
        txtDescripcionResiduo = new javax.swing.JTextField();
        txtPesoResiduo = new javax.swing.JTextField();
        comboPeligrosidad = new javax.swing.JComboBox<>();
        btnAnterior3 = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 153));
        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(700, 400));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(700, 400));

        panelPaso1.setBackground(new java.awt.Color(255, 204, 204));
        panelPaso1.setMaximumSize(new java.awt.Dimension(700, 400));
        panelPaso1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pais.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Pais.setText("Pais");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setText("Ciudad");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel8.setText("Distrito");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setText("Direccion");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setText("Cod. Postal");

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel11.setText("Referencia");

        txtPais.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtCiudad.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtDistrito.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtPostal.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtReferencia.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelPaso1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 16, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setText("Correo");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel4.setText("Telefono");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setText("Contraseña");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        txtContraseña.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellido))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreo))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txtContraseña)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        panelPaso1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 16, -1, -1));

        btnAnterior1.setBackground(new java.awt.Color(255, 51, 51));
        btnAnterior1.setText("Anterior");
        panelPaso1.add(btnAnterior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 317, 108, 33));

        btnSiguiente1.setBackground(new java.awt.Color(51, 204, 255));
        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });
        panelPaso1.add(btnSiguiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 317, 108, 33));

        jTabbedPane1.addTab("Paso 1 (usuario y direccion )", panelPaso1);

        panelPaso2.setBackground(new java.awt.Color(255, 204, 204));
        panelPaso2.setMaximumSize(new java.awt.Dimension(700, 400));
        panelPaso2.setMinimumSize(new java.awt.Dimension(700, 400));
        panelPaso2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Nombre.setText("Nombre");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 75, 27));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setText("Descripcion");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 91, 27));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setText("Icono");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 75, 27));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setText("Color");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 75, 27));

        txtNombreClaResiduo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtNombreClaResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 181, -1));

        txtDescripcionClaResiduo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtDescripcionClaResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 180, -1));

        txtIconoClaResiduo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel1.add(txtIconoClaResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 181, -1));

        boxColor.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        boxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Azul", "Blanco", "Rojo", "Verde" }));
        boxColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxColorItemStateChanged(evt);
            }
        });
        boxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxColorActionPerformed(evt);
            }
        });
        jPanel1.add(boxColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 180, 30));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        lblColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 140, 240));

        panelPaso2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 610, 300));

        btnAnterior2.setBackground(new java.awt.Color(255, 51, 51));
        btnAnterior2.setText("Anterior");
        btnAnterior2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior2ActionPerformed(evt);
            }
        });
        panelPaso2.add(btnAnterior2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 108, 32));

        btnSiguiente2.setBackground(new java.awt.Color(51, 204, 255));
        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });
        panelPaso2.add(btnSiguiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 108, 32));

        jTabbedPane1.addTab("Paso 2 ( Clasificacion de residuo )", panelPaso2);

        panelPaso3.setBackground(new java.awt.Color(255, 204, 204));
        panelPaso3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setText("Nombre");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 25, 75, 27));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel16.setText("Descripcion");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 64, -1, 27));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel17.setText("Peso");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 103, 75, 27));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel18.setText("Peligrosidad");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 142, 90, 27));

        txtNombreResiduo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel7.add(txtNombreResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 27, 220, -1));

        txtDescripcionResiduo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel7.add(txtDescripcionResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 66, 220, -1));

        txtPesoResiduo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jPanel7.add(txtPesoResiduo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 105, 220, -1));

        comboPeligrosidad.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        comboPeligrosidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Manejo Especial", "Manejo Regular", "Manejo Básico", "Sin Manejo Especial" }));
        jPanel7.add(comboPeligrosidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 144, 220, -1));

        panelPaso3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 380, 250));

        btnAnterior3.setBackground(new java.awt.Color(255, 51, 51));
        btnAnterior3.setText("Anterior");
        btnAnterior3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior3ActionPerformed(evt);
            }
        });
        panelPaso3.add(btnAnterior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 108, 33));

        btnFinalizar.setBackground(new java.awt.Color(255, 255, 51));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        panelPaso3.add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 108, 33));

        jTabbedPane1.addTab("Paso 3 ( Residuo )", panelPaso3);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 470));
    }// </editor-fold>//GEN-END:initComponents

    //boton siguiente del panel 1
    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed
         // Cambiar al Tab 2 (Clasificación de Residuo)
    jTabbedPane1.setSelectedIndex(1); // Cambiar al Tab 2
    
    // Habilitar el Tab 2 (Clasificación de Residuo)
    jTabbedPane1.setEnabledAt(1, true);  // Habilitar el tab 2 (Clasificación)
    
    // Deshabilitar el Tab 3 (Residuo) hasta que el usuario complete el paso 2
    jTabbedPane1.setEnabledAt(2, false);  // Deshabilitar el tab 3 (Residuo)
    
    // Deshabilitar el Tab 1 (Usuario y Dirección) para evitar que el usuario vuelva atrás
    jTabbedPane1.setEnabledAt(0, false);  // Deshabilitar el tab 1 (Usuario y Dirección)
    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    //boton siguiente del panel 2
    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
    // Cambiar al Tab 3 (Residuo)
    jTabbedPane1.setSelectedIndex(2); // Cambiar al Tab 3
    
    // Habilitar el Tab 3 (Residuo)
    jTabbedPane1.setEnabledAt(2, true);  // Habilitar el tab 3 (Residuo)
    
    // Deshabilitar el Tab 2 (Clasificación de Residuo) para evitar que el usuario vuelva atrás
    jTabbedPane1.setEnabledAt(1, false);  // Deshabilitar el tab 2 (Clasificación de Residuo)
    btnFinalizar.setEnabled(true);
    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    //finalizar con el registro
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
         // Cambiar al Tab 2 (Clasificación de Residuo)
    jTabbedPane1.setSelectedIndex(1); // Cambiar al Tab 2
    
    // Habilitar el Tab 2 (Clasificación de Residuo)
    jTabbedPane1.setEnabledAt(1, true);  // Habilitar el tab 2 (Clasificación)
    
    // Deshabilitar el Tab 3 (Residuo) hasta que el usuario complete el paso 2
    jTabbedPane1.setEnabledAt(2, false);  // Deshabilitar el tab 3 (Residuo)
    
    // Deshabilitar el Tab 1 (Usuario y Dirección) para evitar que el usuario vuelva atrás
    jTabbedPane1.setEnabledAt(0, false);  // Deshabilitar el tab 1 (Usuario y Dirección)
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void boxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxColorActionPerformed

    }//GEN-LAST:event_boxColorActionPerformed

    //seleccionar imagen
    private void boxColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxColorItemStateChanged
        int psc;
        String dirImg;
        URL url = null;

        psc = boxColor.getSelectedIndex();

        if (psc == 0) {  // Amarillo
            dirImg = "";  // Cambia esto por la ruta correcta
        } else if (psc == 1) {  // Azul
            dirImg = "/imagenes/azulEditado.png";  // Cambia esto por la ruta correcta
        } else if (psc == 2) {  // Negro
            dirImg = "/imagenes/blancoEditado.png";  // Cambia esto por la ruta correcta
        } else if (psc == 3) {  // Verde
            dirImg = "/imagenes/rojoEditado.png";  // Cambia esto por la ruta correcta
        } else if (psc == 4) {  // Verde
            dirImg = "/imagenes/verdeEditado.png";  // Cambia esto por la ruta correcta
        } else {
            dirImg = "";  // No hay imagen seleccionada
        }

        if (!dirImg.isEmpty()) {
            // Obtener la URL de la imagen desde el paquete de recursos
            url = this.getClass().getResource(dirImg);
            if (url != null) {
                ImageIcon img = new ImageIcon(url);
                lblColor.setIcon(img);
            } else {
                System.out.println("Error al cargar la imagen: " + dirImg);
            }
        }

    }//GEN-LAST:event_boxColorItemStateChanged

    private void btnAnterior2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior2ActionPerformed
       // Cambiar al Tab 2 (Clasificación de Residuo)
      jTabbedPane1.setSelectedIndex(1); // Cambiar al Tab 2

      // Habilitar el Tab 2 (Clasificación de Residuo)
      jTabbedPane1.setEnabledAt(1, true);  // Habilitar el Tab 2 (Clasificación de Residuo)

      // Deshabilitar el Tab 0 (Usuario y Dirección) para evitar que el usuario vuelva atrás
      jTabbedPane1.setEnabledAt(0, false);  // Deshabilitar el Tab 0 (Usuario y Dirección)

      // Deshabilitar el Tab 3 (Residuo) para evitar que el usuario vuelva atrás
      jTabbedPane1.setEnabledAt(2, false);  // Deshabilitar el Tab 3 (Residuo)
    }//GEN-LAST:event_btnAnterior2ActionPerformed

    private void btnAnterior3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior3ActionPerformed
    // Cambiar al Tab 2 (Clasificación de Residuo)
    jTabbedPane1.setSelectedIndex(1); // Cambiar al Tab 2
    
    // Habilitar el Tab 2 (Clasificación de Residuo)
    jTabbedPane1.setEnabledAt(1, true);  // Habilitar el tab 2 (Clasificación de Residuo)
    
    // Deshabilitar el Tab 1 (Usuario y Dirección) para evitar que el usuario vuelva atrás
    jTabbedPane1.setEnabledAt(0, false);  // Deshabilitar el tab 1 (Usuario y Dirección)
    
    // Deshabilitar el Tab 3 (Residuo) para evitar que el usuario vuelva atrás
    jTabbedPane1.setEnabledAt(2, false);  // Deshabilitar el tab 3 (Residuo)
    }//GEN-LAST:event_btnAnterior3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Pais;
    private javax.swing.JComboBox<String> boxColor;
    private javax.swing.JButton btnAnterior1;
    private javax.swing.JButton btnAnterior2;
    private javax.swing.JButton btnAnterior3;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JComboBox<String> comboPeligrosidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JPanel panelPaso1;
    private javax.swing.JPanel panelPaso2;
    private javax.swing.JPanel panelPaso3;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcionClaResiduo;
    private javax.swing.JTextField txtDescripcionResiduo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtIconoClaResiduo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreClaResiduo;
    private javax.swing.JTextField txtNombreResiduo;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPesoResiduo;
    private javax.swing.JTextField txtPostal;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

 
    public void camposPaso1(){
        txtNombre.addCaretListener(e -> actualizarEstadoFormulario());
        txtApellido.addCaretListener(e -> actualizarEstadoFormulario());
        txtCorreo.addCaretListener(e -> actualizarEstadoFormulario());
        txtTelefono.addCaretListener(e -> actualizarEstadoFormulario());
        txtPais.addCaretListener(e -> actualizarEstadoFormulario());
        txtCiudad.addCaretListener(e -> actualizarEstadoFormulario());
        txtDistrito.addCaretListener(e -> actualizarEstadoFormulario());
        txtDireccion.addCaretListener(e -> actualizarEstadoFormulario());
        txtPostal.addCaretListener(e -> actualizarEstadoFormulario());
        txtReferencia.addCaretListener(e -> actualizarEstadoFormulario());
        txtContraseña.addCaretListener(e -> actualizarEstadoFormulario());
        
        
    }
    // Actualizar el estado del formulario cada vez que un campo cambie
    public void actualizarEstadoFormulario() {
        // Verifica que todos los campos estén llenos
        boolean formularioCompleto = !txtNombre.getText().isEmpty() &&
                                      !txtApellido.getText().isEmpty() &&
                                      !txtCorreo.getText().isEmpty() &&
                                      !txtTelefono.getText().isEmpty() &&
                                      !txtPais.getText().isEmpty() &&
                                      !txtCiudad.getText().isEmpty() &&
                                      !txtDistrito.getText().isEmpty() &&
                                      !txtDireccion.getText().isEmpty() &&
                                      !txtPostal.getText().isEmpty() &&
                                      !txtReferencia.getText().isEmpty() &&
                                      !new String(txtContraseña.getPassword()).isEmpty(); // Verifica que la contraseña no esté vacía
        // Notificar el estado actualizado del formulario a los observadores (botones)
        formulario.setFormularioCompleto(formularioCompleto);  // Cambia el estado del formulario y notifica a los observadores
    }
    
     public void camposPaso2(){
         // --- ¡Añade CaretListener a los nuevos campos! ---
         txtDescripcionClaResiduo.addCaretListener(e -> actualizarCampo2());
         txtIconoClaResiduo.addCaretListener(e -> actualizarCampo2());
         txtNombreClaResiduo.addCaretListener(e -> actualizarCampo2());
         boxColor.addActionListener(e -> actualizarCampo2());  // Añadir un ActionListener al JComboBox de color
     }

    public void actualizarCampo2() {
        // Verifica que todos los campos estén llenos y sean válidos
        boolean formularioCompleto2 = 
        !txtDescripcionClaResiduo.getText().isEmpty() &&
        !txtIconoClaResiduo.getText().isEmpty() &&
        !txtNombreClaResiduo.getText().isEmpty() &&
        boxColor.getSelectedIndex() != 0 &&  // Verifica que se haya seleccionado un color
        !txtDescripcionClaResiduo.getText().isEmpty()  &&  // Validar que la descripción no sea solo números
        esTextoValido(txtNombreClaResiduo.getText());  // Validar que el nombre no sea solo números

        // Notificar el estado actualizado del formulario a los observadores (botones)
        formulario2.setFormularioCompleto(formularioCompleto2);  // Cambia el estado del formulario y notifica a los observadores
    }

    // Método de validación para asegurar que el campo contiene solo texto
    private boolean esTextoValido(String texto) {
        // Valida que el texto no sea solo números (expresión regular)
        return texto.matches("[A-Za-záéíóúÁÉÍÓÚÑñ ]+");  // Solo letras y espacios
    }

    
    //campos 3
     public void camposPaso3(){
        // --- ¡Añade CaretListener a los nuevos campos! ---
        txtDescripcionResiduo.addCaretListener(e -> actualizarCampo3());
        comboPeligrosidad.addActionListener(e -> actualizarCampo3());
        txtNombreResiduo.addCaretListener(e -> actualizarCampo3());
        txtPesoResiduo.addCaretListener(e -> actualizarCampo3());
    }
     
    public void actualizarCampo3() {
        // Verifica que todos los campos estén llenos y sean válidos
        boolean formularioCompleto3 = 
        !txtDescripcionResiduo.getText().isEmpty() &&
        comboPeligrosidad.getSelectedIndex() != 0 &&  // Verifica que se haya seleccionado una opción de peligrosidad
        esTextoValido(txtNombreResiduo.getText()) &&
        !txtPesoResiduo.getText().isEmpty() &&  // Asegura que el peso no esté vacío
        esNumeroValido(txtPesoResiduo.getText());  // Validar que el peso sea un número

        // Notificar el estado actualizado del formulario a los observadores (botones)
        formulario3.setFormularioCompleto(formularioCompleto3);  // Cambia el estado del formulario y notifica a los observadores
    }

    // Método de validación para asegurar que el campo contiene un número válido
    private boolean esNumeroValido(String texto) {
        try {
            Double.parseDouble(texto);  // Intenta convertir a número decimal
            return true;
        } catch (NumberFormatException e) {
            return false;  // Si no puede convertirlo, entonces no es válido
        }
    }
     
     
     
     
     
     
     
     
   public JTabbedPane getTabbedPane() {
    return jTabbedPane1; // Retorna el JTabbedPane
}

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Formulario getFormulario2() {
        return formulario2;
    }

    public void setFormulario2(Formulario formulario2) {
        this.formulario2 = formulario2;
    }

    public Formulario getFormulario3() {
        return formulario3;
    }

    public void setFormulario3(Formulario formulario3) {
        this.formulario3 = formulario3;
    }

    public JLabel getNombre() {
        return Nombre;
    }

    public void setNombre(JLabel Nombre) {
        this.Nombre = Nombre;
    }

    public JLabel getPais() {
        return Pais;
    }

    public void setPais(JLabel Pais) {
        this.Pais = Pais;
    }

    public JComboBox<String> getBoxColor() {
        return boxColor;
    }

    public void setBoxColor(JComboBox<String> boxColor) {
        this.boxColor = boxColor;
    }

    public JButton getBtnAnterior1() {
        return btnAnterior1;
    }

    public void setBtnAnterior1(JButton btnAnterior1) {
        this.btnAnterior1 = btnAnterior1;
    }

    public JButton getBtnAnterior2() {
        return btnAnterior2;
    }

    public void setBtnAnterior2(JButton btnAnterior2) {
        this.btnAnterior2 = btnAnterior2;
    }

    public JButton getBtnAnterior3() {
        return btnAnterior3;
    }

    public void setBtnAnterior3(JButton btnAnterior3) {
        this.btnAnterior3 = btnAnterior3;
    }

    public JButton getBtnFinalizar() {
        return btnFinalizar;
    }

    public void setBtnFinalizar(JButton btnFinalizar) {
        this.btnFinalizar = btnFinalizar;
    }

    public JButton getBtnSiguiente1() {
        return btnSiguiente1;
    }

    public void setBtnSiguiente1(JButton btnSiguiente1) {
        this.btnSiguiente1 = btnSiguiente1;
    }

    public JButton getBtnSiguiente2() {
        return btnSiguiente2;
    }

    public void setBtnSiguiente2(JButton btnSiguiente2) {
        this.btnSiguiente2 = btnSiguiente2;
    }

    public JComboBox<String> getComboPeligrosidad() {
        return comboPeligrosidad;
    }

    public void setComboPeligrosidad(JComboBox<String> comboPeligrosidad) {
        this.comboPeligrosidad = comboPeligrosidad;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JPanel getPanelPaso1() {
        return panelPaso1;
    }

    public void setPanelPaso1(JPanel panelPaso1) {
        this.panelPaso1 = panelPaso1;
    }

    public JPanel getPanelPaso2() {
        return panelPaso2;
    }

    public void setPanelPaso2(JPanel panelPaso2) {
        this.panelPaso2 = panelPaso2;
    }

    public JPanel getPanelPaso3() {
        return panelPaso3;
    }

    public void setPanelPaso3(JPanel panelPaso3) {
        this.panelPaso3 = panelPaso3;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(JTextField txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public JPasswordField getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(JPasswordField txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JTextField getTxtDescripcionClaResiduo() {
        return txtDescripcionClaResiduo;
    }

    public void setTxtDescripcionClaResiduo(JTextField txtDescripcionClaResiduo) {
        this.txtDescripcionClaResiduo = txtDescripcionClaResiduo;
    }

    public JTextField getTxtDescripcionResiduo() {
        return txtDescripcionResiduo;
    }

    public void setTxtDescripcionResiduo(JTextField txtDescripcionResiduo) {
        this.txtDescripcionResiduo = txtDescripcionResiduo;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtDistrito() {
        return txtDistrito;
    }

    public void setTxtDistrito(JTextField txtDistrito) {
        this.txtDistrito = txtDistrito;
    }

    public JTextField getTxtIconoClaResiduo() {
        return txtIconoClaResiduo;
    }

    public void setTxtIconoClaResiduo(JTextField txtIconoClaResiduo) {
        this.txtIconoClaResiduo = txtIconoClaResiduo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtNombreClaResiduo() {
        return txtNombreClaResiduo;
    }

    public void setTxtNombreClaResiduo(JTextField txtNombreClaResiduo) {
        this.txtNombreClaResiduo = txtNombreClaResiduo;
    }

    public JTextField getTxtNombreResiduo() {
        return txtNombreResiduo;
    }

    public void setTxtNombreResiduo(JTextField txtNombreResiduo) {
        this.txtNombreResiduo = txtNombreResiduo;
    }

    public JTextField getTxtPais() {
        return txtPais;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    public JTextField getTxtPesoResiduo() {
        return txtPesoResiduo;
    }

    public void setTxtPesoResiduo(JTextField txtPesoResiduo) {
        this.txtPesoResiduo = txtPesoResiduo;
    }

    public JTextField getTxtPostal() {
        return txtPostal;
    }

    public void setTxtPostal(JTextField txtPostal) {
        this.txtPostal = txtPostal;
    }

    public JTextField getTxtReferencia() {
        return txtReferencia;
    }

    public void setTxtReferencia(JTextField txtReferencia) {
        this.txtReferencia = txtReferencia;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }
   
   
   
}
