/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entites.LigneDeCommande;
import Entites.Menu;
import Entites.Produit;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateful;

/**
 *
 * @author cdi314
 */
@Stateful
public class GestionPanier implements GestionPanierLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    HashMap<String, LigneDeCommande> panier;

    public GestionPanier() {
        panier = new HashMap();
    }

    public Collection getPanier() {
        return panier.values();
    }

    public void addArticle(Produit produit) {
        if (!panier.containsKey(produit.getNom())) {
            LigneDeCommande lig = new LigneDeCommande(1, produit.getPrix(), produit.getTva().getTaux());
            panier.put(produit.getNom(), lig);
        } else {
            int qty = panier.get(produit.getNom()).getQuantite();
            panier.get(produit.getNom()).setQuantite(++qty);
        }
    }

        public void addArticle(Menu produit) {
        if (!panier.containsKey(produit.getNom())) {
            LigneDeCommande lig = new LigneDeCommande(1, produit.getPrix(), produit.getTva().getTaux());
            panier.put(produit.getNom(), lig);
        } else {
            int qty = panier.get(produit.getNom()).getQuantite();
            panier.get(produit.getNom()).setQuantite(++qty);
        }
    }
    
    public void removeArticle(Produit produit) {
        if (panier.containsKey(produit.getNom())) {
            LigneDeCommande lig = panier.get(produit.getNom());
            int qty = lig.getQuantite();
            if (qty == 1) {
                panier.remove(produit.getNom());
            } else {
                lig.setQuantite(--qty);
            }
        }
    }
    
    
}
