package pri.cxq.controller;
import pri.cxq.bean.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.alibaba.fastjson.JSON;

/**
 * 验证email的Servlet
 */
@WebServlet(urlPatterns = "/EmailServlet")
public class EmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String email = request.getParameter("email");

        String pattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        Msg msg = null;
        if (m.matches()) {
            msg = new Msg(true, "验证通过");
        } else {
            msg = new Msg(false, "邮箱非法");
        }
        String info = JSON.toJSONString(msg);//序列化
        writer.print(info);
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
