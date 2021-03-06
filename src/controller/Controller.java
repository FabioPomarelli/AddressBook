/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.*;

/**
 *
 * @author pom
 */
public class Controller implements EventHandler {

    ModelAgenda modelAgenda;
    ModelEdit modelEdit;
    ModelJson modelJson;
    ModelGroupe modelGroupe;

    private static Controller instance = null;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();

        }
        return instance;
    }

    private void mouseEvent(MouseEvent e) {

        //model.setShowMessaggio(true);
        //model.jobResponce();
    }

    private void DialogEvent(DialogEvent e) {

    }

    private void keyEvent(KeyEvent e) {
        if (!e.getCode().isLetterKey()) {

            String key = e.getCode().toString();
            //System.out.print(e.getCode().toString());
            switch (key) {
                case ("DIGIT0"):
                case ("DIGIT1"):
                case ("DIGIT2"):
                case ("DIGIT3"):
                case ("DIGIT4"):
                case ("DIGIT5"):
                case ("DIGIT6"):
                case ("DIGIT7"):
                case ("DIGIT8"):
                case ("DIGIT9"):
                    // model.addValue(key.substring(5, 6));
                    break;
                case ("NUMPAD0"):
                case ("NUMPAD1"):
                case ("NUMPAD2"):
                case ("NUMPAD3"):
                case ("NUMPAD4"):
                case ("NUMPAD5"):
                case ("NUMPAD6"):
                case ("NUMPAD7"):
                case ("NUMPAD8"):

            }

        }

    }

    private void actionEvent(ActionEvent e) {

        if (RadioMenuItem.class.getName().equals(e.getSource().getClass().getName())) {
            String radio = ((RadioMenuItem) e.getSource()).getText();
            // model.jobResponce(radio);

        }
        if (MenuItem.class.getName().equals(e.getSource().getClass().getName())) {
            String tap = ((MenuItem) e.getSource()).getText();
            switch (tap) {
                case ("Quit"):
                    System.exit(0);
                    break;

            }
        }
        if (Button.class.getName().equals(e.getSource().getClass().getName())) {

            //String click = ((Button) e.getSource()).getText();
            String click = ((Button) e.getSource()).getId();
            System.out.println("click " + click);

            switch (click) {
                case ("ButtonSafe"):
                    modelAgenda.safe();
                    break;
                case ("ButtonEditContact"):
                    modelEdit.edit("Edit");
                    break;
                case ("ButtonNewContact"):
                    modelEdit.edit("New");
                    break;

                case ("ButtonNewGroupe"):
                    modelGroupe.edit("new");
                    break;

                case ("ButtonShowJson"):
                    modelEdit.edit("new");
                    break;
                case ("ButtonSearch"):
                    modelEdit.edit("new");
                    break;

                case ("0"):
                case ("1"):
                case ("2"):
                case ("3"):
                case ("4"):
                case ("5"):
                case ("6"):
                case ("7"):
                case ("8"):
                case ("9"):
                case ("."):
                case ("^"):
                case ("*"):
                case ("/"):
                case ("+"):
                case ("-"):
                case ("("):
                /*     case (")"):
                    model.addValue(click);
                    break;
                case ("="):
                    model.calculate();
                    break;
                case ("CE"):
                    model.deleteLastValue();
                    break;
                case ("C"):
                    model.deleteValue();
                    break;
                case ("PI"):
                    model.addValue("Math.PI");
                    break;
                case ("SIN"):
                    model.addValue("Math.sin(");
                    break;
                case ("COS"):
                    model.addValue("Math.cos(");
                    break;
                case ("TAN"):
                    model.addValue("Math.tan(");
                    break;
                case ("SQRT"):
                    model.addValue("Math.sqrt(");
                    break;
                case ("ASIN"):
                    model.addValue("Math.asin(");
                    break;
                case ("ACOS"):
                    model.addValue("Math.acos(");
                    break;
                case ("ATAN"):
                    model.addValue("Math.atan(");
                    break;*/
            }
        }

    }

    @Override
    public void handle(Event e) {

        String type = e.getEventType().toString();
        switch (type) {
            case ("KEY_PRESSED"):
            case ("KEY_TYPED"):
                this.keyEvent((KeyEvent) e);
                break;
            case ("ACTION"):
                this.actionEvent((ActionEvent) e);
                break;
            case ("MOUSE_CLICKED"):
                this.mouseEvent((MouseEvent) e);
                break;
            case ("DIALOG_CLOSE_REQUEST"):
                this.DialogEvent((DialogEvent) e);
                break;

            default:
                System.out.println("Evento non conosciuto " + type);
                break;
        }
    }

    public void setModelAgenda(ModelAgenda m) {
        this.modelAgenda = m;
    } //addModel()

    public void setModelJson(ModelJson m) {
        this.modelJson = m;
    } //addModel()

    public void setModelEdit(ModelEdit m) {
        this.modelEdit = m;
    }//addModel()

    public void setModelGroupe(ModelGroupe m) {
        this.modelGroupe= m;
    } //addModel()

    public void initModelAgenda() {

        modelAgenda.init();
    } //initModel()

    public void initModelEdit() {

        modelEdit.init();
    } //initModel()
}
