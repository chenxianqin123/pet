package pri.cxq.bean;

import pri.cxq.utils.DateUtils;


public class Car {
    private Integer car_id;
    private Integer user_id;
    private Integer pet_id;
    private long create_date;

    public Car() {
    }

    public Car(Integer car_id, Integer user_id, Integer pet_id, long create_date) {
        this.car_id = car_id;
        this.user_id = user_id;
        this.pet_id = pet_id;
        this.create_date = create_date;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public String getFormatDate() {
        return DateUtils.formatDate(create_date, "yyyy-MM-dd HH:mm:ss");
    }
}
