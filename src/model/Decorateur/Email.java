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
public class Email extends AElementDecorateur {

    @JsonProperty
    private String description = "";
    @JsonProperty
    private String email = "";
    
   
    @JsonIgnore
    public Email() {
      
    }
    
   /* @JsonCreator 
    public Email(@JsonProperty("email") String email, @JsonProperty("parametres") List<Map<Integer ,String[]>> parametres) {
       this.parametres=parametres;
       this.email = email;
    }*/

    /**
     * Constructeur
     *
     * @param adress
     * @param element représente le type d'une personne (Morale, Entreprise
     * etc...)
     */
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void afficher() {
        System.out.println("Bonjour je suis de type Email " + this.getEmail());
        //this.getElement().afficher();
    }

    public String afficherStr() {
        return ("Bonjour je suis de type Email " + this.getEmail() + "\n");
        // + this.getElement().afficherStr());

    }

    @JsonCreator
    public Email(@JsonProperty("email") String email, @JsonProperty("description") String description) {
        this.email = email;
        this.description = description;
    }

   
    @Override
    public String toString() {
        return "Email [name=, getEmail()=" + getEmail() + " ]";
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
        parametres.put(2, new String[]{"Description Email", this.description});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(3, new String[]{"Email", this.email});
        list.add(parametres);

        return list;

    }
    
     @Override
    @JsonIgnore
      public void setAccept(IVisitor visitor, List<Map<Integer, String[]>> values, List deco) {
        System.out.println("valore : " );
    }
    
    
   /* @Override
    @JsonIgnore
    public void setAccept(IVisitor visitor, String value) {
        List<Map<Integer, String[]>> list = new ArrayList<Map<Integer, String[]>>();

        Map<Integer, String[]> parametres;
        parametres = new HashMap<>();
        parametres.put(1, new String[]{"Class", this.getClass().getCanonicalName()});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(2, new String[]{"Description Email", this.description});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(3, new String[]{"Email", this.email});
        list.add(parametres);

        return list;

    }*/

    @Override
    @JsonIgnore
    public void accept(IVisitor visitor) {
    
    }

}
