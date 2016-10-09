package view;

import javax.swing.*;

/**
 * Created by annav on 09.10.2016.
 */
public class InputData {
    private static int gridWidth;
    private static int gridHeight;

    /*
    * Builder pattern with nested Builder class
    */
    public static class Builder {
        private int gridWidth = 10;
        private int gridHeight = 10;

        public Builder(){}

        // setters

        public synchronized Builder setGridHeight(int val) {
            this.gridHeight = val;
            return this;
        }
        public synchronized Builder setGridHeight(JTextField text) throws NumberFormatException {
            this.gridHeight = Integer.parseInt(text.getText());
            return this;
        }

        public synchronized Builder setGridWidth(int val) {
            this.gridWidth = val;
            return this;
        }
        public synchronized Builder setGridWidth(JTextField text) throws NumberFormatException{
            this.gridWidth = Integer.parseInt(text.getText());
            return this;
        }

        public InputData build() {
            return new InputData(this);
        }
    }

    // constructor
    public InputData(Builder builder) {
        setGridHeight(builder.gridHeight);
        setGridWidth(builder.gridWidth);
    }

    // getters
    public static int getGridHeight() {
        return gridHeight;
    }
    public static int getGridWidth() {
        return gridWidth;
    }

    // setters
    public static synchronized void setGridHeight(int val) {
        gridHeight = val;
    }
    public static synchronized void setGridWidth(int val) {
        gridWidth = val;
    }
}
