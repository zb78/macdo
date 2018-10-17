/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entites.Commande;
import Entites.LigneDeCommande;
import Entites.Menu;
import Entites.Produit;
import Entites.Tva;
import Entites.Type;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi314
 */
@Stateful
public class GestionPanier implements GestionPanierLocal {

    @PersistenceContext(unitName = "macdo-ejbPU")
    private EntityManager em;

    private ArrayList<LigneDeCommande> panier;

    public GestionPanier() {
        panier = new ArrayList<>();
    }

    @Override
    public ArrayList<LigneDeCommande> getPanier() {
        return panier;
    }

    @Override
    public void setPanier(ArrayList<LigneDeCommande> panier) {
        this.panier = panier;
    }

    @Override
    public void addArticle(Produit produit) {
        System.out.println("addArticle++++++++++++" + produit);
        LigneDeCommande lig = new LigneDeCommande(produit);
        System.out.println("LigneDeCommande done");
        System.out.println("addArticle>>>" + this.panier);
        panier.add(lig);
        System.out.println("addArticle>>>done" + this.panier);
    }

    @Override
    public void addArticle(Menu produit) {
        LigneDeCommande lig = new LigneDeCommande(1, produit.getPrix(), produit.getTva().getTaux());
        panier.add(lig);
//        if (!panier.contains(lig)) {
//            panier.add(lig);
//        } else {
//            int p = panier.indexOf(lig);
//            panier.get(p).setQuantite(panier.get(p).getQuantite() + 1);
//        }
    }

    @Override
    public void removeArticle(Produit produit) {
        LigneDeCommande lig = new LigneDeCommande(1, produit.getPrix(), produit.getTva().getTaux());
        panier.remove(lig);

    }

    @Override
    public void removeArticle(Menu produit) {
        LigneDeCommande lig = new LigneDeCommande(1, produit.getPrix(), produit.getTva().getTaux());
        panier.remove(lig);
    }

    @Override
    public void removeArticle(Integer indiceOfPanier) {
        panier.remove(indiceOfPanier.intValue());
    }

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public Produit getProduitById(Long id) {
        Produit produit = em.find(Produit.class, id);
        return produit;
    }

    @Override
    public void addProduitInPanierById(Long id) {

        Produit produit = getProduitById(id);
        System.out.println("panier >>>>>  :" + panier + "produit :>>>> " + produit);
        if (produit != null) {
            addArticle(produit);
        }
        System.out.println("panier :<<<<: " + panier);
    }

    @Override
    public void persistCommande() {
        Commande commande = new Commande(new Date());
        //em.persist(commande);
        for (LigneDeCommande p : panier) {
            p.setCommande(commande);
            //em.persist(p);
        }

        for (LigneDeCommande lc : panier) {
            if (lc.getSousLignesDeCommandes() != null) {
                for (LigneDeCommande sousLignesDeCommande : lc.getSousLignesDeCommandes()) {
                    em.persist(sousLignesDeCommande);
                }
            } else {
                em.persist(lc);
            }
        }

        panier.clear();
    }

    @Override
    public String calculTotal() {
        Float tot = 0F;
        for (LigneDeCommande ligneDeCommande : panier) {
            tot += (ligneDeCommande.getPrix() * (1 + ligneDeCommande.getTvaTaux()));
        }
        int totint = (int) (tot * 100);
        tot = (float) (totint / 100);
        return String.valueOf(tot);
    }

    @Override
    public void ajouterPanier(int indexPanier) {
        LigneDeCommande l = panier.get(indexPanier);
        l.setQuantite(l.getQuantite() + 1);
    }

    @Override
    public void retirerPanier(int indexPanier) {
        LigneDeCommande l = panier.get(indexPanier);
        if (l.getQuantite() == 1) {
            panier.remove(l);
        } else {
            l.setQuantite(l.getQuantite() - 1);
        }
    }

    public LigneDeCommande perso() {
        Tva tva = em.find(Tva.class, 1);
        String desc = "- 1 sandwich au choix*\n"
                + "- 1 grande portion de frites, ou de grande Deluxe Potatoes, ou 1 P'tite Salade\n"
                + "- 1 bouteille d'Evian 50cl, ou 1 bouteille de Badoit 50cl, ou 1 Minute Maid orange 47cl, ou 1 soda 50cl";
        Menu menu = new Menu("Menu BestOf", 10F, desc, "./Images/MenuBestOf&MenuMaxiBestOf.png", tva);
        
        Type t = new Type("Boisson");
        Type t1 = new Type("Accompagnement");
        Type t2 = new Type("Burger");
        
        Produit boisson = new Produit("Coca Cola", 1F, "UNe Grande Coca", "./Images/GrandCoca.png");
        Produit accompagnement = new Produit("Grande Frite", 2F, "Grande Frite","./Images/GrandeFrite.png" );
        Produit burger = new Produit("Big Mac", 5F, "Big Mac", "./Images/BigMac.jpg" );
        
        ArrayList<Produit> boissons = new ArrayList<>();
        ArrayList<Produit> accompagnements = new ArrayList<>();
        ArrayList<Produit> burgers = new ArrayList<>();
        boissons.add(boisson);
        accompagnements.add(accompagnement);
        burgers.add(burger);
        
        ArrayList<Type> types = new ArrayList<>();
        types.add(t);
        types.add(t1);
        types.add(t2);
        
        menu.setTypes(types);
        
        Commande c = new Commande(new Date());
        
        ArrayList<LigneDeCommande> slc = new ArrayList<>();
        slc.add(new LigneDeCommande(burger));
        slc.add(new LigneDeCommande(accompagnement));
        slc.add(new LigneDeCommande(boisson));
        
        LigneDeCommande lc = new LigneDeCommande();
        lc.setMenu(menu);
        lc.setSousLignesDeCommandes(slc);
        for (LigneDeCommande ligneDeCommande : slc) {
            ligneDeCommande.setLigneParent(lc);
        }
        
        return lc;
        
    }
}
