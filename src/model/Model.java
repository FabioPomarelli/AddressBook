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
public interface Model {
    public void setValue(String value);

    public void incrementValue();

    public void addValue(String str);

    public void deleteValue();

    public void deleteLastValue();

    public void calculate();

    public void init();

    public void setShowMessaggio(boolean toggle);

    public boolean getShowMessaggio();

    public void jobResponce(String responce);

    public void jobResponce();
    
    public void safe();
    
}
