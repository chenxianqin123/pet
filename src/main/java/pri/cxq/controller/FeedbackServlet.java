package pri.cxq.controller;

import pri.cxq.bean.*;
import pri.cxq.dao.FeedbackDao;
import pri.cxq.dao.OrderDao;
import pri.cxq.dao.PetDao;
import pri.cxq.dao.UserDao;
import pri.cxq.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    FeedbackDao feedbackDao = new FeedbackDao();
    OrderDao orderDao = new OrderDao();
    UserDao userDao = new UserDao();
    PetDao petDao = new PetDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter writer = response.getWriter();

        String method = request.getParameter("method");
        /**
         * 用户追加反馈信息
         */
        if(method.equals("addMessage")){
            Integer order_id =Integer.valueOf(request.getParameter("order_id"));//订单ID
            String message = request.getParameter("message");//反馈信息

            Feedback feedback = new Feedback(null,order_id,message, DateUtils.getDateTime());

            boolean flag = feedbackDao.saveFeedback(feedback);//将反馈信息进行存储
            if(!flag){
                writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else{
                writer.write("<script>");
                writer.write("alert(\"反馈成功！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }

        if(method.equals("check")){
            Integer order_id = null;//订单号
            String user_name = null;//用户名
            String breed = null;//宠物品种
            String create_date = null;//购买时间
            List<OrderFeedback> orderFeedbacks = new ArrayList<OrderFeedback>();//用户反馈信息
            List<Order> orderList = orderDao.getOrderList();//获取所有订单信息
            List<Feedback> feedbacks = new ArrayList<Feedback>();
            /**
             * 遍历所有订单，查找数据
             */
            for(Order order:orderList){
                order_id = order.getOrder_id();
                create_date = order.getFormatDate();
                Integer user_id = order.getUser_id();
                User user = userDao.getUser(user_id);
                if(user != null){
                    user_name = user.getUser_name();
                }else{
                    user_name = "用户已注销";
                }
                Integer pet_id = order.getPet_id();//通过订单获得宠物品种
                Pet pet = petDao.getPet(pet_id);
                if(pet != null){
                    breed = pet.getBreed();
                }else{
                    breed = "宠物信息不存在";
                }
                feedbacks = feedbackDao.getList(order.getOrder_id());
                String message = this.getMessage(feedbacks);

                OrderFeedback orderFeedback = new OrderFeedback(order_id,user_name,breed,create_date,message);
                orderFeedbacks.add(orderFeedback);
            }

            request.setAttribute("bean",orderFeedbacks);
            request.getRequestDispatcher("/management/feedback.jsp").forward(request,response);
        }




    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private String getMessage(List<Feedback> feedbacks) {
        StringBuffer message = new StringBuffer("");
        for(Feedback feedback:feedbacks){
            String messageStr = feedback.getMessage();
            String create_date = DateUtils.formatDate(feedback.getCreate_date(),"yyyy-MM-dd HH:mm:ss");
//            message.append(create_date+""+messageStr);
            message.append("时间："+create_date+"\\n"+"情况："+"\\n"+messageStr+"\\n");
        }
        if(message.equals("")){
            return "暂无反馈";
        }
        return  message.toString();
    }

}
