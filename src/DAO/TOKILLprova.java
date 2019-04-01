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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ViewJson;

/**
 *
 * @author pom
 */
public class TOKILLprova {

    private static HashMap<Integer, String[]> subjects;

    public TOKILLprova() {
    }

    public static void main(String[] args) {
lecturejson();


/*

        List<Map<Integer, String[]>> lista = new ArrayList();

        subjects = new HashMap<Integer, String[]>();
        subjects.put(1, new String[]{"math", "logic"});
        lista.add(subjects);

        subjects = new HashMap<Integer, String[]>();
        subjects.put(2, new String[]{"ions", "electrons"});
        lista.add(subjects);

        subjects = new HashMap<Integer, String[]>();
        subjects.put(3, new String[]{"life", "bacteria"});
        lista.add(subjects);

        subjects = new HashMap<Integer, String[]>();
        subjects.put(4, new String[]{"life", "bacteria"});
        lista.add(subjects);
        System.out.println(subjects.get(4));
        for (String s : subjects.get(4)) {
            System.out.println(s);
        }

        int k = 0;
        for (Map<Integer, String[]> s1 : lista) {

            System.out.println(s1.toString());
            k += 1;
            String sss[] = s1.get(k);
            System.out.println(sss[0]);
            System.out.println(sss[1]);

        }*/

    }

    public static void lecturejson() {
        File file = new File("./Agenda.json");
        BufferedReader br;
        String data = "";
        try {
            String st;
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                data = data + st + "\n";
            }
            System.out.println(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewJson.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
