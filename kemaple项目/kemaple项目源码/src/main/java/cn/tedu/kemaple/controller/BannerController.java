package cn.tedu.kemaple.controller;

import cn.tedu.kemaple.entity.Banner;
import cn.tedu.kemaple.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class BannerController {
    @Autowired(required = false)
    BannerMapper mapper;

    @RequestMapping("/banner/select")
    public List<Banner> select(){
       return mapper.select();
    }

    @RequestMapping("/banner/insert")
    public void insert(String url){
        mapper.insert(url);
    }
    @RequestMapping("/banner/delete")
    public void deleteById(int id){
        //从磁盘中删除文件
       String url=mapper.selectById(id);
       new  File( "D:/kmfiles"+url).delete();
        mapper.deleteById(id);
    }
}
