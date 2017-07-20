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
public class PostFactory {
    
    private static PostFactory singleton;
    
    public static PostFactory getInstance()
    {
        if(singleton == null)
            singleton = new PostFactory();
        return singleton;
    }
    //lista utenti
    private ArrayList<Post> post = new ArrayList<Post>();
    
    private PostFactory()
    {
        //dati
        Post post1 = new Post();
        post1.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Carlo"));
        post1.setContenuto("NerdBook è fantastico! Ci sono un sacco di persone interessanti.\n" +
        "                   Spero di trovare anche la mia anima gemella!");
        post1.setTipologia(Post.TipoPost.TESTO);
        post1.setId(1);
        post1.setGruppo(null); //il post non si trova sulla bacheca di un gruppo
        post1.setDestinatario(null);
        post1.setAllegato(null);
        
        Post post2 = new Post();
        post2.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Francesca"));
        post2.setContenuto("Io ho trovato una persona fantastica. Spero non ci lasceremo mai!\n" +
        "                    Ecco una nostra foto:");
        post2.setAllegato("img/nerd_couple.jpg");
        post2.setTipologia(Post.TipoPost.IMMAGINE);
        post2.setId(2);
        post2.setGruppo(null); 
        post2.setDestinatario(null);
        
        Post post3 = new Post();
        post3.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Ferdinando"));
        post3.setAllegato("http://vignette3.wikia.nocookie.net/nonciclopedia/images/f/f9/Leonida_-_This_is_Javaaa.jpg/revision/latest?cb=20111216164640");
        post3.setContenuto("A me non importa trovare l'anima gemella! Io ho JAVA!!! ");
        post3.setTipologia(Post.TipoPost.URL);
        post3.setId(3);
        post3.setGruppo(null); 
        post3.setDestinatario(null);
        
        Post post4 = new Post();
        post4.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Carlo"));
        post4.setContenuto("Curabitur sed leo mattis, tempus ligula in, pulvinar felis. Duis tristique augue in egestas dapibus. Proin convallis sit amet orci.");
        post4.setTipologia(Post.TipoPost.TESTO);
        post4.setId(4);
        post4.setGruppo(GruppiFactory.getInstance().getGroupByName("Gruppo 1")); 
        post4.setDestinatario(null);
        post4.setAllegato(null);
        
        Post post5 = new Post();
        post5.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Francesca"));
        post5.setContenuto("Mauris vel facilisis nisl, sed vehicula risus. Nam dignissim quis turpis ut euismod. Donec sagittis lobortis vulputate. Aenean ut tellus.");
        post5.setTipologia(Post.TipoPost.TESTO);
        post5.setId(5);
        post5.setGruppo(GruppiFactory.getInstance().getGroupByName("Gruppo 2")); 
        post5.setDestinatario(null);
        post5.setAllegato(null);
        
        Post post6 = new Post();
        post6.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Ferdinando"));
        post6.setContenuto("Benvenuti al Presidium, posso essere la vostra guida?");
        post6.setTipologia(Post.TipoPost.TESTO);
        post6.setId(6);
        post6.setGruppo(GruppiFactory.getInstance().getGroupByName("Gruppo 2")); 
        post6.setDestinatario(null);
        post6.setAllegato(null);
        
        Post post7 = new Post();
        post7.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Incompleto"));
        post7.setContenuto("Benevenuto!");
        post7.setTipologia(Post.TipoPost.TESTO);
        post7.setId(7);
        post7.setGruppo(null);
        post7.setDestinatario(null);
        post7.setAllegato(null);
        
        Post post8 = new Post();
        post8.setAutore(UtentiRegistratiFactory.getInstance().getUserByName("Carlo"));
        post8.setContenuto("Benvenuto!");
        post8.setTipologia(Post.TipoPost.TESTO);
        post8.setId(8);
        post8.setGruppo(null);
        post8.setDestinatario(UtentiRegistratiFactory.getInstance().getUserByName("Incompleto"));
        post8.setAllegato(null);
        
        //aggiunta dei post
        post.add(post1);
        post.add(post2);
        post.add(post3);
        post.add(post4);
        post.add(post5);
        post.add(post6);
        post.add(post7);
        post.add(post8);
    }
    public Post getPostById(int id)
    {
        
        for(Post p : this.post)
        {
            if(p.getId() == id)
                return p;
        }
        return null;
    }
    public List getPostByUser(UtentiRegistrati u)
    {
        List<Post> l = new ArrayList<Post>();
        
        for(Post elemento:post)
            if(elemento.getDestinatario() == null)
                if(elemento.getAutore().equals(u))
                    l.add(elemento);
        return l;
    }
    public List getPostByDest(UtentiRegistrati u)
    {
        List<Post> l = getPostByUser(u);
        if(l == null)
            l = new ArrayList<Post>();
        
        for(Post elemento:post)
            if(elemento.getDestinatario() != null)
                if(elemento.getDestinatario().equals(u))
                    l.add(elemento);
        return l;
    }
    public List getPostByGroup(Gruppi g)
    {
         List<Post> l = new ArrayList<Post>();
        
        for(Post elemento:post)
        {
            if(elemento.getGruppo() != null)
            {
                if(elemento.getGruppo().equals(g))
                    l.add(elemento);
            }
        }
        return l;
    }
}
