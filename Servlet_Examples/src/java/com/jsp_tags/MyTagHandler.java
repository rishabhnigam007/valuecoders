package com.jsp_tags;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            // task ..... tag
            JspWriter out=pageContext.getOut();
            out.println("<h1>This is my custom tag</h1>");
            out.println("<p> This is custom paragraph </p>");
            out.println("<br>");
            out.println(new Date().toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return SKIP_BODY;        
    }
}


/*
        first extends tagsupport class and then override its dostrattag method
        second create a TLD (Tag Library Desciptor) file
example : http://localhost:9494/Testing/tag.jsp
*/