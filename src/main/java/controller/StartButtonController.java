package controller;

import model.MainModel;
import model.Score;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by annav on 10.10.2016.
 */
public class StartButtonController implements ActionListener{
    private MainController controller;
    private MainModel model;
    private MainView view;

    private static Thread lifeThread;
    //private MainView view;

    public StartButtonController() {
        this.model = MainController.getModel();
        //controller = new MainController();
        lifeThread = new Thread(){
                public void run(){
                    int timer = 0;
                    do {
                        synchronized (MainController.LOCK) {
                            if (!PauseButtonController.pauseButtonState){
                                MainController.LOCK.notifyAll();
                                model.computeNextIteration();
                                model.newIteration();
                                MainController.getView().setScoreText();
                                repaint();
                                //System.out.println(++timer + " score: " + Score.getPoints());
                                try {
                                    lifeThread.sleep(4000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    MainController.LOCK.wait(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } while (true);
                };
        };
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        lifeThread.start();
    }

    // control getter
    public MainController getController() {
        return controller;
    }

    // control setter
    public void setController(MainController controller) {
        this.controller = controller;
    }

    public static Thread getLifeThread() {
        return lifeThread;
    }

    public void setLifeThread(Thread lifeThread) {
        this.lifeThread = lifeThread;
    }

    public synchronized void repaint(){
        MainController.getView().getBoardPanel().repaintCells(MainController.getModel().getNextCellStateMap());
    }
}
