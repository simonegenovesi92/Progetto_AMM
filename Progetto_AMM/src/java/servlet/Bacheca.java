/*
 * To change this license header, choose License Headers loggato Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template loggato the editor.
 */
package servlet;

import oggetti.Gruppi;
import oggetti.GruppiFactory;
import oggetti.Post;
import oggetti.PostFactory;
import oggetti.UtentiRegistrati;
import oggetti.UtentiRegistratiFactory;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Simone Genovesi
 */
public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessione = request.getSession();
        
        Object loggato = sessione.getAttribute("loggato");
        if(loggato != null)
        {
            boolean flag = (boolean)loggato;
            if(!flag)
            {
                request.setAttribute("anegativo",true);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }
            else
            {
                loggato = sessione.getAttribute("utente");
                request.setAttribute("anegativo",false);
                
                List<UtentiRegistrati> lu = UtentiRegistratiFactory.getInstance().getUserList();
                sessione.setAttribute("utenti", lu);
                List<Gruppi> lg = GruppiFactory.getInstance().getGroupList();
                sessione.setAttribute("gruppi", lg);
                
                Object vb = request.getParameter("visual-bak"); //utente del quale si vuole visualizzare la bacheca
                Object vg = request.getParameter("visual-group");
                UtentiRegistrati register;
                Gruppi group;
                
                if(vg != null)
                {
                    
                    String n = vg.toString();
                    group = GruppiFactory.getInstance().getGroupByName(n);
                    if(group != null)
                    {
                        request.setAttribute("session", group);
                        
                        List<Post> p = PostFactory.getInstance().getPostByGroup(group);
                        if(p != null)
                            request.setAttribute("post", p);
                    }
                }
                else if(vb != null)
                {
                    
                    request.setAttribute("vis",true);
                    String n = vb.toString();
                    register = UtentiRegistratiFactory.getInstance().getUserByName(n);
                    request.setAttribute("session", register);
                    List<Post> p = PostFactory.getInstance().getPostByDest(register);
                    if(p != null)
                        request.setAttribute("post", p);
                }
                else
                
                {
                    request.setAttribute("vis",true);
                    register = (UtentiRegistrati)loggato;
                    request.setAttribute("session", register);
                    List<Post> p = PostFactory.getInstance().getPostByDest(register);
                    if(p != null)
                        request.setAttribute("post", p);
                }
                
                if(request.getParameter("stato") != null || request.getParameter("tipo") != null || request.getParameter("allegato") != null)
                {
                    String testo = request.getParameter("stato");
                    String allegato = request.getParameter("link");
                    String radio = request.getParameter("tipo");
                    Post.TipoPost tipo = null;
                    
                    if(radio != null)
                    {
                        if(radio.equals("immagine"))
                        {
                            if(allegato != null)
                            {
                                if (!(allegato.equals("")))
                                {
                                    request.setAttribute("medias",1);
                                    tipo = Post.TipoPost.IMMAGINE;
                                    request.setAttribute("t_errore", false);
                                    request.setAttribute("insert", true);
                                }
                                else
                                    request.setAttribute("t_errore", true);
                                    
                            }
                            else
                            {
                                request.setAttribute("t_errore", true);
                            }
                        }
                        else if(radio.equals("url"))
                        {
                            if(allegato != null)
                            {
                                if (!(allegato.equals("")))
                                {
                                    request.setAttribute("medias", 2);
                                    tipo = Post.TipoPost.URL;
                                    request.setAttribute("t_errore", false);
                                    request.setAttribute("insert", true);
                                }
                                else
                                    request.setAttribute("t_errore", true);
                                    
                            }
                            else
                            {
                                request.setAttribute("t_errore", true);
                            }
                        }
                    }
                    else if(testo != null)
                    {
                        if(!testo.equals(""))
                        {
                            request.setAttribute("insert", true);
                            request.setAttribute("t_errore", false);
                            tipo = Post.TipoPost.TESTO;
                        }
                    }
                    if(!allegato.equals(""))
                    {
                        if(tipo == null)
                        {
                            request.setAttribute("t_errore", true);
                            request.setAttribute("insert", false);
                        }                        
                    }
                    if(request.getAttribute("t_errore") != null)
                    {
                        if(!(boolean)request.getAttribute("t_errore"))
                        {
                            request.setAttribute("insert", true);
                            
                            Post n = new Post();
                            n.setAutore((UtentiRegistrati)sessione.getAttribute("utente"));
                            if(vb != null)
                                n.setDestinatario(UtentiRegistratiFactory.getInstance().getUserByName(vb.toString()));
                            else 
                                n.setDestinatario((UtentiRegistrati)sessione.getAttribute("utente"));
                            if(vg != null)
                                n.setGruppo(GruppiFactory.getInstance().getGroupByName(vg.toString()));
                            n.setTipologia(tipo);
                            if(!testo.equals(""))
                                n.setContenuto(request.getParameter("stato"));
                            if(!allegato.equals(""))
                                n.setAllegato(request.getParameter("link"));
                            request.setAttribute("n",n);
                        }
                    }
                }
                if(request.getParameter("conf") != null)
                {
                    if((request.getParameter("conf").equals("true")))
                        request.setAttribute("conf", true);
                }
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("anegativo",true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
