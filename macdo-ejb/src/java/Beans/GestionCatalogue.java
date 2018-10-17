package Beans;

import Entites.Menu;
import Entites.Produit;
import Entites.Type;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GestionCatalogue implements GestionCatalogueLocal {
    @PersistenceContext(unitName = "macdo-ejbPU")
    private EntityManager em;

    @Override
    public List<Type> selectTypesCatalogue(){
        TypedQuery<Type> qr = em.createQuery("select distinct t from Type t", Type.class);
        List<Type> lesTypes = qr.getResultList();
//        for(Type t : lesTypes){
//            TypedQuery<Produit> qr02 = em.createQuery("select tp.produits from Type tp where tp.id = :paramId", Produit.class);
//            qr02.setParameter("paramId", t.getId());
//            t.setProduits(qr02.getResultList());
//        }
//        System.out.println("----------");
//        for(Type t : lesTypes){
//            System.out.println(">>>>>>>>>>>>> Type = "+t.getNom());
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Produits = "+t.getProduits());
//        }
        return lesTypes;
    }
    
    @Override
    public List<Menu> selectMenusCatalogue(){
        TypedQuery<Menu> qr = em.createQuery("select distinct m from Menu m", Menu.class);
        List<Menu> lesMenus = qr.getResultList();
//        for(Menu m : lesMenus){
//            TypedQuery<Type> qr02 = em.createQuery("select me.types from Menu me where me.id = :paramId", Type.class);
//            qr02.setParameter("paramId", m.getId());
//            m.setTypes(qr02.getResultList());
//        }
//        System.out.println("----------");
//        for(Menu m : lesMenus){
//            System.out.println(">>>>>>>>>>>>> Menu = "+m.getNom());
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Types = "+m.getTypes());
//        }
        return lesMenus;
    }
    
    @Override
    public List<Produit> selectProduitsCatalogue(){
        TypedQuery<Produit> qr = em.createQuery("select distinct p from Produit p", Produit.class);
        List<Produit> lesProduits = qr.getResultList();
        return lesProduits;
    }
    
    @Override
    public List<Type> selectTypesCatalogue(String nomMenu){ 
        TypedQuery<Type> qr = em.createQuery("select distinct t from Type t where t.menu.nom = :paramName", Type.class);
        System.out.println("-----------------------");
        System.out.println("nomMenu ="+nomMenu);
        qr.setParameter("paramName", nomMenu);
        List<Type> lesTypes = qr.getResultList();
        System.out.println("-----------------------");
        System.out.println("lesTypes ="+lesTypes);
        for(Type t : lesTypes){
            TypedQuery<Produit> qr02 = em.createQuery("select tp.produits from Type tp where tp.id = :paramId", Produit.class);
            qr02.setParameter("paramId", t.getId());
            t.setProduits(qr02.getResultList());
        }
        System.out.println("----------");
        for(Type t : lesTypes){
            System.out.println(">>>>>>>>>>>>> Type = "+t.getNom());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Produits = "+t.getProduits());
        }
        return lesTypes;
    }
    
    @Override
    public List<Produit> selectProduitsCatalogueByIdType(Long idType){
        TypedQuery<Produit> qr = em.createQuery("select p from Produit p where p.type.id = :paramId", Produit.class);
        qr.setParameter("paramId", idType);
        List<Produit> lesProduits = qr.getResultList();
        return lesProduits;
    }
    
    @Override
    public List<Produit> selectProduitsCatalogueByNomType(String nomType){
        TypedQuery<Produit> qr = em.createQuery("select p from Produit p where p.type.nom = :paramName", Produit.class);
        qr.setParameter("paramName", nomType);
        List<Produit> lesProduits = qr.getResultList();
//        List<Produit> lesProduitsAffich = null;
//        for(Produit p : lesProduits){
//            for (int i = 0; i <= lesProduitsAffich.size(); i++) {
//                if (!p.getNom().equals(lesProduitsAffich.get(i).getNom())) {
//                    lesProduitsAffich.add(p);
//                } 
//            }
//        }
//        return lesProduitsAffich;
        return lesProduits;
    }
    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

/*--------------- CDI1804 --------------- by CL --------------- CDI1804 ---------------*/

