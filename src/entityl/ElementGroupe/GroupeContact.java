/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityl.ElementGroupe;




import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import entity.ElementSimple.SimpleContact;
 
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class GroupeContact {
 
    public String nomgroupe;
    public List<SimpleContact> contacts;
 
    @JsonCreator
    public GroupeContact(@JsonProperty("nomgroupe") String nomgroupe) {
        this.nomgroupe = nomgroupe;
    }
 
    public void setContacts(List<SimpleContact> contacts) {
        this.contacts = contacts;
    }
 
    @Override
    public String toString() {
        return "Agenda [nomgroupe=" + nomgroupe + " , Deco=" + contacts + "]";
    }
 
}
























/*






public class GroupeContact extends ElementContact {
   
     public static final String SCLASS = "GroupeContact";
    public final String OCLASS = "GroupeContact";
    

    private List<SimpleContact1> elementCarnetAdress = new ArrayList<>();


    public void add(SimpleContact1 element) {
        this.elementCarnetAdress.add(element);

    }

  
    public void retirer(ElementContact element) {
        this.elementCarnetAdress.remove(element);
    }

 
   
    public void getGroupe(List element) {
         this.elementCarnetAdress=element;
    }
    
    
    
    public List getGroupe() {
        return this.elementCarnetAdress;
    }

   
    public void afficher() {
        for (Object obj : this.elementCarnetAdress) {
            ((SimpleContact1) (obj)).afficher();
        }
    }

    public String afficherStr() {
        String app = "";
        for (Object obj : this.elementCarnetAdress) {
            app += ((SimpleContact1) (obj)).afficherStr();
        }
        return app;
    }
}
*/