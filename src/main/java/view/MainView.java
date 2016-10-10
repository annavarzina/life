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
    private static HashMap<Point,Boolean> currentCellStateMap = new HashMap<Point, Boolean>();
    private static HashMap<Point,Boolean> nextCellStateMap = new HashMap<Point, Boolean>();

    public MainView(){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Game of Life");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initialize HashMaps
        //currentCellStateMap = new HashMap<Point, Boolean>();
        //nextCellStateMap = new HashMap<Point, Boolean>();
        // set initial state for the hashmaps
        setInitialZeroState(currentCellStateMap);
        setInitialZeroState(nextCellStateMap);

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

    public static HashMap<Point,Boolean> getCurrentCellStateMap(){
        return MainView.currentCellStateMap;
    }

    public static HashMap<Point,Boolean> getNextCellStateMap(){
        return MainView.nextCellStateMap;
    }


    public synchronized void setInitialZeroState(HashMap<Point,Boolean> cellMap){
        for(int row = 0; row < InputData.getGridHeight(); row++){
            for(int col = 0; col <InputData.getGridWidth(); col++){
                Point point = new Point(row, col);
                cellMap.put(point, false); //false is dead cell, true is alive cell
            }
        }
    }

    //setters
    public static synchronized void setCurrentCellStateMap(HashMap<Point,Boolean> cellState) {
        MainView.currentCellStateMap = cellState;
    }

    public static synchronized void setNextCellStateMap(HashMap<Point,Boolean> cellsState){
        MainView.nextCellStateMap = cellsState;
    }

    public static synchronized void putKeyValue(HashMap<Point,Boolean> cellsState, Point point, Boolean bool) {
        cellsState.put(point, bool);
    }
}
