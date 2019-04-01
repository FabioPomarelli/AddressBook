/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Controller;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;
import model.ModelAgenda;
import model.ModelEdit;
import view.View;

/**
 *
 * @author pom
 */
public class Main extends Application {

    static final String VIEW_LISTE = "/view/ViewListe.fxml";
    static final String VIEW_EDIT = "/view/ViewEdit.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            
            
            
            startListe(true, stage);
            startEdit(false, stage);
        } catch (IOException e) {

            System.out.println("Non parto" + e.getMessage());

        }

    }
  
    public void startListe(boolean show, Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewListe.fxml"));
        Parent root = loader.load();

        //ricevo il View Controller
        //ricevo il View Controller
        ModelAgenda myModelAgenda = ModelAgenda.getInstance();
        ModelEdit myModelEdit = ModelEdit.getInstance();

        Controller myController = Controller.getInstance();
        myController.addModelAgenda(myModelAgenda);
        myController.addModelEdit(myModelEdit);

        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(myController);

        myModelAgenda.addObserver(ViewCtrl);

        
        myModelAgenda.setStage(stage);
        // Image image = new Image("/icons/Calculator.png");
        //stage.getIcons().add(image);
        Scene scene = new Scene(root);
        stage.setTitle("Agenda");
        stage.setResizable(false);
        stage.setScene(scene);
        if (show) {

            stage.show();
            //  
        } else {
            stage.hide();
        }
        myController.initModelAgenda();
        myController.initModelEdit();

    }

    public void startEdit(boolean show, Stage stage1) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewEdit.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGroupe.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewContact.fxml"));
        Parent root = loader.load();

        //ricevo il View Controller
        //ricevo il View Controller
        ModelEdit myModelEdit = ModelEdit.getInstance();
        Controller myController = Controller.getInstance();
        //myController.addModel(myModelEdit);
        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(myController);

        myModelEdit.addObserver(ViewCtrl);
        
        

        //Stage stage = new Stage();
        // Image image = new Image("/icons/Calculator.png");
        //stage.getIcons().add(image);
        Stage stage = new Stage();
        
        myModelEdit.setStage(stage);
        Scene scene = new Scene(root);
        stage.setTitle("Edit");
        stage.setResizable(false);

        stage.setScene(scene);

        if (show) {
            stage.show();
        } else {
            stage.hide();
        }
        myController.initModelEdit();

    }

    /*
    @Override
    public void start(Stage stage) throws Exception {
        
        
        
//        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }*/
}
