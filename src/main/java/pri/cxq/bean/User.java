package pri.cxq.bean;

/**
 * 用户类
 */
public class User {
    private Integer user_id;//用户ID
    private String user_name;//用户名
    private String user_email;//邮箱
    private Integer administractor;//管理员身份
    private String user_password;//密码
    private long create_date;//创建时间

    public User() {}

    public User(Integer user_id, String user_name, String user_email, Integer administractor, String user_password, long create_date) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.administractor = administractor;
        this.user_password = user_password;
        this.create_date = create_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public Integer getAdministractor() {
        return administractor;
    }

    public void setAdministractor(Integer administractor) {
        this.administractor = administractor;
    }
}
