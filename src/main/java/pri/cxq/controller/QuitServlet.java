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

/**
 * 用户退出登录的Servlet
 */
@WebServlet(urlPatterns = "/QuitServlet")
public class QuitServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 清除session，返回主页面
         */
        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        if(method.equals("remove")){
            User user = (User)session.getAttribute("user");
            boolean flag = userDao.removeUser(user.getUser_id());
        }
        session.invalidate();
        response.sendRedirect("/pet/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }
}
