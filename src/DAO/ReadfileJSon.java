/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author pom
 */
public class ReadfileJSon {

    private static ReadfileJSon instance = null;

    private ReadfileJSon() {

    }

    public static ReadfileJSon getInstance() {
        if (instance == null) {
            instance = new ReadfileJSon();

        }
        return instance;
    }

    public String lecturejson(String fichier) {
        if (fichier != "") {
            File file = new File("./Agenda.json");
            BufferedReader br;
            String data = "";
            try {
                String st;
                br = new BufferedReader(new FileReader(file));
                while ((st = br.readLine()) != null) {
                    data = data + st + "\n";
                }
                return (data);
            } catch (FileNotFoundException ex) {
                System.out.println("Erreur fichier n'est pas trouve ");
               // Logger.getLogger(ViewJson.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("Erreur lecture json IO ");
               // Logger.getLogger(ViewJson.class.getName()).log(Level.SEVERE, null, ex);
            }

            

        }
        return "";
    }
}
