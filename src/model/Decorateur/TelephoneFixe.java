/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Decorateur;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ElementSimple.IVisitor;

/**
 *
 * @author pom
 */
public class TelephoneFixe extends AElementDecorateur {

    @JsonProperty
    private String description = "";
    @JsonProperty
    private String telephone;

    /**
     * Constructeur
     *
     * @param adress
     * @param element représente le type d'une personne (Morale, Entreprise
     * etc...)
     */
    
    
    @JsonIgnore
    public TelephoneFixe() {
      
    }
    
    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void afficher() {
        System.out.println("Bonjour je suis de type Telephone Fixe " + this.getTelephone());
        //this.getElement().afficher();
    }

    public String afficherStr() {
        return ("Bonjour je suis de type Telephone Fixe " + this.getTelephone() + "\n");
        // + this.getElement().afficherStr());

    }

    @JsonCreator
    public TelephoneFixe(@JsonProperty("telephone") String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Telephone Fixe [name=, getTelephone()=" + getTelephone() + " ]";
    }

    @Override
    @JsonIgnore
    public void accept(IVisitor visitor) {
    }

    @Override
    @JsonIgnore
      public void setAccept(IVisitor visitor, List<Map<Integer, String[]>> values, List deco){
        System.out.println("valore : " );
    }

    @Override
    @JsonIgnore
    public List<Map<Integer, String[]>> getAccept(IVisitor visitor) {
        List<Map<Integer, String[]>> list = new ArrayList<Map<Integer, String[]>>();

        Map<Integer, String[]> parametres;
        parametres = new HashMap<>();
        parametres.put(1, new String[]{"Class", this.getClass().getCanonicalName()});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(2, new String[]{"Description Telephonr fixe", this.description});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(3, new String[]{"Telephone Fixe", this.telephone});
        list.add(parametres);

        return list;

    }

}
