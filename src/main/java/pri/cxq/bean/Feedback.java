package pri.cxq.bean;

/**
 * 宠物成长信息反馈类
 */
public class Feedback {
    private Integer feedback_id;
    private Integer order_id;
    private String message;
    private long create_date;

    public Feedback() {
    }

    public Feedback(Integer feedback_id, Integer order_id, String message, long create_date) {
        this.feedback_id = feedback_id;
        this.order_id = order_id;
        this.message = message;
        this.create_date = create_date;
    }

    public Integer getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(Integer feedback_id) {
        this.feedback_id = feedback_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }
}
