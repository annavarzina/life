package model;

import view.InputData;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by annav on 09.10.2016.
 */
public class MainModel {
    // compute nearby alive cells (extra rule for the border cell) - method
    // put next state to the HashMap -method
    private HashMap<Point,Boolean> currentCellStateMap = new HashMap<Point, Boolean>();
    private HashMap<Point,Boolean> nextCellStateMap = new HashMap<Point, Boolean>();

    private int width;
    private int height;

    public MainModel(int width, int height){
        this.width = width;
        this.height = height;

        // set initial state for the hashmaps
        setInitialZeroState(currentCellStateMap);
        setNextCellStateMap(currentCellStateMap);
        //computeNextIteration();
    }

    public void computeNextIteration(){
        HashMap<Point, Boolean> map = new HashMap<Point, Boolean>();
        for(int row = 0; row < height; ++row){
            for(int col = 0; col < width; ++col){
                int counter = 0;
                if(row == 0){
                    if(col == 0){ // up-left corner case
                        for(int i = 0; i <= 1; ++i){
                            for(int j = 0; j <= 1; ++j){
                                if ((i!=0) || (j!=0)){
                                    if (this.currentCellStateMap.get(new Point(i, j))){
                                        ++counter;
                                    }
                                }
                            }
                        }
                    } else if (col == (width -1)){ // up-right corner case
                        for(int i = 0; i <= 1; ++i){
                            for(int j = (width -2); j<= (width -1); ++j){
                                if ((i!=0) || (j!=(width -1))){
                                    if (this.currentCellStateMap.get(new Point(i, j))){
                                        ++counter;
                                    }
                                }
                            }
                        }
                    } else { // upper row
                        for(int i = 0; i <= 1; ++i){
                            for(int j = (col -1); j<= (col + 1); ++j){
                                if ((i!=0) || (j!=col)){
                                    if (this.currentCellStateMap.get(new Point(i, j))){
                                        ++counter;
                                    }
                                }
                            }
                        }
                    }
                } else if (row == (height -1)){
                    if(col == 0){//bottom-left corner case
                        for(int i = (height - 2); i <= (height-1); ++i){
                            for(int j = 0; j<=1; ++j){
                                if ((i!=(height -1)) || (j!=0)){
                                    if (this.currentCellStateMap.get(new Point(i, j))){
                                        ++counter;
                                    }
                                }
                            }
                        }
                    } else if (col == (width -1)){ //bottom-right corner case
                        for(int i = (height - 2); i <= (height-1); ++i){
                            for(int j = (width -2); j<= (width -1); ++j){
                                if ((i!=(height -1)) || (j!=(width -1))){
                                    if (this.currentCellStateMap.get(new Point(i, j))){
                                        ++counter;
                                    }
                                }
                            }
                        }
                    } else {// bottom row
                        for(int i = height - 2; i <= (height-1); ++i){
                            for(int j = (col -1); j<= (col + 1); ++j){
                                if ((i!=(height -1)) || (j!=col)){
                                    if (this.currentCellStateMap.get(new Point(i, j))){
                                        ++counter;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (col == 0) { //left column
                        for (int i = (row - 1); i <= (row + 1); ++i) {
                            for (int j = 0; j <= 1; ++j) {
                                if ((i != row) || (j != 0)) {
                                    if (this.currentCellStateMap.get(new Point(i, j))) {
                                        ++counter;
                                    }
                                }
                            }
                        }
                    } else if (col == (width - 1)) { //right column
                        for (int i = (row - 1); i <= (row + 1); ++i) {
                            for (int j = (width - 2); j <= (width-1); ++j) {
                                if ((i != row) || (j != (width - 1))) {
                                    if (this.currentCellStateMap.get(new Point(i, j))) {
                                        ++counter;
                                    }
                                }
                            }
                        }
                    } else { //central cell
                        for (int i = (row - 1); i <= (row + 1); i++) {
                            for (int j = (col - 1); j <= (col + 1); j++) {
                                if ((i != row) || (j != col)) {
                                    if (this.currentCellStateMap.get(new Point(i, j))) {
                                        ++counter;
                                    }
                                }
                            }
                        }
                    }
                }
                if (counter == 2) {
                    map.put(new Point(row, col), this.currentCellStateMap.get(new Point(row, col)));
                } else if (counter == 3) {
                    map.put(new Point(row, col), true); // cell is born
                } else {
                    map.put(new Point(row, col), false); // cell is dying of congestion
                }
                //System.out.println("X = " + row + ", Y = " + col + ", counter = " + counter);
            }
        }
        setNextCellStateMap(map);
        //setNextCellStateMap(nextCellStateMap);
        System.out.println("Current cells: " + computeAliveCells(currentCellStateMap));
        System.out.println("Next cells: " + computeAliveCells(nextCellStateMap));
    }

    // getters

    public HashMap<Point,Boolean> getCurrentCellStateMap(){
        return this.currentCellStateMap;
    }

    public HashMap<Point,Boolean> getNextCellStateMap(){
        return this.nextCellStateMap;
    }

    //setters

    public void setInitialZeroState(HashMap<Point,Boolean> cellMap){
        for(int row = 0; row < InputData.getGridHeight(); ++row){
            for(int col = 0; col <InputData.getGridWidth(); ++col){
                Point point = new Point(row, col);
                cellMap.put(point, false); //false is dead cell, true is alive cell
            }
        }
    }


    public synchronized void setCurrentCellStateMap(HashMap<Point,Boolean> cellState) {
        this.currentCellStateMap = cellState;
    }

    public synchronized void setNextCellStateMap(HashMap<Point,Boolean> cellsState){
        this.nextCellStateMap = cellsState;
    }

    public synchronized void newIteration(){
        setCurrentCellStateMap(this.nextCellStateMap);
    }

    public int computeAliveCells(HashMap<Point,Boolean> map){
        int counter = 0;
        for(int i = 0; i < width; ++i){
            for(int j=0; j < height; ++j){
                if (map.get(new Point(i,j))){
                    ++counter;
                }
            }
        }
        return counter;
    }
}
