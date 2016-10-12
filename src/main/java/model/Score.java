package model;

import controller.StartButtonController;

import java.text.NumberFormat;

/**
 * Created by annav on 12.10.2016.
 */
public class Score {

    private static int points = 0;

    public Score(){};

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int points) {
        Score.points = points;
    }

    public synchronized static int incrementPoint(){
        return ++points;
    }

    public synchronized static int decrementPoint(){
        return --points;
    }

    public String getFormattedScore() {
        NumberFormat nf = NumberFormat.getInstance();
        int score = Score.getPoints();
        return nf.format(score);
    }

}

