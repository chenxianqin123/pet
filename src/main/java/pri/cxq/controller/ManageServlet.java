package pri.cxq.controller;

import pri.cxq.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理进入后台管理界面的Servlet
 */
@WebServlet(urlPatterns = "/ManageServlet")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user.getAdministractor() == 1){
            response.sendRedirect("/pet/management/menu.jsp");
        }else {
            writer.write("<script>");
            writer.write("alert(\"对不起，您不是管理员！\");");
            writer.write("history.go(-1);");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
