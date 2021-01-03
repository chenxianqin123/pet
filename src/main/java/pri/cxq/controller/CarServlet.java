package pri.cxq.controller;

import pri.cxq.dao.CarDao;
import pri.cxq.dao.PetDao;
import pri.cxq.bean.Car;
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
 * 处理加入购物车请求的Servlet
 */
@WebServlet(urlPatterns = "/CarServlet")
public class CarServlet extends HttpServlet {

    CarDao carDao = new CarDao();
    PetDao petDao = new PetDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        String method = request.getParameter("method");
        //添加购物车操作
        if (method.equals("add")) {
            //获取用户ID与需要加入购物车的宠物ID
            User user = (User) request.getSession().getAttribute("user");
            Integer user_id = user.getUser_id();
            Integer pet_id = Integer.valueOf(request.getParameter("pet_id"));
            //封装
            Car car = new Car(null, user_id, pet_id, DateUtils.getDateTime());
            boolean flag = carDao.saveCar(car);
            if (!flag) {
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();

            } else {
                writer.write("<script>");
                writer.write("alert(\"添加成功！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        //删除操作
        if(method.equals("remove")){
            Integer car_id = Integer.valueOf(request.getParameter("car_id"));
            boolean flag = carDao.removeCar(car_id);
            if(!flag){
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {
                writer.write("<script>");
                writer.write("alert(\"取消成功！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        //查询操作
        if (method.equals("check")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Integer user_id = user.getUser_id();//获得当前用户的id

            /**
             * 通过用户购物车信息的pet_id搜索相应的宠物信息
             */
            List<Car> cars = carDao.getCars(user_id);

            Map<Car, Pet> cp = new LinkedHashMap<Car, Pet>();

            for (Car car : cars) {
                Integer pet_id = car.getPet_id();
                Pet pet = petDao.getPet(pet_id);
                if (pet != null) {
                    cp.put(car,pet);
                }
            }
            request.setAttribute("cp",cp);
            request.getRequestDispatcher("/car.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
