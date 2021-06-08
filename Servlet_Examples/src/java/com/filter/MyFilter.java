package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        System.out.println("Before Filter");
        //........
        //........
        
        
        // forward request 
        chain.doFilter(request, response);
        System.out.println("After Filter");
        //........
        //........
    }

    @Override
    public void destroy() 
    {
        
    }
    
}


/*

    To run this filter you must specify filter name and filter mapping in web.xml file
    Web Pages/WEB-INF/web.xml
    <web-app>
    

    THIS IS FOR MANAGING FILTER OPERATION IN FILTER.JAVA FILE WHERE YOU GIVE MESSAGE
    <!--  filter  -->
    <filter>
        <filter-name>filter1</filter-name>
        <filter-class>com.filter.MyFilter</filter-class>
    </filter>   
    
    THIS IS MAPPING IN WHICH YOU APPLY TO FILTER FROM HERE WE APPLY FILTER IN TWO PAGE
    <!--  filter Mapping  -->
    <filter-mapping>
        <filter-name>filter1</filter-name>
        <url-pattern>/ProfileServlet</url-pattern>   FIRST PAGE
        <url-pattern>/OrderServlet</url-pattern>    SECOND PAGE
        IT COULD BE A JSP PAGE LIKE THIS
        <url-pattern>/index.jsp</url-pattern>
    </filter-mapping>

    </web-app>
    

*/