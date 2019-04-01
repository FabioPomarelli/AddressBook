/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Decorateur;

//import org.json.simple.JSONObject;
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
public class AdressePostale extends AElementDecorateur {

    @JsonProperty
    private String description = "";
    @JsonProperty
    private String adress = "";
    @JsonProperty
    private String codepostale = "";
    @JsonProperty
    private String ville = "";

    /**
     * Constructeur
     *
     * @param adress
     * @param element représente le type d'une personne (Morale, Entreprise
     * etc...)
     */
     @JsonIgnore
    public AdressePostale() {
      
    }
    
    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void afficher() {
        System.out.println("Bonjour je suis de type AdressePostale " + this.getAdress());
        //this.getElement().afficher();
    }

    public String afficherStr() {
        return ("Bonjour je suis de type AdressePostale " + this.getAdress() + "\n");
        // + this.getElement().afficherStr());

    }

    @JsonCreator
    public AdressePostale(@JsonProperty("adress") String adress) {
        this.adress = adress;
    }


    @Override
    public String toString() {
        return "AdressePostale [Adresse=" + adress + "]";
    }

    @Override
    @JsonIgnore
    public void accept(IVisitor visitor) {
    }

    @Override
    @JsonIgnore
     public void setAccept(IVisitor visitor, List<Map<Integer, String[]>> values, List deco) {
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
        parametres.put(2, new String[]{"Description Adresse", this.description});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(3, new String[]{"Adress", this.adress});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(4, new String[]{"Code Postale", this.codepostale});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(5, new String[]{"Ville", this.ville});
        list.add(parametres);
        return list;

    }

}
