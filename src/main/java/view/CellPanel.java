package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by annav on 09.10.2016.
 */
public class CellPanel extends JPanel{
    private Color defaultBackground;
    private int row;
    private int col;

    // enter row and col in constructor
    public CellPanel(final int row, final int col) {
        this.row = row;
        this.col = col;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (getBackground() == Color.GREEN){
                    setBackground(defaultBackground);
                    System.out.println("GRAY: " + row +' ' + col);
                    MainView.putKeyValue(MainView.getCurrentCellStateMap(),new Point(row,col),false);
                } else {
                    //defaultBackground = getBackground();
                    setBackground(Color.GREEN);
                    System.out.println("Green: " + row +' ' + col);
                    MainView.putKeyValue(MainView.getCurrentCellStateMap(),new Point(row,col),true);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!getBackground().equals(Color.GREEN)) {
                    //defaultBackground = getBackground();
                    setBackground(Color.BLUE);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (getBackground().equals(Color.BLUE)) {
                    setBackground(defaultBackground);
                }
            }

        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BoardPanel.CELL_SIZE, BoardPanel.CELL_SIZE);
    }

}
