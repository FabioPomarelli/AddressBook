/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;

/**
 *
 * @author pom
 */
public class Datas {

    private static Datas instance = null;
    private boolean showViewListe = true;
    private boolean showViewEdit = false;
    private boolean showViewJson = false;
    private Stage ViewListe = null;
    private Stage ViewEdit = null;
    private Stage ViewJson = null;

    private Datas() {

    }

    public void setViewListe(Stage ViewListe) {
        this.ViewListe = ViewListe;
    }

    public void setViewEdit(Stage ViewEdit) {
        this.ViewEdit = ViewEdit;
    }

    public void setViewJson(Stage ViewJson) {
        this.ViewJson = ViewJson;
    }

    public Stage getViewListe() {
        return ViewListe;
    }

    public Stage getViewEdit() {
        return ViewEdit;
    }

    public Stage getViewJson() {
        return ViewJson;
    }

    public void setShowViewJson(boolean showViewJson) {
        this.showViewJson = showViewJson;
    }

    public boolean isShowViewJson() {
        return showViewJson;
    }

    public boolean isShowViewListe() {
        return showViewListe;
    }

    public void setShowViewListe(boolean ShowViewListe) {
        this.showViewListe = ShowViewListe;
    }

    public void setShowViewEdit(boolean ShowViewEdit) {
        this.showViewEdit = ShowViewEdit;
    }

    public boolean isShowViewEdit() {
        return showViewEdit;
    }

    public static Datas getInstance() {
        if (instance == null) {
            instance = new Datas();

        }
        return instance;
    }

    private List<ListeContact> listeContact = new ArrayList();

    public Formulaire formulaire;

    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;

    }

    public Formulaire getFormulaire() {
        return this.formulaire;

    }

    public List<ListeContact> getListeContact() {
        return this.listeContact;

    }

    public void setListeContact(List<ListeContact> listecontact) {
        this.listeContact = listecontact;

    }

    public void switchView(boolean ViewListe, boolean ViewEdit, boolean ViewJson) {
        this.setShowViewEdit(showViewEdit);
        this.setShowViewJson(showViewJson);
        this.setShowViewListe(showViewListe);
        if (ViewListe) {
            this.ViewListe.show();

        } else {
            this.ViewListe.hide();
        }
        if (ViewEdit) {
            this.ViewEdit.show();

        } else {
            this.ViewEdit.hide();
        }
        if (ViewJson) {
            this.ViewJson.show();

        } else {
            this.ViewJson.hide();
        }

    }

}
