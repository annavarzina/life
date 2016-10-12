package controller;

import model.MainModel;
import view.InputData;
import view.MainView;

/**
 * Created by annav on 09.10.2016.
 */
public class MainController {
    public static final Integer LOCK = 0;

    private static MainModel model;
    private static MainView view;

    public MainController(){
        model = new MainModel(InputData.getGridWidth(), InputData.getGridHeight());
        view = new MainView();
        view.getControlPanel().getStartButton().addActionListener(new StartButtonController());
        view.getControlPanel().getPauseButton().addActionListener(new PauseButtonController());
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
}
