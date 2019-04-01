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
public class ModelEdit extends java.util.Observable {
private static Stage stage;

    public static void setStage(Stage stage) {
        ModelEdit.stage = stage;
    }
    private static ModelEdit instance = null;
    private static Datas data=null;
    private ModelEdit() {
        this.data=Datas.getInstance();

    }

    public static ModelEdit getInstance() {
        if (instance == null) {
            instance = new ModelEdit();

        }
        return instance;
    }

    public void edit(String type) {
      //  try {
           /* FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewEdit.fxml"));
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGroupe.fxml"));
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewContact.fxml"));
            Parent root = loader.load();

            //ricevo il View Controller
            //ricevo il View Controller
            //ModelAgenda myModelAgenda = new ModelAgenda();
            Controller myController = Controller.getInstance();
            //myController.addModel(myModelEdit);
            View ViewCtrl = (View) loader.getController();
            ViewCtrl.addController(myController);

            this.addObserver(ViewCtrl);

            myController.initModelEdit();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            // Image image = new Image("/icons/Calculator.png");
            //stage.getIcons().add(image);
            stage.setTitle(type);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();*/
            
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
