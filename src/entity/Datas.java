/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pom
 */
public class Datas {

    private static Datas instance = null;
    private boolean showViewListe = true;
    private boolean showViewEdit = true;

    private Datas() {

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

    private Formulaire formulaire;

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

}
