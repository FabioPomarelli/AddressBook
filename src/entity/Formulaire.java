package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import entity.Decorateur.AElementDecorateur;
import entity.Decorateur.IVisitable;
import entity.ElementSimple.AppliVisitor;
import entity.ElementSimple.SimpleContact;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pom
 */
public class Formulaire {

    private boolean isEditable=true;
    private GridPane gridPaneFormalaire;
    private AppliVisitor visitor = new AppliVisitor();
    private List<AElementDecorateur> decos;
    private SimpleContact contact;

    
    public void setEditable(boolean edit){
        this.isEditable=edit;
    }
    
    public Formulaire(SimpleContact contact) {
        this.contact = contact;
    }

    public void setContact(SimpleContact contact) {
        this.contact = contact;
    }

    public void setFormularieJavaFx() {
        System.out.println("SAFEFF");
        //saveGridPaneSimpleContact((GridPane) gridPaneFormalaire.getChildren().get(0));
        List<AElementDecorateur> deco = new ArrayList<>();

        for (int i = 1; i < gridPaneFormalaire.getChildren().size(); i++) {
            System.out.println("SAFEFF" + i);

            deco.add((AElementDecorateur) saveGridPaneElementVisitable((GridPane) gridPaneFormalaire.getChildren().get(i), null));
        }

        System.out.println(deco.size());

        this.contact = (SimpleContact) saveGridPaneElementVisitable((GridPane) gridPaneFormalaire.getChildren().get(0), deco);
    }

    public GridPane getFormularieJavaFx() {

        //Creating a Grid Pane Parent
        GridPane gridPaneParent = new GridPane();

        gridPaneParent.add(this.createGridPaneVisitable(this.contact), 0, 0);

        int i = 0;
        for (AElementDecorateur deco : this.contact.getDecorateurs()) {
            gridPaneParent.add(this.createGridPaneVisitable(deco), 0, i + 1);
            i++;
        }
        this.gridPaneFormalaire=gridPaneParent;
        return gridPaneParent;

    }

    
    
    /*****************************************************/
    private IVisitable saveGridPaneElementVisitable(GridPane grid, List deco) {
        System.out.println(((TextField) grid.getChildren().get(1)).getText());
        String nameClass = (((TextField) grid.getChildren().get(1)).getText());

        try {

            Class cls = Class.forName(nameClass);
            IVisitable myVisitable = (IVisitable) cls.newInstance();

            List<Map<Integer, String[]>> list = new ArrayList<Map<Integer, String[]>>();

            Map<Integer, String[]> parametres;
            int k = 0;
            for (int i = 2; i < grid.getChildren().size(); i += 2) {
                parametres = new HashMap<Integer, String[]>();
                String key = (((Label) grid.getChildren().get(i)).getText());
                String value = (((TextField) grid.getChildren().get(i + 1)).getText());

                parametres.put(k, new String[]{key, value});
                k += 1;
                list.add(parametres);
            }

            myVisitable.setAccept(visitor, list, deco);

            return myVisitable;
        } catch (ClassNotFoundException e) {

            System.out.println("NOOOOOOOOOOOOOOOOO  ClassNotFoundException ");
        } catch (InstantiationException e) {

            System.out.println("NOOOOOOOOOOOOOOOOO InstantiationException");
        } catch (IllegalAccessException e) {

            System.out.println("NOOOOOOOOOOOOOOOOO IllegalAccessException");
        } catch (Exception e) {

            System.out.println("NOOOOOOOOOOOOOOOOO IllegalAccessException");
        }
        return null;
//Class cls = Class.forName(fullPathOfTheClass);
    }

    private GridPane createGridPaneVisitable(IVisitable visitable) {
        //Creating a Grid Pane Simple Contact
        GridPane gridPane = new GridPane();
TextField app;
        List<Map<Integer, String[]>> list = visitable.getAccept(visitor);
        int k = 0;
        for (Map<Integer, String[]> parametres : list) {

            System.out.println(parametres.toString());

            String appStr[] = parametres.get(k + 1);

            gridPane.add(new Label(appStr[0]), 0, k);
            app=new TextField(appStr[1]);
            app.setDisable(!this.isEditable);
            gridPane.add(app, 1, k);
            k += 1;
        }
        return gridPane;
    }

}
