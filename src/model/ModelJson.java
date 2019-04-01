/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import entity.Datas;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.View;

/**
 *
 * @author pom
 */
public class ModelJson extends java.util.Observable {

    private static Stage stage;

    private static ModelJson instance = null;
    private static Datas data = null;

    public static void setStage(Stage stage) {
        ModelJson.stage = stage;
    }

    private ModelJson() {
        this.data = Datas.getInstance();

    }

    public static ModelJson getInstance() {
        if (instance == null) {
            instance = new ModelJson();

        }
        return instance;
    }

    public void edit(String type) {
        
        data.setShowViewListe(false);
        init();

        //  } catch (IOException e) {
        // }
    }

    public void init() {
        setChanged();
        notifyObservers(data);
    }
}
