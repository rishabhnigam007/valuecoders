package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//  By Implimenting servlet interface

public class FirstServlet implements Servlet
{
    // Life cycle methods
    
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        this.config=config;
        System.out.println("creating object.......");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
    {
        System.out.println("Servicing.........");
        
        //set the content type of the response
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<h1> This is my output from servlet</h1>");
        out.println("<h1> Todays date and time is "+new Date().toString()+"</h1>");
    }

    @Override
    public void destroy() 
    {
        System.out.println("Going to destroy servlet object");
    }     
    
    // Non life cycle methods
    @Override
    public ServletConfig getServletConfig() 
    {
        return this.config;
    }
    
    @Override
    public String getServletInfo() 
    {
        return "This servlet is created by Rishabh Nigam";
    }
    
}