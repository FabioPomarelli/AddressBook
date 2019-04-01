/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package view;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ViewContact implements View {

    private EventHandler controller;

    @FXML
    private TextField resultdisplay;

    @FXML
    private Button ButtonEgale;
    @FXML
    private GridPane GridPaneButtonJS1;
    @FXML
    private GridPane GridPaneButtonJS2;
    @FXML
    private GridPane GridPaneButtonOper;
    @FXML
    private GridPane GridPaneButtonNombre;
    @FXML
    private RadioMenuItem menuRagioNoeudSolve;
    @FXML
    private RadioMenuItem menuRagioJsSolve;
    @FXML
    protected void handleTextFieldAction(KeyEvent event) {
        this.controller.handle((Event) event);
    }

    @FXML
    protected void handleMouseEvent(Event event) {
        this.controller.handle((Event) event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void Calculation(ActionEvent event) {
        this.controller.handle(event);
    }

    // Called from the Model
    @Override
    public void update(Observable obs, Object obj) {
      /*  Data data = ((Data) obj);
        resultdisplay.setText(data.getOperazione());
        toggleButtonError(data.getError());
        toggleButtonEval(data.getTypeEval(), data.getError());
        data.setReponse(toggleAvviso(data.getShowMessaggio()));
        data.setShowMessaggio(false);*/
    } //update()

    //to initialise TextField
    public void setValue(String v) {
        resultdisplay.setText(v);
    } //setValue()

    @Override
    public void addController(EventHandler controller) {
        this.controller = controller;
    }

    private void toggleButtonError(boolean toggle) {
        GridPaneButtonOper.setDisable(toggle);
        GridPaneButtonNombre.setDisable(toggle);
        ButtonEgale.setDisable(toggle);
        GridPaneButtonJS1.setDisable(toggle);
        GridPaneButtonJS2.setDisable(toggle);

        resultdisplay.setDisable(toggle);

    }

    private void toggleButtonEval(String toggle, boolean error) {
        if (toggle.equals("JS") && error == false) {
            GridPaneButtonJS1.setDisable(false);
            GridPaneButtonJS2.setDisable(false);
            menuRagioNoeudSolve.setSelected(false);
            menuRagioJsSolve.setSelected(true);      
        } else {
            GridPaneButtonJS1.setDisable(true);
            GridPaneButtonJS2.setDisable(true);
            menuRagioNoeudSolve.setSelected(true);
            menuRagioJsSolve.setSelected(false);   
        }

    }

    private String toggleAvviso(boolean toggle) {
        if (toggle) {
            List<String> choices = new ArrayList<>();
            choices.add("Noeud Eval Solve");
            choices.add("JavaScript Eval Solve");

            ChoiceDialog<String> dialog = new ChoiceDialog<>("JavaScript Eval Solve", choices);
            dialog.setTitle("Choisissez le mode");
            dialog.setHeaderText("Activer la modalité avec la méthode eval() de javascript?");
            dialog.setContentText("Choisissez le mode :");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                return result.get();
            }

        }
        return "";
    }
}

