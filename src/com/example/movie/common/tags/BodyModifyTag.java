package com.example.movie.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: pramod
 * Date: 4/12/13
 * Time: 9:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class BodyModifyTag extends SimpleTagSupport {
    private int start;
    private int end;

    public void setStart(int start){
        this.start= start-1;

    }
    public void setEnd(int end){
        this.end=end-1;
    }

    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        getJspBody().invoke(sw);
        String ss = sw.toString().trim().substring(start,end);
        getJspContext().getOut().print(ss.toUpperCase());
    }
}
