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
public class GruppiFactory {
   
    private static GruppiFactory singleton;
    
    public static GruppiFactory getInstance()
    {
        if(singleton == null)
            singleton = new GruppiFactory();
        return singleton;
    }
    
    private ArrayList<Gruppi> gruppi = new ArrayList<Gruppi>();
    
    private GruppiFactory()
    {
        //dati
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setNome("Gruppo 1");
        gruppo1.setDescrizione("Descrizione 1");
        gruppo1.setAdmin(UtentiRegistratiFactory.getInstance().getUserByName("Carlo"));
        gruppo1.setId(1);
        gruppo1.setUrlAvatar("img/group.gif");
        
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setNome("Gruppo 2");
        gruppo2.setDescrizione("Descrizione 2");
        gruppo2.setAdmin(UtentiRegistratiFactory.getInstance().getUserByName("Francesca"));
        gruppo2.setId(2);
        gruppo2.setUrlAvatar("img/group.gif");
        //aggiunta degli utenti
        gruppi.add(gruppo1);
        gruppi.add(gruppo2);
    }
    public Gruppi getGroupById(int id)
    {
        
        for(Gruppi group : this.gruppi)
        {
            if(group.getId() == id)
                return group;
        }
        return null;
        
    }
    public Gruppi getGroupByName(String n)
    {
        for(Gruppi group : this.gruppi)
        {
            if(group.getNome().equals(n))
                return group;
        }
        return null;
    }
    public List getGroupList()
    {
        return gruppi;
    }
}
