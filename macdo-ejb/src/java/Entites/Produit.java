package Entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Attributs
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private float prix;
    private int statut;
    private String description;
    private String image;
    
    //Associations
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Tva tva;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Type type;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Statut statuts;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<Propriete> proprietes;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<Element> elements;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<SupplementPayant> supplementpaynts;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Collection<OptionGratuite> optiongratuites;
    
    //Constructeurs
    public Produit() {
    }

    public Produit(String nom, float prix, int statut, String description, String image) {
        this.nom = nom;
        this.prix = prix;
        this.statut = statut;
        this.description = description;
        this.image = image;
    }

    public Produit(String nom, float prix, int statut, String description, String image, Tva tva, Type type, Statut statuts, Collection<Propriete> proprietes, Collection<Element> elements, Collection<SupplementPayant> supplementpaynts, Collection<OptionGratuite> optiongratuites) {
        this.nom = nom;
        this.prix = prix;
        this.statut = statut;
        this.description = description;
        this.image = image;
        this.tva = tva;
        this.type = type;
        this.statuts = statuts;
        this.proprietes = proprietes;
        this.elements = elements;
        this.supplementpaynts = supplementpaynts;
        this.optiongratuites = optiongratuites;
    }
    
    //Getters
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public int getStatut() {
        return statut;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //Autres Getters-Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Propriete> getProprietes() {
        return proprietes;
    }

    public void setProprietes(Collection<Propriete> proprietes) {
        this.proprietes = proprietes;
    }

    public Collection<Element> getElements() {
        return elements;
    }

    public void setElements(Collection<Element> elements) {
        this.elements = elements;
    }

    public Collection<SupplementPayant> getSupplementpaynts() {
        return supplementpaynts;
    }

    public void setSupplementpaynts(Collection<SupplementPayant> supplementpaynts) {
        this.supplementpaynts = supplementpaynts;
    }

    public Collection<OptionGratuite> getOptiongratuites() {
        return optiongratuites;
    }

    public void setOptiongratuites(Collection<OptionGratuite> optiongratuites) {
        this.optiongratuites = optiongratuites;
    }
    
    //Autres
    @Override
    public String toString() {
        return "Entites.Produit[ id=" + id + " ]";
    }

}
