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
public class UtentiRegistrati {
    
    private int id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String urlAvatar;
    private String about;
    private String password;
    private TipoAccount account;    
    

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of ID
     *
     * @param id new value of ID
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * Get the value of Cognome
     *
     * @return the value of Cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Set the value of Cognome
     *
     * @param cognome new value of Cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Get the value of DataNascita
     *
     * @return the value of DataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * Set the value of DataNascita
     *
     * @param dataNascita new value of DataNascita
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
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

    /**
     * Get the value of About
     *
     * @return the value of About
     */
    public String getAbout() {
        return about;
    }

    /**
     * Set the value of About
     *
     * @param about new value of About
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of Password
     *
     * @param password new value of Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of Account
     *
     * @return the value of Account
     */
    public TipoAccount getAccount() {
        return account;
    }

    /**
     * Set the value of Account
     *
     * @param account new value of Account
     */
    public void setAccount(TipoAccount account) {
        this.account = account;
    }

    
    public enum TipoAccount {
        UTENTE, ADMIN
    };
    
    public UtentiRegistrati()
    {
        id = 0;
        nome = "";
        cognome = "";        
        dataNascita = "";
        urlAvatar = "";
        about = null;
        password = "";
        account = TipoAccount.UTENTE ;       
    }
    
    @Override
    public boolean equals(Object u) {
        if(u == null) return false;
        if (u instanceof UtentiRegistrati)
            if (this.getId() == ((UtentiRegistrati)u).getId()) return true;
        return false;
    }
}
