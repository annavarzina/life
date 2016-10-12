package controller;

import model.MainModel;
import model.Score;
import view.InputData;
import view.MainView;

import javax.swing.*;

/**
 * Created by annav on 09.10.2016.
 */
public class MainController {
    public static final Integer LOCK = 0;

    private static MainModel model;
    private static MainView view;
    private Score points;

    public MainController(){
        model = new MainModel(InputData.getGridWidth(), InputData.getGridHeight());
        setPoints(0);
        view = new MainView();
        view.getControlPanel().getStartButton().addActionListener(new StartButtonController());
        view.getControlPanel().getPauseButton().addActionListener(new PauseButtonController());
        view.setScoreText();
    }

    public static MainModel getModel() {
        return model;
    }

    public static void setModel(MainModel model) {
        MainController.model = model;
    }


    public static MainView getView() {
        return view;
    }

    public static void setView(MainView view) {
        MainController.view = view;
    }

    public Score getPoints() {
        return this.points;
    }

    //public int getPoints(){
     //   return Score.getPoints();
    //}

    public void setPoints(int points) {
        Score.setPoints(points);
    }

}
