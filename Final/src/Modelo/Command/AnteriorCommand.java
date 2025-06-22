package Modelo.Command;

import javax.swing.JTabbedPane;

public class AnteriorCommand implements Command {
    private JTabbedPane tabbedPane;

    public AnteriorCommand(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void execute() {
        int currentIndex = tabbedPane.getSelectedIndex();
        if (currentIndex > 0) {
            tabbedPane.setSelectedIndex(currentIndex - 1);
        }
    }
}