package Controlador.PatronCommand;

import Modelo.ISP.Command.Command;
import javax.swing.JTabbedPane;

public class SiguienteCommand implements Command {
    private JTabbedPane tabbedPane;
    
    public SiguienteCommand(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void execute() {
        int currentIndex = tabbedPane.getSelectedIndex();
        if (currentIndex < tabbedPane.getTabCount() - 1) {
            tabbedPane.setSelectedIndex(currentIndex + 1);
        }
    }
}