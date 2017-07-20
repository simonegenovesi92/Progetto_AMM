/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oggetti;

/**
 *
 * @author Simone Genovesi
 */
public class Gruppi {
    
    private String nome;
    private int id;
    private String descrizione;
    private UtentiRegistrati admin;
    private String urlAvatar;

    /**
     * Get the value of Nome
     *
     * @return the value of Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of Nome
     *
     * @param nome new value of Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of Id
     *
     * @param id new value of Id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of Descrizione
     *
     * @return the value of Descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Set the value of Descrizione
     *
     * @param descrizione new value of Descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Get the value of Admin
     *
     * @return the value of Admin
     */
    public UtentiRegistrati getAdmin() {
        return admin;
    }

    /**
     * Set the value of Admin
     *
     * @param admin new value of Admin
     */
    public void setAdmin(UtentiRegistrati admin) {
        this.admin = admin;
    }

    /**
     * Get the value of UrlAvatar
     *
     * @return the value of UrlAvatar
     */
    public String getUrlAvatar() {
        return urlAvatar;
    }

    /**
     * Set the value of UrlAvatar
     *
     * @param urlAvatar new value of UrlAvatar
     */
    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
    public Gruppi() {
        nome = "";
        descrizione = "";
        admin = null;
        id = 0;
        urlAvatar = "";
    }
    
    @Override
    public boolean equals(Object group) {
        if(group == null) return false;
        if (group instanceof Gruppi)
            if (this.getId() == ((Gruppi)group).getId()) return true;
        return false;
    }
}
