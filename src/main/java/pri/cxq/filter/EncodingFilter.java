package pri.cxq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编码解码过滤器
 */
@WebFilter(filterName = "EncodingFilter",
        urlPatterns = {"/EmailServlet","/ManageServlet", "/CarServlet", "/PetServlet", "/DisplayAllServlet", "/InfoServlet", "/LoginServlet", "/OrderServlet", "/QuitServlet", "/RegisterServlet", "/FeedbackServlet"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "POST请求的解码方式"),
                @WebInitParam(name = "contentType", value = "text/html; charset=UTF-8", description = "Response的回响内容类型")
        }
)
public class EncodingFilter implements Filter {
    String encoding = null;
    String contentType = null;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        contentType = config.getInitParameter("contentType");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding(encoding);
        response.setContentType(contentType);

        chain.doFilter(req, resp);
    }


    public void destroy() {
    }


}
