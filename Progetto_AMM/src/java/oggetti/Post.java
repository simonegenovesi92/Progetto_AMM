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
public class Post {

    private int id;
    private UtentiRegistrati autore;
    private Gruppi gruppo;
    private UtentiRegistrati destinatario;
    private String contenuto;
    private String allegato;
    private TipoPost tipologia;

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
     * Get the value of Autore
     *
     * @return the value of Autore
     */
    public UtentiRegistrati getAutore() {
        return autore;
    }

    /**
     * Set the value of Autore
     *
     * @param autore new value of Autore
     */
    public void setAutore(UtentiRegistrati autore) {
        this.autore = autore;
    }

    /**
     * Get the value of Gruppo
     *
     * @return the value of Gruppo
     */
    public Gruppi getGruppo() {
        return gruppo;
    }

    /**
     * Set the value of Gruppo
     *
     * @param gruppo new value of Gruppo
     */
    public void setGruppo(Gruppi gruppo) {
        this.gruppo = gruppo;
    }

    /**
     * Get the value of Destinatario
     *
     * @return the value of Destinatario
     */
    public UtentiRegistrati getDestinatario() {
        return destinatario;
    }

    /**
     * Set the value of Destinatario
     *
     * @param destinatario new value of Destinatario
     */
    public void setDestinatario(UtentiRegistrati destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Get the value of Contenuto
     *
     * @return the value of Contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * Set the value of Contenuto
     *
     * @param contenuto new value of Contenuto
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * Get the value of Allegato
     *
     * @return the value of Allegato
     */
    public String getAllegato() {
        return allegato;
    }

    /**
     * Set the value of Allegato
     *
     * @param allegato new value of Allegato
     */
    public void setAllegato(String allegato) {
        this.allegato = allegato;
    }

    /**
     * Get the value of Tipologia
     *
     * @return the value of Tipologia
     */
    public TipoPost getTipologia() {
        return tipologia;
    }

    /**
     * Set the value of Tipologia
     *
     * @param tipologia new value of Tipologia
     */
    public void setTipologia(TipoPost tipologia) {
        this.tipologia = tipologia;
    }
    
    public enum TipoPost{
        TESTO, IMMAGINE, URL
    };
    
    public Post()
    {
        id = 0;
        autore = null;
        gruppo = null;
        destinatario = null;
        contenuto = "";
        allegato = null;
        tipologia = TipoPost.TESTO;
    }
    
}
