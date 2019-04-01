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
import view.View;

/**
 *
 * @author pom
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("IMAGE" + getClass().getResourceAsStream("/img/team.png"));
        System.out.println("IMAGE" + getClass().getResource("/img/team.png"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewListe.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGroupe.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewContact.fxml"));
        Parent root = loader.load();

        //ricevo il View Controller
        //ricevo il View Controller
  
        ModelAgenda myModelAgenda = new ModelAgenda();

        Controller myController = new Controller();
        myController.addModel(myModelAgenda);
        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(myController);

        myModelAgenda.addObserver(ViewCtrl);

        myController.initModel();

        Scene scene = new Scene(root);

        // Image image = new Image("/icons/Calculator.png");
        //stage.getIcons().add(image);
        stage.setTitle("Calculatrice");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

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
