/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.ElementSimple;

import entity.Decorateur.AdressePostale;
import entity.Decorateur.Email;

/**
 *
 * @author pom
 */
public interface IVisitor {

    public void visit(SimpleContact contact);

    //visit other concrete decoratuers
    public void visit(AdressePostale adress);

    public void visit(Email email);
    
    
}
