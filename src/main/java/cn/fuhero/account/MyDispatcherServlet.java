package cn.fuhero.account;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fu Zhong on 2015/7/3.
 */
public class MyDispatcherServlet extends DispatcherServlet {

    private static final long serialVersionUID = -1107097025839846163L;
    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        super.init(config);
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding(encoding);
        super.doService(request, response);
    }

}
