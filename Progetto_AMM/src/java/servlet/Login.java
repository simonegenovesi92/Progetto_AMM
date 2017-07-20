/*
 * To change this license header, choose License Headers loggato Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template loggato the editor.
 */
package servlet;

import oggetti.Post;
import oggetti.PostFactory;
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
public class Login extends HttpServlet {

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
        if(request.getParameter("logout") != null)
        {
            HttpSession sessione = request.getSession(false);
            if(request.getParameter("logout").equals("1"))
            {
                sessione.invalidate();
            }
        }
        HttpSession sessione = request.getSession();
        String utente = request.getParameter("utente");
        String password = request.getParameter("password");
        if(utente == null || password == null)
            request.getRequestDispatcher("login.jsp").forward(request, response);
        if(utente != null)
        {
            UtentiRegistrati register = UtentiRegistratiFactory.getInstance().getUserByName(utente);
            if(register != null)
            {
                if(register.getNome().equals(utente) && register.getPassword().equals(password))
                {
                    sessione.setAttribute("loggato",true);
                    sessione.setAttribute("utente",register); 
                    sessione.setAttribute("sessione",register);
                    if(register.getNome() == null || register.getUrlAvatar() == null || register.getCognome() == null || register.getAbout() == null)
                        response.sendRedirect("profilo.html");
                    else
                    {
                        List<Post> p = PostFactory.getInstance().getPostByUser(register);
                        sessione.setAttribute("post", p);
                        response.sendRedirect("bacheca.html");
                    }
                }
                else
                {
                    request.setAttribute("error", true);
                    sessione.setAttribute("loggato",false);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            else
            {
                request.setAttribute("error", true);
                sessione.setAttribute("loggato",false);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
