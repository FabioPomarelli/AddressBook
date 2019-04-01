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
import entity.Datas;
import exception.*;
import java.util.Arrays;
import java.util.List;
import entity.ListeContact;
import java.util.ArrayList;
import model.Decorateur.AElementDecorateur;
import model.Decorateur.AdressePostale;
import model.Decorateur.Email;
import model.Decorateur.TelephoneFixe;
import model.Decorateur.TelephoneMobile;
import model.ElementSimple.SimpleContact;

/**
 * extends java.util.Observable
 *
 * @author pom
 */
public class ModelAgenda extends java.util.Observable implements Model {

    private Datas data =new Datas();
    
    
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
    public ModelAgenda() {
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
        
        ModelFormulaire formularie = new ModelFormulaire(contact2);
        
        
        data.setFormulaire(formularie);
        
        
    } //Model()

    @Override
    public void setValue(String value) {
        //  this.data.setOperazione(value);
        setChanged();
        notifyObservers(groupes);
    } //setValue()

    @Override
    public void incrementValue() {
        setChanged();
        notifyObservers(groupes);
    }

    @Override
    public void addValue(String str) {
        /*   data.setAppendOperazione(str);
        // calc.setOperazione(calc.getOperazione() + str);
        setChanged();
        notifyObservers(data);*/
    }

    @Override
    public void deleteValue() {
        /*  data.setError(false);
        data.setOperazione("");
        setChanged();
        notifyObservers(data);*/
    }

    @Override
    public void deleteLastValue() {
        /*if (data.getError()) {
            data.setOperazione(data.getOldOperazione());
            data.setError(false);
            setChanged();
            notifyObservers(data);

        } else {
            String tmpStr = data.getOperazione();
            tmpStr = (tmpStr.length() > 0) ? tmpStr.substring(0, tmpStr.length() - 1) : "";  //corrige !!!
            data.setOperazione(tmpStr);
            setChanged();
            notifyObservers(data);
        }*/
    }

    @Override
    public void calculate() {
        /*  try {
            String tmp = data.getOperazione();
            data.setOldOperazione(tmp);
            this.evalResolve.setOperation(tmp);
            //EvalNoeud monCalcul = new EvalNoeud(tmp);
            double returnedResult = evalResolve.getResultat();
            data.setOperazione("" + returnedResult);
        } catch (ExpressionMalFormeeException | InfinityException | DivisionBy0Exception e1) {
            data.setOperazione(e1.getMessage());
            data.setError(true);
        } catch (ScriptException e2) {
            data.setOperazione(e2.getMessage());
            data.setError(true);
        } catch (Exception es) {
            System.out.println("oioioioioioioiiiooiiiio" + es.getMessage());
        }

        setChanged();
        notifyObservers(data);*/
    }

    @Override
    public void setShowMessaggio(boolean toggle) {
        /*  data.setShowMessaggio(toggle);
        setChanged();
        notifyObservers(data);*/
    }

    @Override
    public boolean getShowMessaggio() {

        return true;
        // return data.getShowMessaggio();
    }

    @Override
    public void jobResponce() {
        /*   String responce = data.getReponse();
        if (!responce.equals("")) {
            data.setReponse("");
            this.jobResponce(responce);
        }*/
    }

    @Override
    public void jobResponce(String responce) {
        /* switch (responce) {
            case ("Noeud Eval Solve"):
                this.setEvalResolve(EvalNoeud.getInstance());
                this.deleteValue();
                break;
            case ("JavaScript Eval Solve"):
                this.setEvalResolve(EvalJavaScript.getInstance());
                this.deleteValue();
                break;

        }*/

    }

    @Override
    public void init() {
        setChanged();
        notifyObservers(data);
    }
    
    
   
    public void safe() {
        
        
        
        System.out.println("Salvataggio!!!");
        
       // setChanged();
        //notifyObservers(data);
    }

} //Model
