package cn.tedu.kemaple.mapper;

import cn.tedu.kemaple.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from category")
    List<Category> select();

    @Insert("insert into category values(null,#{name})")
    void insert(String name);

    @Delete("delete from category where id=#{id}")
    void deleteById(int id);

    @Update("update category set name=#{name} where id=#{id}")
    void update(Category category);
}
