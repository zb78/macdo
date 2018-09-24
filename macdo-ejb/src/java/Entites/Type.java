package Entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Atributs
    @Column(nullable = false)
    private String nom;
    
    //Associations
    @OneToMany(mappedBy = "type")
    private Collection<Produit> produit;
   
    
    //Constructeurs

    public Type() {
    }

   
    //Getters
    
    //Setters
    
    
    //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Autres
    @Override
    public String toString() {
        return "Entites.Type[ id=" + id + " ]";
    }
    
}
