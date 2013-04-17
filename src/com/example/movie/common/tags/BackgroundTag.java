package com.example.movie.common.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pramod
 * Date: 4/11/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class BackgroundTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        int randInt = (int) (Math.random() * 5 + 1);
        StringBuilder sb = new StringBuilder();
        sb.append("\n<style type=\"text/css\"> ");
        sb.append("\nbody { ");
        sb.append("\nbackground:transparent !important; ");
        sb.append("\n} ");
        sb.append(" \nhtml {\n" +
                "        background: url(\""+request.getContextPath()+"/resources/img/login_page_"+randInt+".jpg\") no-repeat center center fixed; -webkit-background-size: cover;\n" +
                "            -moz-background-size: cover;\n" +
                "            -o-background-size: cover;\n" +
                "            background-size: cover;\n" +
                "        }");
        sb.append("\n</style> ");


        getJspContext().getOut().print(sb.toString());

    }
}
