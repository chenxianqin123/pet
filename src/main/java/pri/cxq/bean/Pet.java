package pri.cxq.bean;

/**
 * 宠物类
 */
public class Pet {
    private Integer pet_id;//宠物编号
    private Integer sort;//宠物分类 1代表狗狗 2代表猫咪
    private String breed;//品种
    private String description;//描述
    private Integer number;//数量
    private Integer price;//价格
    private String picture;//展示图片
    private long create_date;//上架时间

    public Pet() {
    }

    public Pet(Integer pet_id, Integer sort, String breed, String description, Integer number, Integer price, String picture, long create_date) {
        this.pet_id = pet_id;
        this.sort = sort;
        this.breed = breed;
        this.description = description;
        this.number = number;
        this.price = price;
        this.picture = picture;
        this.create_date = create_date;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
