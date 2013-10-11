package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Company entity managed by JPA
 */
@Entity 
public class TypeCompte {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    public String description;
    
    public static TypeCompte findById(Long id) {
        return JPA.em().find(TypeCompte.class, id);
    }


}

