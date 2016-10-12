package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * Created by annav on 09.10.2016.
 */
public class CellPanel extends JPanel{
    private Color defaultBackground;
    private int row;
    private int col;

    HashMap<Point, Boolean> currentCellState;

    // enter row and col in constructor
    public CellPanel(final int row, final int col) {
        this.row = row;
        this.col = col;
        defaultBackground = Color.LIGHT_GRAY;
        this.setBackground(defaultBackground);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (getBackground() == Color.GREEN){
                    setBackground(defaultBackground);
                    //System.out.println("GRAY: " + row +' ' + col);
                    setCurrentCellState(MainController.getModel().getCurrentCellStateMap());
                    putKeyValue(currentCellState,new Point(row,col),false);
                    MainController.getModel().setCurrentCellStateMap(currentCellState);
                } else {
                    //defaultBackground = getBackground();
                    setBackground(Color.GREEN);
                    //System.out.println("Green: " + row +' ' + col);
                    setCurrentCellState(MainController.getModel().getCurrentCellStateMap());
                    putKeyValue(currentCellState,new Point(row,col),true);
                    MainController.getModel().setCurrentCellStateMap(currentCellState);
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


    public static synchronized void putKeyValue(HashMap<Point,Boolean> cellsState, Point point, Boolean bool) {
        cellsState.put(point, bool);
    }

    public Color getDefaultBackground(){
        return defaultBackground;
    }



    public HashMap<Point, Boolean> getCurrentCellState() {
        return currentCellState;
    }

    public void setCurrentCellState(HashMap<Point, Boolean> currentCellState) {
        this.currentCellState = currentCellState;
    }
}
