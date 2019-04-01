/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ElementSimple;

import model.Decorateur.AdressePostale;
import model.Decorateur.Email;

/**
 *
 * @author pom
 */
public class AppliVisitor implements IVisitor{
    
    public void visit(SimpleContact contact){
      /*  if (contact.nomgetPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;
        }*/
    
    }

    //visit other concrete decoratuers
    public void visit(AdressePostale adress){
    
    
    }

    public void visit(Email email){
    
    
    }
  private double totalPostageForCart;
  //collect data about the book

  //add other visitors here

  //return the internal state
  public double getTotalPostage() {
    return totalPostageForCart;
  }
}