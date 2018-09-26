/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.secondaires;

import Beans.CreationDonneesLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi314
 */
public class CreationDonnees implements sousController{
    CreationDonneesLocal creationDonnees = lookupCreationDonneesLocal();
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        
        
        return "/WEB-INF/Creationdonnees.jsp";
    }

    private CreationDonneesLocal lookupCreationDonneesLocal() {
        try {
            Context c = new InitialContext();
            return (CreationDonneesLocal) c.lookup("java:global/macdo/macdo-ejb/CreationDonnees!Beans.CreationDonneesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    

}
