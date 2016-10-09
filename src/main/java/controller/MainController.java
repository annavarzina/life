package controller;

import model.MainModel;
import view.MainView;

/**
 * Created by annav on 09.10.2016.
 */
public class MainController {
    private MainModel model;
    private MainView view;

    public MainController(){
        this.model = new MainModel();
        this.view = new MainView();
    }
}
