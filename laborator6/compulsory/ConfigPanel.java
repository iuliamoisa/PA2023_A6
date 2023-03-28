package org.example;

import javax.swing.*;
import javax.swing.JLabel;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        // spinner = a single line input field that allows the user to select a number or an object value from an ordered sequence
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));


        linesLabel = new JLabel("Line probability:");
        String[] opt = {"0.1", "0.2","0.3", "0.4","0.5", "0.6", "0.7", "0.8", "0.9", "1"};
        linesCombo = new JComboBox<>(opt);
        createButton = new JButton("Create new game");
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}
