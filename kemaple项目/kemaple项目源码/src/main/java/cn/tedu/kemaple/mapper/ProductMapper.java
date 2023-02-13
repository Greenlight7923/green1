package cn.tedu.kemaple.mapper;

import cn.tedu.kemaple.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{url},#{price},#{oldPrice}," +
            "#{saleCount},#{num},0,#{created},#{categoryId})")
    void insert(Product product);

    @Select("select id,title,url,price,old_price,sale_count from product ")
    @Result(column = "old_Price",property="oldPrice")
    @Result(column = "sale_count",property="saleCount")
    List<Product> select();

    @Select("select url from product where id=#{id}")
    String selectById(int id);

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select id,title,sale_count from product order by sale_count desc limit 0,6")
    List<Product> selectTop();

    @Select("select id,title,url,price,old_price,sale_count from product")
    List<Product> selectIndex();
}
