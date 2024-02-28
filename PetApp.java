import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetApp {

    private static String[] petTypes = {"Dogs", "Cats", "Pigs", "Rabbit", "Bird"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Pet App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        ButtonGroup group = new ButtonGroup();
        for (String petType : petTypes) {
            JRadioButton radioButton = new JRadioButton(petType);
            radioButton.setActionCommand(petType);
            radioButton.addActionListener(new RadioButtonListener());
            group.add(radioButton);
            panel.add(radioButton);
        }

        frame.setVisible(true);
    }

    private static class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedPetType = e.getActionCommand();
            JOptionPane.showMessageDialog(null, "Selected pet type: " + selectedPetType);
        }
    }
}
