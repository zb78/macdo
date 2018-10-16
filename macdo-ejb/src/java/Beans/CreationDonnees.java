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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreationDonnees implements CreationDonneesLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
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
        
        
        Menu menu1 = new Menu("SANDWICH", "./Images/vignette/sandwich.png");
        Menu menu2 = new Menu("ACCOMPAGNEMENT", "./Images/vignette/friteEtSauce.png" );
        Menu menu3 = new Menu("BOISSON", "./Images/vignette/boisson.png");
        Menu menu4 = new Menu("SALADE", "./Images/vignette/salade.png");
        Menu menu5 = new Menu("DESSERT", "./Images/vignette/dessert.png");
        
        
        Type type1 = new Type("Sauce", "./Images/vignette/sauce.png");
        Type type2 = new Type("Sandwich", "./Images/vignette/sandwich.png");
        Type type2BIS = new Type("Sandwich", "./Images/vignette/sandwich.png");
        Type type2AFF = new Type("Sandwich", "./Images/vignette/sandwich.png");
        Type type2MINI = new Type("Sandwich", "./Images/vignette/sandwich.png");
        Type type2MINIAFF = new Type("Sandwich", "./Images/vignette/sandwich.png");
        Type type3MAX = new Type("Accompagnement", "./Images/vignette/friteEtSauce.png" );
        Type type3MAXAFF = new Type("Accompagnement", "./Images/vignette/friteEtSauce.png" );
        Type type3 = new Type("Accompagnement", "./Images/vignette/friteEtSauce.png" );
        Type type3AFF = new Type("Accompagnement", "./Images/vignette/friteEtSauce.png" );
        Type type3MINI = new Type("Accompagnement", "./Images/vignette/friteEtSauce.png" );
        Type type3MINIAFF = new Type("Accompagnement", "./Images/vignette/friteEtSauce.png" );
        Type type4MAX = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type4MAXAFF = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type4 = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type4BIS = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type4AFF = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type4MINI = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type4MINIAFF = new Type("Boisson", "./Images/vignette/boisson.png");
        Type type5 = new Type("Salade", "./Images/vignette/salade.png");
        Type type5AFF = new Type("Salade", "./Images/vignette/salade.png");
        Type type6MINI = new Type("Dessert", "./Images/vignette/dessert.png");
        Type type6MINIAFF = new Type("Dessert", "./Images/vignette/dessert.png");
        Type type7MINI = new Type("Jouet", "./Images/vignette/livre.png");

        
        type2AFF.setMenu(menu1);
        type2MINIAFF.setMenu(menu1);
        type3MAXAFF.setMenu(menu2);
        type3AFF.setMenu(menu2);
        type3MINIAFF.setMenu(menu2);
        type4MAXAFF.setMenu(menu3);
        type4AFF.setMenu(menu3);
        type4MINIAFF.setMenu(menu3);
        type5AFF.setMenu(menu4);
        type6MINIAFF.setMenu(menu5);
        //System.out.println("*********TYPE*********"+ type2AFF.getMenu());
        
        
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
        Statut statut2 = new Statut(1, "PRET");  
        
        
        Propriete propriete1 = new Propriete("Volume de 50cL", "50cL");
        Propriete propriete2 = new Propriete("Volume de 33cL", "33cL");
        Propriete propriete3 = new Propriete("Volume de 40cL", "40cL");
        Propriete propriete4 = new Propriete("Volume de 20cL", "20cL");
        
        
        OptionGratuite optionGratuite0 = new OptionGratuite("Faites votre choix", "SANS SAUCE");
        OptionGratuite optionGratuite1 = new OptionGratuite("Faites votre choix", "SAUCE CAESAR");
        
        OptionGratuite optionGratuite2 = new OptionGratuite("Jouet", "LIVRE");
        
        
        // !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! 
        Produit produit1a = new Produit("Big Mac", 4.0F, statut1,
                "Deux steack hachés, du cheddar fondu, 3 buns de pain, des oignons, des cornichons, deux lits de salade et une sauce inimitable...", 
                "./Images/BigMac.jpg");
        /*   // PROBLEME CONCERNANT LES PRIX //
                ici 4.0F c'est le prix HT du BIG MAC (qui est à 4.40€TTC sur le site)
        */
        produit1a.getElements().add(element1);
        produit1a.getElements().add(element2);
        produit1a.getElements().add(element3);
        produit1a.getElements().add(element4);
        produit1a.getElements().add(element5);
        produit1a.setType(type2);
        produit1a.setTva(tva1);
        Produit produit1b = new Produit("Big Mac", 4.0F, statut1,
                "Deux steack hachés, du cheddar fondu, 3 buns de pain, des oignons, des cornichons, deux lits de salade et une sauce inimitable...", 
                "./Images/BigMac.jpg");
        /*   // PROBLEME CONCERNANT LES PRIX //
                ici 4.0F c'est le prix HT du BIG MAC (qui est à 4.40€TTC sur le site)
        */
        produit1b.getElements().add(element1);
        produit1b.getElements().add(element2);
        produit1b.getElements().add(element3);
        produit1b.getElements().add(element4);
        produit1b.getElements().add(element5);
        produit1b.setType(type2BIS);
        produit1b.setTva(tva1);
        Produit produit2 = new Produit("GRANDE FRITE", 2.6F, statut1, 
                "Ce sont toujours les vedettes des restaurants. Créées à partir de pommes de terre à chair blanche, elles sont aussi longues que croustillantes. Cuites avec de l'huile végétale, elles sont servies avec du ketchup, de la sauce moutarde ou une sauce spéciale.", 
                "./Images/GrandeFrite.png");
        produit2.setType(type3MAX);
        produit2.setTva(tva1);
        Produit produit3 = new Produit("GRAND COCA-COLA", 2.6F, statut2, 
                "50cl\n\n original taste = goût original", 
                "./Images/GrandCoca.png");
        produit3.getProprietes().add(propriete1);
        produit3.getElements().add(element6);
        produit3.setType(type4MAX);
        produit3.setTva(tva1);
        Produit produit4 = new Produit("SALADE CHICKEN CAESAR", 7.3F, statut2, 
                "Salade composée d'un mélange de romaine et de batavia, de 2 spécialités panées au poulet, de tomates-cerises, de copeaux de fromage et de délicieux croûtons saveur ail et fines herbes.\n\nServie avec une sauce Caesar.\n\nChicken = spécialité panée au poulet.", 
                "./Images/saladeCesar.png");
        produit4.setType(type5);
        produit4.getOptionGratuites().add(optionGratuite0);
        produit4.getOptionGratuites().add(optionGratuite1);
        produit4.setTva(tva1);
        Produit produit51 = new Produit("EVIAN (33CL)", 2.3F, statut2, 
                "EVIAN® (33CL)",
                "./Images/evian33.png");
        produit51.getProprietes().add(propriete2);
        produit51.setType(type4);
        produit51.setTva(tva1);
        Produit produit52 = new Produit("EVIAN (33CL)", 2.3F, statut2, 
                "EVIAN® (33CL)",
                "./Images/evian33.png");
        produit52.getProprietes().add(propriete2);
        produit52.setType(type4BIS);
        produit52.setTva(tva1);
        Produit produit53 = new Produit("EVIAN (33CL)", 2.3F, statut2, 
                "EVIAN® (33CL)",
                "./Images/evian33.png");
        produit53.getProprietes().add(propriete2);
        produit53.setType(type4MINI);
        produit53.setTva(tva1);
        Produit produit6 = new Produit("MOYENNE FRITE", 2.3F, statut1, 
                "Ce sont toujours les vedettes des restaurants. Créées à partir de pommes de terre à chair blanche, elles sont aussi longues que croustillantes. Cuites avec de l'huile végétale, elles sont servies avec du ketchup, de la sauce moutarde ou une sauce spéciale.",
                "./Images/MoyenneFrite.png");
        produit6.setType(type3);
        produit6.setTva(tva1);
        Produit produit71 = new Produit("MOYEN COCA-COLA", 2.3F, statut2, 
                "40cl", 
                "./Images/MoyenCoca.png");
        produit71.getProprietes().add(propriete3);
        produit71.getElements().add(element6);
        produit71.setType(type4);
        produit71.setTva(tva1);
        Produit produit72 = new Produit("MOYEN COCA-COLA", 2.3F, statut2, 
                "40cl", 
                "./Images/MoyenCoca.png");
        produit72.getProprietes().add(propriete3);
        produit72.getElements().add(element6);
        produit72.setType(type4BIS);
        produit72.setTva(tva1);
        Produit produit8 = new Produit("CHEESEBURGER", 1.8F, statut1, 
                "Un steak haché, une tranche de cheddar fondu, des cornichons, des oignons, du ketchup et de la moutarde douce dans un pain classique : fondez pour son goût unique et emblématique.\n\nPain spécial, steak haché, fromage fondu, oignon, cornichon, moutarde, ketchup.", 
                "./Images/cheeseburger.png");
        produit8.getElements().add(element2);
        produit8.getElements().add(element4);
        produit8.getElements().add(element5);
        produit8.getElements().add(element7);
        produit8.getElements().add(element8);
        produit8.setType(type2MINI);
        produit8.setTva(tva1);
        Produit produit9 = new Produit("PETITE FRITE", 1.8F, statut1, 
                "Ce sont toujours les vedettes des restaurants. Créées à partir de pommes de terre à chair blanche, elles sont aussi longues que croustillantes. Cuites avec de l'huile végétale, elles sont servies avec du ketchup, de la sauce moutarde ou une sauce spéciale.", 
                "./Images/petiteFrite.png");
        produit9.setType(type3MINI);
        produit9.setTva(tva1);
        Produit produit10 = new Produit("MINUTE MAID ORANGE (20CL)", 1.77F, statut2, 
                "20cl", 
                "./Images/minuteMaid20.png");
        produit10.getProprietes().add(propriete4);
        produit10.setType(type4MINI);
        produit10.setTva(tva1);
        Produit produit11 = new Produit("P'TITE POMME", 1.36F, statut2, 
                "Apportez une note fruitée à votre repas. Craquez pour les savoureux quartiers de pommes croquants.", 
                "./Images/ptitePomme.png");
        produit11.setType(type6MINI);
        produit11.setTva(tva1);
        Produit produit12 = new Produit("LIVRE", 2.37F, statut2, 
                "Place à la lecture dans ton Happy Meal ! En ce moment, 2 livres inédits à collectionner.", 
                "./Images/livre.png");
        produit12.setTva(tva2);
        produit12.setType(type7MINI);
        Produit produit13 = new Produit("SAUCE CAESAR", 0.18F, statut2, 
                "LA SAUCE CAESAR", 
                "./Images/sauceCesar.png");
        produit13.setType(type1);
        produit13.setTva(tva1);

        
        optionGratuite0.getProduits().add(produit4);
        optionGratuite1.getProduits().add(produit4);
        
        
        // !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!! IMAGE A FAIRE !!!!!!!!!!!
        // !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! PRIX PRODUIT A REVOIR !!!!!!!!!!! 
        Menu menu11 = new Menu("MENU MAXI BEST OF", 7.4F, 
                "LE MENU MAXI BEST OF, C'EST...\n- 1 sandwich au choix* - 1 grande portion de frites, ou de Deluxe Potatoes, ou 1 P'tite Salade - 1 bouteille d'Evian 50cl, ou 1 bouteille de Badoit 50cl, ou 1 Minute Maid orange 47cl, ou 1 soda 50cl", 
                "./Images/MenuBestOf&MenuMaxiBestOf.png");
        /*   // PROBLEME CONCERNANT LES PRIX //
                ici 7.4F c'est le prix HT du MENU MAXI BEST OF BIG MAC (à 8.10€TTC sur le site)
                Et les autres 'MENU MAXI BEST OF' sont par exmple à 13.95€TTC pour le signature,
                etc.
        */
        type2.setMenu(menu11);
        type3MAX.setMenu(menu11);
        type4MAX.setMenu(menu11);
        menu11.setTva(tva1);
        Menu menu12 = new Menu("MENU SALADE", 7.27F, 
                "MENU SALADE\nMenu Salade", 
                "./Images/menuSalade.png");
        type5.setMenu(menu12);
        type4.setMenu(menu12);
        menu12.setTva(tva1);
        Menu menu13 = new Menu("MENU BEST OF", 7.0F, 
                "LE MENU BEST OF, C'EST...\n1 sandwich au choix* - 1 portion moyenne de frites, ou de Deluxe Potatoes, ou 1 P'tite Salade - 1 bouteille d'Evian 33cl, ou 1 bouteille de Badoit 33cl, ou 1 Minute Maid orange 30cl, ou 1 soda 40cl.", 
                "./Images/MenuBestOf&MenuMaxiBestOf.png");

        type2BIS.setMenu(menu13);
        type3.setMenu(menu13);
        type4BIS.setMenu(menu13);
        menu13.setTva(tva1);
        Menu menu14 = new Menu("MENU HAPPY MEAL", 3.64F, 
                "HAPPY MEAL\n- un plat au choix (McFish, Croque McDo, Hamburger, Cheeseburger, Chicken McNuggets)\n\n- un accompagnement au choix (Petite Frite, Crousties, Moyenne Deluxe Potatoes, P'tites Tomates)\n\n- une boisson gazeuse 25cl, ou un jus de fruits Bio ou un Minute Maid Orange 20cl, ou un Lipton Ice Tea 25cl, Evian 33cl\n\n- un dessert au choix (P'tite Pomme, Mon Bio à boire, Berlingo' ou le fruit du moment) et aussi choisissez entre un super jouet ou un beau livre.", 
                "./Images/menuHappyMeal.png");
        type2MINI.setMenu(menu14);
        type3MINI.setMenu(menu14);
        type4MINI.setMenu(menu14);
        type6MINI.setMenu(menu14);
        menu14.setTva(tva1);
        menu14.getOptionGratuites().add(optionGratuite2);
        

        LigneDeCommande ligneDeCommande1 = new LigneDeCommande(1, menu11.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande1.setMenu(menu11);
        LigneDeCommande ligneDeCommande11 = new LigneDeCommande(1, produit1a.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande11.setLigneParent(ligneDeCommande1);
        ligneDeCommande11.getElements().add(element1);
        ligneDeCommande11.getElements().add(element2);
        ligneDeCommande11.getElements().add(element3);
        ligneDeCommande11.getElements().add(element4);
        ligneDeCommande11.getElements().add(element5);
        ligneDeCommande11.setProduit(produit1a);
        LigneDeCommande ligneDeCommande12 = new LigneDeCommande(1, produit2.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande12.setLigneParent(ligneDeCommande1);
        ligneDeCommande12.setProduit(produit2);
        LigneDeCommande ligneDeCommande13 = new LigneDeCommande(1, produit3.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande13.setLigneParent(ligneDeCommande1);
        ligneDeCommande13.getElements().add(element6);
        ligneDeCommande13.setProduit(produit3); 
        
        LigneDeCommande ligneDeCommande2 = new LigneDeCommande(1, menu12.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande2.setMenu(menu12);
        LigneDeCommande ligneDeCommande21 = new LigneDeCommande(1, produit4.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande21.setLigneParent(ligneDeCommande2);
        ligneDeCommande21.setProduit(produit4);
        ligneDeCommande21.getOptionGratuites().add(optionGratuite1);
        LigneDeCommande ligneDeCommande22 = new LigneDeCommande(1, produit51.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande22.setLigneParent(ligneDeCommande2);
        ligneDeCommande22.setProduit(produit51);
        
        LigneDeCommande ligneDeCommande3 = new LigneDeCommande(1, menu13.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande3.setMenu(menu13);
        LigneDeCommande ligneDeCommande31 = new LigneDeCommande(1, produit1b.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande31.setLigneParent(ligneDeCommande3);
        ligneDeCommande31.setProduit(produit1b);
        LigneDeCommande ligneDeCommande32 = new LigneDeCommande(1, produit6.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande32.setLigneParent(ligneDeCommande3);
        ligneDeCommande32.setProduit(produit6);
        LigneDeCommande ligneDeCommande33 = new LigneDeCommande(1, produit71.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande33.setLigneParent(ligneDeCommande3);
        ligneDeCommande33.getElements().add(element6);
        ligneDeCommande33.setProduit(produit71);
        
        LigneDeCommande ligneDeCommande4 = new LigneDeCommande(1, menu14.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande4.setMenu(menu14);
        LigneDeCommande ligneDeCommande41 = new LigneDeCommande(1, produit8.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande41.setLigneParent(ligneDeCommande4);
        ligneDeCommande41.getElements().add(element2);
        ligneDeCommande41.getElements().add(element4);
        ligneDeCommande41.getElements().add(element5);
        ligneDeCommande41.getElements().add(element7);
        ligneDeCommande41.getElements().add(element8);
        ligneDeCommande41.setProduit(produit8);
        LigneDeCommande ligneDeCommande42 = new LigneDeCommande(1, produit9.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande42.setLigneParent(ligneDeCommande4);
        ligneDeCommande42.setProduit(produit9);
        LigneDeCommande ligneDeCommande43 = new LigneDeCommande(1, produit10.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande43.setLigneParent(ligneDeCommande4);
        ligneDeCommande43.setProduit(produit10);
        LigneDeCommande ligneDeCommande44 = new LigneDeCommande(1, produit11.getPrix(), tva1.getTaux(), commande1);
        ligneDeCommande44.setLigneParent(ligneDeCommande4);
        ligneDeCommande44.setProduit(produit11);
        LigneDeCommande ligneDeCommande45 = new LigneDeCommande(1, produit12.getPrix(), tva2.getTaux(), commande1);
        ligneDeCommande45.setLigneParent(ligneDeCommande4);
        ligneDeCommande45.setProduit(produit12);
        
        
        
        
        em.persist(menu1);
        em.persist(menu2);
        em.persist(menu3);
        em.persist(menu4);
        em.persist(menu5);
        
                
        em.persist(type1);
        em.persist(type2);
        em.persist(type2BIS);
        em.persist(type2MINI);
        em.persist(type3MAX);
        em.persist(type3);
        em.persist(type3MINI);
        em.persist(type4MAX);
        em.persist(type4);
        em.persist(type4BIS);
        em.persist(type4MINI);
        em.persist(type5);
        em.persist(type6MINI);
        em.persist(type7MINI);
        
        em.persist(produit1a);
        em.persist(produit1b);
        em.persist(produit2);
        em.persist(produit3);
        em.persist(produit4);
        em.persist(produit51);
        em.persist(produit52);
        em.persist(produit53);
        em.persist(produit6);
        em.persist(produit71);
        em.persist(produit72);
        em.persist(produit8);
        em.persist(produit9);
        em.persist(produit10);
        em.persist(produit11);
        em.persist(produit12);
        em.persist(produit13);
        
        em.persist(menu11);
        em.persist(menu12);
        em.persist(menu13);
        em.persist(menu14);
        
        em.persist(ligneDeCommande11);
        em.persist(ligneDeCommande12);
        em.persist(ligneDeCommande13);
        em.persist(ligneDeCommande21);
        em.persist(ligneDeCommande22);
        em.persist(ligneDeCommande31);
        em.persist(ligneDeCommande32);
        em.persist(ligneDeCommande33);
        em.persist(ligneDeCommande41);
        em.persist(ligneDeCommande42);
        em.persist(ligneDeCommande43);
        em.persist(ligneDeCommande44);
        em.persist(ligneDeCommande45);
        
        
    }

    
}

/*--------------- CDI1804 --------------- by CL --------------- CDI1804 ---------------*/

