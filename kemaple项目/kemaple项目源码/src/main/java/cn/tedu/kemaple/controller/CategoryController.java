package cn.tedu.kemaple.controller;

import cn.tedu.kemaple.entity.Category;
import cn.tedu.kemaple.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired(required = false)
    CategoryMapper mapper;

    @RequestMapping("/category/select")
    public List<Category> select(){
        return mapper.select();
    }

    @RequestMapping("/category/insert")
    public List<Category> insert(String name){
         mapper.insert(name);
         return mapper.select();
    }

    @RequestMapping("/category/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }

    @RequestMapping("/category/update")
    public void update(@RequestBody Category category){
        mapper.update(category);}

}
