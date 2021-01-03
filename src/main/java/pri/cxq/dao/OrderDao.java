package pri.cxq.dao;

import pri.cxq.bean.Order;
import pri.cxq.utils.DBUtils;

import java.util.List;

/**
 * 订单的持久层操作
 */
public class OrderDao {

    /**
     * 增加订单的方法
     *
     * @param order
     * @return
     */
    public boolean saveOrder(Order order) {
        boolean flag = false;
        String sql = "insert into tb_order(user_id,pet_id,create_date) values(?,?,?)";
        flag = DBUtils.update(sql, order.getUser_id(), order.getPet_id(), order.getCreate_date());
        return flag;
    }

    /**
     * 查找当前用户所有订单的方法
     *
     * @param user_id
     * @return
     */
    public List<Order> getOrders(Integer user_id) {
        List<Order> orders = null;
        String sql = "select * from tb_order tb where tb.user_id = ?";
        orders = DBUtils.getList(Order.class, sql, user_id);
        return orders;
    }


    /**
     * 获取所有订单信息的方法
     * @return
     */
    public List<Order> getOrderList() {
        List<Order> orderList = null;
        String sql = "select * from tb_order tb";
        orderList = DBUtils.getList(Order.class,sql);
        return orderList;
    }
}
