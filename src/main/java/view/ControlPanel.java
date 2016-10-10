package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by annav on 09.10.2016.
 */
public class ControlPanel extends JPanel{
    private static final Insets normalInsets = new Insets(10, 10, 0, 10);//specifies the space that a container must leave at each of its edges
    private JPanel panel;
    private JButton startButton;
    private JToggleButton pauseButton;
    private JTextField scoreField;
    //restart
    //change size
    //iteration time

    /*
     * Creates the control panel with score text field and
     * two buttons
     */
    public ControlPanel(){
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridBagLayout());
        int gridy = 0;

        // score field
        JLabel scoreLabel = new JLabel("Alive cells");
        Font labelFont = innerPanel.getFont().deriveFont(24.0F);
        scoreLabel.setFont(labelFont);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        addComponent(innerPanel, scoreLabel, 0, gridy++, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        scoreField = new JTextField(6);
        scoreField.setEditable(false);
        Font textFont = innerPanel.getFont().deriveFont(30.0F);
        scoreField.setFont(textFont);
        scoreField.setHorizontalAlignment(JTextField.CENTER);
        //String str = model.getFormattedScore();
        //scoreField.setText(str);
        addComponent(innerPanel, scoreField, 0, gridy++, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        startButton = new JButton("Start");

        //startButton.addActionListener(new StartButtonController(frame));
        addComponent(innerPanel, startButton, 0, gridy++, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        pauseButton = new JToggleButton("Pause");

        //pauseButton.addActionListener(new PauseButtonController());
        addComponent(innerPanel, pauseButton, 0, gridy++, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        this.add(innerPanel);
    }

    // adds components to the panel
    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    //start button getter
    public JButton getStartButton() {
        return startButton;
    }
    //pause button getter
    public JToggleButton getPauseButton() {
        return pauseButton;
    }
    //pause button setter
    public void setPauseButton(boolean selected) {
        this.pauseButton.setSelected(selected);
    }
    //score text setter
    public void setScoreText(String scoreText) {
        this.scoreField.setText(scoreText);
    }

}
