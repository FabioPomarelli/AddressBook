/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import model.ModelFormulaire;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pom
 */
public class Datas {

    private List<ListeContact> listeContact = new ArrayList();

    private ModelFormulaire formulaire;

    public Datas() {

    }

    public void setFormulaire(ModelFormulaire formulaire) {
        this.formulaire = formulaire;

    }

    public ModelFormulaire getFormulaire() {
        return this.formulaire;

    }

    public List<ListeContact> getListeContact() {
        return this.listeContact;

    }

    public void setListeContact(List<ListeContact> listecontact) {
        this.listeContact = listecontact;

    }

}
