package tester;
import Modelo.ConexionSingleton.MantenerSession;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JLabel welcomeLabel;

    public MainFrame() {
        setTitle("Ventana Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Crear un JLabel para mostrar el nombre y correo del usuario
        welcomeLabel = new JLabel("Bienvenido");
        
        // Obtener los datos del usuario de la sesión
        MantenerSession sessionManager = MantenerSession.getInstance();
        if (sessionManager.isUserLoggedIn()) {
            // Mostrar el nombre y correo del usuario
            String nombre = sessionManager.getNombre();
            String correo = sessionManager.getCorreo();
            String rol=sessionManager.getRol();
            welcomeLabel.setText("Bienvenido " + nombre + " (" + correo + ")"+rol);
        }

        // Añadir el JLabel al frame
        add(welcomeLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Esta ventana será la ventana principal, que solo se abrirá después del login exitoso
            new MainFrame().setVisible(true);
        });
    }
}