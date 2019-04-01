/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pom
 */
import controller.Controller;
import entity.Formulaire;
import entity.Datas;
import exception.*;
import java.util.Arrays;
import java.util.List;
import entity.ListeContact;
import java.util.ArrayList;
import entity.Decorateur.AElementDecorateur;
import entity.Decorateur.AdressePostale;
import entity.Decorateur.Email;
import entity.Decorateur.TelephoneFixe;
import entity.Decorateur.TelephoneMobile;
import entity.ElementSimple.SimpleContact;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.View;

/**
 * extends java.util.Observable
 *
 * @author pom
 */
public class ModelAgenda extends java.util.Observable implements Model {
    private static Stage stage;

    public static void setStage(Stage stage) {
        ModelAgenda.stage = stage;
    }
    
    private static ModelAgenda instance=null;
    
    public static ModelAgenda getInstance(){
        if(instance==null){
            instance=new ModelAgenda();
            
        }
        return instance;
    }
    
    private Datas data;

    private List<ListeContact> groupes = Arrays.<ListeContact>asList(new ListeContact("Ethan Williams", "Groupe1"),
            new ListeContact("Emma Jones", "Groupe2"),
            new ListeContact("Michael Brown", "Groupe3"),
            new ListeContact("Anna Black", "Groupe4"),
            new ListeContact("Rodger York", "Groupe1"),
            new ListeContact("Susan Collins", "Groupe1"),
            new ListeContact("Mike Graham", "Groupe1"),
            new ListeContact("Judy Mayer", "Groupe1"),
            new ListeContact("Gregory Smith", "IT Support"),
            new ListeContact("Jacob Smith", "Accounts Department"),
            new ListeContact("Isabella Johnson", "Accounts Department"));

    // private EvalResolve evalResolve;
    private ModelAgenda() {
         data= Datas.getInstance();
        data.setListeContact(groupes);

        SimpleContact contact2 = new SimpleContact("Fabio", "Pomarelli");
        TelephoneMobile telephonem2 = new TelephoneMobile("06060606062");
        TelephoneFixe telephone2 = new TelephoneFixe("050505005502");
        AdressePostale adress2 = new AdressePostale("place");
        Email email2 = new Email("fabio@pomarelli.com2", "");
        List<AElementDecorateur> deco2 = new ArrayList<>();
        deco2.add(email2);
        deco2.add(adress2);
        deco2.add(telephone2);
        deco2.add(telephonem2);
        contact2.setDecorateurs(deco2);

        Formulaire formularie = new Formulaire(contact2);

        data.setFormulaire(formularie);

    } //Model()

    public void setValue(String value) {
        //  this.data.setOperazione(value);
        setChanged();
        notifyObservers(groupes);
    } //setValue()

    public void incrementValue() {
        setChanged();
        notifyObservers(groupes);
    }

    public void init() {
        setChanged();
        notifyObservers(data);
    }

    public void safe() {
        data.getFormulaire().setFormularieJavaFx();
        
        System.out.println("Salvataggio!!!");

         setChanged();
        notifyObservers(data);
    }
    
    

        
        

    
    
    
    

} //Model
