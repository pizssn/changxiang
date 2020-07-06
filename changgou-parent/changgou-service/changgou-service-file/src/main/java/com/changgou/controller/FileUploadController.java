package com.changgou.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.util.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: pizssn
 * @Description: com.changgou
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class FileUploadController {

    @PostMapping
    public Result upload(@RequestParam("file")MultipartFile file) throws Exception {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),//获取文件全名
                file.getBytes(),//获取上传文件的字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename())//获取文件扩展名
                );
        //调用FastDFSUtil工具类将文件传入FastDFS中
        String[] upload = FastDFSUtil.upload(fastDFSFile);
        String url = "http://192.168.71.128:8080/"+upload[0]+"/"+upload[1];
        return new Result(true, StatusCode.OK,"上传成功！",url);
    }
}
