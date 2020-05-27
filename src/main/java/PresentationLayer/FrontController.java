/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
@author projektSkabelon
@author Mathias

 Denne klasse bruges til at opdatere nogle af dropdown menuerne på carport jsp siden.
 Det er vores eneste servlet.

 */
@WebServlet( name = "FrontController", urlPatterns = { "/FrontController" } )
public class FrontController extends HttpServlet {

    /**
     Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {

            //ArrayList<String> claddingList = MaterialMapper.getCladdingList();
            ArrayList<String> flatRoofList = MaterialMapper.getFlat();
            ArrayList<String> slopeRoofList = MaterialMapper.getSlope();
            Set<String> flatSet = MaterialHelper.flatSet(flatRoofList);
            //Set<String> slopeSet = MaterialHelper.slopeSet(slopeRoofList);
            //request.setAttribute("claddingList", claddingList);
            request.setAttribute("flatSet", flatSet);
            request.setAttribute("slopeRoofList", slopeRoofList);

            Command action = Command.from( request );
            String view = action.execute( request, response );
            if(view == "index") {
                request.getRequestDispatcher("Carport.jsp").forward(request, response);
            }
            request.getRequestDispatcher( "/WEB-INF/" + view + ".jsp" ).forward( request, response );
        } catch ( LoginSampleException ex ) {
            request.setAttribute( "error", ex.getMessage() );
//            request.getRequestDispatcher( "Carport.jsp" ).forward( request, response );
            request.getRequestDispatcher( "/WEB-INF/loginpage.jsp" ).forward( request, response );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     Handles the HTTP <code>GET</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Handles the HTTP <code>POST</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Returns a short description of the servlet.

     @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
