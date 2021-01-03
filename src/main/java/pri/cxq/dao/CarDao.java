package pri.cxq.dao;

import pri.cxq.bean.Car;
import pri.cxq.utils.DBUtils;

import java.util.List;

/**
 * 购物车的持久层操作
 */
public class CarDao {

    /**
     *添加物品进购物车
     * @param user_id
     * @param pet_id
     * @return
     */
    public boolean saveCar(Car car){
        boolean flag = false;
        String sql = "insert into tb_car(user_id,pet_id,create_date) values (?,?,?)";
        flag = DBUtils.update(sql, car.getUser_id(), car.getPet_id(), car.getCreate_date());
        return flag;
    }

    /**
     * 删除购物车中的物品
     * @param car_id
     * @return
     */
    public boolean removeCar(Integer car_id){
        boolean flag = false;
        String sql = "delete from tb_car tb where tb.car_id = ?";
        flag = DBUtils.update(sql, car_id);
        return flag;
    }

    /**
     * 查询购物车中的所有物品
     * @param user_id
     * @return
     */
    public List<Car> getCars(Integer user_id){
        List<Car> cars = null;
        String sql = "select * from tb_car tb where tb.user_id = ?";
        cars = DBUtils.getList(Car.class, sql, user_id);
        return cars;
    }
}
