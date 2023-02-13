package cn.tedu.kemaple.controller;

import cn.tedu.kemaple.entity.Product;
import cn.tedu.kemaple.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    @RequestMapping("/product/insert")
    public  void insert(@RequestBody Product product){
        System.out.println("product = " + product);
        //设置发布时间
        product.setCreated(new Date());
        mapper.insert(product);
    }

    @RequestMapping("/product/select")
    public List<Product> select(){
        return mapper.select();
    }

    @RequestMapping("/product/delete")
    public void delete(int id){
        String url=mapper.selectById(id);
        new File("D:/kmfile"+url);
        mapper.deleteById(id);
    }
    @RequestMapping("/product/select/top")
    public List<Product> selectTop(){
        return mapper.selectTop();
    }
    @RequestMapping("/product/select/index")
    public List<Product> selectIndex(){
        return mapper.selectIndex();
    }
}
