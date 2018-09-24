package Entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Attributs
    private float taux;
        
    //Associations
    @OneToMany(mappedBy = "tva")
    private Collection<Produit> produit;
    
    //Constructeurs
    public Tva() {
    }

    public Tva(float taux) {
        this.taux = taux;
    }
    
       
    //Getters
    public float getTaux() {
        return taux;
    }
    

    //Setters

    public void setTaux(float taux) {
        this.taux = taux;
    }
    
    
    
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
        return "Entites.Tva[ id=" + id + " ]";
    }
    
}
