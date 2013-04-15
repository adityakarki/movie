package com.example.movie.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pramod
 * Date: 4/11/13
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasicTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print("Very bad use of a tag");
    }
}
