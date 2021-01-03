package pri.cxq.dao;

import pri.cxq.bean.User;
import pri.cxq.utils.DBUtils;

/**
 * 用户的持久层操作
 */
public class UserDao {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public boolean saveUser(User user) {
        boolean flag = false;
        String sql = "insert into tb_user(user_name,user_email,user_password，administractor,create_date) values(?,?,?,?,?)";
        flag = DBUtils.update(sql, user.getUser_name(), user.getUser_email(), user.getUser_password(),user.getAdministractor() ,user.getCreate_date());
        return flag;
    }

    /**
     * 用户注销
     * @param user_id
     * @return
     */
    public boolean removeUser(Integer user_id){
        boolean flag = false;
        String sql = "delete from tb_user tb where tb.user_id = ?";
        flag = DBUtils.update(sql, user_id);
        return flag;
    }

    /**
     * 查找用户
     * @param user_email 邮箱
     * @param user_password 密码
     * @return user 用户对象
     */
    public User checkUser(String user_email, String user_password) {
        User user = null;
        String sql = "select * from tb_user tb where tb.user_email = ? and tb.user_password = ?";
        user = DBUtils.check(User.class, sql, user_email, user_password);
        return user;
    }

    /**
     * 查询账号是否已注册
     * @param user_email 用户邮箱
     * @return
     */
    public boolean isExist(String user_email) {
        boolean flag = false;
        String sql = "select count(*) from tb_user tb where tb.user_email = ?";
        int count = DBUtils.checkCount(sql, user_email);
        if(count > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 查询用户的个人信息
     * @param user_id 用户ID
     * @return info_id 用户信息ID
     */
    public Integer isExistInfo(Integer user_id){
        Integer info_id = null;
        String sql = "select tb.info_id from tb_user_info tb where user_id = ?";
        info_id = DBUtils.checkCount(sql,user_id);
        return  info_id;
    }

    /**
     * 根据用户ID查找用户信息
     * @param user_id
     * @return
     */
    public User getUser(Integer user_id) {
        User user = null;
        String sql = "select * from tb_user tb where tb.user_id = ?";
        user = DBUtils.check(User.class,sql,user_id);
        return  user;
    }

}
