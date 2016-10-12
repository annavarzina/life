package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by annav on 09.10.2016.
 */
public class BoardPanel extends JPanel {
    private static final int BORDERWIDTH = 1;
    public static final int CELL_SIZE = 20;
    private static int width = InputData.getGridWidth();
    private static int height = InputData.getGridHeight();
    public static final int CANVAS_WIDTH = CELL_SIZE * width; // Game board width/height
    public static final int CANVAS_HEIGHT = CELL_SIZE * height;

    private CellPanel[] cells = new CellPanel[width*height];

    public BoardPanel() {
        setLayout(new GridBagLayout());
        // paint a border
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                gbc.gridx = col;
                gbc.gridy = row;

                cells[(width*row)+col] = new CellPanel(row,col);
                Border border = null;
                if (row < height - 1) {
                    if (col < width -1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cells[width*row+col].setBorder(border);
                add(cells[width*row+col], gbc);
            }
        }
        this.setPreferredSize(getPreferredSize());
    }

    //getters
    // returns the preferred size of the game panel
    public Dimension getPreferredSize() {
        int width = CANVAS_WIDTH + BORDERWIDTH;
        int height = CANVAS_HEIGHT + BORDERWIDTH;
        return new Dimension(width, height);
    }

    // CELLSIZE getter
    public int getCellSize(){
        return CELL_SIZE;
    }

    public void setCellColor(CellPanel cellPanel, Color color){
        cellPanel.setBackground(color);
    }

    public void repaintCells(HashMap<Point,Boolean> cellState){
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Boolean state = cellState.get(new Point(row, col));
                if (state.equals(true)){
                    cells[width*row+ col].setBackground(Color.GREEN);
                }
                else {
                    cells[width*row+ col].setBackground(Color.LIGHT_GRAY);
                }
                cells[width*row+ col].repaint();
            }
        }
    }
}
