/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oggetti;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simone Genovesi
 */
public class UtentiRegistratiFactory {
    
    private static UtentiRegistratiFactory singleton;
    
    public static UtentiRegistratiFactory getInstance()
    {
        if(singleton == null)
            singleton = new UtentiRegistratiFactory();
        return singleton;
    }
    
    private ArrayList<UtentiRegistrati> utenti = new ArrayList<UtentiRegistrati>();
    
    private UtentiRegistratiFactory()
    {
        //dati
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setCognome("Lorem");
        utente1.setId(1);
        utente1.setNome("Carlo");
        utente1.setDataNascita("11/07/1992");
        utente1.setPassword("password1");
        utente1.setAccount(UtentiRegistrati.TipoAccount.UTENTE);
        utente1.setUrlAvatar("img/utente_default.gif");
        utente1.setAbout("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed blandit nulla a lorem aliquam, a volutpat ipsum tincidunt.");
        
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setCognome("Ipsum");
        utente2.setId(2);
        utente2.setNome("Francesca");
        utente2.setDataNascita("11/07/1992");
        utente2.setPassword("password2");
        utente2.setAccount(UtentiRegistrati.TipoAccount.UTENTE);
        utente2.setUrlAvatar("img/utente_default.gif");
        utente2.setAbout("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed blandit nulla a lorem aliquam, a volutpat ipsum tincidunt.");
        
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setCognome("Dolor");
        utente3.setId(3);
        utente3.setNome("Ferdinando");
        utente3.setDataNascita("11/07/1992");
        utente3.setPassword("password3");
        utente3.setAccount(UtentiRegistrati.TipoAccount.UTENTE);
        utente3.setUrlAvatar("img/utente_default.gif");
        utente3.setAbout("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed blandit nulla a lorem aliquam, a volutpat ipsum tincidunt.");
        
        UtentiRegistrati incompleto = new UtentiRegistrati();
        incompleto.setId(4);
        incompleto.setNome("incompleto");
        incompleto.setPassword("password");
        incompleto.setCognome(null);
        incompleto.setAccount(UtentiRegistrati.TipoAccount.UTENTE);
        incompleto.setUrlAvatar("img/utente_default.gif");
        incompleto.setAbout("Mi piace tantissimo NerdBook!");
        
        //aggiunta degli utenti
        utenti.add(utente1);
        utenti.add(utente2);
        utenti.add(utente3);
        utenti.add(incompleto);
    }
    public UtentiRegistrati getUserById(int id)
    {
        
        for(UtentiRegistrati register : this.utenti)
        {
            if(register.getId() == id)
                return register;
        }
        return null;
    }
    public UtentiRegistrati getUserByName(String n)
    {
        for(UtentiRegistrati register : this.utenti)
        {
            if(register.getNome().equals(n))
                return register;
        }
        return null;
    }
    public List getUserList()
    {
        return utenti;
    }
}
