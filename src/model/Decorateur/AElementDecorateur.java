/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Decorateur;

/**
 *@JsonSubTypes({ @Type(value = AdressePostale.class, name = "AdressePostale"), @Type(value = Email.class, name = "Email"),  @Type(value = TelephoneFixe.class, name = "TelephoneFixe"),  @Type(value = TelephoneMobile.class, name = "TelephoneMobile") })

 * @author pom
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
 
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({ 
    @Type(value = AdressePostale.class, name = "AdressePostale"), 
    @Type(value = Email.class, name = "Email"),  
    @Type(value = TelephoneFixe.class, name = "TelephoneFixe"),  
    @Type(value = TelephoneMobile.class, name = "TelephoneMobile") })
public abstract class AElementDecorateur implements IElementDecorateur, IVisitable {
   /*@JsonProperty("name")
    String name;
    @JsonProperty("sound")
    String sound;
    @JsonProperty("type")
    String type;
    @JsonProperty("endangered")
    boolean endangered;*/
 
}
