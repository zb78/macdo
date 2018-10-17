package controlleur.secondaires;

import Beans.GestionCatalogueLocal;
import Entites.Type;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatalogueCtrl implements sousController, Serializable {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String ref = request.getParameter("ref");
        request.setAttribute("ref", ref);
        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
        List leCatalogue;
        System.out.println(">>>>>>>>>>>>>>>"+ ref);
        if (ref.isEmpty()) {
            System.out.println("-------------------------------------------------");
            System.out.println("selectMenusCatalogue()");
            System.out.println("-------------------------------------------------");
            leCatalogue = gestionCatalogue.selectMenusCatalogue();
            request.setAttribute("type", "all");
        }else if (ref.contains("MENU")) {
            System.out.println("-------------------------------------------------");
            System.out.println("selectTypesCatalogue("+ref+")");
            System.out.println("-------------------------------------------------");
            leCatalogue = gestionCatalogue.selectTypesCatalogue(ref);
            System.out.println(leCatalogue);
            request.setAttribute("type", "menu");
            
//        }else if ("menu".equals(request.getAttribute("type"))) {
//            System.out.println("-------------------------------------------------");
//            System.out.println("selectProduitsCatalogueByIdType("+Long.valueOf(ref)+")");
//            System.out.println("-------------------------------------------------");
//            leCatalogue = gestionCatalogue.selectProduitsCatalogueByIdType(Long.valueOf(ref));
//            request.setAttribute("type", "produitMenu");
            
        }else{
            System.out.println("-------------------------------------------------");
            System.out.println("selectProduitsCatalogueByNomType("+ref+")");
            System.out.println("-------------------------------------------------");
            leCatalogue = gestionCatalogue.selectProduitsCatalogueByNomType(ref);
            request.setAttribute("type", "produit");
        }
        
           
        request.setAttribute("catalogue", leCatalogue);
        String url= "/WEB-INF/catalogue.jsp";
        return url;
    }

    private GestionCatalogueLocal lookupGestionCatalogueLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCatalogueLocal) c.lookup("java:global/macdo/macdo-ejb/GestionCatalogue!Beans.GestionCatalogueLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

/*--------------- CDI1804 --------------- by CL --------------- CDI1804 ---------------*/

