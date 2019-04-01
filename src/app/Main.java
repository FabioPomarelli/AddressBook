/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Controller;
import entity.Datas;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelAgenda;
import model.ModelEdit;
import model.ModelGroupe;
import model.ModelJson;
import view.View;

/**
 *
 * @author pom
 */
public class Main extends Application {

    static final String VIEW_LISTE = "/view/ViewListe.fxml";
    static final String VIEW_EDIT = "/view/ViewEditContact.fxml";
    static final String VIEW_JSON = "/view/ViewJson.fxml";
    static final String VIEW_NEWGROUPE = "/view/ViewEditGroupe.fxml";
    private Controller myController;
    private ModelAgenda myModelAgenda;
    private ModelEdit myModelEdit;
    private ModelGroupe myModelGroupe;
    private ModelJson myModelJSon;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            this.myController = Controller.getInstance();
            this.myModelEdit = ModelEdit.getInstance();
            this.myModelGroupe = ModelGroupe.getInstance();
            this.myModelAgenda = ModelAgenda.getInstance();
            this.myModelJSon = ModelJson.getInstance();

            this.myController.setModelAgenda(this.myModelAgenda);
            this.myController.setModelEdit(this.myModelEdit);

            Datas data = Datas.getInstance();
            data.setViewListe(startListe(false, stage));
            data.setViewEdit(startEdit(false));
            data.setViewJson(startJson(false));
        } catch (IOException e) {

            System.out.println("Non parto" + e.getMessage());

        }

    }

    private Stage startListe(boolean show, Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_LISTE));
        Parent root = loader.load();

        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(this.myController);
        this.myModelAgenda.addObserver(ViewCtrl);
        this.myModelAgenda.setStage(stage);

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
        return stage;

    }

    public Stage startEdit(boolean show) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_EDIT));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGroupe.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewContact.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        //ricevo il View Controller
        //ricevo il View Controller
        // ModelEdit myModelEdit = ModelEdit.getInstance();
        //Controller myController = Controller.getInstance();
        //myController.addModel(myModelEdit);

        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(this.myController);

        this.myModelEdit.addObserver(ViewCtrl);
        this.myModelEdit.setStage(stage);

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
        return stage;
    }

    public Stage startJson(boolean show) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_JSON));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGroupe.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewContact.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        //ricevo il View Controller
        //ricevo il View Controller
        //ModelJson myModelJson = ModelJson.getInstance();
        //Controller myController = Controller.getInstance();
        //myController.addModel(myModelEdit);
        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(myController);

        this.myModelJSon.addObserver(ViewCtrl);

        //Stage stage = new Stage();
        // Image image = new Image("/icons/Calculator.png");
        //stage.getIcons().add(image);
        this.myModelJSon.setStage(stage);

        Scene scene = new Scene(root);
        stage.setTitle("ShowJson");
        stage.setResizable(false);

        stage.setScene(scene);

        if (show) {
            stage.show();
        } else {
            stage.hide();
        }
        myController.initModelEdit();
        return stage;
    }
    
    
    public Stage startNewGroupe(boolean show) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_NEWGROUPE));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewGroupe.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewContact.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        //ricevo il View Controller
        //ricevo il View Controller
        //ModelJson myModelJson = ModelJson.getInstance();
        //Controller myController = Controller.getInstance();
        //myController.addModel(myModelEdit);
        View ViewCtrl = (View) loader.getController();
        ViewCtrl.addController(myController);

        this.myModelGroupe.addObserver(ViewCtrl);

        //Stage stage = new Stage();
        // Image image = new Image("/icons/Calculator.png");
        //stage.getIcons().add(image);
        this.myModelGroupe.setStage(stage);

        Scene scene = new Scene(root);
        stage.setTitle("ShowJson");
        stage.setResizable(false);

        stage.setScene(scene);

        if (show) {
            stage.show();
        } else {
            stage.hide();
        }
        myController.initModelEdit();
        return stage;
    }
}
