package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by annav on 09.10.2016.
 */
public class BoardPanel extends JPanel {
    private static final int BORDERWIDTH = 2;
    public static final int CELL_SIZE = 20;
    public static final int CANVAS_WIDTH = CELL_SIZE * InputData.getGridWidth(); // Game board width/height
    public static final int CANVAS_HEIGHT = CELL_SIZE * InputData.getGridHeight();

    public BoardPanel() {
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, BORDERWIDTH);
        this.setBorder(border);
        this.setPreferredSize(getPreferredSize());
    }

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
}
