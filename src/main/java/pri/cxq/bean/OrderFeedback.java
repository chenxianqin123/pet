package pri.cxq.bean;

/**
 * 封装订单信息与反馈信息的实体类
 */
public class OrderFeedback {
    private Integer order_id;//订单号
    private String user_name;//用户名
    private String breed;//宠物类别
    private String create_date;//购买时间
    private String feedbackMessage;//反馈记录

    public OrderFeedback() {
    }

    public OrderFeedback(Integer order_id, String user_name, String breed, String create_date, String feedbackMessage) {
        this.order_id = order_id;
        this.user_name = user_name;
        this.breed = breed;
        this.create_date = create_date;
        this.feedbackMessage = feedbackMessage;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }
}
