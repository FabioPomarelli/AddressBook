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
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
 
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ElementGroupe.GroupeContact;
import model.ElementSimple.SimpleContact;
 
public class DeSerializeExample1 {
 
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        GroupeContact zoo = mapper.readValue(FileUtils.readFileToByteArray(new File("Agenda.json")), GroupeContact.class);
        System.out.println(zoo);
        System.out.println(zoo.contacts.get(0).getClass());
    }
}
