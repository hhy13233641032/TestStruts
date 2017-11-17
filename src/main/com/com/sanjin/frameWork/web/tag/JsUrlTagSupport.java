package com.sanjin.frameWork.web.tag;

import org.apache.struts2.views.jsp.StrutsBodyTagSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class JsUrlTagSupport extends StrutsBodyTagSupport {

    private static final long serialVersionUID = 1L;

    private String value;

    @Override
    public int doStartTag() throws JspException {
       JspWriter out = this.pageContext.getOut();
        try {
            out.print(LinkUrlUtils.getlInkUrl(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
