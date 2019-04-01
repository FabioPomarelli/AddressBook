/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pom
 */
public class TOKILLprova {

    private static HashMap<Integer, String[]> subjects;

    public TOKILLprova() {
    }

    public static void main(String[] args) {

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
            k+=1;
            String sss[] =s1.get(k);
            System.out.println(sss[0]);
            System.out.println(sss[1]);
            
            
        }

    }
}
