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
public class Statut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Attributs
    private int nombre;
    @Column(nullable = false)
    private String nom;

    //Associations
    @OneToMany(mappedBy = "statuts")
    private Collection<Produit> produit;

    //Constructeurs
    public Statut() {
    }

    public Statut(int nombre, String nom) {
        this.nombre = nombre;
        this.nom = nom;
    }

    public Statut(int nombre, String nom, Collection<Produit> produit) {
        this.nombre = nombre;
        this.nom = nom;
        this.produit = produit;
    }

    //Getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getNombre() {
        return nombre;
    }

    public String getNom() {
        return nom;
    }

    //Setters
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Autres Getters-Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Produit> getProduit() {
        return produit;
    }

    public void setProduit(Collection<Produit> produit) {
        this.produit = produit;
    }

    //Autres
    @Override
    public String toString() {
        return "Entites.Statut[ id=" + id + " ]";
    }

}
