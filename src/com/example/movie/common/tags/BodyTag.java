package com.example.movie.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pramod
 * Date: 4/11/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class BodyTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException{
        getJspContext().setAttribute("test","this is a test value");
           getJspBody().invoke(null);
    }
}
