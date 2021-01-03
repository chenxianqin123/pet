package pri.cxq.bean;


import java.util.Date;

/**
 * 用户的个人信息类
 */
public class Info {
    private Integer info_id;//个人信息ID
    private Integer user_id;//用户ID
    private String realname;//姓名
    private String sex;//性别
    private Date birthday;//出生日期
    private String email;//邮箱
    private String telephone;//手机
    private String address1;//默认地址
    private String address2;//备用地址
    private String picture;//头像
    private long create_date;//上次修改时间


    public Info() {
    }

    public Info(Integer info_id, Integer user_id, String realname, String sex, Date birthday, String email, String telephone, String address1, String address2, String picture, long create_date) {
        this.info_id = info_id;
        this.user_id = user_id;
        this.realname = realname;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.telephone = telephone;
        this.address1 = address1;
        this.address2 = address2;
        this.picture = picture;
        this.create_date = create_date;
    }

    public Integer getInfo_id() {
        return info_id;
    }

    public void setInfo_id(Integer info_id) {
        this.info_id = info_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }
}
