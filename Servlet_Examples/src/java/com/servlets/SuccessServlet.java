package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SuccessServlet", urlPatterns = {"/SuccessServlet"})
public class SuccessServlet extends HttpServlet 
{

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
        out.println("<h1><center>This is success servlet</center></h1>");
        out.println("<h2><center> Successfully Registered</center></h2>");
        
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>
}