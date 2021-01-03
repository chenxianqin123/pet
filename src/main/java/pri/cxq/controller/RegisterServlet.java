package pri.cxq.controller;

import pri.cxq.dao.UserDao;
import pri.cxq.bean.User;
import pri.cxq.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理用户注册请求的Servlet
 */
@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();//通过response对象给客户端一个响应

        String user_name = request.getParameter("username");
        String user_email = request.getParameter("email");
        String user_password = request.getParameter("password");

        /**
         * 判断用户是否已注册
         * 已注册，给出提示信息，返回登录页
         * 未注册，继续执行注册，返回登录页
         */
        boolean flag = userDao.isExist(user_email);
        if (flag == true) {
            writer.write("<script>");
            writer.write("alert(\"该邮箱已被注册！\");");
            writer.write(" window.location.href = \"login.html\";");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            User user = new User(null, user_name, user_email, 0,user_password, DateUtils.getDateTime());
            flag = userDao.saveUser(user);
            if (flag) {
                writer.write("<script>");
                writer.write("alert(\"恭喜您，注册成功！\");");
                writer.write(" window.location.href = \"login.html\";");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                writer.write("<script>");
                writer.write("alert(\"注册失败！！！\");");
                writer.write(" window.location.href = \"login.html\";");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
