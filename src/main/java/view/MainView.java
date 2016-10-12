package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by annav on 09.10.2016.
 */
public class MainView {
    private BoardPanel boardPanel;
    private ControlPanel controlPanel;
    private JFrame frame;

    public MainView(){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Game of Life");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        // panel with a board
        boardPanel = new BoardPanel();
        panel.add(boardPanel);
        controlPanel = new ControlPanel();
        panel.add(controlPanel);

        frame.add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    //getters
    public JFrame getJFrame() {
        return frame;
    }

    public ControlPanel getControlPanel(){
        return controlPanel;
    }

    public BoardPanel getBoardPanel(){
        return boardPanel;
    }

    //setters




}
