package pri.cxq.dao;

import pri.cxq.bean.Feedback;
import pri.cxq.utils.DBUtils;

import java.util.List;

/**
 * 反馈信息的持久层操作
 */
public class FeedbackDao {

    /**
     * 保存反馈信息
     *
     * @param feedback
     * @return
     */
    public boolean saveFeedback(Feedback feedback) {
        boolean flag = false;
        String sql = "insert into tb_feedback(order_id,message,create_date) values(?,?,?)";
        flag = DBUtils.update(sql, feedback.getOrder_id(), feedback.getMessage(), feedback.getCreate_date());
        return flag;
    }

    /**
     * 获得反馈信息
     *
     * @param order_id
     * @return
     */
    public List<Feedback> getList(Integer order_id) {
        List<Feedback> feedbacks = null;
        String sql = "select * from tb_feedback tb where tb.order_id = ?";
        feedbacks = DBUtils.getList(Feedback.class, sql, order_id);
        return feedbacks;
    }

}
