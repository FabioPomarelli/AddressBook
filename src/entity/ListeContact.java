/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pom
 */
public class ListeContact {

    private String name;
    private String department;

    public ListeContact(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String fName) {
        name = fName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String fName) {
        department = fName;
    }
}
