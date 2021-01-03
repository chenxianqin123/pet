package pri.cxq.controller;

import pri.cxq.dao.PetDao;
import pri.cxq.bean.PageBean;
import pri.cxq.bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 处理宠物信息显示的Servlet
 */
@WebServlet(urlPatterns = "/DisplayAllServlet")
public class DisplayAllServlet extends HttpServlet {
    PetDao petDao = new PetDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageSizeStr = null;//每页多少行
        String currentPageStr = null;//当前第几页
        Integer totalRows = 0;//总行数
        Integer totalPages = 0;//总页数
        Integer startRow = 0;//起始行

        //获得总行数
        String sort = request.getParameter("sort");
        if(sort == null || sort.equals("all")){
            totalRows = petDao.getPetCount();
        }else if(sort.equals("dog")){
            totalRows = petDao.getDogCount();
        }else if(sort.equals("cat")){
            totalRows = petDao.getCatCount();
        }

        //获得每页行数
        pageSizeStr = request.getParameter("pageSize");
        Integer pageSize;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.valueOf(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //获得当前页数
        currentPageStr = request.getParameter("currentPageStr");
        Integer currentPage = null;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.valueOf(currentPageStr);
        } else {
            currentPage = 1;
        }

        startRow = (currentPage - 1) * pageSize;//计算起始行

        String sql = this.getSql(request, startRow, pageSize);//获得请求的查询语句

        List<Pet> pets = petDao.getPetList(sql);
        //封装请求
        PageBean<Pet> pageBean = new PageBean<Pet>(currentPage, pageSize, totalRows, pets);
        request.setAttribute("pageBean", pageBean);

        //请求转发到展示页面
        request.getRequestDispatcher("/display_all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String getSql(HttpServletRequest request, Integer startRow, Integer pageSize) {
        //正常显示全部宠物信息
        StringBuffer sql = new StringBuffer("SELECT \n" +
                "tb_pet.pet_id,\n" +
                "tb_pet.sort,\n" +
                "tb_pet.breed,\n" +
                "tb_pet.description,\n" +
                "tb_pet.number,\n" +
                "tb_pet.price,\n" +
                "tb_pet.picture,\n" +
                "tb_pet.create_date \n" +
                "FROM tb_pet \n");
        String method = request.getParameter("method");
        String sort = request.getParameter("sort");
        String researchText  = request.getParameter("researchText");
        if (method == null) {
            method = "default";
        }
        if (sort == null) {
            sort = "all";
        }
        if (method.equals("ranking") && sort.equals("all")) {//按价格排序显示全部信息
            sql.append("order by tb_pet.price ");
        } else if (method.equals("default") && sort.equals("dog")) {//正常显示狗狗的信息
            sql.append("where tb_pet.sort = 1 ");
        } else if (method.equals("ranking") && sort.equals("dog")) {//按价格排序显示狗狗的信息
            sql.append("where tb_pet.sort = 1 ");
            sql.append("order by tb_pet.price ");
        } else if (method.equals("default") && sort.equals("cat")) {//正常显示猫咪的信息
            sql.append("where tb_pet.sort = 2 ");
        } else if (method.equals("ranking") && sort.equals("cat")) {//按价格排序显示猫咪的信息
            sql.append("where tb_pet.sort = 2 ");
            sql.append("order by tb_pet.price ");
        }
        sql.append("limit ").append(startRow).append(",").append(pageSize);
        request.setAttribute("method", method);
        request.setAttribute("sort", sort);
        return sql.toString();
    }
//    public String getSql2(HttpServletRequest request, Integer startRow, Integer pageSize){
//        String researchText = request.getParameter("researchText");
//        String sort = request.getParameter("sort");
//        String method = request.getParameter("method");
//        //正常显示全部宠物信息
//        StringBuffer sql = new StringBuffer("SELECT \n" +
//                "tb_pet.pet_id,\n" +
//                "tb_pet.sort,\n" +
//                "tb_pet.breed,\n" +
//                "tb_pet.description,\n" +
//                "tb_pet.number,\n" +
//                "tb_pet.price,\n" +
//                "tb_pet.picture,\n" +
//                "tb_pet.create_date \n" +
//                "FROM tb_pet \n" +
//        "where tb_pet.sort = "+researchText+" \n");
//        if(method.equals("ranking")){
//            sql.append("order by tb_pet.price");
//        }
//        request.setAttribute("sort",sort);
//        request.setAttribute("method", method);
//        request.setAttribute("researchText",researchText);
//        return  sql.toString();
//    }
}
