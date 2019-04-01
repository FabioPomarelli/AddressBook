/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;

/**
 *
 * @author pom
 */
public interface View extends java.util.Observer, Initializable{
    	public void addController(EventHandler controller);
}
