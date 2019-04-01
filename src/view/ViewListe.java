/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.ListeContact;
import controller.Controller;
import entity.Datas;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class ViewListe implements View {
    // private Controller controller;

    private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("/img/team.png")));
    //  private final Image depIcon
    //         = new Image(getClass().getResourceAsStream("department.png"));
    /* List<Employee> employees = Arrays.<Employee>asList(
            new ListeContact("Ethan Williams", "Sales Department"),
            new ListeContact("Emma Jones", "Sales Department"),
            new ListeContact("Michael Brown", "Sales Department"),
            new ListeContact("Anna Black", "Sales Department"),
            new ListeContact("Rodger York", "Sales Department"),
            new ListeContact("Susan Collins", "Sales Department"),
            new ListeContact("Mike Graham", "IT Support"),
            new ListeContact("Judy Mayer", "IT Support"),
            new ListeContact("Gregory Smith", "IT Support"),
            new ListeContact("Jacob Smith", "Accounts Department"),
            new ListeContact("Isabella Johnson", "Accounts Department"));
    
     */
    TreeItem<String> rootNode = new TreeItem<String>("MyCompany Human Resources", rootIcon);

    private EventHandler controller;
    private List<ListeContact> contacts;
    @FXML
    private TreeView TreeViewGroupe;
    @FXML
    private TextField TextFieldNom;
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
    private ScrollPane ScrollPaneFormulaire;

    @FXML
    protected void handleTextFieldAction(KeyEvent event) {
        this.controller.handle((Event) event);
    }

    @FXML
    protected void handleMouseEvent(Event event) {
        this.controller.handle((Event) event);
    }

   @FXML
    private Button ButtonSafe;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TreeViewGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem> observable, TreeItem oldValue, TreeItem newValue) {

                TreeItem<String> selectedItem = (TreeItem<String>) newValue;
                TextFieldNom.setText("");
                for (ListeContact contact : contacts) {

                    if (contact.getName().equals(selectedItem.getValue())) {
                        TextFieldNom.setText(selectedItem.getValue());
                        System.out.println(this.getClass());

                    }

                }
            }

        });

        TextFieldNom.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });

        /*TreeViewGroupe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Employee>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Employee>> observable, TreeItem<Employee> oldValue, TreeItem<Employee> newValue) {
                System.out.println("ECCO");
                TextFieldNom.setText("ECCO");
                //TreeItem<String> selectedItem = (TreeItem<String>) newValue;
                TextFieldNom.setText(newValue.toString());
            }

        });
        // TODO*/
    }

    @FXML
    private void Calculation(ActionEvent event) {
        System.out.println("Ciaoooooooooooooooooooo");

        this.controller.handle(event);
    }
    
    @FXML
    private void SafeContact(ActionEvent event) {
        System.out.println("safe");

        this.controller.handle(event);
    }
    
    

    @FXML
    private void TreeViewEvent(ActionEvent event) {
        this.controller.handle(event);
    }

    // Called from the Model
    @Override
    public void update(Observable obs, Object obj) {
        Datas data = (Datas)obj;
        
        initTreeView(data.getListeContact());
        
        GridPane forms=data.getFormulaire().getFormularieJavaFx();
        
        initGridPane(forms);
        
        //for safe!
        data.getFormulaire().setFormularieJavaFx(forms);
        
        /* Data data = ((Data) obj);
        resultdisplay.setText(data.getOperazione());
        toggleButtonError(data.getError());
        toggleButtonEval(data.getTypeEval(), data.getError());
        data.setReponse(toggleAvviso(data.getShowMessaggio()));
        data.setShowMessaggio(false);*/
    } //update()

    private void initGridPane(GridPane grid) {
       this.ScrollPaneFormulaire.setContent(grid);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void initTreeView(List<ListeContact> contacts) {
        this.contacts = contacts;
        rootNode.setExpanded(true);
        for (ListeContact contact : contacts) {
            TreeItem<String> empLeaf = new TreeItem<String>(contact.getName());
            boolean found = false;
            for (TreeItem<String> depNode : rootNode.getChildren()) {
                if (depNode.getValue().contentEquals(contact.getDepartment())) {
                    depNode.getChildren().add(empLeaf);
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem<String> depNode = new TreeItem<String>(
                        contact.getDepartment()//,
                //new ImageView(depIcon)
                );
                rootNode.getChildren().add(depNode);
                depNode.getChildren().add(empLeaf);
            }
        }

        TreeViewGroupe.setEditable(true);
        TreeViewGroupe.setRoot(rootNode);

        TreeViewGroupe.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });

    }

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
