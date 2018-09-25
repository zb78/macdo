package Entites;

import java.io.Serializable;
import java.util.ArrayList;
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
    private Float taux;

    //Associations
    @OneToMany(mappedBy = "tva")
    private Collection<Produit> produits;

    @OneToMany(mappedBy = "tva")
    private Collection<Menu> menus;

    //Constructeurs
    public Tva() {
        produits = new ArrayList();
        menus = new ArrayList();
    }

    public Tva(float taux) {
        this();
        this.taux = taux;
    }

    public Tva(Float taux, Collection<Produit> produits, Collection<Menu> menus) {
        this();
        this.taux = taux;
        this.produits = produits;
        this.menus = menus;
    }

    //Getters
    public float getTaux() {
        return taux;
    }

    //Setters
    public void setTaux(Float taux) {
        this.taux = taux;
    }

    //Autres Getters-Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    //Autres
    @Override
    public String toString() {
        return "Entites.Tva[ id=" + id + " ]";
    }

}
