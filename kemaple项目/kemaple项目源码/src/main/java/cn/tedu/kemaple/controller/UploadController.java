package cn.tedu.kemaple.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        System.out.println("pic = " + pic);
        //得到文件的原始文件名
        String fileName=pic.getOriginalFilename();
        System.out.println(fileName);
        //得到后缀
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        //得到唯一的文件名  UUID.randomUUID()得到唯一标识符
        fileName= UUID.randomUUID()+suffix;
        System.out.println(fileName);


        //保存图片的路径
        String dirPath="D:/kmfile";
        File dirFile=new File(dirPath);
        //判断文件如果不存在则创建
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //得到文件的完整路径
        String filePath=dirPath+"/"+fileName;
        //把接收到的文件保存到磁盘中  异常抛出
        pic.transferTo(new File(filePath));
        //把上传成功后的图片路径返回给客户端
        return "/"+fileName;
    }
    @RequestMapping("/remove")
    public void remove(String url){
        System.out.println("url = " + url);
        //得到文件的完整路径
        String filePath="D:/kmfile"+url;
        //删除文件
        new File(filePath).delete();
    }
    }
