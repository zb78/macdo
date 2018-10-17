/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.secondaires;

import Beans.GestionPanierLocal;
import Entites.Produit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi314
 */
public class Panier implements sousController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        GestionPanierLocal gestionPanier;
        HttpSession session = request.getSession();
        gestionPanier
                = (GestionPanierLocal) session.getAttribute("gestionPanier");
        if (gestionPanier == null) {
            gestionPanier = lookupGestionPanierLocal();
            session.setAttribute("gestionPanier", gestionPanier);
        }

        String numProduit = request.getParameter("add");
        String produitPlus = request.getParameter("plus");
        String produitMoins = request.getParameter("moins");
        String valider = request.getParameter("valider");

        System.out.println("numProduit : " + numProduit);

        if (numProduit != null) {

            Long idProduit = Long.valueOf(numProduit);

            Produit produit = gestionPanier.getProduitById(idProduit);
            if (produit != null) {
                gestionPanier.addArticle(produit);
            }
        }
        
        if(produitPlus!=null){
            Integer idPanier = Integer.valueOf(produitPlus);
            gestionPanier.ajouterPanier(idPanier);
        }

        if (produitMoins != null) {
            Integer idPanier = Integer.valueOf(produitMoins);
            gestionPanier.retirerPanier(idPanier);
            
        }

        if (valider != null) {
            gestionPanier.persistCommande();
            return "/WEB-INF/commandevalider.jsp";
        }

        session.setAttribute("prixTtc", gestionPanier.calculTotal());
        System.out.println("avant le webinf : " + gestionPanier.getPanier());

        return "/WEB-INF/panier.jsp";
    }

    private GestionPanierLocal lookupGestionPanierLocal() {
        try {
            Context c = new InitialContext();
            return (GestionPanierLocal) c.lookup("java:global/macdo/macdo-ejb/GestionPanier!Beans.GestionPanierLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
