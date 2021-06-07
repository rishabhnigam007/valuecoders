package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet 
{
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException
//    {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegisterServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1><center>Welcome to Register Servlet</center></h1>");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String address1=request.getParameter("address1");
        String address2=request.getParameter("address2");
        String city=request.getParameter("city");
        String pincode=request.getParameter("pincode");
        
        String cond=request.getParameter("condition");
        
//        cond != null also use instead of checked value name of checkbox
        if(cond != null)
        {
            if(cond.equals("checked"))
            {
                out.println("<h2> Email : "+email+"</h2>");
                out.println("<h2> Password : "+password+"</h2>");
                out.println("<h2> Address1 : "+address1+"</h2>");
                out.println("<h2> Address2 : "+address2+"</h2>");
                out.println("<h2> City : "+city+"</h2>");
                out.println("<h2> Pincode : "+pincode+"</h2>");
            
                // jDBC impliment and save this data to database
            
                RequestDispatcher rd=request.getRequestDispatcher("SuccessServlet");
                //forward response
                rd.forward(request, response);
            }
            else
            {
                out.println("<h2><center> You have not checked Terms and Condition</center></h2>");
            
            }
        }
        else
        {
            out.println("<h2><center> You have not checked Terms and Condition</center></h2>");
            // get the object of RequestDispather
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            
            // include request
            rd.include(request, response);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
