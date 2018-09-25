package Beans;

import Entites.Commande;
import Entites.Element;
import Entites.LigneDeCommande;
import Entites.Menu;
import Entites.OptionGratuite;
import Entites.Produit;
import Entites.Propriete;
import Entites.Statut;
import Entites.Tva;
import Entites.Type;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;

@Stateless
public class CreationDonnees implements CreationDonneesLocal {
    
    public void creerDonnes(){
        Date date1 = new GregorianCalendar(2018, 8, 25, 19, 50).getTime();
        Commande commande1 = new Commande(date1);
        
        
        Tva tva1 = new Tva(0.1F); 
        /*POUR INFO // 
            -Le taux de 10% 
                s’applique pour tous les produits alimentaires qui sont consommés immédiatement, 
                qu’il s’agisse de :
                    nourriture à emporter,
                    nourriture à livrer,
                    nourriture à consommer sur place,
                    ou de prestation de traiteur (hors services annexes tels location de salle).
            -Le taux de 5,5% 
                s’applique pour les produits alimentaires conditionnés qu’il est possible de conserver 
                et de consommer plus tard. Par exemple une bouteille d’eau fermée, ou un plat préparé sous vide. 
                Peu importe que le produit soit consommé plus tard ou immédiatement.
            -Le taux de 20% 
                s’applique pour les boissons alcoolisées, qu’elles soient consommées sur place, 
                livrées ou emportées. Le taux de TVA alcool est unique.*/
        Tva tva2 = new Tva(0.055F); 
        /* 5.5% >> TVA sur les livres en France continentale*/
        
        
        Type type1 = new Type("MENU");
        Type type2 = new Type("SANDWICH");
        Type type3 = new Type("ACCOMPAGNEMENT");
        Type type4 = new Type("BOISSON");
        Type type5 = new Type("SALADE");
        Type type6 = new Type("DESSERT");
        Type type7 = new Type("JOUET");
        
        
        Element element1 = new Element("Salade");
        Element element2 = new Element("Fromage");
        Element element3 = new Element("Sauce");
        Element element4 = new Element("Oignons");
        Element element5 = new Element("Cornichons");
        Element element6 = new Element("Glace"); /***--_glaçons pour les boissons_--***/
        Element element7 = new Element("Ketchup");
        Element element8 = new Element("Moutarde");
        
        
        /* PROPAL */
        Statut statut1 = new Statut(0, "A PREPARER EN CUISINE");
        Statut statut2 = new Statut(1, "EN COURS DE PREPARATION EN CUISINE");
        Statut statut3 = new Statut(2, "PRET");
        
        
        Propriete propriete1 = new Propriete("Volume de 50cL", "50cL");
        Propriete propriete2 = new Propriete("Volume de 33cL", "33cL");
        Propriete propriete3 = new Propriete("Volume de 40cL", "40cL");
        Propriete propriete4 = new Propriete("Volume de 20cL", "20cL");
        
        
        OptionGratuite optionGratuite1 = new OptionGratuite("Faites votre choix", "...pour la Sauce de la Salade Caesar : avec ou sans SAUCE CAESAR");
        
        
        // !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!!
        // !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! 
        Produit produit1 = new Produit("Big Mac", 4.0F, 0,
                "Deux steack hachés, du cheddar fondu, 3 buns de pain, des oignons, des cornichons, deux lits de salade et une sauce inimitable...", 
                "image");
        /*   // PROBLEME CONCERNANT LES PRIX //
                ici 4.0F c'est le prix HT du BIG MAC (qui est à 4.40€TTC sur le site)
        */
        produit1.getElements().add(element1);
        produit1.getElements().add(element2);
        produit1.getElements().add(element3);
        produit1.getElements().add(element4);
        produit1.getElements().add(element5);
        produit1.setType(type2);
        Produit produit2 = new Produit("GRANDE FRITE", 2.6F, 0, 
                "Ce sont toujours les vedettes des restaurants. Créées à partir de pommes de terre à chair blanche, elles sont aussi longues que croustillantes. Cuites avec de l'huile végétale, elles sont servies avec du ketchup, de la sauce moutarde ou une sauce spéciale.", 
                "image");
        produit2.setType(type3);
        Produit produit3 = new Produit("GRAND COCA-COLA®", 2.6F, 3, 
                "50cl\n\n original taste = goût original", 
                "image");
        produit3.getProprietes().add(propriete1);
        produit3.getElements().add(element6);
        produit3.setType(type4);
        Produit produit4 = new Produit("SALADE CHICKEN CAESAR", 7.3F, 3, 
                "Salade composée d'un mélange de romaine et de batavia, de 2 spécialités panées au poulet, de tomates-cerises, de copeaux de fromage et de délicieux croûtons saveur ail et fines herbes.\n\nServie avec une sauce Caesar.\n\nChicken = spécialité panée au poulet.", 
                "image");
        Produit produit5 = new Produit("EVIAN® (33CL)", 2.3F, 3, 
                "EVIAN® (33CL)",
                "image");
        Produit produit6 = new Produit("MOYENNE FRITE", 2.3F, 0, 
                "Ce sont toujours les vedettes des restaurants. Créées à partir de pommes de terre à chair blanche, elles sont aussi longues que croustillantes. Cuites avec de l'huile végétale, elles sont servies avec du ketchup, de la sauce moutarde ou une sauce spéciale.",
                "image");
        Produit produit7 = new Produit("MOYEN COCA-COLA®", 2.3F, 0, 
                "40cl", 
                "image");   
        Produit produit8 = new Produit("CHEESEBURGER", 1.8F, 0, 
                "Un steak haché, une tranche de cheddar fondu, des cornichons, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique.\n\nPain spécial, steak haché, fromage fondu, oignon, cornichon, moutarde, ketchup.", 
                "image");   
        Produit produit9 = new Produit("PETITE FRITE", 1.8F, 0, 
                "Ce sont toujours les vedettes des restaurants. Créées à partir de pommes de terre à chair blanche, elles sont aussi longues que croustillantes. Cuites avec de l'huile végétale, elles sont servies avec du ketchup, de la sauce moutarde ou une sauce spéciale.", 
                "image");   
        Produit produit10 = new Produit("MINUTE MAID® ORANGE (20CL)", 1.77F, 3, 
                "20cl", 
                "image"); 
        Produit produit11 = new Produit("P'TITE POMME", 1.36F, 3, 
                "Apportez une note fruitée à votre repas. Craquez pour les savoureux quartiers de pommes croquants.", 
                "image");   
        Produit produit12 = new Produit("LIVRE", 2.37F, 3, 
                "Place à la lecture dans ton Happy Meal ! En ce moment, 2 livres inédits à collectionner.", 
                "image");  
        Produit produit13 = new Produit("SAUCE CAESAR", 0.18F, 3, 
                "LA SAUCE CAESAR", 
                "image");  
        
        
        // !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!!
        // !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! 
        Menu menu1 = new Menu("MENU MAXI BEST OF™", 7.4F, 
                "LE MENU MAXI BEST OF, C'EST...\n- 1 sandwich au choix* - 1 grande portion de frites, ou de Deluxe Potatoes, ou 1 P'tite Salade - 1 bouteille d'Evian 50cl, ou 1 bouteille de Badoit 50cl, ou 1 Minute Maid orange 47cl, ou 1 soda 50cl", 
                "image");
        /*   // PROBLEME CONCERNANT LES PRIX //
                ici 7.4F c'est le prix HT du MENU MAXI BEST OF BIG MAC (à 8.10€TTC sur le site)
                Et les autres 'MENU MAXI BEST OF' sont par exmple à 13.95€TTC pour le signature,
                etc.
        */
        Menu menu2 = new Menu("MENU SALADE", 7.27F, 
                "MENU SALADE\nMenu Salade", 
                "image");
        Menu menu3 = new Menu("MENU BEST OF™", 7.0F, 
                "LE MENU BEST OF, C'EST...\n1 sandwich au choix* - 1 portion moyenne de frites, ou de Deluxe Potatoes, ou 1 P'tite Salade - 1 bouteille d'Evian 33cl, ou 1 bouteille de Badoit 33cl, ou 1 Minute Maid orange 30cl, ou 1 soda 40cl.", 
                "image");
        Menu menu4 = new Menu("MENU HAPPY MEAL", 3.64F, 
                "HAPPY MEAL\n- un plat au choix (McFish, Croque McDo, Hamburger, Cheeseburger, Chicken McNuggets)\n\n- un accompagnement au choix (Petite Frite, Crousties, Moyenne Deluxe Potatoes, P'tites Tomates)\n\n- une boisson gazeuse 25cl, ou un jus de fruits Bio ou un Minute Maid Orange 20cl, ou un Lipton Ice Tea 25cl, Evian 33cl\n\n- un dessert au choix (P'tite Pomme, Mon Bio à boire, Berlingo' ou le fruit du moment) et aussi choisissez entre un super jouet ou un beau livre.", 
                "image");
        
        
        //LigneDeCommande ligneDeCommande = new LigneDeCommande(QUANTITE, PRIX, TVA, COMMANDE);
        LigneDeCommande ligneDeCommande1 = new LigneDeCommande(1, menu1.getPrix(), tva1.getTaux(), commande1);
        LigneDeCommande ligneDeCommande11 = new LigneDeCommande(1, produit1.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande11.setLigneParent(ligneDeCommande1);
        ligneDeCommande11.getElements().add(element1);
        ligneDeCommande11.getElements().add(element2);
        ligneDeCommande11.getElements().add(element3);
        ligneDeCommande11.getElements().add(element4);
        ligneDeCommande11.getElements().add(element5);
        LigneDeCommande ligneDeCommande12 = new LigneDeCommande(1, produit2.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande12.setLigneParent(ligneDeCommande1);
        LigneDeCommande ligneDeCommande13 = new LigneDeCommande(1, produit3.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande13.setLigneParent(ligneDeCommande1);
        ligneDeCommande13.getElements().add(element6);
        
    }

    
}

/*--------------- CDI1804 --------------- by CL --------------- CDI1804 ---------------*/

