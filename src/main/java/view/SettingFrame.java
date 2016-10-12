package view;

import controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by annav on 09.10.2016.
 *
 * An instance of this class is used to generate a frame
 * that allows user to adjust settings on a game board:
 * board width,
 * board height.
 */
public class SettingFrame extends JFrame{
    public SettingFrame() {
        setTitle("Board size settings");
        setLocationRelativeTo(null);
        setSize(300,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        //Labels

        JLabel commentLabel = new JLabel("<html>Enter the amount of cells" +
                "<br> in X and Y direction.</html>");
        commentLabel.setBounds(30,20,180,25);
        panel.add(commentLabel);

        JLabel widthLabel = new JLabel("Board's width: ");
        widthLabel.setBounds(30,70,180,25);
        panel.add(widthLabel);

        JLabel heightLabel = new JLabel("Board's height:  ");
        heightLabel.setBounds(30,100,180,25);
        panel.add(heightLabel);

        //Text Fields
        final JTextField width = new JTextField(20);
        width.setBounds(180,70,70,25);
        panel.add(width);

        final JTextField height = new JTextField(20);
        height.setBounds(180,100,70,25);
        panel.add(height);

        //Button
        JButton okBtn = new JButton("OK");
        okBtn.setBounds(90, 140, 120, 25);
        panel.add(okBtn);

        //load the board
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try{
                    new InputData.Builder().setGridHeight(height).setGridWidth(width).build();
                    if ((InputData.getGridWidth() < 2) || (InputData.getGridWidth() > 30) ) {
                        JOptionPane.showMessageDialog(new JFrame(), "Please try again and enter the width between 2 and 30.");
                        SettingFrame frame = new SettingFrame();
                        frame.setVisible(true);
                    }
                    else if ((InputData.getGridHeight() < 2) || (InputData.getGridHeight()>30) ){
                        JOptionPane.showMessageDialog(new JFrame(), "Please try again and enter the height between 2 and 30.");
                        SettingFrame frame = new SettingFrame();
                        frame.setVisible(true);
                    }
                    else {
                        // new board frame
                        new MainController();
                    }
                }
                catch (NumberFormatException err){
                    JOptionPane.showMessageDialog(new JFrame(), "Wrong input data. Please try again.");
                    SettingFrame frame = new SettingFrame();
                    frame.setVisible(true);
                }
            }
        });
    }
}
