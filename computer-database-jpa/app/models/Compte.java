package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Company entity managed by JPA
 */
@Entity 
public class Compte {

    @Id
    public Long id;
    
    @Constraints.Required
    public String login;

    @Constraints.Required
    public String password;
    
    @Constraints.Required
    public String url;

    @ManyToOne(cascade = CascadeType.MERGE)
    public TypeCompte typeCompte;

    @ManyToOne(cascade = CascadeType.MERGE)
    public Projet projet;
    
    
    public static Compte findById(Long id) {
        return JPA.em().find(Compte.class, id);
    }


}

