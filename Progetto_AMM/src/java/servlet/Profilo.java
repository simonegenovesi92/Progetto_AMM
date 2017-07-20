/*
 * To change this license header, choose License Headers loggato Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template loggato the editor.
 */
package servlet;

import oggetti.Gruppi;
import oggetti.GruppiFactory;
import oggetti.UtentiRegistrati;
import oggetti.UtentiRegistratiFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Simone Genovesi
 */
public class Profilo extends HttpServlet {

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
        Object reg = sessione.getAttribute("loggato");
        if(reg != null)
        {
            boolean flag = (boolean)reg;
            if(!flag)
            {
                request.setAttribute("anegato",true);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("anegato",false);
                List<UtentiRegistrati> l = UtentiRegistratiFactory.getInstance().getUserList();
                sessione.setAttribute("utenti", l);
                List<Gruppi> group = GruppiFactory.getInstance().getGroupList();
                sessione.setAttribute("gruppi", group);
                UtentiRegistrati register = (UtentiRegistrati)sessione.getAttribute("utente");
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String stato = request.getParameter("stato");
                String compleanno = request.getParameter("compleanno");
                String foto = request.getParameter("foto");
                String password = request.getParameter("password");
                String confpassword = request.getParameter("confpassword");
                if(nome != null)
                {
                    if(!nome.equals(""))
                    {
                        register.setNome(nome);
                        request.setAttribute("erroredati", false);
                    }
                }
                if(cognome != null)
                {
                    if(!cognome.equals(""))
                    {
                        register.setCognome(cognome);
                        request.setAttribute("erroredati", false);
                    }
                }
                if(stato != null)
                {
                    if(!stato.equals(""))
                    {
                        register.setAbout(stato);
                        request.setAttribute("erroredati", false);
                    }
                }
                if(compleanno != null)
                {
                    if(!compleanno.equals(""))
                    {
                        register.setDataNascita(compleanno);
                        request.setAttribute("erroredati", false);
                    }
                }
                if(foto != null)
                {
                    if(!foto.equals(""))
                    {
                        register.setUrlAvatar(foto);
                        request.setAttribute("erroredati", false);
                    }
                }
                if(password != null)
                {
                    if(confpassword != null)
                    {
                        if(confpassword.equals(password))
                        {
                            if (!(password.equals("")))
                            {
                                register.setPassword(password);
                                request.setAttribute("erroredati", false);
                            }
                        }
                            request.setAttribute("erroredati", true);
                    }
                }
                    request.setAttribute("erroredati", true);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("anegato",true);
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
