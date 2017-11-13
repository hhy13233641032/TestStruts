package com.sanjin.frameWork.web.tag;

import com.sanjin.frameWork.content.ApplicationContext;
import org.apache.struts2.views.jsp.StrutsBodyTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class CssUrlTagSupport extends StrutsBodyTagSupport {

    private static final long serialVersionUID = 1L;

    private String value;

    @Override
    public int doStartTag() throws JspException {
        String baseUrl = ApplicationContext.getSystemImgUrl();
        JspWriter out = this.pageContext.getOut();
        try {
            out.print("/ts"+value.toString());
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
