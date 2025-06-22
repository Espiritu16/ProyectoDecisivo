package tester;

import Modelo.ConexionSingleton.MantenerSession;
import Modelo.ConexionSingleton.MantenerSession;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel emailLabel = new JLabel("Correo:");
        emailField = new JTextField(20);
        
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(20);
        
        loginButton = new JButton("Iniciar sesión");

        // Añadir componentes al Frame
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Acción al hacer clic en el botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se haría el login
                String correo = emailField.getText();
                String contrasena = new String(passwordField.getPassword());
                
                // Autenticación (suponiendo que existe el método en tu SessionManager)
                MantenerSession sessionManager = MantenerSession.getInstance();
                if (sessionManager.autenticarUsuario(correo, contrasena)) {
                    // Si es exitoso, abrir la ventana principal
                   new MainFrame().setVisible(true);
                    dispose(); // Cerrar ventana de login
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}