/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author pom
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import model.Decorateur.AElementDecorateur;
import model.Decorateur.AdressePostale;
import model.Decorateur.Email;
import model.Decorateur.IElementDecorateur;
import model.Decorateur.TelephoneFixe;
import model.Decorateur.TelephoneMobile;
import model.ElementGroupe.GroupeContact;
import model.ElementSimple.SimpleContact;


public class SerializeExample1 {

    private static String outputFile = "Agenda.json";

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        classic();
    }

    public static void avecMap() throws IOException {

        List<Map<Integer, String[]>> list = new ArrayList<Map<Integer, String[]>>();

        Map<Integer, String[]> parametres;
        parametres = new HashMap<>();
        parametres.put(1, new String[]{"Class", "this.getClass().getCanonicalName()"});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(2, new String[]{"Description Email", "DESC"});
        list.add(parametres);

        parametres = new HashMap<>();
        parametres.put(3, new String[]{"Email", "EMA"});
        list.add(parametres);

        SimpleContact contact1 = new SimpleContact("Fabio", "Pomarelli");
       
        
        Email email = new Email("Email","");
        List<AElementDecorateur> deco = new ArrayList<>();
        deco.add(email);

        contact1.setDecorateurs(deco);
        
        
        GroupeContact groupe = new GroupeContact("agendaaaa");
        List<SimpleContact> contacts = new ArrayList<>();
        contacts.add(contact1);
        groupe.setContacts(contacts);

        System.out.println(groupe.contacts.size());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File(outputFile)), groupe);

    }

    public static void classic() throws IOException {
        SimpleContact contact1 = new SimpleContact("Fabio", "Pomarelli");
        TelephoneMobile telephonem = new TelephoneMobile("0606060606");
        TelephoneFixe telephone = new TelephoneFixe("05050500550");
        AdressePostale adress = new AdressePostale("rue");
        Email email = new Email("email@email.com","");
        List<AElementDecorateur> deco = new ArrayList<>();
        deco.add(email);
        deco.add(adress);
        deco.add(telephone);
        deco.add(telephonem);
        contact1.setDecorateurs(deco);

        SimpleContact contact2 = new SimpleContact("Florent", "fffff");
        TelephoneMobile telephonem2 = new TelephoneMobile("06060606062");
        TelephoneFixe telephone2 = new TelephoneFixe("050505005502");
        AdressePostale adress2 = new AdressePostale("place");
        Email email2 = new Email("email@email.com2","");
        List<AElementDecorateur> deco2 = new ArrayList<>();
        deco2.add(email2);
        deco2.add(adress2);
        deco2.add(telephone2);
        deco2.add(telephonem2);
        contact2.setDecorateurs(deco2);

        GroupeContact groupe = new GroupeContact("agendaaaa");
        List<SimpleContact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        groupe.setContacts(contacts);

        System.out.println(groupe.contacts.size());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File(outputFile)), groupe);

    }

}
