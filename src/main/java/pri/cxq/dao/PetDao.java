package pri.cxq.dao;

import pri.cxq.bean.Pet;
import pri.cxq.utils.DBUtils;

import java.util.List;

/**
 * 宠物持久层操作
 */
public class PetDao {
    /**
     * 上传宠物信息的方法
     * @param pet
     * @return
     */
    public boolean savePet(Pet pet){
        boolean flag = false;
        String sql = "insert into tb_pet(sort,breed,description,number,price,picture,create_date) values(?,?,?,?,?,?,?)";
        flag = DBUtils.update(sql, pet.getSort(), pet.getBreed(), pet.getDescription(), pet.getNumber(), pet.getPrice(), pet.getPicture(), pet.getCreate_date());
        return flag;
    }

    /**
     * 下架宠物信息的方法
     * @param pet_id
     * @return
     */
    public boolean removePet(Integer pet_id){
        boolean flag = false;
        String sql = "delete from tb_pet where pet_id = ?";
        flag = DBUtils.update(sql,pet_id);
        return flag;
    }

    /**
     * 返回所有宠物信息的方法
     * @param sql
     * @return
     */
    public List<Pet> getPetList(String sql){
        List<Pet> pets = DBUtils.getList(Pet.class,sql);
        return pets;
    }

    /**
     * 返回一共有多少条宠物的记录
     * @return
     */
    public Integer getPetCount(){
        Integer count = null;
        String sql = "select count(*) from tb_pet";
        count = DBUtils.checkCount(sql);
        return  count;
    }
    /**
     * 返回一共有多少条狗狗的记录
     * @return
     */
    public Integer getDogCount() {
        Integer count = null;
        String sql = "select count(*) from tb_pet tb where tb.sort = 1";
        count = DBUtils.checkCount(sql);
        return  count;
    }
    /**
     * 返回一共有多少条猫咪的记录
     * @return
     */
    public Integer getCatCount() {
        Integer count = null;
        String sql = "select count(*) from tb_pet tb where tb.sort = 2";
        count = DBUtils.checkCount(sql);
        return  count;
    }

    /**
     * 获得所有狗狗信息
     * @param sql
     * @return
     */
    public List<Pet> getDogList(String sql){
        List<Pet> dogs = DBUtils.getList(Pet.class,sql,1);
        return dogs;
    }

    /**
     * 获得所有猫咪信息
     * @param sql
     * @return
     */
    public List<Pet> getCatList(String sql){
        List<Pet> cats = null;
        cats = DBUtils.getList(Pet.class,sql,2);
        return cats;
    }

    /**
     * 根据宠物ID获取宠物信息
     * @param pet_id
     * @return
     */
    public Pet getPet (Integer pet_id){
        Pet pet = null;
        String sql = "select * from tb_pet tb where tb.pet_id = ?";
        pet = DBUtils.check(Pet.class,sql,pet_id);
        return pet;
    }

    /**
     * 修改宠物信息
     * @param pet
     * @return
     */
    public  boolean updatePet(Pet pet){
        boolean flag = false;
        String sql = "update tb_pet set \n" +
                "tb_pet.sort = ?,\n" +
                "tb_pet.breed = ?,\n" +
                "tb_pet.description = ?,\n" +
                "tb_pet.number = ?,\n" +
                "tb_pet.price = ?,\n" +
                "tb_pet.picture = ?,\n" +
                "tb_pet.create_date = ? \n" +
                "where pet_id = 1";
        flag = DBUtils.update(sql, pet.getSort(), pet.getBreed(), pet.getDescription(), pet.getNumber(), pet.getPrice(), pet.getPicture(), pet.getCreate_date(), pet.getPet_id());
        return flag;
    }

    /**
     * 这是减少宠物数量的方法
     * @param pet_id
     * @return
     */
    public boolean decreaseCount(Integer pet_id) {
        boolean flag = false;
        String sql = "update tb_pet tb set tb.number = tb.number - 1 where tb.pet_id = ?";
        flag = DBUtils.update(sql, pet_id);
        return flag;
    }
}
