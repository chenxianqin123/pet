package pri.cxq.controller;

import pri.cxq.dao.CarDao;
import pri.cxq.dao.FeedbackDao;
import pri.cxq.dao.OrderDao;
import pri.cxq.dao.PetDao;
import pri.cxq.bean.Order;
import pri.cxq.bean.Pet;
import pri.cxq.bean.User;
import pri.cxq.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 处理购买请求的Servlet
 */
@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    PetDao petDao = new PetDao();
    CarDao carDao = new CarDao();
    OrderDao orderDao = new OrderDao();
    FeedbackDao feedbackDao = new FeedbackDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String method = request.getParameter("method");

        /**
         * 如果是直接购买，增加一条订单记录，同时宠物数量-1
         */
        if (method.equals("add")) {
            User user = (User) request.getSession().getAttribute("user");
            Integer user_id = user.getUser_id();//用户ID
            Integer pet_id = Integer.valueOf(request.getParameter("pet_id"));//宠物ID

            Order order = new Order(null, user_id, pet_id, DateUtils.getDateTime());//封装订单对象

            boolean flag1 = orderDao.saveOrder(order);
            boolean flag2 = petDao.decreaseCount(pet_id);
            if (!flag1 || !flag2) {
                writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                writer.write("<script>");
                writer.write("alert(\"购买成功！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        /**
         * 如果是在购物车中购买，增加一条订单信息，订单信息-1，宠物数量-1，
         */
        if (method.equals("car_add")) {
            User user = (User) request.getSession().getAttribute("user");
            Integer user_id = user.getUser_id();//用户ID
            Integer pet_id = Integer.valueOf(request.getParameter("pet_id"));//宠物ID
            Integer car_id = Integer.valueOf(request.getParameter("car_id"));//购物车ID

            Order order = new Order(null, user_id, pet_id, DateUtils.getDateTime());//封装订单对象
            boolean flag1 = orderDao.saveOrder(order);
            boolean flag2 = carDao.removeCar(car_id);
            boolean flag3 = petDao.decreaseCount(pet_id);

            if (!flag1 || !flag2 || !flag3) {
                writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                writer.write("<script>");
                writer.write("alert(\"购买成功！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        /**
         * 查看所有订单
         */
        if(method.equals("check")){
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            Integer user_id = user.getUser_id();

            List<Order> orders = orderDao.getOrders(user_id);

            Map<Order, Pet> op = new LinkedHashMap<Order, Pet>();

            for(Order order:orders){
                Integer pet_id = order.getPet_id();
                Pet pet = petDao.getPet(pet_id);
                if(pet != null){
                   op.put(order,pet);
                }
            }
            request.setAttribute("op",op);
            request.getRequestDispatcher("/order.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
