package Controlador.PatronProxy;

import Vista.Admin.Main.VentanaAdmin;
import Vista.Usuario.Main.VentanaUsuario;
import javax.swing.JOptionPane;

public class UsuarioProxy {

    public void abrirJFrameSegunRol(String rol) {
        if (rol.equalsIgnoreCase("Usuario")) {
            VentanaUsuario ventanaMainUsuario = new VentanaUsuario();
            ventanaMainUsuario.setVisible(true);  // Mostrar JFrame del usuario
            ventanaMainUsuario.updateUserInfo();
        } else if (rol.equalsIgnoreCase("Admin")) {
           VentanaAdmin ventanaMainAdmin= new VentanaAdmin();
           ventanaMainAdmin.setVisible(true);
           ventanaMainAdmin.updateUserInfo();
        } else {
            JOptionPane.showMessageDialog(null, "Rol no reconocido.");
        }
    }
}