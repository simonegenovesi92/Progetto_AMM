/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        
        HttpSession session = request.getSession();
        
        Object in = session.getAttribute("in");
        if(in != null)
        {
            boolean flag = (boolean)in;
            if(!flag)
            {
                request.setAttribute("negato",true);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }
            else
            {
                in = session.getAttribute("user");
                request.setAttribute("negato",false);
                
                List<UtentiRegistrati> lu = UtentiRegistratiFactory.getInstance().getUserList();
                session.setAttribute("utenti", lu);
                List<Gruppi> lg = GruppiFactory.getInstance().getGroupList();
                session.setAttribute("gruppi", lg);
                
                Object vb = request.getParameter("visualizza_bacheca"); //utente del quale si vuole visualizzare la bacheca
                Object vg = request.getParameter("visualizza_gruppo");
                UtentiRegistrati u;
                Gruppi g;
                
                if(vg != null)
                {
                    
                    String n = vg.toString();
                    g = GruppiFactory.getInstance().getGroupByName(n);
                    if(g != null)
                    {
                        request.setAttribute("x", g);
                        
                        List<Post> p = PostFactory.getInstance().getPostByGroup(g);
                        if(p != null)
                            request.setAttribute("post", p);
                    }
                }
                else if(vb != null)
                {
                    
                    request.setAttribute("f",true);
                    String n = vb.toString();
                    u = UtentiRegistratiFactory.getInstance().getUserByName(n);
                    request.setAttribute("x", u);
                    List<Post> p = PostFactory.getInstance().getPostByDest(u);
                    if(p != null)
                        request.setAttribute("post", p);
                }
                else
                
                {
                    request.setAttribute("f",true);
                    u = (UtentiRegistrati)in;
                    request.setAttribute("x", u);
                    List<Post> p = PostFactory.getInstance().getPostByDest(u);
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
                        if(radio.equals("imm"))
                        {
                            if(allegato != null)
                            {
                                if (!(allegato.equals("")))
                                {
                                    request.setAttribute("multimedia",1);
                                    tipo = Post.TipoPost.IMMAGINE;
                                    request.setAttribute("erroretipo", false);
                                    request.setAttribute("inspost", true);
                                }
                                else
                                    request.setAttribute("erroretipo", true);
                                    
                            }
                            else
                            {
                                request.setAttribute("erroretipo", true);
                            }
                        }
                        else if(radio.equals("url"))
                        {
                            if(allegato != null)
                            {
                                if (!(allegato.equals("")))
                                {
                                    request.setAttribute("multimedia", 2);
                                    tipo = Post.TipoPost.URL;
                                    request.setAttribute("erroretipo", false);
                                    request.setAttribute("inspost", true);
                                }
                                else
                                    request.setAttribute("erroretipo", true);
                                    
                            }
                            else
                            {
                                request.setAttribute("erroretipo", true);
                            }
                        }
                    }
                    else if(testo != null)
                    {
                        if(!testo.equals(""))
                        {
                            request.setAttribute("inspost", true);
                            request.setAttribute("erroretipo", false);
                            tipo = Post.TipoPost.TESTO;
                        }
                    }
                    if(!allegato.equals(""))
                    {
                        if(tipo == null)
                        {
                            request.setAttribute("erroretipo", true);
                            request.setAttribute("inspost", false);
                        }                        
                    }
                    if(request.getAttribute("erroretipo") != null)
                    {
                        if(!(boolean)request.getAttribute("erroretipo"))
                        {
                            request.setAttribute("inspost", true);
                            
                            Post n = new Post();
                            n.setAutore((UtentiRegistrati)session.getAttribute("user"));
                            if(vb != null)
                                n.setDestinatario(UtentiRegistratiFactory.getInstance().getUserByName(vb.toString()));
                            else 
                                n.setDestinatario((UtentiRegistrati)session.getAttribute("user"));
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
                if(request.getParameter("conferma") != null)
                {
                    if((request.getParameter("conferma").equals("true")))
                        request.setAttribute("conferma", true);
                }
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("negato",true);
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
