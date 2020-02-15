package com.qgw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class UploadController {

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        //TODO 原文件名
        String fileName = file.getOriginalFilename();
        //TODO 文件大小
        Long size = file.getSize();
        //TODO 打印文件的属性
        log.info("上传文件名:{},文件大小:{}", fileName, size);

        //TODO 指定文件存储硬盘目录
        String path = "C:\\Users\\屈冠文\\IdeaProjects\\format\\myspringcloud\\eureka-feign-upload-server\\filedir";
        File dest = new File(path + "/" + fileName);
        //TODO 判断如果父目录不存在则新建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //TODO 将上传文件保存到指定位置
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }

    }
}

