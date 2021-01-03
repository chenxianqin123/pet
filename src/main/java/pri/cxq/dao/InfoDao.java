package pri.cxq.dao;

import pri.cxq.bean.Info;
import pri.cxq.utils.DBUtils;
import pri.cxq.utils.DateUtils;

/**
 * 用户个人信息的持久层操作
 */
public class InfoDao {
    /**
     * 添加个人信息
     *
     * @param info 需要添加的用户信息
     * @return info_id 新增的用户信息ID
     */
    public Integer saveInfo(Info info) {
        Integer info_id = null;
        String sql = "insert into tb_user_info\n" +
                "(user_id,realname,sex,birthday,email,telephone,address1,address2,picture,create_date) \n" +
                "values(?,?,?,?,?,?,?,?,?,?)";
        info_id = DBUtils.updateForPrimary(sql, info.getUser_id(), info.getRealname(), info.getSex(), info.getBirthday(), info.getEmail(), info.getTelephone(), info.getAddress1(), info.getAddress2(), info.getPicture(), info.getCreate_date());
        return info_id;
    }

    /**
     * 获取用户的个人信息
     *
     * @param user_id 用户ID
     * @return info 个人信息对象
     */
    public Info getInfo(Integer user_id) {
        Info info = null;
        String sql = "SELECT tb.info_id,tb.user_id,tb.realname,tb.sex,tb.birthday,tb.email,tb.telephone,tb.address1,tb.address2,tb.picture,tb.create_date \n" +
                "FROM tb_user_info tb \n" +
                "where tb.user_id = ?";
        info = DBUtils.check(Info.class, sql, user_id);
        return info;
    }


    /**
     * 更新个人信息
     *
     * @param info 个人信息
     * @return 是否更新成功
     */
    public boolean updateInfo(Info info) {
        String birthday = DateUtils.formatDate(info.getBirthday(),"yyyy-MM-dd");
        boolean flag = false;
        String sql = "update tb_user_info tb \n" +
                "set tb.realname = ?,tb.sex = ?,tb.birthday = ?,tb.email = ?\n" +
                ",tb.telephone = ?,tb.address1 = ?,tb.address2 = ?\n" +
                ",tb.picture = ?,tb.create_date = ? \n" +
                "where tb.user_id = ?";
        flag = DBUtils.update(sql, info.getRealname(), info.getSex(), birthday,info.getEmail(), info.getTelephone(), info.getAddress1(), info.getAddress2(), info.getPicture(), info.getCreate_date(), info.getUser_id());
        return flag;
    }
}
