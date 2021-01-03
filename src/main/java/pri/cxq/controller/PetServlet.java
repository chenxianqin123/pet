package pri.cxq.controller;

import pri.cxq.bean.Pet;
import pri.cxq.dao.PetDao;
import pri.cxq.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/PetServlet")
@MultipartConfig
public class PetServlet extends HttpServlet {

    PetDao petDao = new PetDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String method = request.getParameter("method");

        /**
         * 上传宠物信息
         */
        if (method.equals("add")) {

            /**
             * 存储宠物展示图
             */
            Part part = request.getPart("picture");//获取图片

            String picture = part.getSubmittedFileName();

            String dir = this.getServletContext().getRealPath("/images/pet_image");//创建展示图保存路径
            File imgDir = new File(dir);//如果文件不存在，则创建一个
            if (!imgDir.exists()) {
                imgDir.mkdirs();
            }
            if(picture != ""){
                part.write(dir + "/" + picture);//将文件存入指定目录
            }

            Pet pet = this.requestDateObj(request);//获得封装对象

            boolean flag = petDao.savePet(pet);

            if (!flag) {
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                writer.write("<script>");
                writer.write("alert(\"上传成功！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }

        /**
         * 删除宠物信息
         */
        if (method.equals("remove")) {
            Integer pet_id = Integer.parseInt(request.getParameter("pet_id"));

            boolean flag = petDao.removePet(pet_id);

            if (!flag) {
                writer.write("<script>");
                writer.write("alert(\"失败！！！\");");
                writer.write("history.go(-1);");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                writer.write("<script>");
                writer.write("alert(\"下架成功！！！\");");
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

    //封装需要上传的宠物信息
    public Pet requestDateObj(HttpServletRequest request) throws IOException, ServletException {
        Integer pet_id = null;
        Integer sort = null;
        String sortStr = request.getParameter("sort");
        if (sortStr.equals("狗狗")) {
            sort = 1;
        } else {
            sort = 2;
        }
        String breed = request.getParameter("breed");
        String description = request.getParameter("description");
        Integer number = Integer.valueOf(request.getParameter("number"));
        Integer price = Integer.valueOf(request.getParameter("price"));
        String picture = request.getPart("picture").getSubmittedFileName();
        long create_date = DateUtils.getDateTime();

        return new Pet(null, sort, breed, description, number, price, picture, create_date);
    }
}
