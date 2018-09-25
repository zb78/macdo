/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi314
 */
@Entity
public class LigneDeCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer quantite;
    private Float prix;
    private Float tvaTaux;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Commande commande;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Menu menu;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<LigneDeCommande> sousLignesDeCommandes;
    
    @OneToMany(mappedBy = "sousLignesDeCommandes")
    private LigneDeCommande ligneParent;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<OptionGratuite> optionGratuites;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<SupplementPayant> supplementPayants;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<Element> elements;
    
    public LigneDeCommande() {
        sousLignesDeCommandes = new ArrayList<>();
        optionGratuites = new ArrayList<>();
        supplementPayants = new ArrayList<>();
        elements = new ArrayList<>();
    }

    public LigneDeCommande(Integer quantite, Float prix, Float tvaTaux) {
        this();
        this.quantite = quantite;
        this.prix = prix;
        this.tvaTaux = tvaTaux;
    }

    public LigneDeCommande(Integer quantite, Float prix, Float tvaTaux, Commande commande, Menu menu) {
        this();
        this.quantite = quantite;
        this.prix = prix;
        this.tvaTaux = tvaTaux;
        this.commande = commande;
        this.menu = menu;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Float getTvaTaux() {
        return tvaTaux;
    }

    public void setTvaTaux(Float tvaTaux) {
        this.tvaTaux = tvaTaux;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Collection<LigneDeCommande> getSousLignesDeCommandes() {
        return sousLignesDeCommandes;
    }

    public void setSousLignesDeCommandes(Collection<LigneDeCommande> sousLignesDeCommandes) {
        this.sousLignesDeCommandes = sousLignesDeCommandes;
    }

    public LigneDeCommande getLigneParent() {
        return ligneParent;
    }

    public void setLigneParent(LigneDeCommande ligneParent) {
        this.ligneParent = ligneParent;
    }

    public Collection<OptionGratuite> getOptionGratuites() {
        return optionGratuites;
    }

    public void setOptionGratuites(Collection<OptionGratuite> optionGratuites) {
        this.optionGratuites = optionGratuites;
    }

    public Collection<SupplementPayant> getSupplementPayants() {
        return supplementPayants;
    }

    public void setSupplementPayants(Collection<SupplementPayant> supplementPayants) {
        this.supplementPayants = supplementPayants;
    }

    public Collection<Element> getElements() {
        return elements;
    }

    public void setElements(Collection<Element> elements) {
        this.elements = elements;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.quantite);
        hash = 43 * hash + Objects.hashCode(this.prix);
        hash = 43 * hash + Objects.hashCode(this.tvaTaux);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LigneDeCommande other = (LigneDeCommande) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        if (!Objects.equals(this.tvaTaux, other.tvaTaux)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LigneDeCommande{" + "id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", tvaTaux=" + tvaTaux + '}';
    }
    
    

    
    
}