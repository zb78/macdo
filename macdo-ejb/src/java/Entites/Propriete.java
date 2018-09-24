package Entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Propriete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Attributs
    @Column(nullable = false)
    private String nom;
    private String valeur;

    //Associations
    @ManyToMany(mappedBy = "proprietes")
    private Collection<Produit> produits;

    //Constructeurs
    public Propriete() {
    }

    public Propriete(String nom, String valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public Propriete(String nom, String valeur, Collection<Produit> produits) {
        this.nom = nom;
        this.valeur = valeur;
        this.produits = produits;
    }

    //Getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNom() {
        return nom;
    }

    public String getValeur() {
        return valeur;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
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

    //Autres
    @Override
    public String toString() {
        return "Entites.Propriete[ id=" + id + " ]";
    }

}
