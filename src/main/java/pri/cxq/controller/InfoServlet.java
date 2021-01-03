package pri.cxq.controller;

import pri.cxq.dao.InfoDao;
import pri.cxq.dao.UserDao;
import pri.cxq.bean.Info;
import pri.cxq.bean.User;
import pri.cxq.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 处理用户个人信息请求的Servlet
 */
@WebServlet(urlPatterns = "/InfoServlet")
@MultipartConfig
public class InfoServlet extends HttpServlet {

    private UserDao userDao = new UserDao();
    private InfoDao infoDao = new InfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String method = request.getParameter("method");
        if (method.equals("isExist")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Integer existInfo = userDao.isExistInfo((Integer) user.getUser_id());
            /**
             * 判断当前用户是否存在个人信息
             * 存在，跳转到个人信息显示界面
             * 不存在，跳转到个人信息添加界面
             */
            if (existInfo == null) {
                request.setAttribute("method","add");
                request.getRequestDispatcher("/info_add.jsp").forward(request,response);
            } else {
                Info info = infoDao.getInfo(user.getUser_id());
                session.setAttribute("info", info);//将用户人个信息存储到session作用域
                response.sendRedirect("/pet/info.jsp");
            }
        }
        if (method.equals("update") || method.equals("add")) {
            Part part = request.getPart("picture");//获取图片
            String picture = part.getSubmittedFileName();

            String dir = this.getServletContext().getRealPath("/images/info_image");//创建头像保存路径
            File imgDir = new File(dir);//如果文件不存在，则创建一个
            if (!imgDir.exists()) {
                imgDir.mkdirs();
            }
            if(picture != ""){
                part.write(dir + "/" + picture);//将文件存入指定目录
            }
            Info info = this.requestDateObj(request);
            boolean flag = false;
            if (method.equals("add")) {
                Integer info_id = infoDao.saveInfo(info);
                if (info_id != null) {
                    flag = true;
                }
            } else {
                flag = infoDao.updateInfo(info);
            }
            if (flag) {
                response.sendRedirect("/pet/InfoServlet?method=isExist");
            } else {
                writer.write("<script>");
                writer.write("alert(\"失败！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //封装需要更改的用户信息
    public Info requestDateObj(HttpServletRequest request) throws IOException, ServletException {
        String realname = request.getParameter("realname");
        String sex = request.getParameter("sex");
        Date birthday = DateUtils.parseDate(request.getParameter("year"), request.getParameter("month"), request.getParameter("day"));
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String picture = request.getPart("picture").getSubmittedFileName();
        long create_date = DateUtils.getDateTime();
        Info info = new Info(null, null, realname, sex, birthday, telephone, email, address1, address2, picture, create_date);
        User user = (User) request.getSession().getAttribute("user");
        info.setUser_id(user.getUser_id());
        return info;
    }
}
