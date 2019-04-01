/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ElementSimple;

/**
 *
 * @author pom
 */
import model.Decorateur.IVisitable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Decorateur.AElementDecorateur;


@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class SimpleContact implements IVisitable {

    public String nom="";
    public String prenom="";
    public List<AElementDecorateur> deco=null;

    @JsonIgnore
    public SimpleContact(){
    
    }
    
    
    @JsonCreator
    public SimpleContact(@JsonProperty("nom") String nom, @JsonProperty("prenom") String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setDecorateurs(List<AElementDecorateur> deco) {
        this.deco = deco;
    }

    @JsonIgnore
    public List<AElementDecorateur> getDecorateurs() {
        return this.deco;
    }

    @Override
    public String toString() {
        return "Contact [nom=" + nom + ", prenom=" + prenom + ", Deco=" + deco + "]";
    }

    public String getPrenom() {
        return this.prenom;

    }

    public String getNom() {
        return this.nom;

    }

    //accept the visitor
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
     public void setAccept(IVisitor visitor, List<Map<Integer, String[]>> values, List deco) {
        System.out.println("valore : " );
        
    }

  /*  @Override
    public String getAccept(IVisitor visitor) {
        return "ElementSimple";
    }*/

    @Override
    @JsonIgnore
    public List<Map<Integer, String[]>> getAccept(IVisitor visitor) {
        List<Map<Integer, String[]>> list = new ArrayList<Map<Integer, String[]>>();

        Map<Integer, String[]> parametres = new HashMap<Integer, String[]>();
        parametres = new HashMap<>();
        parametres.put(1, new String[]{"Class", this.getClass().getName()});
        list.add(parametres);
        
        parametres.put(2, new String[]{"Nom", this.nom});
        list.add(parametres);
        parametres = new HashMap<Integer, String[]>();
        parametres.put(3, new String[]{"Prenom", this.prenom});
        list.add(parametres);

        return list;

    }

    

}
