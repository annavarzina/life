package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by annav on 12.10.2016.
 */
public class PauseButtonController implements ActionListener {

        public PauseButtonController() {}
        public static Boolean pauseButtonState = false;

        @Override
        public void actionPerformed(ActionEvent event) {
            JToggleButton button = (JToggleButton) event.getSource();
                if (button.isSelected()) {
                    pauseButtonState = true;
                } else {
                    pauseButtonState = false;
                }
        }
    }

