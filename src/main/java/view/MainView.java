package view;

import javax.swing.*;

/**
 * Created by annav on 09.10.2016.
 */
public class MainView {
    private BoardPanel boardPanel;
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

        frame.add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    public JFrame getJFrame() {
        return frame;
    }
}
