package pri.cxq.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤没有登录就跳转到登录界面的请求
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/menu.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null){
            writer.write("<script>");
            writer.write("alert(\"请先登录\");");
            writer.write("window.location.href=\"login.html\";");
            writer.write("</script>");
            writer.flush();
            writer.close();
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
