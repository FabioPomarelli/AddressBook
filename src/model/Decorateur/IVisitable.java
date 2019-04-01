/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Decorateur;

import java.util.List;
import java.util.Map;
import model.ElementSimple.IVisitor;

/**
 *
 * @author pom
 */
public interface IVisitable {

    public void accept(IVisitor visitor);

    public void setAccept(IVisitor visitor, List<Map<Integer, String[]>> values, List deco);

    public List<Map<Integer, String[]>> getAccept(IVisitor visitor);

    //public void getAccept(AppliVisitor visitor, String string);
}
