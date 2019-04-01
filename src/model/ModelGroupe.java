/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Datas;

import javafx.stage.Stage;


/**
 *
 * @author pom
 */
public class ModelGroupe extends java.util.Observable {
private static Stage stage;

    public static void setStage(Stage stage) {
        ModelGroupe.stage = stage;
    }
    private static ModelGroupe instance = null;
    private static Datas data=null;
    private ModelGroupe() {
        this.data=Datas.getInstance();

    }

    public static ModelGroupe getInstance() {
        if (instance == null) {
            instance = new ModelGroupe();

        }
        return instance;
    }

    public void edit(String type) {
     
            data.switchView(false, true, false);
            data.formulaire.setEditable(true);
            init();
    }

    public void init() {
         setChanged();
        notifyObservers(data);
    }
}
