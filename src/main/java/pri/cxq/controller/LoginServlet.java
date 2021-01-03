package pri.cxq.controller;

import pri.cxq.dao.UserDao;
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
 * 处理用户登录请求的Servlet
 */
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String user_email = request.getParameter("email");
        String user_password = request.getParameter("password");

        /**
         * 验证登录信息（邮箱、密码）
         * 登录成功，给出提示信息，跳转到主页
         * 登录失败，给出提示信息，返回登录页
         */
        User user = userDao.checkUser(user_email, user_password);
        if(user == null){
            writer.write("<script>");
            writer.write("alert(\"邮箱或密码错误！\");");
            writer.write("window.location.href=\"login.html\";");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user",user);//将用户对象存储到session作用域
            writer.write("<script>");
//            writer.write("alert(\"登录成功...\");");
            writer.write("window.location.href=\"index.jsp\";");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
